package chess.movimientos

import chess._
import chess.tablero._
import scala.util.{Try,Success}

class MotorDeMovimiento(val tableroOriginal:Tablero) {
    
    def moverSiElTrebejoEs( mov:Movimiento, color:Color ):Try[Tablero] = {
    
      if( tableroOriginal.trebejoEn( mov.desde ).fold(false)( _.esDeColor(color) ) )
        mover(mov)
      else
        "El Trebejo no es de color " + color
       
    }
    
	//moves
	def mover( mov:Movimiento ):Try[Tablero] = ValidacionesDeMovimiento.validar(mov, tableroOriginal) match {
	    case Left(_) => Success( GeneradorDeMovimiento.generar(mov, tableroOriginal) )
	    case Right(err) => err
	  }

}