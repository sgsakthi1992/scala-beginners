package lectures.part2oop

object CaseClasses extends App {
  /*
  equals, hashCode, toString
   */

  case class Person(name: String, age: Int)

  // 1. class parameters are promoted to fields
  val jim = new Person("Jim", 34)
  println(jim.name)

  // 2. sensible toString
  println(jim.toString)
  println(jim) //in turns toString - syntactic sugar

  // 3. equals & hashCode implemented out of the box
  val jim2 = new Person("Jim", 34)
  println(jim == jim2)

  // 4. have handy copy methods
  val jim3 = jim.copy(age = 45)
  println(jim3)

  // 5. case classed have companion objects
  val thePerson = Person
  val mary = Person("Mary", 23) //apply method
  
  // 6. CCs are serializable
  // Akka
  
  // 7. CCs have extractor patterns = CCs can be used in Pattern Matching
  
  case object UnitedKingdom { //have everything as CCs exception Companion object
    def name : String = "The UK of GB & NI "
  }
}
