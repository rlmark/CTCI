package chapter2

sealed trait LinkedList[+A]
case object Empty extends LinkedList[Nothing]
case class Node[A](data: A, next: LinkedList[A]) extends LinkedList[A]

object LinkedList {

  def deleteNode(list: LinkedList[Int], d: Int): LinkedList[Int] = {
    def loop(l: LinkedList[Int]): LinkedList[Int] = l match {
      case Node(x, ys) if x == d => ys
      case Empty => Empty
      case Node(x, ys) => Node(x, loop(ys))
    }
    loop(list)
  }
}
