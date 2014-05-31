package storrent.states

import scala.collection.mutable.LinkedHashMap
import scala.collection.mutable.MutableList
import storrent.container.PrettyMap
import storrent.container.PrettyMutableList

class DictContext(STATE_CONTEXT: StateContext) extends StateContext(STATE_CONTEXT.getTorrent) {
  var map: PrettyMap = new PrettyMap()
  var key: String = ""

  def getMap(): PrettyMap = {
    map
  }

  override def addInt(int: String) = {
    if (key.isEmpty()) {
      key = int
    } else {
      map += key -> int
      key = ""
    }
  }

  override def addString(string: String) = {
    if (key.isEmpty()) {
      key = string
    } else {
      map += key -> string
      key = ""
    }
  }

  override def addList(list: PrettyMutableList): Unit = {
    map += key -> list
    key = ""
  }

  override def setDefault() = {
    STATE_CONTEXT.setState(new DictionaryState(STATE_CONTEXT, this))
  }

  override def addDictionary(mapToAdd: PrettyMap): Unit = {
    map+= key -> mapToAdd
    key = ""
  }
}

