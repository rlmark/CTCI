package tutoring

sealed trait Tree[+A] {
  val count: Int
}
case class Empty(count: Int = 0) extends Tree[Nothing] {
}
case class Node[A](data: A, count: Int, left: Tree[A], right: Tree[A]) extends Tree[A]


