package tutoring

object KthLeast {
  def findKthLeast(k: Int, binaryTree: Tree[Int]): Int = {
    // Could also first check to make sure k > 0 or k < root.count
    binaryTree match {
      case _:Empty => println(s"sadness $k | $binaryTree"); throw new IllegalStateException("Sad")
      case Node(data, count, l, r) if l.count + 1 == k => data
      case Node(data, count, l, r) if l.count < k => findKthLeast(k - (l.count + 1), r)
      case Node(data, count, l, r) if count >= k => findKthLeast(k, l)
    }
  }
}
