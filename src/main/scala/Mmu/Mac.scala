import chisel3._
import _root_.circt.stage.ChiselStage

class Mac extends Module {
  val io = IO(new Bundle {
    val weightPreload = Input(Bool())
    val pSumIn = Input(SInt(24.W))
    val activationIn = Input(SInt(8.W))
    val weightIn = Input(SInt(8.W))
    val activationOut = Output(SInt(8.W))
    val pSumOut = Output(SInt(24.W))
  })

  val activationReg = RegNext(io.activationIn, 0.S(8.W))
  val weightReg = RegInit(0.S(8.W))
  val pSumReg = RegInit(0.S(24.W))
  val mulResult = WireDefault(0.S(16.W))

  when (io.weightPreload) {
    weightReg := io.weightIn
  }

  mulResult := activationReg * weightReg
  pSumReg := mulResult + io.pSumIn

  io.activationOut := activationReg
  io.pSumOut := pSumReg
}

object Mac extends App {
  ChiselStage.emitSystemVerilogFile(
    new Mac(),
    firtoolOpts = Array("--split-verilog", "-o=build/Mmu/")
  )
}
