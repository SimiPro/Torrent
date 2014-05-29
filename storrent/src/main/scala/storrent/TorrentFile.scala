package storrent

import scala.collection.mutable.Map
import scala.collection.mutable.MutableList
import scala.collection.mutable.LinkedHashMap

 
class TorrentFile(
    dictionarys:MutableList[LinkedHashMap[String,String]] = MutableList(), 
    lists:MutableList[MutableList[String]] = MutableList[MutableList[String]](),
    //Really need ints list what case for?
    ints:MutableList[Int] = MutableList[Int](),
    strings:MutableList[String] = MutableList[String]()) {
    
    
    def addInt(int:String) = {
      ints += int.toInt
      strings += int
    }
    
    def addList(list:MutableList[String]) = {
      lists += list
    }
    
    def addString(string:String) = {
      strings += string
    }
    
    def addDictionary(map:LinkedHashMap[String,String]) = {
      dictionarys += map
    }
    
    override def toString() = {
     // string & int
     var result =  strings.addString(new StringBuilder())
     
     //list
     if (!lists.isEmpty) {
	     lists.foreach(A => {
	       result.append("[")
	       result.append(A.head)
	       A.tail.foreach(result.append(',').append(_))
	       result.append("]")
	     })
     }
     
     if (!dictionarys.isEmpty) {
       	 dictionarys.foreach(A => {
       	   println(dictionarys)
     	   result.append("{")
     	   result.append(A.head._1).append(" => ").append(A.head._2)
       	   A.tail.foreach(T => {
       		   result.append(',').append(T._1).append(" => ").append(T._2)
       	   })
       	   result.append("}")
	     })
     }
     
     println(result.toString)
     
     
     
     result.toString
    }
  }