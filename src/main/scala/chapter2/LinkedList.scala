package chapter2

sealed trait LinkedList[+A]
case object Empty extends LinkedList[Nothing]
case class Node[A](data: A, next: LinkedList[A]) extends LinkedList[A]

object LinkedList {
//  def deleteNode(head: LinkedList[Int], d: Int): LinkedList[Int] = {
//
//    @tailrec
//    def loop(previousNode: Node[Int], currentNode: LinkedList[Int]): LinkedList[Int] = {
//      currentNode match {
//        // at the end, we've found no value to remove
//        case Empty => currentNode
//        case c @ Node(data, next) =>
//          if (data == d) Node(previousNode.data, next)
//          else loop(c, next)
//      }
//    }
//
//    head match {
//      case Empty => head
//      // if the first element contains the desired element to delete, return the next element as the new head
//      case Node(data, next) if data == d => next
//      // otherwise, recreate the head element where the tail is created by our loop
//      case h @ Node(data, next) =>  loop(h, next)
//    }
//
//  }

  def deleteNode(head: LinkedList[Int], d: Int): LinkedList[Int] = {


    def loop(previousNode: Option[Node[Int]], currentNode: LinkedList[Int]): LinkedList[Int] = {
      (previousNode, currentNode) match {
        // at the start of the list, if you're handed an empty value, return empty
        case (None, Empty) => Empty
        // at start of list, handle when the head's data matches the target
        case (None, c @ Node(data, next)) => if (data == d) next else loop(Some(c), next)
        // at the end of our list, we've found no value to remove
        case (Some(p), Empty) => p
        // traversing list, either skip the node if its data matches the target or recurse
        case (Some(p), c @ Node(data, next)) =>
          if (data == d) Node(p.data, next)
          else Node(p.data, loop(Some(c), next))
      }
    }

    loop(None, head)
  }
}
