package tutoring

import org.scalatest.{Matchers, WordSpec}
import KthLeast._

class KthLeastSpec extends WordSpec with Matchers {
  "KthLeast" should {
    "return the smallest data value" when {
      "given a right branching tree" in {
        val testTree =
          Node(1,3,
            Empty(),
            Node(2,2,
              Empty(),
              Node(3,1,
                Empty(),
                Empty())))
        withClue("k is 1, data should be 1")(findKthLeast(1, testTree) shouldBe 1)
        withClue("k is 2, data should be 2")(findKthLeast(2, testTree) shouldBe 2)
        withClue("k is 3, data should be 3")(findKthLeast(3, testTree) shouldBe 3)
      }
      "given a left branching tree" in {
        val testTree =
          Node(3,3,
            Node(2, 2,
              Node(1,1,
                Empty(),
                Empty()),
              Empty()),
            Empty())

        withClue("k is 1, data should be 1")(findKthLeast(1, testTree) shouldBe 1)
        withClue("k is 2, data should be 2")(findKthLeast(2, testTree) shouldBe 2)
        withClue("k is 3, data should be 3")(findKthLeast(3, testTree) shouldBe 3)
      }
    }
    "throw exception" when {
      "given a K value greater than the nodes in the tree" in {
        val testTree =
          Node(1,3,
            Empty(),
            Node(2,2,
              Empty(),
              Node(3,1,
                Empty(),
                Empty())))
        intercept[IllegalArgumentException] {findKthLeast(25, testTree)}
      }
    }
  }
}
