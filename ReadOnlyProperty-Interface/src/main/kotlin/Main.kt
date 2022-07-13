import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

/**
    - Pada Kotlin, ada sebuah interface generic yang dapat digunakan sebagai delegate property yang sifatnya readonly,
      alias val (immutable), namanya ReadOnlyProperty.
    - ReadOnlyProperty dapat digunakan sebagai delegate, sehingga sebelum data kita dikembalikan, kita dapat melakukan
      sesuatu, atau bahkan mengubah value pada properties tersebut.
    - function getValue yang di-override dari interface ReadOnlyProperty dapat digunakan untuk memanipulasi data propeties
      pada class-nya.
    - Pada saat membuat class dengan turunan interface ReadOnlyProperty dengan 2 generic parameter, dimana generic parameter
      pertama dapat diisi oleh tipe data dari object pemilik dari property atau object dari class yang mendelegasikan
      property-nya, dan tipe data parameter yang kedua adalah sama dengan return value function yang di-override
      yaitu 'getValue' atau sederhana-nya tipe data dari property yang didelegasikan.

    - Jadi dengan delegation kita dapat memanggil function/properties dari object lain yang dibuat dari superclass
      yang sama dengan class yang mendelegasikan sebuah function/properties.
 */

// Membuat class dengan turunan interface ReadOnlyProperty dengan 2 generic parameter, dimana generic parameter pertama
// dapat diisi oleh tipe data dari object pemilik dari property atau object dari class yang mendelegasikan property-nya,
// dan tipe data parameter yang kedua adalah sama dengan return value function yang di-override yaitu 'getValue' atau
// sederhana-nya tipe data dari property yang didelegasikan.
class Animal(val name: String) : ReadOnlyProperty<Any, String> {

    // meng-override function getValue dari interface ReadOnlyProperty yang mempunyai 2 parameter, dimana
    // parameter pertama diisi oleh object pemilik dari property, ketika diisi type data Any maka object dari class
    // manapun dapat mengakses function ini, dan return value dari function tersebut adalah
    // String  sesuai dengan generic parameter type interface ReadOnlyProperty yang kedua yaitu 'String'.
    override fun getValue(thisRef: Any, property: KProperty<*>): String {
        println("Access property ${property.name} From ${Animal::class} with value ${this.name}")
        return name.uppercase()
    }
}

class Predator(name: String){
    val name: String by Animal(name)
}

fun main() {
    val crocodile = Predator("Crocodile")
    println(crocodile.name)
    println(crocodile.name)
}

