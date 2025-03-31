package lectures.part2oop

object Exceptions extends App {
  val x: String = null
  // println(x.length) //null pointer exception


  // throwing & catching exceptions
  //val aWeirdValue = throw new NullPointerException

  //catching exceptions
  def getInt(withExceptions: Boolean): Int =
    if (withExceptions) throw new RuntimeException("No Int for you")
    else 42

  val potentialFail = try {
    getInt(true)
  } catch {
    case e: RuntimeException => "Caught a runtime exception"
    case e1: Exception => "Caught a generic exception"
  } finally {
    //does not influence the return type of this expression
    //use finally only for side effects
    println("Finally!!")
  }
  println(potentialFail)

  //own exceptions or custom exceptions
  class MyException extends Exception
  val exception = new MyException
  throw exception
}
