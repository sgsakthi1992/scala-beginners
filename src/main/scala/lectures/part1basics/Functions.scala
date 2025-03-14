package lectures.part1basics

object Functions extends App {

  def aFunction(a: String, b: Int): String = a + " " + b

  println(aFunction("hello", 2))

  def aParameterLessFunction(): Int = 42

  println(aParameterLessFunction())

  def anotherParameterLessFunction: Int = 42

  println(anotherParameterLessFunction) // no parenthesis if we declare the function without parenthesis

  //concatenate the same string n number of times - recursive functions (don't use while loops)
  def aRepeatedFunction(aString: String, n: Int): String = {
    if (n == 1) aString
    else aString + " " + aRepeatedFunction(aString, n - 1)
  }

  println(aRepeatedFunction("hello", 3))

  // WHEN YOU NEED LOOPS, USE RECURSION

  // Compilers can infer the return type of function if we don't specify it
  // but a recursive functions should specify a return type and compilers can't infer that

  def aFunctionWithSideEffects(aString: String): Unit = println(aString)

  def aBigFunction(n: Int): Int = {
    def aSmallerFunction(a: Int, b: Int): Int = a + b
    aSmallerFunction(n, n -1)
  }
}
