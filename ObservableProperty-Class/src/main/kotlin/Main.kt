import kotlin.properties.Delegates
import kotlin.properties.ObservableProperty
import kotlin.reflect.KProperty

/**
    - Genric interface delegate yang sebelumnya kita gunakan (ReadOnlyProperty dan ReadWriteProperty) kita perlu
      mengatur value datanya secara manual.
    - Kadang kita tidak butuh maintance value-nya secara manual, namun hanya akan melakukan sesuatu sebelum dan
      setelah datanya diubah.
    - Untuk kasus seperti ini kita dapat menggunakan generic class ObservableProperty.
    - Pada saat sebuah class meng-extends class ObservableProperty maka ada beberapa function yang dapat di-override
      (opsional) seperti beforeChange, afterChange, getValue, SetValue.
    - Dan Pada class ObservableProperty mengimplement interface ReadWriteProperty dan perbedaanya adalah pada class
      ObservableProperty langsung maintance value-nya didalam class-nya sehingga kita tidak perlu mengatur value-nya
      secara manual.
    - Pada function beforeChange ketika return value-nya true maka boleh mengubah value property-nya dan kalau false
      tidak boleh mengubah value dari properties-nya.

    Object Delegates
        Function                                     Keterangan
        - Delegates.notNull()                      => ReadWriteProperty yang nilai awal dapat null, namun error jika masih
                                                      null ketika program berjalan.
        - Delegates.vetoable(value, beforeChange)  => ObservableProperty dengan beforeChange.
        - Delegates.observable(value, afterChange) => ObservableProperty dengan afterChange.

 */
class Animal<T>(name: T) : ObservableProperty<T>(name){

    // Function ini ketika return value-nya  true maka boleh mengubah value property-nya dan kalau false tidak boleh
    // mengubah value dari properties-nya.
    override fun beforeChange(property: KProperty<*>, oldValue: T, newValue: T): Boolean {
        println("Before change ${property.name} from $oldValue to $newValue")
        // bisa juga melakukan validasi disini.
        return true
    }

    override fun afterChange(property: KProperty<*>, oldValue: T, newValue: T) {
        println("After change  ${property.name} from $oldValue to $newValue")
    }

}

class Mamalia(name: String, numberOfFeet: Int){
    // Properties name-nya didelegasikan pada class Animal yang extends class ObservableProperty.
    var name: String by Animal<String>(name)
    var feet: Int by Animal<Int>(numberOfFeet)

    // contoh mendelegasikan properties food pada Object Delegates (Delegates.notNull())
    var food: String by Delegates.notNull<String>()

    // contoh mendelegasikan properties age pada Object Delegates (Delegates.vetoable())
    // parameter pertama initialValue, parameter kedua lambda expression 3 parameter dan return value-nya Boolean.
    var age: Int by Delegates.vetoable(0){property, oldValue, newValue ->
        println("Before change ${property.name} from $oldValue to $newValue")
        true
    }

    // contoh mendelegasikan properties info pada Object Delegates (Delegates.observable())
    // paramter pertama initialValue, paramter kedua lambda expression 3 parameter.
    var info: String by Delegates.observable("Indonesia"){property, oldValue, newValue ->
        println("After change  ${property.name} from $oldValue to $newValue")
    }
}

fun main() {
    val animal1: Mamalia = Mamalia("Dog",4)
    println(animal1.name)
    println(animal1.feet)
    println("= = = = = = =")
    animal1.name = "Monkey"
    animal1.feet = 2
    println("= = = = = = =")
    println(animal1.name)
    println(animal1.feet)
    println("= = = = = = =")
    // memanggil value dari properties food, yang didelegasikan pada object (Delegates.notNull()).
    // ketika value-nya null dan program di-running maka akan error.
    // println(animal1.food) // Error runtime

    // mengubah value dari properties age, yang didelegasikan pada object (Delegates.vetoable())
    animal1.age = 3
    println(animal1.age)
    println("= = = = = = =")

    // mengubah value dari properties info, yang didelegasikan pada object (Delegates.observable())
    animal1.info = "North Sumatra"
    println(animal1.info)
}