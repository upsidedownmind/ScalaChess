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
  
  type Tablero = List[Escaque]
  type Posicion = Pair[Int,Char]

  type Color = Symbol

  val blanco:Color = 'blanco
  val negro:Color  = 'negro
  
  //objetos "null" o de valor incorrecto
  val posicionInvalida:Posicion = new Posicion(-1, '0')
  val movimientoInvalido:Movimiento = new Movimiento( posicionInvalida, posicionInvalida)
  //val jugadorinvalido:Jugador = Jugador("jugador invalido", 'color) 
  
  implicit def string2Failure(msg:String) = new Failure( new Exception(msg) )
}