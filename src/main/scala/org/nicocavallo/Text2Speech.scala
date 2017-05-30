package org.nicocavallo

import java.util.Locale
import java.util.concurrent.Executors

import marytts.LocalMaryInterface
import marytts.util.data.audio.AudioPlayer

trait Text2Speech {

  private val executor = Executors.newSingleThreadExecutor()

  val voiceName: String

  private lazy val maryTTS = {
    val m = new LocalMaryInterface()
    m.setLocale(Locale.UK)
    m.setVoice(voiceName)
    m
  }

  def speak(inputText: String): Unit = {
    val audio = maryTTS
      .generateAudio(
        inputText
//          .replaceAll(" – ", " ")
//          .replaceAll(" - ", " ")
//          .replaceAll("&apos;", "")
//          .replaceAll("EU", "E.U.")
//          .replaceAll("iot", "I.O.T.").replaceAll("IOT", "I.O.T.").replaceAll("IoT", "I.O.T.")
//          .replaceAll("UK", "U.K.").replaceAll(".uk", ".U K.")
//          .replaceAll("AI", "A.I.")
//          .replaceAll("'", "")
//          .replaceAll("’", "")
//          .replaceAll("£(\\d+)m", "$1 million pounds")
//          .replaceAll("£(\\d+)k", "$1 thousand pounds")
//          .replaceAll("\\$(\\d+) (\\w+)", "$1 $2 dollars")
      )
    //maryTTS.
    executor.execute(new AudioPlayer(audio))
  }

  def shutdown(): Unit = executor.shutdown()

}

class GenericText2Speech(val voiceName: String) extends Text2Speech

object Prudence extends GenericText2Speech("dfki-prudence-hsmm")