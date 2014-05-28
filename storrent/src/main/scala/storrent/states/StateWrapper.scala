package  storrent.states



class StateWrapper(context:StateContext,state:StateLike) extends StateLike {
	
	def DictState() {
	  context.setState(state)
	}
  
    def write(STATE_CONTEXT:StateContext, byte:Byte) {
    	context.write(byte)
    }
}