package lectures.part2oop

object AnonymousClasses extends App {
  abstract class Animal {
    def eat: Unit
  }

  //anonymous class - works for traits & classes (even not abstract)
  val funnyAnimal: Animal = new Animal {
    override def eat: Unit = println("Hahahaha")
  }
  /*
  equivalent with

      class AnonymousClasses$$anon$1 extends Animal {
         override def eat: Unit = println("Hahahaha")
      }
      val funnyAnimal: Animal = new AnonymousClasses$$anon$1
   */

  println(funnyAnimal.getClass)
  funnyAnimal.eat

  class Person(name: String) {
    def sayHi: Unit = println(s"Hi, my name is $name")
  }

  val jim = new Person("Jim") { //need to pass the required constructor arguments
    override def sayHi: Unit = println(s"Hello, my name is Jim")
  }

  jim.sayHi
}
