/**
    - Kadang ada kasus kita tidak peduli dengan generic parameter type pada object.
        misal: kita cuma ingin memanggil function atau properties pada generic object tersebut tapi tidak ada hubungan-nya
        dengan generic type-nya.
    - Misal kita hanya ingin mengambil panjang data Array<T>, dan kita tidak peduli dengan isi data T-nya.
    - Jika kita mengalami kasus seperti ini, kita dapat menggunakan Star Projection.
    - Star Projection dapat dibuat dengan mengganti generic parameter type dengan karakter '*' (star).
 */

// Contoh membuat function dengan parameter (Star Projection)
fun displayLength(array: Array<*>){
    println("Banyak-nya data : ${array.size}")
}

fun main() {
    val arrayInt: Array<Int> = arrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    val arrayString: Array<String> = arrayOf("Football","Golf", "Rugby")
    displayLength(arrayInt)
    displayLength(arrayString)
}