import io.gatling.sbt.GatlingPlugin

name := """gatling-multidb"""

version := "1.0"

scalaVersion := "2.11.6"

val integration = "latest.integration"

enablePlugins(GatlingPlugin)

libraryDependencies ++= Seq(
  "org.scalatest" %% "scalatest" % "2.2.4" % "test",
  "io.gatling" % "gatling-core" % integration % "test",
  "io.gatling.highcharts" % "gatling-charts-highcharts" % integration % "test",
  "io.gatling" % "gatling-test-framework" % integration % "test"
)