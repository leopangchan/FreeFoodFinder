name := """Free Food Finder"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.11.11"

val jUnitVersion = "4.11" // replace appropriately

libraryDependencies += javaJdbc
libraryDependencies += cache
libraryDependencies += javaWs

libraryDependencies ++= Seq(
  javaJpa,
  "org.hibernate" % "hibernate-entitymanager" % "5.1.0.Final", // replace by your jpa implementation
  "junit" % "junit" % jUnitVersion % Test
)

PlayKeys.externalizeResources := false