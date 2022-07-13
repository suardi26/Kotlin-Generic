/**
    Comparable.
    - Sebelumnya, kita sudah mengetahui bahwa opertar perbandingan '==' dan '!=' akan menggunakan function equals
      sebagai implementasi-nya.
    - Bagaimana dengan operator perbandingan lainnya, seperti '>', '>=', '<', '<=', Operator perbandingan tersebut dapat
      dilakukan, jika object kita mewariskan interface generic Comparable.
    - interface generic Comparable banyak digunakan seperti proses pengurutan data.
    - Dan beberapa class di kotlin sudah implement Comparable, seperti Int, String, dll. sehingga
      kita dapat juga memanggil function dari object number seperti Int, Double, dll.
 */

// Membuat class dengan turunan interface Comparable.
class Product (val name: String, val qty: Int) : Comparable<Product>{

    // Dapat membandingkan kedua properties dari kedua object dari class/tipe data yang sama.
    override fun compareTo(other: Product): Int {
        // Dan beberapa class di kotlin sudah implement Interface Comparable, seperti Int, String, dll. sehingga
        // kita dapat juga memanggil function 'compareTo' dari object number seperti Int, Double, dll.
        return this.qty.compareTo(other.qty)
    }
}

fun main() {
    val product1 = Product("Beng-Beng", 10)
    val product2 = Product("Oreo", 20)
    val compare1: Boolean = product1 > product2
    val compare2: Boolean = product1 < product2
    val compare3: Boolean = product1 == product2
    println("Apakah ${product1.qty} ${product1.name} lebih banyak dari ${product2.qty} ${product2.name} = $compare1")
    println("Apakah ${product1.qty} ${product1.name} lebih Sedikit dari ${product2.qty} ${product2.name} = $compare2")
    println("Apakah ${product1.qty} ${product1.name} sama dengan ${product2.qty} ${product2.name} = $compare3")
}