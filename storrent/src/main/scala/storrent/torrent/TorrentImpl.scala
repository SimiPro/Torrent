package storrent.torrent

import storrent.TorrentFile
import storrent.TorrentFile

class TorrentImpl(lenght:String, md5:String) extends Torrent { 
  var lenght 
  var md5
  var name
  var piece_lenght
  var pieces
  var files
  
  
  def this(encodedFile:TorrentFile) = {
    this()
    
  }
  
  
}