package storrent.states

import storrent.TorrentFile
import scala.collection.mutable.Map

  class StateContext {
    var state:StateLike = new NoState()
    var file:TorrentFile  = new TorrentFile()
    
    def getTorrent():TorrentFile =  {
      file
    }
    
    def setState(newState:StateLike):Unit = {
      state = newState
    }
    
    def getState():StateLike = {
      state
    }
    
    def write(byte:Byte) = {
      state.write(this, byte)
    }
    
    def setDefault() = {
      setState(new NoState())
    }
    
    def addString(string:String):Unit =  {
      getTorrent.addString(string)
    }
    
    def addInt(int:String):Unit =  {
      getTorrent.addInt(int)
    }
    
    def addList(list:List[String]):Unit = {
      getTorrent.addList(list)
    }
    
    def addDictionary(map:Map[String,String]):Unit = {
      getTorrent.addDictionary(map)
    }
    
  }