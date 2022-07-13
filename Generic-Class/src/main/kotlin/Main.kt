/**
    - Generic class/Generic Type adalah class atau interface yang menggunakan parameter type.
    - Pada Pembuatan Generic parameter Type tidak ada ketentuan, tapi biasanya orang menggunakan 1 karakter sebagai generic
      parameter type.
    - Berikut nama generic parameter type yang biasa digunakan (tidak wajib) :
            - E = Element (Biasanya digunakan di collection atau struktur data).
            - N = Key.
            - V = Value.
            - N = Number.
            - T = Type.
            - V = Value.
            - S, U, dll.
    - Untuk membuat generic class/generic type maka harus menambahkan nama generic parameter dalam diamond operator '<>'
      setelah nama class-nya. Contoh generic type pada Class : 'Class Data<T> (val data: T)
      dimana : <T> => adalah generic paramter type, yang pada saat pembuatan object dapat diganti dengan tipe data
      yang diinginkan. Dan tidak harus huruf 'T' bisa juga huruf lain yang dapat digunakan sebagai generic parameter
      type namun yang sering digunakan adalah huruf 'T'.
    - Untuk membuat object dari generic class maka harus menambahkan type data dalam diamond operator '<>' setelah
      nama class-nya. contoh : Data<String>("Suardi").

    - Multiple Parameter Type.
        - Parameter type di Generic class/Generic type boleh lebih dari 1, tapi harus menggunakan nama generic paramter
          type berbeda. Misalnya : 'class Product<T,U>(val name: T, val price: U, ... , val category: E){...}'
        - Multiple Parameter Type sangat berguna pada saat kita ingin membuat generic parameter type yang banyak.

    - Pembuatan object dari generic class/generic type dapat menggunakan beberapa cara seperti :
        val product1: Product<String, Int> = Product<String,Int>("Daia",10_000)
        val product1 = Product<String,Int>("Daia",10_000) // atau
        val product1: Product<String, Int> = Product("Daia",10_000) // atau
        val product1 = Product("Daia",10_000)
 */

// Membuat generic class/generic type.
class Data<T>(val data: T){
    fun printData() = println("Data : ${this.data}")

    // membuat function yang return value-nya generic parameter type, artinya return value-nya dapat diisi dengan
    // tipe data apapun sesuai dengan generic paramter type-nya.
    fun getMyData(): T = this.data

}

// Membuat generic class/generic type (Multiple Parameter Type).
class Product<T,U>(val name: T, val price: U){
    fun printDataProduct() {
        println("""
            Product :   ${this.name}
            Price   :   ${this.price}
        """.trimIndent())
    }
    // membuat function yang return value-nya generic parameter type, artinya return value-nya dapat diisi dengan
    // tipe data apapun sesuai dengan generic paramter type-nya.
    fun getNameProduct(): T = this.name
    fun getPriceProduct():U = this.price

}

fun main() {

    // Membuat object dari generic class/generic type, dan menggantikan generic parameter type-nya menjadi String.
        val dataString: Data<String> = Data<String>("Suardi")
        dataString.printData()

        val myDataString: String = dataString.getMyData()
        println(myDataString)

    // Membuat object dari generic class/generic type, dan menggantikan generic parameter type-nya menjadi Int.
        val dataInt: Data<Int> = Data<Int>(26)
        dataInt.printData()

        val myDataInt: Int = dataInt.getMyData()
        println(myDataInt)
        println("= = = = = = = = = =")

    // Membuat object dari generic class/generic type (Multiple Parameter Type) dan menggantikan
    // generic parameter type-nya menjadi String dan juga Int.

        // Beberapa cara membuat object dari generic class/generic object.
        // val product1: Product<String, Int> = Product<String,Int>("Daia",10_000)
        // val product1 = Product<String,Int>("Daia",10_000) // atau
        // val product1: Product<String, Int> = Product("Daia",10_000) // atau
        val product1 = Product("Daia",10_000)

        product1.printDataProduct()

        val productName: String = product1.name
        val productPrice: Int = product1.price
        println(productName)
        println(productPrice)
        println("= = = = = = = = = =")

}