package lectures.part2oop

import scala.language.postfixOps

object Inheritance extends App {

  //Single class inheritance
  class Animal {
    val creatureType = "wild"

    def eat: Unit = println("nonnom")
  }

  class Cat extends Animal

  val cat = new Cat
  cat eat

  //constructors
  class Person(name: String, age: Int)

  class Adult(name: String, age: Int, idCard: String) extends Person(name, age)

  //overriding
  class Dog extends Animal {
    override val creatureType = "domestic"

    override def eat: Unit = println("crunch crunch")
  }

  val dog = new Dog
  dog.eat
  println(dog.creatureType)
  println(cat.creatureType)

  //other way of overriding fields with constructor
  class Horse(override val creatureType: String) extends Animal

  val horse = new Horse("Domestic")
  println(horse.creatureType)

  class Donkey(creature: String) extends Animal {
    override val creatureType: String = creature
  }

  val donkey = new Donkey("Domestic")
  println(donkey.creatureType)

  // type substitution (broad: polymorphism)
  val unkownAnimal: Animal = new Dog
  unkownAnimal.eat

  //super
  class Pig extends Animal {
    override def eat: Unit = {
      super.eat
      println("oink oink")
    }
  }

  val pig = new Pig
  pig.eat
  
  //preventing overrides
  // 1. keyword final on member
  // 2. final on class (preventing extension)
  // 3. seal the class = allows to extend classes in this file prevents extension in other file
}
