package exercises

object OOBasicsExercise extends App {

  val writer = new Writer("Nyra", "Bandi", 2023)
  println(s"Writer full name: ${writer.fullName}")
  val novel = new Novel("Hungry caterpillar", 2025, writer)
  println(s"Author age: ${novel.authorAge}")
  println(novel.isWrittenBy(writer))
  println(novel.isWrittenBy(new Writer("Malli", "Bandi", 1988)))
  println(novel.copy(2026).yearOfRelease)
}

/*
    Novel and a Writer

    Writer: firstname, surname, year
    -method fullname

    Novel: name, year of release, author
    - authorAge
    - isWrittenBy(author)
    - copy(new year of release) = new instance of Novel
 */

class Writer(firstName: String, lastName: String, val year: Int) {
  def fullName: String = s"$firstName $lastName"
}

class Novel(name: String, val yearOfRelease: Int, author: Writer) {
  def authorAge: Int = yearOfRelease - author.year

  def isWrittenBy(author: Writer): Boolean = author.equals(this.author)

  def copy(newYear: Int) :Novel = new Novel(name, newYear, author)

}