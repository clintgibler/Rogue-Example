name := "rogue-example"

version := "0.0.1"

scalaVersion := "2.9.1"

libraryDependencies ++= Seq(
  "org.scalatest" %% "scalatest" % "1.7.2" % "test",
  "com.foursquare" %% "rogue" % "1.1.8" intransitive(),
  "net.liftweb" %% "lift-mongodb-record" % "2.4-M4"
)
