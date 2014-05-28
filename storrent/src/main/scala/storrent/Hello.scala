package storrent

import scala.io.Source
import scala.io.Codec
import scala.annotation.tailrec
import java.io._
import java.nio._
import java.nio.file.Files
import java.nio.file.Paths

object Hello {
  def main(args: Array[String]) {
	  var fileName = "/home/simipro/git/STorrent/storrent/src/test/java/storrent/core/bencode/torr.torrent"
	    
//      val source = scala.io.Source.fromFile(fileName)  
//val byteArray = source.map(_.toByte).toArray
	  
	  val byteArray = Files.readAllBytes(Paths.get(fileName))
      var line = new Returnz
      do {
    	  line = extractStepByStep(byteArray, line)
		  println(line.result)
      } while (line.start != 0)
   }
  
  class Returnz {
    var start = 0
    var result = ""
  }
  
  
     def extractStepByStep(byteArray: Array[Byte], returnz: Returnz): Returnz = {
        var torrentFile = new Returnz
        for (x <- returnz.start to byteArray.length-1) {
        	var actualByte = byteArray(x)
	        torrentFile = actualByte match {
	    		//dictionary d<contents>e {"bar": "spam", "foo": 42}) => d 3:bar 4:spam 3:foo i42e e
	     		case 'd' => {
	     		  var ditctionary = new Returnz
   				  torrentFile.result += "{ \n"
   				  var boolz = true
   				  ditctionary.start = returnz.start+1
	     		  do {
	     		     // overjump "d"
	     			 ditctionary = extractStepByStep(byteArray, ditctionary)
   					 torrentFile.start = ditctionary.start
   					 torrentFile.result += ditctionary.result
	     			 if (boolz) {
	     			   torrentFile.result += ":"
	     			 } else {
	     			   torrentFile.result += ",\n"
	     			 }
	     			 boolz = !boolz
	     		  }while (byteArray(ditctionary.start).toChar != 'e')
	     		  torrentFile.result += " }\n"
	     		  torrentFile.start = torrentFile.start +1
	     		  torrentFile
	     		}
	     		//integer i<integer encoded in base ten ASCII>e i123e
		     	case 'i' => {
		     	  // Overjump "i"
		   			var start = x+1 
					var end = 'e'
		    		extract(start, end, byteArray)
	     		}
	     		//list l<contents>e l4:spami42ee ==> list: spam, 42
	     		case 'l' => {
	     		  var ress = new Returnz
	     		  ress.start = returnz.start +1
	     		  torrentFile.result += "\n [ "
	     		  do {
	     			  ress = extractStepByStep(byteArray, ress)
	     			  torrentFile.result += ress.result
	     			  torrentFile.result += ','
	     		  }while(byteArray(ress.start).toChar != 'e')
	     		  torrentFile.result += " ]\n"
	     		  torrentFile.start = ress.start +1
	     		  torrentFile
	     		}
	     		// A byte string is encoded as <length>:<contents> 4:spam
	    		case _ => {
	    		  var start = x
	    		  var end = ':'
	    		  extractString(start, end, byteArray)
	    		}
        	}
        	return torrentFile
        }
        torrentFile
     }
      
      def extract(start:Int,end:Char, byteArray: Array[Byte]): Returnz = {
  		  var result = new Returnz
          for (j <- start to byteArray.length-1){
                 var char = byteArray(j).toChar
     		     if (char != end) {
     		    	 result.result += char
     		     }else {
     		        result.start = j+1
     		        return result
     		     }
     		  }
          throw new Exception("Check spaces")
      }
      
      def extractString(start:Int,end:Char, byteArray: Array[Byte]): Returnz = {
  		  var result = new Returnz
          for (j <- start to byteArray.length-1){
                 var char = byteArray(j).toChar
     		     if (char != end) {
     		    	 result.result += char
     		     }else {
     		       var end = result.result.toInt
     		       result.result = ""
     		       // +1 cause overjump ':'
     		       for (jj <- j+1 to j+end){
     		         result.result += byteArray(jj).toChar
     		       }
     		       result.start = j+end+1
     		       return result
     		     }
     		  }
          throw new Exception
      }
      
  }
