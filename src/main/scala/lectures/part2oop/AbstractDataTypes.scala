package lectures.part2oop

object AbstractDataTypes extends App {

  // abstract - cannot be instantiated
  abstract class Animal {
    val creatureType: String

    def eat: Unit
  }

  class Dog extends Animal {
    override val creatureType: String = "Canine"

    override def eat: Unit = println("crunch crunch") //override keyword is not mandatory
  }

  //traits
  trait Carnivore {
    def eat(animal: Animal): Unit
  }

  class Crocodile extends Animal with Carnivore {

    override val creatureType: String = "croc"

    override def eat: Unit = println("nom nom nom")

    override def eat(animal: Animal): Unit = println(s"I'm a croc and i'm eating ${animal.creatureType}")
  }

  val dog = new Dog
  val croc = new Crocodile
  croc.eat(dog)

  //traits vs abstract classes
  // both traits & abstract classes can have abstract & non-abstract members
  // traits cannot have constructor parameters
  // multiple traits may be inherited but can extend only one class
  // traits are behavior, abstract class is a type of thing

}
