import javax.xml.crypto.Data

/**
    - Generic adalah penambahan parameter type saat membuat class atau function.
    - Berbeda dengan tipe data yang digunakan pada sebuah atribut class atau function, Generic parameter type
      memungkinkan kita bisa menggunakan tipe data yang berbeda-beda setiap pembuatan object ataupun pemanggilan
      function tanpa harus menggunakan overloading function.

    Pemanfaatan Generic
    - Pada saat melakukan casting object misal dari class Any ke String dan ternyata value-nya bukan String maka
      akan erorr, dan errornya tidak terjadi pada saat kompilasi code menjadi binary code namun pada saat
      program berjalan, hal ini sangat berbahaya.
    - Namun dengan menggunakan Generic paramter type, maka akan dilakukan pengecekan ketika proses kompilasi.
    - Jadi pada saat program selesai di compile sebenarnya Generic parameter type data akan hilang digantikan
      dengan tipe data yang di gunakan pada saat pemanggilan object ataupun pemanggilan function dengan Generic
      parameter type, sehingga Pengecekan errornya dapat diketahui pada saat program di compile tidak pada saat
      program berjalan (running).
    - Compiler akan mengubah generic parameter type menjadi tipe data Any (Object di java), dimana tipe data Any
      dapat di diisi seluruh class pada kotlin karena tipe data Any adalah superclass dari seluruh class di Kotlin.
    - Dengan kata lain Generic parameter type (informasi generic) yang kita buat akan hilang ketika kode
      program telah di compile menjadi binary file.
    - Dengan adanya generic parameter type kita tidak perlu lagi melakukan pengecekan tipe data & konversi tipe data
      secara manual.
    - Generic parameter type juga memudahkan kita dalam membuat kode program yang generic
      sehingga bisa digunakan oleh berbagai macam tipe data.

    - Contoh generic type pada Class : 'Class Data<T> (val data: T)
      dimana : <T> => adalah generic paramter type, yang pada saat pembuatan object dapat diganti dengan tipe data
      yang diinginkan. Dan tidak harus huruf 'T' bisa juga huruf lain yang dapat digunakan sebagai generic parameter
      type namun yang sering digunakan adalah huruf 'T'.
    - Untuk membuat object dari generic class maka harus menambahkan type data dalam diamond operator '<>' setelah
      nama class-nya. contoh : Data<String>("Suardi")

 */

// Contoh membuat class yang bukan Generic (menggunakan superclass dari semua class yang ada di kotlin yaitu 'Any').
class Data(val data: Any)

// Membuat generic class
class Product<T>(val name: T)

fun main(){
    // Perlu malakukan casting dari Any ke String.
    // Ketika memasukan value yang bukan String maka akan erorr, dan errornya tidak terjadi pada saat kompilasi code
    // menjadi binary code namun pada saat program berjalan.
    val dataString = Data("Suardi")
    val valueString: String = dataString.data as String

    // Perlu melakukan casting dari Any ke Int.
    val dataInt = Data(45)
    val valueInt = dataInt.data as Int

    // Membuat object dari generic class dan tidak perlu lagi melakukan casting
    val product1: Product<String> = Product<String>("Suardi")
    val nameOfProduct: String = product1.name
}