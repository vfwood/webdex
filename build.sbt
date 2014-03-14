name := "pbs"

version := "1.0-SNAPSHOT"

resolvers += "apache-snapshots-repo" at "https://repository.apache.org/snapshots/"

libraryDependencies ++= Seq(
  jdbc,
  anorm,
  cache,
  "mysql" % "mysql-connector-java" % "5.1.26",
  "com.typesafe.play" %% "play-slick" % "0.5.0.8",
  "org.apache.lucene" % "lucene-core" % "4.7.0"
)     

play.Project.playScalaSettings
