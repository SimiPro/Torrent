name := "storrent"

version := "1.0"

scalaVersion := "2.10.4"

libraryDependencies += "org.scalatest" % "scalatest_2.10" % "2.1.6" % "test"

resolvers ++= Seq(
    "RoundEights" at "http://maven.spikemark.net/roundeights"
)

libraryDependencies ++= Seq(
    "com.roundeights" %% "hasher" % "1.0.0"
)