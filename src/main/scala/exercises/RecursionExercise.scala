package exercises

import scala.annotation.tailrec

object RecursionExercise extends App {

  // concatenate a string n times using tail recursion
  def stringConcat(s: String, n: Int): String = {
    @tailrec
    def helper(s: String, accumulator: String, n: Int): String =
      if (n == 1) accumulator
      else helper(s, s + " " + accumulator, n - 1)

    helper(s, s, n)
  }

  println(stringConcat("hello", 3))

  // isPrime function tail recursive
  def isPrime(n: Int): Boolean = {
    def isPrimeUntil(t: Int, isStillPrime: Boolean): Boolean =
      if(!isStillPrime) false
      else if (t <= 1) true
      else isPrimeUntil(t - 1, n % t != 0)

    isPrimeUntil(n / 2, true)
  }

  println(isPrime(5))
  println(isPrime(10))
  println(isPrime(2003))

  //fibonacci function tail recursive
  def fibonacci(n: Int): Int = {
    @tailrec
    def helper(n:Int, lastValue: Int, sum: Int): Int =
      if(n <= 2) sum
      else {
        val temp = sum - lastValue
        helper(n-1, temp, sum+temp)
      }

    helper(n, 0, 1)
  }
  println(fibonacci(6))

}
