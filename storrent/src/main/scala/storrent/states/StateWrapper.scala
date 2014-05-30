package storrent.states

class StateWrapper(context: StateContext) extends StateLike {
  var wrapActive = true

  def this(context: StateContext, state: StateLike) {
    this(context)
    context.setState(state)
  }

  def write(STATE_CONTEXT: StateContext, byte: Byte) {
    context.write(byte)
  }
}