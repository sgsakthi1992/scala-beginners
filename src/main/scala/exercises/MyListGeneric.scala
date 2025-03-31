package exercises

object MyListGeneric extends App {
  abstract class MyList[+A] {
    def head: A

    def tail: MyList[A]

    def isEmpty: Boolean

    def add[B >: A](value: B): MyList[B]

    override def toString: String = {
      if (tail.isEmpty)
        s"$head"
      else s"$head - " + tail.toString
    }
  }

  object Empty extends MyList[Nothing] {
    def head: Nothing = throw new NoSuchElementException

    def tail: MyList[Nothing] = throw new NoSuchElementException

    def add[B >: Nothing](value: B): MyList[B] = new Cons(value, Empty)

    def isEmpty: Boolean = true
  }

  class Cons[+A](h: A, t: MyList[A]) extends MyList[A] {

    override def head: A = h

    override def tail: MyList[A] = t

    override def add[B >: A](value: B): MyList[B] = new Cons(value, this)

    override def isEmpty: Boolean = false
  }

  val listOfIntegers: MyList[Int] = new Cons(1, new Cons(2, new Cons(3, Empty)))
  println(listOfIntegers.toString)

  val listOfStrings: MyList[String] = new Cons("A", new Cons("B", new Cons("C", Empty)))
  println(listOfStrings.toString)

  val listOfChars1: MyList[Char] = new Cons('c', Empty)
  val listOfChars2 = listOfChars1.add('b')
  val listOfChars3 = listOfChars2.add('a')
  println(listOfChars3.toString)

  val typecastlist: MyList[Any] = listOfChars3.add("D")
  println(typecastlist)
}
