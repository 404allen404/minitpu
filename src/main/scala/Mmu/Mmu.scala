import chisel3._
import _root_.circt.stage.ChiselStage

class Mmu extends Module {

}

object Mmu extends App {
  ChiselStage.emitSystemVerilogFile(
    new Mmu(),
    firtoolOpts = Array("--split-verilog", "-o=build/Mmu")
  )
}
