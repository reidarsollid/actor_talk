package scala

object FizzBuzz extends App {

  1 to 100 foreach {
    i => i match {
      case n if (n % 15 == 0) => println("FizzBuzz")
      case n if (n % 3 == 0) => println("Fizz")
      case n if (n % 5 == 0) => println("Buzz")
      case n => println(n)
    }
  }

}
