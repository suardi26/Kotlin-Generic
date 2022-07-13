/**
    - Generic parameter type tidak hanya bisa digunakan pada class atau interface, namun bisa juga pada sebuah function.
    - Generic parameter type yang dideklarasikan pada sebuah function, hanya dapat diakses pada function tersebut,
      namun tidak dapat diakses diluar function.
    - Membuat Generic function sangat cocok digunakan ketika tanpa harus mengubah deklarasi sebuah class.
    - Berbeda dengan membuat generic type/generic class yang harus menambahkan nama generic parameter type dalam diamond
      operator '<>'setelah nama class-nya. Sedangkan untuk membuat generic function harus menambahkan nama
      generic parameter type dalam diamond operator '<>'sebelum nama function-nya.
        contoh :  'fun <T> printCategory(param: T){...}'.

    - Dan apabila generic function dibuat dalam generic type/generic class maka harus diperhatikan ketika nama generic
      parameter type itu sama yang ada di class dan di function, maka yang terjadi nama generic parameter type yang
      di class di-override pada function-nya sehingga yang berlaku adalah generic parameter type yang ada di
      function tersebut.

    - Memanggil generic function dapat dengan memanggil nama function-nya dengan menambahkan generic type dalam
      diamond operator '<>' atau bisa juga tidak.
            contoh = 'animal1.printCategory<String>("Predator")'
                     'animal1.printCategory("Predator")'

    - Multiple Parameter Type pada generic Function.
        - Parameter type di Generic function boleh lebih dari 1, tapi harus menggunakan nama generic parameter
          type berbeda. Misalnya : 'fun <T,U,Y> printInfo(food: T, numberOfFoot: U, age: Y){{...}'
 */

// membuat class biasa
class Animal(val name: String){

    // membuat generic function
    fun <T> printCategory(param: T){
        println("Animal : ${this.name}, Type : $param")
    }

    // Multiple Parameter Type pada generic Function.
    fun <T,U,Y> printInfo(food: T, numberOfFoot: U, age: Y){
        println("""
            Nama        : ${this.name}
            Makanan     : $food
            Jumlah Kaki : $numberOfFoot
            Umur        : $age Tahun
        """.trimIndent())
    }
}

// Membuat generic type/generic class
// dimana nama generic paramter type adalah 'T' sama dengan nama generic parameter yang ada pada function showAge().
class Staff<T>(val name: T){

    // Membuat nama generic paramter 'T' pada function, dimana sama dengan nama generic parameter yang ada pada class
    // Staff. Maka nama generic parameter 'T' yang ada pada class Staff akan di-override pada function ini, dan generic
    // parameter type yang berlaku adalah pada function tersebut.
    fun <T> getAge(age: T): T{
        return age
    }
}

fun main() {
    // membuat object dari class biasa dan memanggil generic function.
        val animal1 = Animal("Crocodile")
        // animal1.printCategory<String>("Predator")
        animal1.printCategory("Predator")

    // Memanggil Generic function (Multiple Parameter Type pada generic Function)
        // animal1.printInfo<String, Int, Int>("Meat", 4, 2)
        animal1.printInfo("Meat", 4, 2)
        println("= = = = = = = = = =")

    // membuat object dari generic class/generic type dan memanggil generic function.
    // mengganti generic parameter type yang ada pada genric class menjadi tipe data String.
        val staff1: Staff<String> = Staff<String>("Gunawan")

        // memanggil generic function dan memasukan value Int, maka generic parameter type yang berlaku adalah
        // yang ada pada function ini, karena nama generic parameter pada class-nya dan pada function ini sama
        // yaitu 'T', sehingga generic parameter pada class-nya akan di-override pada function ini.
        // Sehingga pada function ini return value-nya bukan String melainkan Int.

        //val ageStaff1: Int = staff1.getAge<Int>(25)
        val ageStaff1: Int = staff1.getAge(25)

}