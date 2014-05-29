package storrent.states

import scala.collection.mutable.LinkedHashMap
import scala.collection.mutable.MutableList

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
	  
		override def addList(list:MutableList[String]):Unit = {
		  var result = new StringBuilder()
		  
		  if (!list.isEmpty) {
		       result.append("[")
		       result.append(list.head)
		       list.tail.foreach(result.append(',').append(_))
		       result.append("]")
	     }
		  
	      map += key -> result.toString
	      key = ""
	    }
	     
	   override def setDefault() = {
      	  STATE_CONTEXT.setState(new DictionaryState(STATE_CONTEXT, this))
       }
	   
	       
	 override def addDictionary(mapToAdd:LinkedHashMap[String,String]):Unit = {
	    var result = new StringBuilder()
		if (!mapToAdd.isEmpty) {
       	   println(mapToAdd)
     	   result.append("{")
     	   result.append(mapToAdd.head._1).append(" => ").append(mapToAdd.head._2)
       	   mapToAdd.tail.foreach(T => result.append(',').append(T._1).append(" => ").append(T._2))
       	   result.append("}")
	     }
	     map += key -> result.toString
	     key = ""
     }
}
	   
	      
