package storrent.states


class StringState extends StateLike {
    var string:String = ""
    var lenght:String = ""
    var stillLength = true
  
	def this(newlenght: Char) {
        this()
	    lenght += newlenght
    }
  
	def write(STATE_CONTEXT:StateContext, byte:Byte) =  {
	  var char = byte.toChar
	  if (!stillLength) {
	    string += char
	    if (string.length() == lenght.toInt) {
	      STATE_CONTEXT.addString(string)
	      STATE_CONTEXT.setDefault()
	    }
	  }	 else {
		  if (char == ':') {
	         stillLength = false 
		  } else {
		    lenght += char
		  }
	  	}
	  }
}