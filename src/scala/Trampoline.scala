package scala

import util.control.TailCalls._

class Trampoline {
  def isEven(xs: List[Int]): TailRec[Boolean] =
    if (xs.isEmpty) done(true) else tailcall(isOdd(xs.tail))

  def isOdd(xs: List[Int]): TailRec[Boolean] =
    if (xs.isEmpty) done(false) else tailcall(isEven(xs.tail))

}

object MainTrampoline extends App {
  val trampo = new Trampoline
  println(trampo.isOdd((1 to 100001).toList).result)

}
