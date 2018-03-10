package chapter1

object StringReverse {
  def reverse(arr: Array[Char]): Array[Char] = {
    val length = arr.length

    if(arr == null) Array.empty
    else if(length <= 1) arr
    else {
      val newArr = Array.ofDim[Char](length)
      var i = length - 1
      var j = 0
      while (i >= 0) {
        val currentElement = arr(i)
        newArr(j) = currentElement

        i -= 1
        j += 1
      }
      newArr
    }

  }
}
