package storrent.container

import scala.collection.mutable.MutableList
import scala.collection.mutable.LinkedHashMap

class PrettyMap extends LinkedHashMap[String, Any] {

  override def toString: String = {
    var result = new StringBuilder()
    if (!this.isEmpty) {
      result.append("{")
      result.append(this.head._1).append(" => ").append(this.head._2)
      this.tail.foreach(T => result.append(',').append(T._1).append(" => ").append(T._2))
      result.append("}")
    }
    result.toString
  }

}
