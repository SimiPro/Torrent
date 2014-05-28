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
 var fileContext = new StateContext()
  
  def main(args: Array[String]) {
      var line = new TorrentFile
      byteArray = "4:spam".getBytes()
      
      for (x <- 0 until byteArray.length) {
        var actualByte = byteArray(x)
        fileContext.write(actualByte)
      }
      println(fileContext.getTorrent.toString)
 }
 
 def getString(input:String):String =  {
   byteArray = input.getBytes()
   for (x <- 0 until byteArray.length) {
        var actualByte = byteArray(x)
        fileContext.write(actualByte)
   }
   fileContext.getTorrent.toString
 }
 

  

  

  
    

    

    
 


    
 }    
  
