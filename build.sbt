name := "Lambda-Seed"

version := "0.1"

scalaVersion := "2.12.6"

libraryDependencies ++= Seq(
  "com.amazonaws" % "aws-lambda-java-core" % "1.2.0"
  , "com.fasterxml.jackson.module" %% "jackson-module-scala" % "2.9.5"
  , "com.typesafe" % "config" % "1.3.3"
  , "com.typesafe.scala-logging" %% "scala-logging" % "3.9.0"
  , "com.zaxxer" % "HikariCP" % "2.7.4"
  , "in.norbor" %% "yoda-orm" % "3.2.2"
)

libraryDependencies ++= Seq(
  "com.h2database" % "h2" % "1.4.197" % "test"
  , "org.scalatest" %% "scalatest" % "3.0.5" % "test"
)
