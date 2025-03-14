package lectures.part1basics

object ValuesVariablesTypes extends App {

  // Values

  // VAL's are immutable, cant reassign the value
  val x: Int = 42
  println(x)

  // types are optional. Compiler will infer types
  val y = 10
  println(y)
  val aString: String = "hello"
  val anotherString = "hi"

  val aBoolean: Boolean = true
  val anotherBoolean = false

  val aChar: Char = 'a'
  val anotherChar = 'b'

  val aShort: Short = 4613
  val aLong: Long = 567897549912465L
  val aFloat: Float = 2.0
  val aDouble: Double = 3.14

  // Variables (can be reassigned, it is mutable)
  var aVariable = 4
  aVariable = 5 // (side effects)
}
