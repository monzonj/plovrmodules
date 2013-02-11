import com.benmccann.playplovr.PlayPlovrPlugin
import com.benmccann.playplovr.PlayPlovrPlugin._
import sbt._
import Keys._
import play.Project._

object ApplicationBuild extends Build {

  val appName         = "plovrmodules"
  val appVersion      = "1.0-SNAPSHOT"

  val appDependencies = Seq(
    // Add your project dependencies here,
    jdbc,
    anorm
  )


  val main = play.Project(appName, appVersion, appDependencies).settings(
    PlayPlovrPlugin.defaultPlovrSettings ++ Seq(

        // project-specific assets.plovr settings
        plovrConfiguration <<= baseDirectory(_ / "plovr" /  "plovr.json"),
        plovrTargetPath := "public/javascripts/compiled.js"

      ): _*
  )


}
