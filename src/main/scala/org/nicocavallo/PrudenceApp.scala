package org.nicocavallo

import java.util.concurrent.Executors

import scala.concurrent.ExecutionContext

object PrudenceApp extends App {

  val executor = Executors.newSingleThreadExecutor()

  implicit val ec: ExecutionContext = ExecutionContext
    .fromExecutor(executor)

  val text = args.headOption
  text.fold(System.err.println("Missing text. Try again")) { t =>
    Prudence.speak(t.trim())
  }

  executor.shutdown()

}
