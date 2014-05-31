package storrent.states

import scala.collection.mutable.MutableList
import scala.collection.mutable.LinkedHashMap
import storrent.container.PrettyMap
import storrent.container.PrettyMutableList
import storrent.TorrentFile
import storrent.TorrentFile

class ListContext(STATE_CONTEXT: StateContext) extends StateContext(STATE_CONTEXT.getTorrent) {
  var reallist: PrettyMutableList = new PrettyMutableList()

  override def addInt(int: String) = {
    reallist += int
  }

  override def addString(string: String) = {
    reallist += string
  }

  override def addDictionary(map: PrettyMap): Unit = {
    reallist += map
  }

  override def setDefault() = {
    STATE_CONTEXT.setState(new ListState(STATE_CONTEXT, this))
  }

  def getList(): PrettyMutableList = {
    reallist
  }
}
