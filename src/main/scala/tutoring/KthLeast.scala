package tutoring

object KthLeast {
  def findKthLeast(k: Int, binaryTree: Tree[Int]): Int = {
    binaryTree match {
      case _:Empty => println(s"sadness $k | $binaryTree"); throw new Exception("Sad")
      case Node(data, count, l, r) if l.count + 1 == k => data
      case Node(data, count, l, r) if l.count < k => findKthLeast(k - (l.count + 1), r)
      case Node(data, count, l, r) if count >= k => findKthLeast(k, l)
    }
  }
}
