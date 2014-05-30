package storrent

import scala.collection.mutable.Map
import scala.collection.mutable.MutableList
import scala.collection.mutable.LinkedHashMap
import storrent.container.PrettyMutableList
import storrent.container.PrettyMap

class TorrentFile(
  dictionarys: MutableList[PrettyMap] = MutableList(),
  lists: MutableList[PrettyMutableList] = MutableList[PrettyMutableList](),
  //Really need ints list what case for?
  ints: MutableList[Int] = MutableList[Int](),
  strings: PrettyMutableList =  new PrettyMutableList()) {

  def addInt(int: String) = {
    ints += int.toInt
    strings += int
  }

  def addList(list: PrettyMutableList) = {
    lists += list
  }

  def addString(string: String) = {
    strings += string
  }

  def addDictionary(map: PrettyMap) = {
    dictionarys += map
  }

  override def toString() = {
    // string & int
    var result = strings.addString(new StringBuilder())

    //list
    if (!lists.isEmpty) {
      lists.foreach(A => {
        result.append(A.toString)
      })
    }
    
    //directory
    if (!dictionarys.isEmpty) {
      dictionarys.foreach(A => {
       result.append(A.toString)
      })
    }
    result.toString
  }
}