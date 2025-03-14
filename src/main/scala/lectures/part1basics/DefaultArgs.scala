package lectures.part1basics

import scala.annotation.tailrec

object DefaultArgs extends App {

  @tailrec
  def factorial(x: Int, accumulator: Int = 1): Int = //accumulator with default value as 1
    if (x <= 1) accumulator
    else factorial(x - 1, x * accumulator)

  val fact10 = factorial(10)
  println(fact10)

  //leading parameter with default values are not allowed by compiler
  def savePics(format: String = "jpeg", width: Int = 1920, height: Int = 1080): Unit = println("saving pics")
  savePics("bmp")
  /*
  1. pass in every leading argument
  2. name the arguments
   */
  savePics(width = 800) //compiler will take default value for other arguments
}
