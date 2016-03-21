import akka.actor.{PoisonPill, Props, ActorSystem}
import com.packt.akka.Counter

/**
  * Created by jcohe_000 on 3/20/2016.
  */
object ActorPath extends App {

  val system = ActorSystem("Actor-Paths")

  val counter1 = system.actorOf(Props[Counter], "Counter")

  println(s"Actor Reference for counter1: ${counter1}")

  val counterSelection1 = system.actorSelection("counter")

  println(s"Actor Selection for counter1: ${counterSelection1}")

  counter1 ! PoisonPill

  Thread.sleep(100)

  val counter2 = system.actorOf(Props[Counter], "counter")

  println(s"Actor Reference for count2 is: ${counter2}")

  val counterSelection2 = system.actorSelection("counter")

  println(s"Actor Selection for counter2 is: ${counterSelection2}")

  system.terminate()
}
