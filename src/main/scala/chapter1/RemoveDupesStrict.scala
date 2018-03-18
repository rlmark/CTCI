package chapter1

object RemoveDupesStrict {
// Remove duplicates in a string without ANY additional collections
  def dedupe(string: StringBuilder): String = {
    // null & length checks
    if (string == null) return ""
    if (string.length == 1) return string.toString

    var right = string.length - 1
    var compare = 0

    while(compare < right) {
      val currentComparison = string(compare)
      var left = compare + 1
      while(left <= right) {
        if(currentComparison != string(left)) left += 1
        else { shift(left, string)
          right -= 1
        }
      }
      compare += 1
    }

    def shift(leftIndexToRemove: Int, charArray: StringBuilder): Unit = {
      var l = leftIndexToRemove
      val length = charArray.length()
      while(l < charArray.length - 1){
        charArray(l) = charArray(l + 1)
        l += 1
      }
      charArray.setLength(length - 1)
    }

    string.toString

  }

}
