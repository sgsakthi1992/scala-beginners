package lectures.part2oop

object OOBasics extends App {
  val person = new Person("Nyra", 1)
  println(person.age)
  println(person.x)
  person.greet("Sakthi")
  person.greet
}

//constructor
class Person(name: String, val age: Int) {
  //body not an expression but defines the implementation
  val x = 2 //fields
  println(1 + 3) // this will be executed when the Person class is instantiated

  //method
  def greet(name: String): Unit = println(s"${this.name} says, Hi, $name")

  //overloading
  def greet: Unit = println(s"Hi, I'm $name")

  //multiple constructors
  def this(name: String) = this(name, 0) //can call only the main or another constructor
}

// class parameters are NOT FIELDS
// add val before the parameters to make that as a field