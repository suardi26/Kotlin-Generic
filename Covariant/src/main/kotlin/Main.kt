/**
    - Covariant artinya kita dapat melakukan substitusi generic parameter type dari subtype(child) ke supertype (parent).
      namun tidak bisa sebaliknya dari supertype (parent) ke subtype (child).
    - Tidak semua jenis class generic yang mendukung covariant, hanya class generic yang menggunakan generic parameter
      type sebagai return type function artinya pada saat membuat class generic dan di set sebagai covariant maka
      tidak boleh membuat function dengan menerima input dari generic parameter type-nya, tapi boleh membuat function
      dengan return value generic parameter type-nya.
    - Artinya saat membuat object Contoh<String>, maka bisa disubstitusi menjadi Contoh<Any>.
    - Untuk memberitahu bahwa generic paramter type tersebut adalah covariant, kita perlu menggunakan keyword 'out'.
        contoh : 'class Covariant<out T>(val data: T) {...}'
    - Jadi kesimpulannya, ketika generic parameter type di set covariant pada class-nya maka semua function-nya
      boleh memiliki return value generic parameter type-nya, tanpa menerima input dari generic parameter type-nya
      pada sebuah function. contoh : 'fun data(): T{...}'
    - Pada generic parameter type yang covariant untuk proporties-nya yang menggunakan generic parameter type sebagai
      type datanya harus 'val' immutable, artinya tidak boleh di ganti lagi misalnya objectnya telah disubstitusi dari
      String ke Any dan untuk menghindari error maka propertiesnya tidak lagi bisa diubah ke type data lainnya misal :
      Int, karena menggunakan keyword val.

 */

// Membuat generic class/generic type (covariant)
class Covariant<out T>(val data:T){
    // (Covariant) semua function-nya boleh memiliki return value generic parameter type-nya, tanpa menerima input
    // dari generic parameter type-nya.
    fun data(): T = this.data


    // Membuat function biasa
    fun info() = println("Data : ${this.data}")
}

fun main() {
    val data1: Covariant<String> = Covariant("Google.txt")
    // pada covariant objectnya dengan parameter subtype String dapat di substitusi pada object dengan parameter
    // supertype (Any). dikarenakan String adalah subtype dari supertype Any.
    val data2: Covariant<Any> = data1

    println(data2.data)
    println(data2.data())

}

