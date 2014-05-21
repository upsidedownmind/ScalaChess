package chess

import scala.util.Failure

/* DSL constants and helpers */
object Constantes {
  
  object TipoDeTrebejo extends Enumeration {
    type TipoDeTrebejo = Value
    val Rey, Reina, Alfil, Caballo, Torre, Peon, Nada = Value
    //Nada == escaque en blanco
  } 
  
  //+++ sugar:
  

  type Color = Symbol

  val blanco:Color = 'blanco
  val negro:Color  = 'negro
  
  
  implicit def string2Failure(msg:String) = new Failure( new Exception(msg) )
}