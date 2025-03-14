package lectures.part1basics

object Expressions extends App {
  val x = 1 + 2
  println(x)

  println(2 + 3 * 4) // + - * / & | ^ << >> >>>(right shift with zero extension - specific to scala)

  println(1 == x) // == != > >= < <=

  println(!(1 == x)) // ! && ||

  var aVariable = 2
  aVariable += 3 // += -= *= /= (all these are side effects)
  println(aVariable)

  // Instructions (Do something) vs Expressions (Give me the Value) - instructions are executed(Java), expressions are evaluated(Scala)

  val aCondition = true
  val aConditionedValue = if (aCondition) 5 else 3 // IF in scala is an Expression

  println(aConditionedValue)
  println(if (aCondition) 5 else 3)

  var i = 0
  val aWhile = while (i < 10) {
    println(i)
    i += 1
  } // Never write this again. This is imperative programming like Java

  // Everything in Scala is an expression

  val aWeirdValue = aVariable = 3 // Unit is a special type in scala which is equivalent to void
  println(aWeirdValue)

  //side effects: println(), while's, reassigning which returns Unit

  // Code blocks
  val aCodeBlock = {
    val y = 2
    val z = y + 1
    if (z > 2) "hello" else "bye" // val y & z are not available outside this block
  }

  println(aCodeBlock)

  val someValue = { 2 < 3 }
  val someOtherValue = {
    if (someValue) 123 else 456
    42
  } // takes the last expression as the value

    println(someOtherValue)
}
