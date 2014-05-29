package storrent

import scala.io.Source
import scala.io.Codec
import scala.annotation.tailrec
import java.io._
import java.nio._
import java.nio.file.Files
import java.nio.file.Paths
import scala.collection.mutable.Map
import storrent.states.StateContext
import storrent.states.StateContext

object Hello2 {
 var fileName = "/home/simipro/git/STorrent/storrent/src/test/java/storrent/core/bencode/torr.torrent"
 var byteArray = Files.readAllBytes(Paths.get(fileName))
  
  def main(args: Array[String]) {
      var line = new TorrentFile
      byteArray = Files.readAllBytes(Paths.get(fileName))
      println(getStringByBytes(byteArray))
 }
 
 def getString(input:String):String =  {
   var fileContext = new StateContext()
   byteArray = input.getBytes()
   for (x <- 0 until byteArray.length) {
        var actualByte = byteArray(x)
        fileContext.write(actualByte)
   }
   fileContext.getTorrent.toString
 }
 
  def getStringByBytes(input:Array[Byte]):String =  {
   var fileContext = new StateContext()
   for (x <- 0 until input.length) {
        var actualByte = input(x)
        fileContext.write(actualByte)
   }
   fileContext.getTorrent.toString
 }
 

  

  

  
    

    

    
 


    
 }    
  
