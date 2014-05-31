package storrent

import scala.io.Source
import com.roundeights.hasher.Implicits._
import scala.language.postfixOps
import scala.io.Codec
import scala.annotation.tailrec
import java.io._
import java.nio._
import java.nio.file.Files
import java.nio.file.Paths
import scala.collection.mutable.Map
import storrent.states.StateContext
import storrent.states.StateContext
import java.security.spec.PKCS8EncodedKeySpec
import java.security.KeyFactory
import java.security.spec.RSAPublicKeySpec
import scala.collection.mutable.MutableList
import storrent.container.PrettyMutableList
import java.security.MessageDigest

object Hello2 {
  var fileName = new File("").getAbsolutePath() + "/src/test/java/storrent/core/bencode/sample.torrent"
  var byteArray = Files.readAllBytes(Paths.get(fileName))

  def main(args: Array[String]) {
    
    var torrent = new TorrentFile(fileName)
    println(torrent.getRSAHash)
    
    
  
  
  }

  def getString(input: String): String = {
    var fileContext = new StateContext()
    byteArray = input.getBytes("UTF-8")
    for (x <- 0 until byteArray.length) {
      var actualByte = byteArray(x)
      fileContext.write(actualByte)
    }
    fileContext.getTorrent.toString
  }
  
  def getTorrentByFilePath(path:String):TorrentFile = {
    var fileContext = new StateContext(path)
    byteArray = Files.readAllBytes(Paths.get(fileName))
    for (x <- 0 until byteArray.length) {
      var actualByte = byteArray(x)
      fileContext.write(actualByte)
    }
    fileContext.getTorrent
  }
  

  def getStringByBytes(input: Array[Byte]): String = {
    var fileContext = new StateContext()
    for (x <- 0 until input.length) {
      var actualByte = input(x)
      fileContext.write(actualByte)
    }
    fileContext.getTorrent.toString
  }

}

