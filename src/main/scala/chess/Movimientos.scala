package chess

import chess.Constantes._
import chess.Tablero._
import scala.util.Try
import scala.util.Success
import scala.util.Failure
import scala.util.Success
import scala.util.Failure
import scala.util.Success

object Movimientos { 
  
  case class Movimiento( val desde:Posicion, val hasta:Posicion )
  
  //objetos "null" o de valor incorrecto
  lazy val posicionInvalida:Posicion = new Posicion(-1, '0')
  lazy val movimientoInvalido:Movimiento = new Movimiento( posicionInvalida, posicionInvalida) 

  //match
  val movimientoSimplePattern = "([a-hA-h][1-8])([a-hA-h][1-8])".r
  val posicionPattern = "([a-hA-h])([1-8])".r
  
  
  //DSL
  implicit def String2Movimiento( mov:String  ):Movimiento = mov match {
    case movimientoSimplePattern(desde, hasta) => new Movimiento( desde, hasta )
    case _ => movimientoInvalido
  }
  
  implicit def String2Posicion( pos:String ):Posicion = pos match {
    case posicionPattern(char, num) => new Posicion(num.toInt, char.charAt(0))
    case _ => posicionInvalida
  } 
  
  implicit def Tablero2ControllDeMovimiento(tablero:Tablero):ControllDeMovimiento = new ControllDeMovimiento(tablero)
  
  //help
  class ControllDeMovimiento(val tableroOriginal:Tablero) { 
    
    def moverSiElTrebejoEs( mov:Movimiento, color:Color ):Try[Tablero] = {
    
      if( tableroOriginal.trebejoEn( mov.desde ).fold(false)( _.esDeColor(color) ) )
        mover(mov)
      else
        "El Trebejo no es de color " + color
       
    }
    
	//moves
	def mover( mov:Movimiento ):Try[Tablero] = ReglasDeMovimiento.validar(mov, tableroOriginal) match {
	    case Left(_) => Success( ReglasDeMovimiento.generarMovimiento(mov, tableroOriginal) )
	    case Right(err) => err
	  }
	 
  }
}