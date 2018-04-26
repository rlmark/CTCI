package chapter2

sealed trait LinkedList[+A] {
  def headOption = {
    this match {
      case Empty =>  None
      case Node(data, _) => Some(data)
    }
  }

  def head = {
    this match {
      case Empty => throw new RuntimeException("No element found")
      case Node(data, _) => data
    }
  }
}
case object Empty extends LinkedList[Nothing]
case class Node[A](data: A, next: LinkedList[A]) extends LinkedList[A]

object LinkedList  extends App {

  def deleteNode(list: LinkedList[Int], d: Int): LinkedList[Int] = {
    def loop(l: LinkedList[Int]): LinkedList[Int] = l match {
      case Node(x, ys) if x == d => ys
      case Empty => Empty
      case Node(x, ys) => Node(x, loop(ys))
    }
    loop(list)
  }

  def deleteAllMatches(list: LinkedList[Int], target: Int): LinkedList[Int] = {
    def loop(list: LinkedList[Int]): LinkedList[Int] = {
      list match {
        case Empty => Empty
        case Node(data, next) if data == target => loop(next)
        case Node(data, next) => Node(data, loop(next))
      }
    }
    loop(list)
  }

  def map[A, B](list: LinkedList[A], f: A => B): LinkedList[B] = {
    list match {
      case Empty => Empty
      case Node(a, next) => Node(f(a), map(next, f))
    }
  }

  // Note to self: stop forgetting that the OP of fold has TWO arguments, A and B.
  // where A represents the current element in the list and B represents the accumulated value so far
  def foldLeft[A,B](list: LinkedList[A], z: B)(op: (B,A) => B): B = {
    list match {
      case Empty => z
      case Node(data, next) => op(foldLeft(next, z)(op), data)
    }
  }

  def foldRight[A, B](list: LinkedList[A], z: B)(op: (A, B) => B): B = {
    list match {
      case Empty => z
      case Node(data, next) => op(data, foldRight(next, z)(op))
    }
  }

  // Write code to remove duplicates from an unsorted linked list.
  def dedupe(list: LinkedList[Int]):LinkedList[Int] = {
    def loop(list: LinkedList[Int]): LinkedList[Int] = {
      list match {
        case Empty => Empty
        case Node(data, next) => Node(data, loop(deleteAllMatches(next, data)))
      }
    }

    loop(list)
  }

  val ll = Node(1, Node(2, Node(3, Node(1, Empty))))

  println(dedupe(ll))
}
