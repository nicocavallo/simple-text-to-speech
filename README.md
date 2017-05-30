# Simple Text-to-Speech for Scala
This is a minimalistic library based on <a href="https://github.com/marytts/marytts" target="_blank">MaryTTS</a>. Its aim is to simplify text to speech interfaces for some of my projects.

### Code example
```scala
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
```
### Run
```bash
suknca@suknca MINGW64 /c/repo/simple-text-2-speech (master)
$ sbt "run \"Hello Nico\""
[warn]   Executing in batch mode.
[warn]   For better performance, hit [ENTER] to switch to interactive mode, or
[warn]   consider launching sbt without any commands, or explicitly passing 'shell'
[info] Loading global plugins from C:\Users\suknca\.sbt\0.13\plugins
[info] Loading project definition from C:\repo\text-2-speech\project
[info] Set current project to text-2-speech (in build file:/C:/repo/text-2-speech/)
[info] Running org.nicocavallo.PrudenceApp Hello Nico
[success] Total time: 5 s, completed 30-May-2017 11:05:08
```
### Include it in your sbt projects:
Include this lines in your project's build.sbt
```sbt
resolvers += "jitpack" at "https://jitpack.io"
libraryDependencies += "com.github.nicocavallo" %% "simple-text-to-speech" % "master-SNAPSHOT"
```
Then use it as any other library

```scala
import org.nicocavallo.Prudence

import java.util.concurrent.Executors

import scala.concurrent.ExecutionContext

object TryIt extends App {

  val executor = Executors.newSingleThreadExecutor()
  
  Prudence.speak( "Hello!" )( ExecutionContext.fromExecutor(executor) )
  
  executor.shutdown()

}
```