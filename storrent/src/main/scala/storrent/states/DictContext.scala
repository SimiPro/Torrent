package storrent.states

import scala.collection.mutable.LinkedHashMap

 class DictContext(STATE_CONTEXT:StateContext) extends StateContext {
    	 var map:LinkedHashMap[String,String] = LinkedHashMap()
    	 var key:String = ""
    	 
    	 def getMap(): LinkedHashMap[String,String] = {
    	   map
    	 }
    	   
    	override def addInt(int:String) = {
    		if (key.isEmpty()){
    		  key = int
    		} else {
    		  map += key -> int
    		  key = ""
    		}
    	 }
	    
	  override  def addString(string:String) = {
	       if (key.isEmpty()){
    		  key = string
    		} else {
    		    map += key -> string
    		  key = ""
    		}
	     }
	     
		   override def setDefault() = {
	      	  STATE_CONTEXT.setState(new DictionaryState(STATE_CONTEXT, this))
	    	}	
	      
      }