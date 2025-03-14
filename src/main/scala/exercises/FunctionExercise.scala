package exercises

object FunctionExercise extends App {
  // A greeting function (name, age) => "Hi, my name is $name and I am $age years old
  def greeting(name: String, age: Int): String = {
    "Hi, my name is $name and I am $age year(s) old"
  }

  println(greeting("Nyra", 1))

  // Factorial function
  def factorial(n: Int): Int =
    if (n == 1) n
    else n * factorial(n - 1)


  println(factorial(5))

  // Fibonacci function
  def fibonacci(n: Int): Int =
    if (n <= 1) n
    else fibonacci(n - 1) + fibonacci(n - 2)


  println(fibonacci(6))

  // Tests if a number is prime
  def isPrime(n: Int): Boolean = {
    def isPrimeUntil(t: Int): Boolean =
      if (t <= 1) true
      else n % t != 0 && isPrimeUntil(t - 1)
    isPrimeUntil(n / 2)
  }

  println(isPrime(5))
  println(isPrime(10))
  println(isPrime(2003))

}
