/**
    - Secara default, saat membuat generic parameter type, sifat parameter tersebut adalah invariant.
    - Invariant artinya tidak boleh ada substitusi dengan subtype(child) atau supertype(parent).
    - Polymorphism tidak berlaku pada Generic Parameter type, Contohnya pada saat membuat object Contoh<String>,
      maka tidak sama dengan contoh <Any>, begitupun sebalik-nya, saat membuat object Contoh<Any>, maka tidak sama
      dengan Contoh<String>, jadi Generic parameter type tidak dapat terjadi polymorphism baik itu substitusi
      object dari superclass ke subclass ataupun dari subclass ke superclass.
 */

// membuat generic class (invariant).
class Invariant<T>(val data:T)

fun main() {
    val data1: Invariant<String> = Invariant("Suardi")

    // objectnya dengan parameter type String tidak dapat di substitusi pada object dengan parameter type Any.
    //val data2: Invariant<Any> = data1 // erorr Invariant
}