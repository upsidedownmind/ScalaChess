package chess

import chess.Constantes._

object ReglasDeMovimiento {

	def reglas = List(
		( mov:Option[Movimiento], tablero:Tablero )  => mov,
		( mov:Option[Movimiento], tablero:Tablero )  => None
	)
	
  
	def esValido( mov:Option[Movimiento], tablero:Tablero ) = false //TODO
  
}