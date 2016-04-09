name := "pircbot"
version := "1.5.0"
organization := "org.jibble"
licenses := List("GPL-2.0+" -> url("https://www.gnu.org/licenses/gpl-2.0.html"))

crossPaths := false // no Scala suffix for published jar-s

javacOptions in (Compile, compile) ++= Seq("-source", "1.2", "-target", "1.2")
