package chapter1

import org.scalatest.{FlatSpec, Matchers}

class RotateMatrixSpec extends FlatSpec with Matchers {
  import RotateMatrix._
  val threeByThree = Vector(Vector(1,2,3).map(_.toByte), Vector(4,5,6).map(_.toByte), Vector(7,8,9).map(_.toByte))

  "indexToVec" should "create a row given an index and a matrix" in {
    indexToRow(2, threeByThree) should contain theSameElementsInOrderAs  Vector(3,6,9)
    indexToRow(0, threeByThree) should contain theSameElementsInOrderAs Vector(7,4,1)
  }
  "rotateRight" should "create a matrix that has been rotated 90 degrees right" in {
    val expected = Vector(
      Vector(7,4,1),
      Vector(8,5,2),
      Vector(9,6,3)
    )
    rotateRight(threeByThree) shouldBe expected
  }

}
