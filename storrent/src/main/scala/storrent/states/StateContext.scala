package storrent.states

import storrent.TorrentFile
import scala.collection.mutable.LinkedHashMap
import scala.collection.mutable.MutableList

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
    
    def addList(list:MutableList[String]):Unit = {
      getTorrent.addList(list)
    }
    
    def addDictionary(map:LinkedHashMap[String,String]):Unit = {
      getTorrent.addDictionary(map)
    }
    
  }