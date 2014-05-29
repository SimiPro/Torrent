package storrent.states

import scala.collection.mutable.MutableList



class ListState(STATE_CONTEXT:StateContext, listContext:ListContext) extends StateLike {
  def this(STATE_CONTEXT:StateContext){
    this(STATE_CONTEXT, new ListContext(STATE_CONTEXT))
  }
      
    	def write(STATE_CONTEXT:StateContext, byte:Byte) =  {
    		
    		// List cant contain lists and dicts, not implemented yet
//    		case 'd' => STATE_CONTEXT.setState(new DictionaryState())
//		    case 'l' => {
//		       STATE_CONTEXT.setState(new ListState())
//		    }
    	  
    	    byte.toChar match {
	    	    case 'e' => {
	    	    	STATE_CONTEXT.setDefault
	    	    	STATE_CONTEXT.addList(listContext.getList)
	    	    } 
	    	   	case 'i' => {
	    	   	  STATE_CONTEXT.setState(new StateWrapper(listContext, new IntState()))
	    	   	}
	    	   	case 'd' => {
	    	   		STATE_CONTEXT.setState(new StateWrapper(listContext, new DictionaryState(listContext)))
	    	   	}
	    	   	case default => {
	    	   	  STATE_CONTEXT.setState(new StateWrapper(listContext, new StringState(default)))
	    	   	}
    	   }
    	  
    	  
    	  //write gege abe (String / Int )
    	  // fertig -- addString uf die List 
    	  // falls 
    	  

    	}
    	
    	

    }