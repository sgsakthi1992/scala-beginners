package exercises

object ObjectOrientedExercises extends App {
  /*
    1. Generic trait MyPredicate[-T] with a little method test(T) => Boolean
    2. Generic trait MyTransformer[-A, B] with a method transform(A) => B
    3. MyList:
       - map(transformer) => MyList
       - filter(transformer) => MyList
       - flatMap(transformer from A to MyList[B]) => MyList[B]

       class EvenPredicate extends MyPredicate[Int]
       class StringToIntTransformer extends MyTransformer[String, Int]

       [1, 2, 3].map(n * 2) = [2, 4, 6]
       [1, 2, 3, 4].filter(n % 2) = [2, 4]
       [1, 2, 3].flatMap(n => [n, n+1]) => [1, 2, 2, 3, 3, 4]
   */

  trait MyPredicate[-T] {
    def test(value: T): Boolean
  }

  object EvenPredicate extends MyPredicate[Int] {
    override def test(value: Int): Boolean = value % 2 == 0
  }

  trait MyTransformer[-A, B] {
    def transform(value: A): B
  }

  object DoubleTransformer extends MyTransformer[Int, Int] {
    override def transform(value: Int): Int = value * 2
  }

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

    def map[B](myTransformer: MyTransformer[A, B]): MyList[B]

    def flatMap[B](myTransformer: MyTransformer[A, MyList[B]]): MyList[B]

    def filter(myPredicate: MyPredicate[A]): MyList[A]

    def ++[B >: A](list: MyList[B]): MyList[B]
  }

  object Empty extends MyList[Nothing] {
    def head: Nothing = throw new NoSuchElementException

    def tail: MyList[Nothing] = throw new NoSuchElementException

    def add[B >: Nothing](value: B): MyList[B] = new Cons(value, Empty)

    def isEmpty: Boolean = true

    def map[B](myTransformer: MyTransformer[Nothing, B]): MyList[B] = Empty

    def flatMap[B](myTransformer: MyTransformer[Nothing, MyList[B]]): MyList[B] = Empty

    def filter(myPredicate: MyPredicate[Nothing]): MyList[Nothing] = Empty

    def ++[B >: Nothing](list: MyList[B]): MyList[B] = Empty
  }

  class Cons[+A](h: A, t: MyList[A]) extends MyList[A] {

    override def head: A = h

    override def tail: MyList[A] = t

    override def add[B >: A](value: B): MyList[B] = new Cons(value, this)

    override def isEmpty: Boolean = false

    override def filter(predicate: MyPredicate[A]): MyList[A] = {
      if (predicate.test(h)) new Cons(h, t.filter(predicate))
      else t.filter(predicate)
    }

    override def map[B](myTransformer: MyTransformer[A, B]): MyList[B] =
      new Cons(myTransformer.transform(h), t.map(myTransformer))


    override def flatMap[B](myTransformer: MyTransformer[A, MyList[B]]): MyList[B] =
      myTransformer.transform(h) ++ t.flatMap(myTransformer)


    override def ++[B >: A](list: MyList[B]): MyList[B] = new Cons(h, t ++ list)
    /*
     [1, 2] ++ [3]
     = new Cons(1, [2] ++ [3])
     = new Cons(1, new Cons(2, Empty ++ [3])
     = new Cons(1, new Cons(2, new Cons(3))
     */
  }

  val listOfIntegers: MyList[Int] = new Cons(1, new Cons(2, new Cons(3, new Cons(4, Empty))))
  println(listOfIntegers.toString)

  val filteredList = listOfIntegers.filter(EvenPredicate)
  println(filteredList.toString)

  val mappedList = listOfIntegers.map(DoubleTransformer)
  println(mappedList.toString)

  val flatmappedList = listOfIntegers.map((value: Int) => new Cons(value, new Cons(value + 1, Empty)))
  println(flatmappedList.toString)
}
