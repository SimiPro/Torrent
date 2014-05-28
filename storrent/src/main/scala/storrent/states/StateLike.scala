package storrent.states


  abstract class StateLike {
    def write(STATE_CONTEXT:StateContext, byte:Byte)
  }
