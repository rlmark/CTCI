package chapter1

object RotateMatrix {

  def indexToRow(index: Int, matrix: Vector[Vector[Byte]]) = {
    matrix.map( row => row(index)).reverse
  }

  def rotateRight(matrix: Vector[Vector[Byte]]): Vector[Vector[Byte]] = {
    var resultingMatrix: Vector[Vector[Byte]] = Vector.empty

    for(i <- matrix.indices ){
      val row = indexToRow(i, matrix)
      resultingMatrix :+= row // append row
    }
    resultingMatrix
  }

}
