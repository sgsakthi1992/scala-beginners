package exercises

/*
  head = first element of the list
  tail = remainder of the list
  isEmpty = is this list empty
  add(int) => new list with this element added
  toString => a string representation of the list
 */

abstract class MyList {
  def head: Int

  def tail: MyList

  def isEmpty: Boolean

  def add(value: Int): MyList

  override def toString: String = {
    if (tail.isEmpty)
      s"$head"
    else s"$head - " + tail.toString
  }
}

object Empty extends MyList {
  def head: Int = throw new NoSuchElementException

  def tail: exercises.MyList = throw new NoSuchElementException

  def add(value: Int): exercises.MyList = new IntList(value, Empty)

  def isEmpty: Boolean = true
}

class IntList(val h: Int, val t: MyList) extends MyList {

  override def head: Int = h

  override def tail: MyList = t

  override def add(value: Int): MyList = new IntList(value, this)

  override def isEmpty: Boolean = false
}

object InheritanceExercise extends App {
  val list1 = new IntList(1, Empty)
  val list2 = list1.add(2)
  val list3 = list2.add(3)
  println(list3.toString)
}
