/**
    - Kadang kita ingin membatasi data yang boleh digunakan pada generic paramter type.
    - Kita dapat menambahkan constraint pada generic parameter type dengan menyebutkan tipe data yang diperbolehkan.
    - Secara otomatis, type data yang dapat digunakan adalah type yang sudah kita sebutkan, atau
      class-class turunan-nya.
    - secara default, constraint type untuk generic parameter type adalah Any, sehingga semua tipe data dapat digunakan.
            secara default  :    'class Company <T : Any>(val employee: T)'
            bisa juga       :    'class Company <T> (val employee: T)'.
    - Cara menambahkan generic constraint pada generic parameter type adalah dengan menambahkan  ':' dan diikuti dengan
      tipe data-nya setelah nama generic parameter type-nya. contoh : 'class Company <T : Employee>(val employee: T)'.

    Where Keyword
    - Kadang kita ingin membatasi type data dengan beberapa jenis type data pada generic paramter type
      misalnya : type data pada generic parameter dari class A dan juga Class B atau interface B.
    - Secara default, hanya satu type data yang dapat digunakan untuk membatasi generic paramter type.
    - Namun jika ingin menggunakan lebih dari satu type data, kita dapat menggunakan keyword 'where'.
        Contoh : 'class VicePresident<T>(val employee: T) where T : Employee, T : CanSayHello'
 */

interface CanSayHello{
    fun sayHello(name: String)
}

open class Employee
class Manager : Employee()
class Staff : Employee(), CanSayHello{
    override fun sayHello(name: String) {
        println("Hello $name")
    }
}

// Menambahkan class Employee pada constraint generic parameter type, sehingga tipe data yang dapat mengisi generic
// type-nya adalah class Employee dan turunan-nya.
class Company<T : Employee>(val employee: T)

// Menambahkan class Employee dan juga interface CanSayHello pada constraint generic parameter type dengan keyword
// 'where', sehingga tipe data yang dapat mengisi generic type-nya adalah
class VicePresident<T>(val employee: T) where T : Employee, T : CanSayHello


fun main(){
    // Harus memasukan generic type dari class Employee atau turunan-nya.
    val data1 = Company<Employee>(Employee())
    val data2 = Company<Manager>(Manager())

    // maka akan error karena object yang dimasukan bukan object dari class Employee atau turunan-nya melainkan object
    // dari Class String.
    // val data3 = Company("PT. Suska")

    // Harus memasukan generic type dari class Employee atau turunan-nya dan dari interface CanSayHello atau turunan-nya.
    val data4 = VicePresident(Staff())

    // erorr karena class Manager hanya turunan dari class Employee dan bukan turunan dari interface CanSayHello.
    // val data5 = VicePresident(Manager())
}