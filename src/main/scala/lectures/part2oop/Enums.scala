package lectures.part2oop

object Enums extends App {
  enum Permissions {
    case READ, WRITE, EXECUTE, NONE

    // add fields/methods
    def openDocument: Unit =
      if (this == READ) println("opening document")
      else println("reading not allowed")
  }

  val somePermissions: Permissions = Permissions.READ
  println(somePermissions)
  somePermissions.openDocument

  //can take constructor arguments
  enum PermissionWithBits(bits: Int) {
    case READ extends PermissionWithBits(4)
    case WRITE extends PermissionWithBits(2)
    case EXECUTE extends PermissionWithBits(1)
    case NONE extends PermissionWithBits(0)
  }

  //can have companion objects
  object PermissionWithBits {
    def fromBits(bits :Int): PermissionWithBits = PermissionWithBits.NONE
  }

  // standard API of enum
  val somePermissionOrdinal = somePermissions.ordinal
  println(somePermissionOrdinal)

  val allPermissions = PermissionWithBits.values
  println(allPermissions.length)

  val readPermission = Permissions.valueOf("READ")
  println(readPermission)
}
