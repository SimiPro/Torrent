package storrent.states

import storrent.TorrentFile
import scala.collection.mutable.LinkedHashMap
import scala.collection.mutable.MutableList
import storrent.container.PrettyMap
import storrent.container.PrettyMutableList
import storrent.TorrentFile
import storrent.TorrentFile

class StateContext(file: TorrentFile) {
  var state: StateLike = new NoState()

  def getTorrent(): TorrentFile = {
    file
  }

  def setState(newState: StateLike): Unit = {
    state = newState
  }

  def getState(): StateLike = {
    state
  }

  def write(byte: Byte) = {
    state.write(this, byte)
  }

  def setDefault() = {
    setState(new NoState())
  }

  def addString(string: String): Unit = {
    getTorrent.addString(string)
  }

  def addInt(int: String): Unit = {
    getTorrent.addInt(int)
  }

  def addList(list: PrettyMutableList): Unit = {
    getTorrent.addList(list)
  }

  def addDictionary(map: PrettyMap): Unit = {
    getTorrent.addDictionary(map)
  }

}