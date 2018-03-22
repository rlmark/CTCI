package chapter1

object StringEncode extends App {
  def replaceSpace(string: String): String = {
    """\s""".r.replaceAllIn(string, "%20")
  }

  println(replaceSpace("Hi this is a string with spaces   "))
}
