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
}