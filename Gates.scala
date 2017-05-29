package week3.event_simulation

class Gates extends Simulation with Parameters {

  def inverter(input: Wire, output: Wire): Unit = {
    def invertAction(): Unit = {
      val inputSig = input.getSignal
      afterDelay(InverterDelay) {
        output setSignal (!inputSig)
      }
    }

    input addAction invertAction
  }

  def andGate(in1: Wire, in2: Wire, output: Wire): Unit = {
    def addAction(): Unit = {
      val in1Sig = in1.getSignal
      val in2Sig = in2.getSignal
      afterDelay(AndGateDelay) {
        output setSignal (in1Sig & in2Sig)
      }
    }

    in1 addAction addAction
    in2 addAction addAction
  }

  def orGate(in1: Wire, in2: Wire, output: Wire): Unit = {
    def orAction(): Unit = {
      val in1Sig = in1.getSignal
      val in2Sig = in2.getSignal
      afterDelay(OrGateDelay) {
        output setSignal (in1Sig | in2Sig)
      }
    }

    in1 addAction orAction
    in2 addAction orAction
  }
}