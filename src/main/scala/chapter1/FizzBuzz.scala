package chapter1

object FizzBuzz extends App {
  val result = 1 to 100 map {i =>
    if(i % 15 == 0) "fizzbuzz"
    else if(i % 3 == 0) "fizz"
    else if(i % 5 == 0) "buzz"
    else i
  }
  println(result.mkString(", "))
}
