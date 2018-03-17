package chapter1

import org.scalatest.{FlatSpec, Matchers}
class RemoveDupesStrictSpec extends FlatSpec with Matchers {
  import RemoveDupesStrict._
  "dedupe" should "remove duplicates in a string with no additional buffer" in {
    val testString = "scalaby"
    dedupe(testString) shouldBe "scalby"
  }
}
