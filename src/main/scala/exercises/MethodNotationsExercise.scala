package exercises

import scala.language.postfixOps

object MethodNotationsExercise extends App {
  /*
    1. Overload the + operator
      mary + "the rockstar" => new person "Mary (the rockstar)" with same fav movie

    2. Add an age to the Person class
       Add a unary operator => new person with the age + 1
       +mary => mary with the age increment

    3. Add a "learns" method in the Person class => "Mary learns Scala"
       Add a learnsScala method, calls learns method with "Scala"
       Use it in a postfix notation.

    4. Overload the apply method
       marry.apply(2) => "Mary watched Inception 2 times
   */

  class Person(val name: String, val age: Int, favMovie: String) {
    def +(nickName: String): Person = new Person(s"$name ($nickName)", age, favMovie)

    def unary_+ : Person = new Person(name, age + 1, favMovie)

    def learns(lang: String): String = s"$name learns $lang"

    def learnsScala: String = this learns "Scala"

    def apply(count: Int): String = s"$name watched $favMovie $count times"
  }

  val mary = new Person("Mary", 18, "Inception")

  val nickNameMary = mary + "the rockstar"
  println(nickNameMary.name)

  val newAgeMary = +mary
  println(newAgeMary.age)

  println(mary learnsScala)

  println(mary(2))

}
