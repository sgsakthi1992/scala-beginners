package exercises

object ExceptionExercise extends App {
  /*
  PocketCalculator
      - add(x,y)
      - subtract(x,y)
      - multiply(x,y)
      - divide(x,y)

      throw
        - OverflowException if add exceed Int.MAX_VALUE
        - UnderflowException if subtract exceeds Int.MIN_VALUE
        - MathCalculationException for division by 0
   */


  class OverflowException extends RuntimeException

  class UnderflowException extends RuntimeException

  class MathCalculationException extends RuntimeException("Division by zero")

  object PocketCalculator {
    def add(x: Int, y: Int): Int = {
      val result = x + y
      if (x > 0 && y > 0 && result < 0) throw new OverflowException
      else if (x < 0 && y < 0 && result > 0) throw new UnderflowException
      else result
    }

    def subtract(x: Int, y: Int): Int = {
      val result = x - y
      if (x > 0 && y < 0 && result < 0) throw new OverflowException
      else if (x < 0 && y > 0 && result > 0) throw new UnderflowException
      else result
    }

    def multiply(x: Int, y: Int): Int = x * y

    def divide(x: Int, y: Int): Int = {
      if (y == 0) throw new MathCalculationException
      else x / y
    }
  }

  //println(PocketCalculator.add(Int.MaxValue, 1))
  //println(PocketCalculator.subtract(Int.MinValue, 7))
  println(PocketCalculator.multiply(5, 10))
  println(PocketCalculator.divide(10, 0))
}
