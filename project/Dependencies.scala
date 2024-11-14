import sbt._

object Dependencies {
  lazy val scalaTest = Seq(
    "org.scalatest" %% "scalatest" % "3.2.13" % Test,
    "org.scalatestplus" %% "scalacheck-1-18" % "3.2.19.0" % Test
  )

  val circeVersion = "0.13.0"
  val pureconfigVersion = "0.15.0"
  val catsVersion = "2.2.0"
  val sparkVersion = "3.2.1"
  val beamVersion = "2.57.0"
  val scioVersion = "0.14.1"

  lazy val core = Seq(
    // cats FP libary
    "org.typelevel" %% "cats-core" % catsVersion,

    // support for JSON formats
    "io.circe" %% "circe-core" % circeVersion,
    "io.circe" %% "circe-generic" % circeVersion,
    "io.circe" %% "circe-parser" % circeVersion,
    "io.circe" %% "circe-literal" % circeVersion,

    // support for typesafe configuration
    "com.github.pureconfig" %% "pureconfig" % pureconfigVersion,

    // logging
    "com.typesafe.scala-logging" %% "scala-logging" % "3.9.2",
    "ch.qos.logback" % "logback-classic" % "1.2.3",

    // parallel collections
    "org.scala-lang.modules" %% "scala-parallel-collections" % "1.0.4",

    // spark
    // "org.apache.spark" %% "spark-sql" % sparkVersion % Provided, // for submiting spark app as a job to cluster
    "org.apache.spark" %% "spark-sql" % sparkVersion, // for simple standalone spark app

    // scio/beam
    "com.spotify" %% "scio-core" % scioVersion,
    "com.spotify" %% "scio-test" % scioVersion % Test,
    "org.apache.beam" % "beam-runners-direct-java" % beamVersion % Runtime,
    "org.apache.beam" % "beam-runners-google-cloud-dataflow-java" % beamVersion % Runtime,
    "com.fasterxml.jackson.core" % "jackson-databind" % "2.14.1",

    // kafka streams
    "org.apache.kafka" %% "kafka-streams-scala" % "3.4.0",
    "com.goyeau" %% "kafka-streams-circe" % "0.6.3",

  )
}
