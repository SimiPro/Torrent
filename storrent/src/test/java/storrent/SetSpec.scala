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
    assert(Hello2.getString("d3:cow3:moo4:spam4:eggse") == "{cow => moo,spam => eggs}")
  }

  "d4:spaml1:a1:bee" should "be transfered to  {spam => [a,b]}" in {
    println(Hello2.getString("d4:spaml1:a1:bee"))
    assert(Hello2.getString("d4:spaml1:a1:bee") == "{spam => [a,b]}")
  }

  "d5:spam1l1:a1:be3:cow3:moo5:spam24:eggse" should "be transfered to  {spam => [a,b],cow => moo,spam => eggs}" in {
    println(Hello2.getString("d4:spaml1:a1:bee"))
    assert(Hello2.getString("d5:spam1l1:a1:be3:cow3:moo5:spam24:eggse") == "{spam1 => [a,b],cow => moo,spam2 => eggs}")
  }

  "d3:egg1:aed3egg1:a" should "be transfered to {egg => a}{egg => a}" in {
    assert(Hello2.getString("d3:egg1:aed3:egg1:ae") == "{egg => a}{egg => a}")
  }

  "d3:eggd1:ai24eee" should "be transfered to {egg => {a => 24}}" in {
    assert(Hello2.getString("d3:eggd1:ai24eee") == "{egg => {a => 24}}")
  }

  "ld3:eggi25eee" should "be transfered to [{egg => 25}]" in {
    assert(Hello2.getString("ld3:eggi25eee") == "[{egg => 25}]")
  }

}