package storrent.states

import scala.collection.mutable.MutableList

class ListContext(STATE_CONTEXT:StateContext) extends StateContext {
         var reallist:MutableList[String] = MutableList[String]()
         
	       override def addInt(int:String) = {
		      reallist += int
		    }
		    
		   override def addString(string:String) = {
		      reallist += string
		    }
		   
		    
		   override def setDefault() = {
	      	  STATE_CONTEXT.setState(new ListState(STATE_CONTEXT, this))
	    	}	
		   
			def getList() : MutableList[String] = {
			  reallist
			}
   } 
       