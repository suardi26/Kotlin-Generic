/**
    - Type Erasure adalah proses pengecekan generic pada saat compile time, dan menghiraukan pengecekan pada saat
      runtime.
    - Type Erasure menjadikan informasi generic yang kita buat akan hilang ketika kode program kita telah dicompile
      menjadi binary file.
    - Compiler akan mengubah generic parameter type menjadi tipe data Any (atau Object pada java) ketika sudah menjadi
      binary file.

    Problem Type Erasure
    - Karena informasi generic hilang ketika sudah menjadi binary file.
    - Oleh karena itu, konversi tipe data generic akan berbahaya jika dilakukan secara tidak bijak.
 */

class TypeErasure<T>(param: T){
    // pada saat selesai di-compile generic parameter <T> akan berubah menjadi tipe data Any (atau Object pada java).
    private val data: T = param
    fun getData(): T = data
}

fun main(){
    val data = TypeErasure<String>("Suardi")
    val dataString = data.getData()
    println(dataString)

    // Melakukan casting dimana Data memiliki nilai String di paksa ke Data dengan generic parameter type Integer
    // dengan melakukan casting.
    val student: TypeErasure<Int> = data as TypeErasure<Int>
    val dataInt = student.getData() // pada saat compile aman, namun pada saat runtime akan error.
    println(dataInt)
}

