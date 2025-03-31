package exercises

object OOPBasicsExercise2 extends App {

  val counter = new Counter()
  counter.increment.print
  counter.increment(3).increment.print
  counter.increment(5).decrement(2).print
}

class Counter(value: Int = 0) {
  def currentCount: Int = value

  def increment: Counter = new Counter(value + 1) //immutability

  def decrement: Counter = new Counter(value - 1)

  def increment(amount: Int): Counter =
    if (amount <= 0) this
    else increment.increment(amount - 1)

  def decrement(amount: Int): Counter =
    if (amount <= 0) this
    else decrement.decrement(amount - 1)

  def print: Unit = println(currentCount)
}
