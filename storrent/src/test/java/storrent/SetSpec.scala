package storrent

import org.scalatest.Spec

class SetSpec extends Spec {

//  object `A Set` {
//    
//    object `when empty` {
//        
//	  def `4:spam` {
//	    assert(Hello2.getString("4:spam") == "spam")
//	  }
//	  
//	  def `4:spam:5:lenght` {
//	    assert(Hello2.getString("4:spam:5:lenght") == "spamlenght")
//	  }
//    
//    }
//  }
  object `A Set` {
    object `when empty` {
      def `should have size 0` {
         assert(Hello2.getString("4:spam") == "spam")
      }

      def `should produce NoSuchElementException when head is invoked` {
        assert(Hello2.getString("4:spam:5:lenght") == "spamlenght")
      }
    }
  }
  
}