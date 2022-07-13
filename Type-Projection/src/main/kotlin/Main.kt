/**
    - Kadang-kadang agak sulit untuk membuat class generic type yang harus covariant atau contravariant, misal karena
      memang pada class generic tersebut terdapat input dan output generic paramter type.
    - Namun jika membuat function untuk memanipulasi data invariant sangatlah sulit, karena generic parameter type-nya
      harus selalu sama.
    - Kita dapat melakukan type projection, yaitu menambahkan informasi pada covariant atau contravariant di parameter
      function, ini memaksa isi function untuk melakukan pengecekan.
    - jika covariant, kita tidak boleh mengubah data generic pada object.
    - jika contravariant, kita tidak boleh mengambil data generic object.

 */

// generic class
class Container<T>(var data: T)

// function Type Projection dengan parameter 'from' yang (covariant) subtype (child) -> supertype (parent) dan
// 'to' yang ( contravariant) supertype (parent) -> subtype (child)
// dimana function ini memaksa tipe data Container dari variable 'to' , menjadi tipe data Container dari variable 'from'
fun copy(from: Container<out Any>, to: Container<in Any>){
    to.data = from.data
}

fun main() {
    val container1 = Container("Suardi")
    val container2: Container<Any> = Container("Daud")

    // Memanggil function copy, yang berfungsi dimana parameter pertama class Container yang generic parameter-nya itu
    // covariant hanya boleh mengeluarkan data dan parameter kedua yaitu class Container yang generic parameter-nya
    // Contravariant hanya boleh menerima data.
    copy(container1, container2)
    println(container1.data)
    println(container2.data)
}