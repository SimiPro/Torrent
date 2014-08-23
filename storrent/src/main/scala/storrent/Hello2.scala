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
import storrent.torrent.Torrent
import java.text.SimpleDateFormat
import java.util.Date
import java.net.URLEncoder
import dispatch.url
import dispatch.Http
import dispatch._, Defaults._

object Hello2 {
  var fileName = new File("").getAbsolutePath() + "/src/test/java/storrent/core/bencode/test.to"
  var byteArray = Files.readAllBytes(Paths.get(fileName))

  def main(args: Array[String]) {
    
    for (x <- 0 until byteArray.length) {
      var actualByte = byteArray(x)
      
     }    
    
    
    var file = new TorrentFile(fileName)
    var torrent = Torrent.createTorrent(file)
    println(torrent.getPieces)
    println(torrent.getAnnounce)
    println(torrent.getCreationDate)
    println(torrent.getName)
    println(torrent.getPieceLenght)
    println(torrent.getLenght)
//    println(file.toString)

//    val svc = url(torrent.getAnnounce)
//    val tracker = Http(svc OK )


    println("Conect to HTML: " + torrent.getAnnounce)
    val svc = url(torrent.getAnnounce)
    val tracker = Http(svc OK as.xml.Elem)
    
    for (str <- tracker)
      println(str)
    
    println("HEXA" + URLEncoder.encode(new String(hex2bytes("64e48d5c37c6cf14ecfb5278a21c0d3cb28a7cad")), "UTF-8"))
    
  }
  

  def hex2bytes(hex: String): Array[Byte] = {
    hex.replaceAll("[^0-9A-Fa-f]", "").sliding(2, 2).toArray.map(Integer.parseInt(_, 16).toByte)
  }
  
  
  
  @deprecated
  def getString(input: String): String = {
    var fileContext = new StateContext(new TorrentFile())
    byteArray = input.getBytes("UTF-8")
    for (x <- 0 until byteArray.length) {
      var actualByte = byteArray(x)
      fileContext.write(actualByte)
    }
    fileContext.getTorrent.toString
  }
  def getTorrentByFilePath(path: String): TorrentFile = {
    new TorrentFile(fileName)
  }

  @deprecated
  def getStringByBytes(input: Array[Byte]): String = {
    var fileContext = new StateContext(new TorrentFile())
    for (x <- 0 until input.length) {
      var actualByte = input(x)
      fileContext.write(actualByte)
    }
    fileContext.getTorrent.toString
  }

}

