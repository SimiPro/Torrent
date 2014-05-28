package storrent.states


class IntState extends StateLike {
    var int:String = ""
  
	override def write(STATE_CONTEXT:StateContext, byte:Byte) =  {
	  var number = byte.toChar
	  if (number == 'e') {
		    STATE_CONTEXT.addInt(int)
		    STATE_CONTEXT.setDefault()
		  } else {
			  int += byte.toChar
		  }
		}
	}