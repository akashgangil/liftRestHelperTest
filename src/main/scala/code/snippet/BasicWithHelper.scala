
package code
package snippet
import code.model.Item

import net.liftweb._
import common._
import http._
import rest._
import json._
import scala.xml._
/**
 * A simple example of a REST style interface
  * using the basic Lift tools */
object BasicWithHelper extends RestHelper {

  serve {
    case "simple" :: "item" :: Item(item) :: "a" :: Nil XmlGet _ => item:Node
      //      for {
      //        item <- Item.find(itemId) ?~ "Item Not Found"
      //     } yield item:Node
      //println("******************"+item.itemName)
    case "simple" :: Item(item) ::"c"::"d" :: Nil XmlGet _ => item:Node
    case "simple" :: Item(item) ::"e"::"f" :: Nil XmlGet _ => item:Node
    case "simple" :: Item(item) ::"g" ::"h" :: Nil XmlGet _ => item:Node
    case "simple" :: Item(item) ::"i" :: "j" :: Nil XmlGet _ => item:Node
    case "simple" :: Item(item) ::"k" :: "l" :: Nil XmlGet _ => item:Node
  }
}

