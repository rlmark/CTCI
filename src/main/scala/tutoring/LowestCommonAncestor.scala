package tutoring

object LowestCommonAncestor {
/* Given a binary tree, find the lowest common ancestor of 2 given nodes in the tree. The lowest common ancestor between
2 nodes p and q is the lowest node in the tree that has both p and q as descendents
*/

  def findLCA(tree: Tree[Int], p: Int, q: Int): Tree[Int] = {
    tree match {
      case _:Empty => Empty()
      case n@Node(d, _, _, _) if d >= Math.min(p, q) && d <= Math.max(p, q) => if (dataExists(n, p) && dataExists(n, q)) n else Empty()
      case Node(data, _, l, _) if data > p && data > q => findLCA(l, p, q)
      case Node(data, _, _, r) if data < p && data < q => findLCA(r, p, q)
    }
  }

  def dataExists(n: Tree[Int], target: Int): Boolean = {
    n match {
      case _:Empty => false
      case Node(data,_, _, _) if data == target => true
      case Node(data, _, l, _) if data > target => dataExists(l, target)
      case Node(data, _, _, r) if data < target => dataExists(r, target)
    }
  }
}
