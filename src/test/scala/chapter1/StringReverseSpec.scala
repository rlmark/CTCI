package chapter1

import org.scalatest.{FlatSpec, Matchers}

class StringReverseSpec extends FlatSpec with Matchers {
  "reverse" should "reverse a C-style string" in {
    val testArray: Array[Char] = Array('c', 'a', 't')
    StringReverse.reverse(testArray) should contain theSameElementsInOrderAs Array('t', 'a', 'c')
  }
  it should "work for empty string" in {
    val testArray: Array[Char] = Array()
    StringReverse.reverse(testArray) should contain theSameElementsAs Array[Char]()
  }
  it should "work for null input" in {
    StringReverse.reverse(null) shouldBe Array.empty
  }
  "inPlaceReverse" should "reverse an odd C-style string in place" in {
    val testArray: Array[Char] = Array('c', 'a', 't', 'c', 'h')
    StringReverse.inPlaceReverse(testArray) should contain theSameElementsInOrderAs Array('h', 'c', 't', 'a', 'c')
  }
  it should "reverse an even C-style string in place" in {
    val testArray: Array[Char] = Array('c', 'a', 't', 'c' )
    StringReverse.inPlaceReverse(testArray) should contain theSameElementsInOrderAs Array( 'c', 't', 'a', 'c')
  }
  it should "work for empty string in place" in {
    val testArray: Array[Char] = Array()
    StringReverse.inPlaceReverse(testArray) should contain theSameElementsAs Array[Char]()
  }
  it should "work for null input in place" in {
    StringReverse.inPlaceReverse(null) shouldBe Array.empty
  }
}
