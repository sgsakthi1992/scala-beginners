package lectures.part1basics


object StringOps extends App {
  val str: String = "Hello, I'm learning Scala"

  println(str.charAt(2))
  println(str.substring(0,5))
  println(str.split(" ").toList)
  println(str.startsWith("Hello"))
  println(str.replace(" ", "-"))
  println(str.toLowerCase)
  println(str.length)

  val aNumberString = "2"
  val aNumber = aNumberString.toInt
  println(aNumber)

  println('a' +: aNumberString :+ 'z')
  println(str.reverse)
  println(str.take(2))
  println(str.takeRight(2))

  // Scala specific: String interpolators
  // S-interpolator
  val name= "Nyra"
  val age = 1
  val greeting = s"Hello, my name is $name and I'm $age year old" //it should start with s otherwise name and age
  val anotherGreeting = s"Hello, my name is $name and I'm ${age+1} year old"
  println(greeting)
  println(anotherGreeting)

  //F-interpolator (for formatted strings similar to printf)
  val speed = 1.2f
  val myth = f"$name can eat $speed%2.2f burgers per minute"
  println(myth)

  //raw-interpolator
  println(raw"This is a \n newline") //\n will not be escaped

  val escaped = "This is a \n newline"
  println(raw"$escaped") //here \n will be escaped
}
