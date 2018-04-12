package chapter2

sealed trait LinkedList[+A]
case object Empty extends LinkedList[Nothing]
case class Node[A](data: A, next: LinkedList[A]) extends LinkedList[A]

object LinkedList {
  // delete the first node that has the value d


  def deleteNode(head: LinkedList[Int], d: Int): LinkedList[Int] = {
    def loop(previousNode: Node[Int], currentNode: LinkedList[Int]): LinkedList[Int] = {
      currentNode match {
        case Empty => currentNode
        case c @ Node(data, next) =>
          if (data == data ) Node(previousNode.data, next)
          else loop(c, next)
      }
    }

    head match {
      case Empty => return head
      // if the first element contains the desired element to delete, return the next element as the new head
      case Node(data, next) if data == d => return next
      case h @ Node(data, next) => return loop(h, next)
    }

  }
}
