package storrent.container

import scala.collection.mutable.MutableList

class PrettyMutableList extends MutableList[Any] {

  override def toString: String = {
    var result = new StringBuilder()
    if (!this.isEmpty) {
      result.append("[")
      result.append(this.head)
      this.tail.foreach(result.append(',').append(_))
      result.append("]")
    }
    result.toString
  }
}