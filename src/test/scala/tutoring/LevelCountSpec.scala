package tutoring

import org.scalatest.{Matchers, WordSpec}
import LevelCount._

class LevelCountSpec extends WordSpec with Matchers {
  "levelCount" should {
    "count nodes for root when given a tree" in {
      val testTree =
        Node(3,3,
          Node(2, 2,
            Node(1,1,
              Empty(),
              Empty()),
            Empty()),
          Empty())
        levelCount(testTree, 0) shouldBe 1
    }
    "count nodes for root when given empty tree" in {
      val test = Empty()
      levelCount(test, 0) shouldBe 0
    }
    "count nodes for an unbalanced tree" in {
      val testTree =
        Node(1,3,
          Empty(),
          Node(2,2,
            Empty(),
            Node(3,1,
              Empty(),
              Empty())))
      levelCount(testTree, 2) shouldBe 1
    }
    "count nodes for a tree with many leaf nodes for k" in {
      val testTree =
        Node(1,3,
          Node(2,3,
            Empty(),
            Node(3,4,
              Node(4,1,
                Empty(),
                Empty()),
              Empty())),
          Node(2,2,
            Node(1,2,
              Empty(),
              Empty()),
            Node(3,1,
              Empty(),
              Empty())))
      levelCount(testTree, 1) shouldBe 2
      levelCount(testTree, 2) shouldBe 3
    }
  }
}
