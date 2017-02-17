import sbt._

object Dependencies {

  import Versions._

  //NettyIo is very bad one, the organization name is different from the jar name for older versions
  val excludeNettyIo = ExclusionRule(organization = "org.jboss.netty")

  lazy val sparkDeps = Seq(
    "org.apache.spark" %% "spark-core" % spark % "provided" excludeAll (excludeNettyIo),
    // Force netty version.  This avoids some Spark netty dependency problem.
    "io.netty" % "netty-all" % netty
  )

  lazy val sparkExtraDeps = Seq(
    "org.apache.spark" %% "spark-sql" % spark % "provided" excludeAll (excludeNettyIo),
    "org.apache.spark" %% "spark-streaming" % spark % "provided" excludeAll (excludeNettyIo)
  )

  lazy val jobserverDeps = Seq(
    "com.github.spark-jobserver.spark-jobserver" % "job-server-api_2.10" % jobServer % "provided",
    "com.github.spark-jobserver.spark-jobserver" % "job-server-extras_2.10" % jobServer % "provided"
  )

  // This is needed or else some dependency will resolve to 1.3.1 which is in jdk-8
  lazy val typeSafeConfigDeps = Seq("com.typesafe" % "config" % typesafeConfig force())

  lazy val coreTestDeps = Seq()

  val repos = Seq(
    "sonatype-releases" at "https://oss.sonatype.org/content/repositories/releases/",
    "Job Server Bintray" at "https://dl.bintray.com/spark-jobserver/maven",
    "jitpack" at "https://jitpack.io"
  )
}
