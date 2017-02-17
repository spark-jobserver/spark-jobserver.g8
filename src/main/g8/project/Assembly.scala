import sbt.Keys._
import sbt._
import sbtassembly.AssemblyPlugin.autoImport._

object Assembly {
  lazy val settings = Seq(
    // comment below to include tests
    test in assembly := {},
    assemblyExcludedJars in assembly <<= (fullClasspath in assembly) map { _ filter { cp =>
      List ("commons-lang3", "netty", "spark-sql").exists(cp.data.getName.startsWith(_))
    } },
    run in Compile <<= Defaults.runTask(fullClasspath in Compile, mainClass in (Compile, run), runner in (Compile, run)),

    assemblyOption in assembly := (assemblyOption in assembly).value.copy(includeScala = true),

    assemblyMergeStrategy in assembly := {
      case m if m.toLowerCase.endsWith("manifest.mf") => MergeStrategy.discard
      case m if m.toLowerCase.matches("meta-inf.*\\.sf$") => MergeStrategy.discard
      case "log4j.properties" => MergeStrategy.discard
      case x => MergeStrategy.last
    }
  )
}
