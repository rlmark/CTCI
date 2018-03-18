package chapter1

import org.scalatest.{FlatSpec, Matchers}

class AnagramsSpec extends FlatSpec with Matchers {
  import Anagrams._
  "isAnagram" should "determine that a string is an anagram" in {
    val s1 = "stringy"
    val s2 = s1.reverse
    isAnagram(s1, s2) shouldBe true
  }
  it should "determine that a string is not an anagram" in {
    val s1 = "bananna"
    val s2 = "nab"
    isAnagram(s1, s2) shouldBe false
  }
  it should "handle empty strings" in {
    isAnagram("", "hello") shouldBe false
  }
  it should "handle nulls" in {
    isAnagram("test", null) shouldBe false
  }
}
