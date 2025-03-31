package lectures.part2oop

import scala.language.postfixOps

object MethodNotations extends App {

  class Person(val name: String, favMovie: String) {
    def likes(movie: String): Boolean = movie == favMovie

    def +(person: Person): String = s"${this.name} is hanging out with ${person.name}"

    def unary_! : String = s"$name, what the heck?!" //have a space between name and : otherwise : will be treated as part of method name

    def isAlive: Boolean = true

    def apply(): String = s"Hi, my name is $name and I like $favMovie"
    def apply(msg: String): String = s"$msg $name"
  }

  val mary = new Person("Mary", "Inception")
  println(mary.likes("Inception"))

  println(mary likes "Inception") //equivalent to the above calling - method with the single parameter can be replaced like this
  //infix notation = operator notation(Syntactic sugar)

  //"operators" in scala
  var tom = new Person("Tom", "Fight Club")
  println(mary + tom)
  println(mary.+(tom))

  println(1 + 2)
  println(1L.+(2))
  //All operators are methods

  //Prefix notation (another form of syntactic sugar)
  val x = -1
  val y = 1.unary_- //same as -1

  println(!mary)
  println(mary.unary_!)

  //postfix notation
  println(mary.isAlive)
  println(mary isAlive) //method without parameters

  //apply
  println(mary.apply())
  println(mary()) //same as calling the apply method - apply method without any arguments and with empty parenthesis. Parenthesis is must
  println(mary("Hello")) //calling apply method with a single parameter
}

