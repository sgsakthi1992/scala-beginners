package lectures.part3fp

object WhatsAFunction extends App {
  // use functions as first class elements

  trait MyFunction[A, B] {
    def apply(element: A): B
  }

  val doubler = new MyFunction[Int, Int] {
    override def apply(element: Int): Int = element * 2
  }

  println(doubler(2))

  // function types - Function1 till Function22 upto 22 parameters
  val stringToInt = new Function[String, Int] {
    override def apply(v1: String): Int = v1.toInt
  }

  println(stringToInt("3") + 4)

  val adder = new Function2[Int, Int, Int] {
    override def apply(v1: Int, v2: Int): Int = v1 + v2
  }

  // Function types Function2[A, B, R] is equivalent to (A,B) => R //syntactic sugar
  println(adder(3, 4))

  val multipler: (Int, Int) => Int = (v1, v2) => v1 * v2

  println(multipler(3, 4))

  // ALL SCALA FUNCTIONS ARE OBJECTS

}
