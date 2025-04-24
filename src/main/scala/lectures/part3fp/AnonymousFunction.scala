package lectures.part3fp

object AnonymousFunction extends App {
  // anonymous function or Lambda
  val doubler = (x: Int) => x * 2
  println(doubler(4))

  //multiple parameters
  val adder = (a: Int, b: Int) => a + b

  //no parameters
  val justDoSomething = () => 3

  println(justDoSomething) //prints the function
  println(justDoSomething()) //must call with the parenthesis

  // curly braces with lambda
  val stringToInt = { (str: String) =>
    str.toInt
  }

  // MOAR syntactic sugar
  val niceIncrementer: Int => Int = _ + 1 // equivalent to x => x + 1
  val niceAdder: (Int, Int) => Int = _ + _ // equivalent to (a, b) => a+b
}
