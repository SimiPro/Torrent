package storrent.states



   class ListState(list:List[String] = List()) extends StateLike {
       var listContext:ListContext = new ListContext()
      
       class ListContext extends StateContext {
         var list:List[String] = List()
         
         
       override def addInt(int:String) = {
	      list :+ int
	    }
	    
	   override def addString(string:String) = {
	      list :+ string
	    }
	    
	   override def setDefault() = {
    		setState(new ListState())
    	}	
         
       } 
       
      
    	def write(STATE_CONTEXT:StateContext, byte:Byte) =  {
    		
    		// List cant contain lists and dicts, not implemented yet
//    		case 'd' => STATE_CONTEXT.setState(new DictionaryState())
//		    case 'l' => {
//		       STATE_CONTEXT.setState(new ListState())
//		    }
       
    	    byte.toChar match {
	    	    case 'e' => {
	    	    	STATE_CONTEXT.addList(list)
	    	    	STATE_CONTEXT.setDefault
	    	    } 
	    	   	case 'i' => STATE_CONTEXT.setState(new StateWrapper(listContext, new IntState()))
	    	   	case default => STATE_CONTEXT.setState(new StateWrapper(listContext, new StringState(default)))
    	   }
    	  
    	  
    	  //write gege abe (String / Int )
    	  // fertig -- addString uf die List 
    	  // falls 
    	  

    	}
    	
    	

    }