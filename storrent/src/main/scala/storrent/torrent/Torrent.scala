package storrent.torrent

trait Torrent {
	val LENGHT = "lenght"
	val MD5 = "md5sum"
	val NAME = "name"
	val PIECE_LENGHT = "piece length"
	val PIECES = "pieces"
	val FILES = "files"

	  
	def getLenght
	def getMD5
	def getName
	def getFiles
	def getPieceLenght
	def getPieces
  
}