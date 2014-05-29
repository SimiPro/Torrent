package storrent

import org.scalatest.Spec
import storrent.unittest.StorrentSpec

class SetSpec extends StorrentSpec {

  
  "4:spam" should "be transferd to spam" in {
     assert(Hello2.getString("4:spam") == "spam")
  }
  
  "4:spam:6:lenght" should "be transfered to spam,lenght" in {
    assert(Hello2.getString("4:spam6:lenght") == "spamlenght")
  }
  
  "i24e" should "be transfered to 24" in {
    assert(Hello2.getString("i24e") == "24")
  }
  
  "5:radioi25e" should "be transfered to radio25" in {
     assert(Hello2.getString("5:radioi25e") == "radio25")
  }
  
  "l4:spam4:eggse" should "be transfered to [spam,eggs]" in {
     assert(Hello2.getString("l4:spam4:eggse") == "[spam,eggs]")
  }
  
  "l4:spam4:eggsei24e" should "be transfered to 24[spam,eggs]" in {
	 assert(Hello2.getString("l4:spam4:eggsei24e") == "24[spam,eggs]")
  }
  
  "d3:cow3:moo4:spam4:eggse" should "be transfered to  {cow => moo,spam => eggs}" in {
	assert(Hello2.getString("d3:cow3:moo4:spam4:eggse")  == "{cow => moo,spam => eggs}")
  }
  
  
}