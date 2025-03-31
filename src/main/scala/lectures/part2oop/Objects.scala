package lectures.part2oop

import scala.language.postfixOps

object Objects extends App {

  //SCALA DOES NOT HAVE CLASS LEVEL FUNCTIONALITY ("static")
  //equivalent in scala in object
  //class level definitions, we use object in scala

  object Person { //type + its only instance
    //static or class level functionality
    val N_EYES = 2

    def canFly: Boolean = false

    //Factory method
    def apply(mother: Person, father: Person): Person = new Person("Bobby")
  }

  class Person(val name: String) {
    //instance-level functionality
  }
  //writing class and object with the same name is called Companions - reside in the same scope & has the same name
  // Companions can access each other private members

  println(Person.N_EYES)
  println(Person canFly)

  //Scala object is an SINGLETON INSTANCE
  val person1 = Person
  val person2 = Person
  println(person1 == person2)

  val mary = new Person("Mary")
  val john = new Person("John")

  val bobby = Person(mary, john) //apply factory method in Person singleton object

  // Scala applications = Scala object with 
  // def main(args: Array[String]): Unit
  // extends App otherwise

}
