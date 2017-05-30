name := "text-2-speech"

version := "1.0"

scalaVersion := "2.12.1"

val freettsVersion = "1.2.2"

//javaHome := Some(file("C:\\Program Files\\Java\\jdk1.8.0_121"))

resolvers +=
  "Bintray MaryTTS" at "https://jcenter.bintray.com/"

libraryDependencies += "de.dfki.mary" % "voice-dfki-prudence-hsmm" % "5.2"

//libraryDependencies += "net.sf.saxon" % "Saxon-HE" % "9.7.0-18"

//-Djavax.xml.transform.TransformerFactory=com.sun.org.apache.xalan.internal.xsltc.trax.TransformerFactoryImpl

javaOptions += "-Djavax.xml.transform.TransformerFactory=com.sun.org.apache.xalan.internal.xsltc.trax.TransformerFactoryImpl"

crossScalaVersions := Seq("2.11", "2.12")

fork in run := true