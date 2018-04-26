package chapter2

import org.scalatest.{FlatSpec, Matchers}

class LinkedListSpec extends FlatSpec with Matchers {
  import LinkedList._
  "deleteNode" should "delete the first node when value matches" in {
    val ll = Node(1, Node(2, Node(3, Node(4, Empty))))
    deleteNode(ll, 1 ) shouldBe Node(2, Node(3, Node(4, Empty)))
  }
  it should "handle when an empty node is given" in {
    deleteNode(Empty, 1 ) shouldBe Empty
  }
  it should "handle when only one node is given" in {
    val ll = Node(1, Empty)
    deleteNode(ll, 1) shouldBe Empty
  }
  it should "handle deleting a middle node" in {
    val ll = Node(1, Node(2, Node(3, Node(4, Empty))))
    val result =  deleteNode(ll, 3 )
    result shouldBe Node(1, Node(2, Node(4, Empty)))
  }
  it should "only delete the first instance of the desired node" in {
    val ll = Node(1, Node(2, Node(3, Node(2, Empty))))
    val result =  deleteNode(ll, 2 )
    result shouldBe Node(1, Node(3, Node(2, Empty)))
  }
  it should "handle deleting the end node" in {
    val ll = Node(1, Node(2, Node(3, Empty)))
    val result =  deleteNode(ll, 3 )
    result shouldBe Node(1, Node(2, Empty))
  }
  it should "handle when target to delete is not found" in {
    val ll = Node(1, Node(2, Node(3, Empty)))
    deleteNode(ll, 6) shouldBe ll
  }

  "deleteAllMatches" should "delete all nodes where target matches data" in {
    val ll = Node(1, Node(2, Node(3, Node(2, Empty))))
    val result = deleteAllMatches(ll, 2)
    result shouldBe Node(1, Node(3, Empty))
  }

  "map" should "transform a linkedList" in {
    val ll = Node(1, Node(2, Node(3, Empty)))
    map(ll, (f: Int) => f + 1) shouldBe Node(2, Node(3, Node(4, Empty)))
  }
  it should "handle when the list is empty" in {
    map(Empty, (f: Int) => f + 1) shouldBe Empty
  }

  "foldLeft" should "fold over a linked list" in {
    val ll = Node(1, Node(2, Node(3, Empty)))
    val result = foldLeft(ll, 100)((acc: Int, next: Int) => next + acc )
    result shouldBe 106
  }
  it should "handle when the linked list is empty" in {
    foldLeft(Empty, 0)((acc: Int, next: Int) => acc * 199) shouldBe 0
  }
}
