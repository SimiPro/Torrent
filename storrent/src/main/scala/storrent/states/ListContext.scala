package storrent.states

import scala.collection.mutable.MutableList
import scala.collection.mutable.LinkedHashMap

class ListContext(STATE_CONTEXT:StateContext) extends StateContext {
         var reallist:MutableList[String] = MutableList[String]()
         
	       override def addInt(int:String) = {
		      reallist += int
		    }
		    
		   override def addString(string:String) = {
		      reallist += string
		    }
		   
		   override def addDictionary(map:LinkedHashMap[String,String]):Unit = {
				var result = new StringBuilder()
				result.append("{")
		     	result.append(map.head._1).append(" => ").append(map.head._2)
		       	map.tail.foreach(T => result.append(',').append(T._1).append(" => ").append(T._2))
		       	result.append("}")
		       	println(result.toString)
		       	reallist += result.toString
    		}
    
		   
		    
		   override def setDefault() = {
	      	  STATE_CONTEXT.setState(new ListState(STATE_CONTEXT, this))
	    	}	
		   
			def getList() : MutableList[String] = {
			  reallist
			}
   } 
       