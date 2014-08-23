name := "storrent"

version := "1.0"

scalaVersion := "2.11.1"

libraryDependencies += "org.scalatest" % "scalatest_2.11" % "2.2.1" % "test"

libraryDependencies += "net.databinder.dispatch" %% "dispatch-core" % "0.11.2"


resolvers ++= Seq(
    "RoundEights" at "http://maven.spikemark.net/roundeights"
)

libraryDependencies ++= Seq(
    "com.roundeights" %% "hasher" % "1.0.0"
)