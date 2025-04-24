package exercises

/*
  1. a function which takes 2 strings and concatenates them
  2. transform the MyPredicate and MyTransformer into function types
  3. define a function which takes an int and returns another function which takes an int and returns an int
    - what's the type of this function
    - how to do it
 */

object FunctionalProgrammingExercise extends App {
  // 1
  val stringConcat: (String, String) => String = (s1, s2) => s"$s1 $s2"
  println(stringConcat("Hello", "World"))

  // 3 - higher-order function
  val superAdder: Int => (Int => Int) = x => y => x + y
  val adder3 = superAdder(3)
  println(adder3(4))
  println(superAdder(3)(4)) //curried function
}
