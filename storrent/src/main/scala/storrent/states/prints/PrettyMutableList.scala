package storrent.states.prints

import scala.collection.mutable.MutableList

class PrettyMutableList extends MutableList[String] {

  
  override def toString:String = {
    var result = new StringBuilder()
     if (!this.isEmpty) {
       
       this.foreach(A => {
	       result.append("[")
	       result.append(A.head)
	       A.tail.foreach(result.append(',').append(_))
	       result.append("]")
       })
     }
    result.toString
  }
}