package storrent.states


class NoState extends StateLike {
    
    def write(STATE_CONTEXT:StateContext, byte:Byte) =  {
      byte.toChar match {
       case 'd' => STATE_CONTEXT.setState(new DictionaryState())
       case 'l' => STATE_CONTEXT.setState(new ListState())
       case 'i' => STATE_CONTEXT.setState(new IntState())
       case default => STATE_CONTEXT.setState(new StringState(default))
      }
    }
 
}