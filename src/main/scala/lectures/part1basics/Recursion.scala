package lectures.part1basics

import scala.annotation.tailrec

object Recursion extends App {
  def factorial(n: Int): BigInt =
    if (n <= 1) 1
    else n * factorial(n - 1)

 // println(factorial(10000)) // stack over flow

  def anotherFactorial(n: Int): BigInt = {
    @tailrec //force the compiler to check if the recursion is tail recursion 
    def factHelper(x: Int, accumulator: BigInt): BigInt =
      if (x <= 1) accumulator
      else factHelper(x - 1, x * accumulator) // doesn't need to store the intermediate value in stack - TAIL RECURSION - use recursive call as the last expression

    factHelper(n, 1)
  }

  println(anotherFactorial(10000))
  
  // When you need loops use tail recursion
}
