package tutoring

object LevelCount {
/* write the method levelCount which takes a tree and an int, K, and returns the number of nodes on the specified
level K. the root is at Level 0, and for any node, the node's level is one more than its parents level
  */
  def levelCount[A](tree:Tree[A],k: Int): Int = {

    def loop(tree:Tree[A],k: Int): Int = {
      tree match {
        case _: Empty => 0
        case Node(_, _, l, r) =>
          if (k == 0) 1 ;
          else loop(l, k - 1) + loop(r, k - 1)
      }
    }

    loop(tree, k)
  }
}
