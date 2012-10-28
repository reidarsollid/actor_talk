package scala

import actors.Actor
import math.Pi

case class End()

case class Rectangle(height: Int, width: Int)

case class Circle(radius: Float)

class AreaActor extends Actor {
  def act() {
    loop {
      receive {
        case Rectangle(height, width) =>
          println("Area of the rectangle is " + (height * width))
        case Circle(radius) =>
          println(Pi * radius * radius)
        case End =>
          exit('ok)
        case n =>
          println("Can't calculate area of " + n)
      }
    }
  }
}

object AreaActor extends App {
  val areaActor = new AreaActor().start()
  areaActor ! Rectangle(22, 23)
  areaActor ! 'hello
  areaActor ! 22
  areaActor ! End

}
