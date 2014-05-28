package storrent.states

import scala.collection.mutable.Map

 class DictContext extends StateContext {
    	 var map:Map[String,String] = Map()
    	 var key:String = ""
    	 
    	 def getMap(): Map[String,String] = {
    	   map
    	 }
    	   
    	override def addInt(int:String) = {
    		if (key.isEmpty()){
    		  key = int
    		} else {
    		  map.put(key, int)
    		  key = ""
    		}
    	 }
	    
	  override  def addString(string:String) = {
	       if (key.isEmpty()){
    		  key = string
    		} else {
    		  map.put(key, string)
    		  key = ""
    		}
	     }
	     
	     override def setDefault() = {
    		 setState(new DictionaryState())
    	 }
	      
      }