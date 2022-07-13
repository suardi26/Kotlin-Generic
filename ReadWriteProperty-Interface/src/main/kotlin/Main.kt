import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

/**
    - Selain ReadOnlyProperty, kita dapat juga menggunakan interface generic ReadWriteProperty sebagai delegate.
    - ReadWriteProperty dapat digunakan untuk variable var (mutable).
    - Jadi val itu untuk ReadOnlyProperty dan var untuk ReadWriteProperty.
    - Berbeda dengan interface ReadOnlyProperty, yang hanya mengharuskan meng-override function getValue pada
      class turunan-nya, namun pada interface ReadWriteProperty harus meng-override function setValue juga.
      dimana function setValue mempunyai 3 parameter, dimana parameter pertama diisi oleh object pemilik dari property,
      ketika diisi type data Any maka object dari class manapun dapat mengakses function ini, dan parameter kedua
      digunakan untuk manampung object dari interface KProperty<*> yang digunakan untuk mengakses informasi dari
      properties, serta parameter ketiga adalah untuk memasukan value baru dari properties.
 */

// Membuat class dengan turunan interface ReadWriteProperty dengan 2 generic parameter, dimana generic parameter pertama
// dapat diisi oleh tipe data dari object pemilik dari property atau object dari class yang mendelegasikan property-nya,
// dan tipe data parameter yang kedua adalah sama dengan return value function yang di-override yaitu 'getValue' atau
// sederhana-nya tipe data dari property yang didelegasikan.
class Animal(var name: String) : ReadWriteProperty<Any, String> {

    // meng-override function getValue dari interface ReadWriteProperty yang mempunyai 2 parameter, dimana
    // parameter pertama diisi oleh object pemilik dari property, ketika diisi type data Any maka object dari class
    // manapun dapat mengakses function ini, dan return value dari function tersebut adalah
    // String sesuai dengan generic parameter type interface ReadWriteProperty yang kedua yaitu 'String'.
    override fun getValue(thisRef: Any, property: KProperty<*>): String {
        println("Access property ${property.name} From ${Animal::class} with value ${this.name}")
        return name.uppercase()
    }

    // Berbeda dengan interface ReadOnlyProperty, yang hanya mengharuskan meng-override function getValue pada
    // class turunan-nya, namun pada interface ReadWriteProperty harus meng-override function setValue juga.
    // dimana function setValue mempunyai 3 paramter, dimana paramter pertama diisi oleh object pemilik dari property,
    // ketika diisi type data Any maka object dari class manapun dapat mengakses function ini, dan paramter kedua
    // digunakan untuk manampung object dari interface KProperty<*> yang digunakan untuk mengakses informasi dari
    // properties, serta paramter ketiga adalah untuk memasukan value baru dari properties.
    override fun setValue(thisRef: Any, property: KProperty<*>, value: String){
        println("Set property ${property.name} From ${this.name} To $value")
        this.name = value
    }
}

class Predator(name: String){
    var name: String by Animal(name)
}

fun main() {
    val animal1 = Predator("Crocodile")
    println(animal1.name)
    println("= = = = = = = = = = = =")
    println(animal1.name)
    println("= = = = = = = = = = = =")
    animal1.name = "Tiger"
    println("= = = = = = = = = = = =")
    println(animal1.name)
    println("= = = = = = = = = = = =")
    println(animal1.name)

}