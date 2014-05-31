package storrent.torrent

import storrent.TorrentFile

trait Torrent {

  def getLenght: String
  def getMD5: String
  def getName: String
  def getFiles: String
  def getPieceLenght: String
  def getPieces: String
  def getAnnounce: String
  def getAnnounce_list: String
  def getComment: String
  def getCreatedBy: String
  def getCreationDate: String
  def getInfo: String
  

}

object Torrent {
  val LENGHT = "lenght"
  val MD5 = "md5sum"
  val NAME = "name"
  val PIECE_LENGHT = "piece length"
  val PIECES = "pieces"
  val FILES = "files"
  val ANNOUNCE = "announce"
  val ANNOUNCE_LIST = "announce-list"
  val COMMENT = "comment"
  val CREATED_BY = "created by"
  val CREATION_DATE = "creation date"
  val INFO = "info"
  
   def createTorrent(file:TorrentFile):Torrent= {
    new TorrentImpl(file)
  }
}