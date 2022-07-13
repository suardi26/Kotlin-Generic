/**
    - Contravariant maksudnya kita dapat melakukan substitusi generic parameter type dari supertype (parent) ke
      subtype (child), namun tidak bisa sebaliknya dari subtype (child) ke supertype (parent).
    - Tidak semua jenis class generic yang mendukung contravariant, hanya class generic yang menggunakan generic
      parameter type sebagai parameter function artinya pada saat membuat class generic dan di set sebagai contravariant
      maka tidak boleh membuat function dengan return value generic parameter type-nya,tapi boleh membuat function dengan
      menerima input dari generic parameter type-nya.
    - Artinya saat kita membuat object Contoh<Any>, maka dapat disubstitusi menjadi Contoh<String>
    - Untuk memberitahu bahwa generic paramter type tersebut adalah contravariant, kita perlu menggunakan keyword 'in'.
         contoh :
    - Jadi kesimpulannya, ketika generic parameter type di set Contravariant pada class-nya maka semua function-nya
      boleh menerima input dari generic parameter type-nya, tanpa memiliki return value generic parameter type-nya pada
      sebuah function contoh : 'fun data(): T{...}'
 */

// Membuat generic class/generic type (contravariant)
class Contravariant<in T>{
    // (Contravariant) semua function-nya boleh menerima input dari generic parameter type-nya, tanpa memiliki
    // return value generic parameter type-nya pada function.
    fun data(name: T) = println("Data $name")

}

fun main() {
    val data1: Contravariant<Any> = Contravariant()
    // pada contravariant objectnya dengan parameter supertype (Any) dapat di substitusi pada object dengan parameter
    // subtype String. Dikarenakan Any adalah supertipe dari subtype String.
    val data2: Contravariant<String> = data1
    data2.data("facebook.txt")

}