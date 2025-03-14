package lectures.part1basics

object CallByNumberVSCallByValue extends App {
  def calledByValue(x: Long): Unit = {
    println("by value: " + x)
    println("by value: " + x)
  }

  def calledByName(x: => Long): Unit = {
    println("by name: " + x) //equivalent to println("by name: " + System.nanoTime())
    println("by name: " + x) //equivalent to println("by name: " + System.nanoTime())
  }

  //by name parameter delays the evaluation of expression until it is used
  //expression is passed to the function
  //expression is evaluated every use within

  calledByValue(System.nanoTime())
  calledByName(System.nanoTime())

}
