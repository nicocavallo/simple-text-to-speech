name := "text-2-speech"

version := "1.0"

scalaVersion := "2.12.15"

val freettsVersion = "1.2.2"

resolvers += "Gradle plugins" at "https://repo.gradle.org/libs-releases/"

libraryDependencies += "de.dfki.mary" % "voice-dfki-prudence-hsmm" % "5.2"

javaOptions += "-Djavax.xml.transform.TransformerFactory=com.sun.org.apache.xalan.internal.xsltc.trax.TransformerFactoryImpl"

crossScalaVersions := Seq("2.11", "2.12")

useCoursier := false

run / fork := true
