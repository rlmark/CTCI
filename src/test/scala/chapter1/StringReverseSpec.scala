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
}
