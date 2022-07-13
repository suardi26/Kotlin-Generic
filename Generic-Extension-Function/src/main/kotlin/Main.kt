/**
    - Generic juga dapat digunakan pada Extension function.
    - Dengan begitu kita dapat memilih jenis generic parameter type apa yang bisa menggunakan extension function
      tersebut.
 */

class Data<T> (val data: T)

// Contoh generic extension function dari class data.
fun Data<String>.print(){
    val valueOfString = this.data
    println("String value is $valueOfString")
}

fun main(){
    val data1: Data<Int> = Data(1)
    val data2: Data<String> = Data("Suardi")

    // data1.print() // error karena properties data dari object data1 bukan String.
    data2.print() // berhasil karena properties data dari object data2 adalah String.
}
