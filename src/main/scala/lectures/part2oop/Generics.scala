package lectures.part2oop

object Generics extends App {

  class MyList[A] {
    // use the type A
  }

  val listOfIntegers = new MyList[Int]
  val listOfStrings = new MyList[String]

  class MyMap[Key, Value] {

  }

  //traits can also be type parameterised

  //generic methods
  object MyList {
    def empty[A]: MyList[A] = ???
  }

  val emptyListOfIntegers = MyList.empty[Int]

  //variance problem
  class Animal

  class Cat extends Animal

  class Dog extends Animal

  // does List[Cat] also extends List[Animal]?
  // 1. Yes List[Cat] extends List[Animal] = COVARIANCE
  class CovariantList[+A] // +A is covariance

  val animal: Animal = new Cat
  val animalList: CovariantList[Animal] = new CovariantList[Cat]
  //can I add animal to it? amimalList.add(new Dog) ?? HARD Question => we return list of animals

  // 2. No = INVARIANCE
  class InvariantList[A]
  // val invariantList: InvariantList[Animal] = new InvariantList[Cat] //compiler throws error

  // 3. Hell, no = CONTRAVARIANCE
  class Trainer[-A]

  val trainer: Trainer[Cat] = new Trainer[Animal]

  // bounded types
  class Cage[A <: Animal](animal: Animal) //accepts only the subclasses of Animal

  val cage = new Cage(new Dog)

  // >: accepts only super type

  class MySet[+A] {
    //use the type A
    // def add(element: A): MySet[A] = ??? //not allowed : Covariant type A occurs in contravariant position in type A of value element
    def add[B >: A](element: B): MySet[B] = ???
    /*
    A = Cat
    B = Animal
     */
  }
}
