package tutoring

import org.scalatest.{Matchers, WordSpec}

class LowestCommonAncestorSpec extends WordSpec with Matchers {
  val expectedSubTree = Node(8, 1,
    Node(7, 0,
      Node(6, 0,
        Empty(),
        Empty()),
      Empty()),
    Node(12, 0,
      Empty(),
      Empty()))

  val testTree =
    Node(4, 3,
      Empty(),
      Node(5, 2,
        Empty(),
        expectedSubTree))
  "LowestCommonAncestor" should {
    "Find the LCA for two node values that exist in the tree" when {
      "the first argument is less than the second" in {
        LowestCommonAncestor.findLCA(testTree, 6, 12) shouldBe expectedSubTree
      }
      "the second argument is less than the first" in {
        LowestCommonAncestor.findLCA(testTree, 12, 6) shouldBe expectedSubTree
      }
      "one of the arguments is also the LCA" in {
        LowestCommonAncestor.findLCA(testTree, 12, 8) shouldBe expectedSubTree
        LowestCommonAncestor.findLCA(testTree, 8, 12) shouldBe expectedSubTree
      }
    }
    "Return empty when there is no LCA" in {
      LowestCommonAncestor.findLCA(testTree, 12, 24) shouldBe Empty()
      LowestCommonAncestor.findLCA(testTree, 24, 12) shouldBe Empty()
    }
  }
}
