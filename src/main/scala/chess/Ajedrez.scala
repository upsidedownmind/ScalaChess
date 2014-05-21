package chess

import scala.util.{Try, Success, Failure} 
import chess.movimientos._
import scala.util.Failure
  
// el juego! visto desde afuera..
class Ajedrez { 
  
	//tablero
	var tablero:Tablero = GeneradorDePiezas.tableroInicial
	
	//proxima jugada
	var colorDelProximoTurno = blanco
	
	def mover(mov:String):Try[Tablero] = {
	  
	  val result = tablero.moverSiElTrebejoEs(mov, colorDelProximoTurno)
	  
	  //refresh
	  if(result.isSuccess) {
	    colorDelProximoTurno = if (colorDelProximoTurno == blanco) negro else blanco
		tablero = result.get
	  }
	    
	  result
	}
	
	//comportamientos especiales
	def jaque():Try[Tablero] = "no modelado..."
	def jaqueMate():Try[Tablero] = "no modelado..."
	def enroque():Try[Tablero] = "no modelado..."
	def abandonar():Try[Tablero] = "no modelado..."
	def promocion():Try[Tablero] = "no modelado..."
	  
  
} 
 