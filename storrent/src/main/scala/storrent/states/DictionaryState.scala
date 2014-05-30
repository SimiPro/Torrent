package storrent.states

class DictionaryState(STATE_CONTEXT: StateContext, dictContext: DictContext) extends StateLike {
  def this(STATE_CONTEXT: StateContext) {
    this(STATE_CONTEXT, new DictContext(STATE_CONTEXT))
  }

  override def write(STATE_CONTEXT: StateContext, byte: Byte) = {
    byte.toChar match {
      case 'e' => {
        STATE_CONTEXT.addDictionary(dictContext.getMap)
        STATE_CONTEXT.setDefault
      }
      case 'd' => STATE_CONTEXT.setState(new StateWrapper(dictContext, new DictionaryState(dictContext)))
      case 'i' => STATE_CONTEXT.setState(new StateWrapper(dictContext, new IntState()))
      case 'l' => STATE_CONTEXT.setState(new StateWrapper(dictContext, new ListState(dictContext)))
      case default => STATE_CONTEXT.setState(new StateWrapper(dictContext, new StringState(default)))
    }
  }

}
