package chapter1

import org.scalatest.{FlatSpec, Matchers}
class RemoveDupesStrictSpec extends FlatSpec with Matchers {
  import RemoveDupesStrict._
  "dedupe" should "remove duplicates in a string with no additional buffer" in {
    val testString = "scalaby"
    val builder = new StringBuilder()
    builder ++= testString
    dedupe(builder) shouldBe "scalby"
  }
  it should "work for multiple duplicates interspersed" in {
    val testString = "scalaisgreat"
    val builder = new StringBuilder()
    builder ++= testString
    dedupe(builder) shouldBe "scaligret"
  }
  it should "work for many duplicates" in {
    val testString = "aaaabbbbbbaaaaad"
    val builder = new StringBuilder()
    builder ++= testString
    dedupe(builder) shouldBe "abd"
  }
  it should "work for all duplicate string" in {
    val testString = "aa"
    val builder = new StringBuilder()
    builder ++= testString
    dedupe(builder) shouldBe "a"
  }
}
