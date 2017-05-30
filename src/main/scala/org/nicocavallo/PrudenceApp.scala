package org.nicocavallo

object PrudenceApp extends App {

  val text = args.headOption
  text.fold(System.err.println("Missing text. Try again")){ t =>
    Prudence.speak(t)
  }
  Prudence.shutdown()

}
