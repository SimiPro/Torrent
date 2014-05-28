package storrent.states


import scala.collection.mutable.Map

 class DictionaryState extends StateLike {
      var dictContext:DictContext = new DictContext()
      
      
	            
  override def write(STATE_CONTEXT:StateContext, byte:Byte) =  {
    	      		// Dictionary cant contain lists and dicts, not implemented yet
//    		case 'd' => STATE_CONTEXT.setState(new DictionaryState())
//		    case 'l' => {
//		       STATE_CONTEXT.setState(new ListState())
//		    }
       
    	    byte.toChar match {
    	      	case 'e' => {
    	      		STATE_CONTEXT.addDictionary(dictContext.getMap)
    	            STATE_CONTEXT.setDefault
    	      	}
	    	   	case 'i' => STATE_CONTEXT.setState(new StateWrapper(dictContext, new IntState()))
	    	   	case default => STATE_CONTEXT.setState(new StateWrapper(dictContext,new StringState(default)))
          }
    	}
         
   } 
