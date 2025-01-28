import mill._
import scalalib._

object minitpu extends SbtModule {
  override def millSourcePath = os.pwd
  override def scalaVersion = "2.13.15"
  override def ivyDeps = Agg(
    ivy"org.chipsalliance::chisel:6.6.0",
  )
  override def scalacPluginIvyDeps = Agg(
    ivy"org.chipsalliance:::chisel-plugin:6.6.0",
  )
}
