package chapter1

object RemoveDupesStrict {
// Remove duplicates in a string without ANY additional collections
  def dedupe(string: String): String = {
    // null & length checks
    if (string == null) return ""
    if (string.length == 1) return string.toString

    val chars = string.toCharArray
    var right = chars.length - 1
    var compare = 0

    while(compare < right) {
      val currentComparison = chars(compare)
      var left = compare + 1
      while(left < right) {
        if(currentComparison != chars(left)) left += 1
        else { shift(left, chars)
          right -= 1
        }
      }
      compare += 1
    }

    def shift(leftIndexToRemove: Int, charArray: Array[Char]): Unit = {
      var l = leftIndexToRemove
      while(l < charArray.length - 1){
        charArray(l) = charArray(l + 1)
        l += 1
      }
      charArray.dropRight(1) // This doesn't work in world of mutability...
    }

    chars.mkString("")

  }

}
