package scala

import actors.Actor

class Agent extends Actor {
  def act() {
    loop {
      receive {
        case ('hello, x: String) =>
          println("Hello " + x: String)
        case ('end) =>
          exit('ok)
        case _ =>
          println("WTF")
      }
    }
  }
}

object Main extends App {
  val agent = new Agent().start()
  agent !('hello, "My message")
  agent ! 42
  agent ! ('end)
}
