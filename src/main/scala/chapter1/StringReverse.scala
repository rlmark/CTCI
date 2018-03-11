package chapter1

object StringReverse {
  def reverse(arr: Array[Char]): Array[Char] = {
    if(arr == null) Array.empty
    else {
      val length = arr.length
      if(arr.length <= 1) return arr

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

  def inPlaceReverse(arr: Array[Char]): Array[Char] = {
    if (arr == null || arr.length == 1) Array.empty
    else {
      var right = arr.length - 1
      var left = 0

      while (right > left){
        val temp = arr(right)
        arr(right) = arr(left)
        arr(left) = temp
        right -= 1
        left += 1
      }
      arr
    }
  }
}
