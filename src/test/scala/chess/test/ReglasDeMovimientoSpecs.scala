package chess.test

import org.specs2.mutable._
import chess._
import chess.graficos._
import chess.movimientos._
import chess.tablero._

class ReglasDeMovimientoSpecs  extends Specification {

  "El Conjunto de reglas para movimientos "  should {
    
    val tableroEnBlanco = GeneradorDePiezas.tableroEnBlanco
    implicit val color = negro
    
    "permitir mover un peon hacia adelante cuando el escaque esta Empty" in {
      
	    val tablero = tableroEnBlanco.agregar( "d4", GeneradorDePiezas.crear( TipoDeTrebejo.Peon)   )
	    
	    tablero mover( "a2a3" ) must beSuccessfulTry(   )
    }
    
  }
}