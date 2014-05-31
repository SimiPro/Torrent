package storrent

import scala.collection.mutable.Map
import scala.collection.mutable.MutableList
import scala.collection.mutable.LinkedHashMap
import storrent.container.PrettyMutableList
import storrent.container.PrettyMap
import storrent.container.PrettyMap
import java.io.File
import java.security.MessageDigest
import java.io.FileInputStream
import java.io.ByteArrayOutputStream
import java.io.InputStream
import storrent.states.StateContext
import java.nio.file.Files
import java.nio.file.Paths

class TorrentFile(
  dictionarys: MutableList[PrettyMap] = MutableList(),
  lists: MutableList[PrettyMutableList] = MutableList[PrettyMutableList](),
  //Really need ints list what case for?
  ints: MutableList[Int] = MutableList[Int](),
  strings: PrettyMutableList = new PrettyMutableList()) {

  var path = ""

  def this(path: String) = {
    this()
    this.path = path
    encode
  }

  def encode() = {
    // bencode
    var fileContext = new StateContext(this)
    var byteArray = Files.readAllBytes(Paths.get(path))
    for (x <- 0 until byteArray.length) {
      var actualByte = byteArray(x)
      fileContext.write(actualByte)
    }

  }

  def addInt(int: String) = {
    ints += int.toInt
    strings += int
  }

  def getValueByKey(key: String): Any = {
    var result: Any = Nil
    dictionarys.foreach(M => {
      result = getValueByMap(key, M)
    })
    result
  }

  def getValueByMap(key: String, map: PrettyMap): Any = {
    var result: Any = Nil
    val value = map.getOrElse(key, false)
    if (value != false) {
      result = value
    }
    map.foreach(T => {
      if (T._2.isInstanceOf[PrettyMap]) {
        var deep = getValueByMap(key, T._2.asInstanceOf[PrettyMap])
        if (deep != Nil) {
          result = deep
        }
      }
    })
    result
  }

  def getRSAHash(): String = {
    var ff: File = new File(this.path)
    var sha1: MessageDigest = MessageDigest.getInstance("SHA-1")
    var input: InputStream = new FileInputStream(ff)
    var builder = new StringBuilder

    while (!builder.toString().endsWith("4:info")) {
      builder.append(input.read().toChar); // It's ASCII anyway.
    }
    var output = new ByteArrayOutputStream()
    var data = input.read()
    while (data > -1) {
      output.write(data)
      data = input.read()
    }
    //	    var sha12 = output.toByteArray().sha1

    sha1.update(output.toByteArray(), 0, output.size() - 1);
    var hash = sha1.digest()
    input.close()
    println(sha1)

    var hextString = new StringBuffer
    for (x <- 0 until hash.length) {
      hextString.append(Integer.toHexString(0xFF & hash(x)))
    }
    System.out.println("Hex format : " + hextString.toString());
    hextString.toString()
  }

  def addList(list: PrettyMutableList) = {
    lists += list
  }

  def addString(string: String) = {
    strings += string
  }

  def addDictionary(map: PrettyMap) = {
    dictionarys += map
  }

  override def toString() = {
    // string & int
    var result = strings.addString(new StringBuilder())

    //list
    if (!lists.isEmpty) {
      lists.foreach(A => {
        result.append(A.toString)
      })
    }

    //directory
    if (!dictionarys.isEmpty) {
      dictionarys.foreach(A => {
        result.append(A.toString)
      })
    }
    result.toString
  }
}