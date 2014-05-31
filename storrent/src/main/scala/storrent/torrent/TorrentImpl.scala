package storrent.torrent

import storrent.TorrentFile
import java.text.SimpleDateFormat
import java.util.Date

class TorrentImpl(lenght: String, md5: String, name: String, piece_lenght: String, Pieces: String, Files: String, announce: String, announce_list: String, comment: String, created_by: String, creation_date: String, info: String) extends Torrent {

  def this(encodedFile: TorrentFile) = {
    this(
      encodedFile.getValueByKey(Torrent.LENGHT).toString,
      encodedFile.getValueByKey(Torrent.MD5).toString,
      encodedFile.getValueByKey(Torrent.NAME).toString,
      encodedFile.getValueByKey(Torrent.PIECE_LENGHT).toString,
      encodedFile.getRSAHash,
      encodedFile.getValueByKey(Torrent.FILES).toString,
      encodedFile.getValueByKey(Torrent.ANNOUNCE).toString,
      encodedFile.getValueByKey(Torrent.ANNOUNCE_LIST).toString,
      encodedFile.getValueByKey(Torrent.COMMENT).toString,
      encodedFile.getValueByKey(Torrent.CREATED_BY).toString,
      encodedFile.getValueByKey(Torrent.CREATION_DATE).toString,
      encodedFile.getValueByKey(Torrent.INFO).toString)
  }

  def getLenght: String = {
    this.lenght
  }

  def getMD5: String = {
    this.md5
  }

  def getName: String = {
    this.name
  }

  def getFiles: String = {
    this.Files
  }

  def getPieceLenght: String = {
    this.piece_lenght
  }

  def getPieces: String = {
    this.Pieces
  }

  def getAnnounce: String = {
    this.announce
  }
  
  def getAnnounce_list: String = {
    this.announce_list
  }
  
  def getCreatedBy: String = {
    this.created_by
  }
  
  def getCreationDate: String = {
    var date = ""
    if (!this.creation_date.isEmpty()) {
      date = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(new Date(this.creation_date.toInt * 1000L))
    }
    date
  }
  
  def getInfo: String = {
    this.info
  }
  
  def getComment: String = {
    this.comment
  }
}