package storrent

import scala.collection.mutable.Map
import scala.collection.mutable.MutableList

 
class TorrentFile(
    dictionarys:List[Map[String,String]] = List(), 
    lists:List[List[String]] = List(),
    ints:List[Int] = List(),
    strings:MutableList[String] = MutableList[String]()) {
    
    
    def addInt(int:String) = {
      ints :: List(int.toInt)
      
    }
    
    def addList(list:List[String]) = {
      lists :: List(list)
    }
    
    def addString(string:String) = {
      strings += string
    }
    
    def addDictionary(map:Map[String,String]) = {
      dictionarys :+ map
    }
    
    override def toString() = {
     var result =  strings.addString(new StringBuilder())
     println(result.toString)
      result.toString
    }
  }