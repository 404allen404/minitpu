import chisel3._
import _root_.circt.stage.ChiselStage

class Tpu extends Module {

}

object Tpu extends App {
  ChiselStage.emitSystemVerilogFile(
    new Tpu(),
    firtoolOpts = Array("--split-verilog", "-o=build/Tpu")
  )
}
