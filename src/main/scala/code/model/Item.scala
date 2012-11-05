package code
package model
import net.liftweb._
import json.{Extraction, Xml, DefaultFormats, Formats}

import json.JsonAST._
import json.Extraction._
import mapper._
import util._
import common._
import scala.xml.Node

case class Item(val itemName: String,val itemId: String){
}

object Item {
  var count = 0;

  implicit val formats = net.liftweb.json.DefaultFormats

  implicit def toXml(item:Item):Node = <item>{Xml.toXml(item)}</item>
  implicit def toJson(item:Item) :JValue= Extraction.decompose(item)

  def unapply(i:String):Option[Item] = if(i=="1234"){count = count +1;return new Some(new Item(""+count,"1234"))} else None

  def unapply(in: Any): Option[(String, String)] = {
    in match {
      case i: Item => Some((i.itemName, i.itemId))
      case _ => None
    }
  }

  //	def find(i:String):Box[Item] = if(i=="1234") return new Full(new Item("a","1234")) else None
  //def unapply(i:String):Option[Item] = if(i=="1234"){Thread.sleep(2000);return new Some(new Item("a","1234"))} else None
}
