package chapter1

import scala.collection.mutable

object Anagrams {
  // Write a function to determine if two strings are anagrams
  def isAnagram(string1: String, string2: String): Boolean = {
    if(string1 == null || string2 == null) return false

    if(string1.length != string2.length) return false

    val letters: scala.collection.mutable.Map[Char, Int] = mutable.Map.empty

    string1.foreach(char =>
      if(letters.get(char).isEmpty) {
        letters += (char -> 1)
      } else {
        val tmp: Int = letters(char)
        letters(char) = tmp + 1
      }
    )

    string2.foreach(char2 =>
      if(letters.get(char2).isEmpty) {
        return false
      } else {
        val tmp = letters(char2)
        letters(char2) = tmp - 1
      }
    )

    !letters.values.exists(int => int != 0)
  }
}
