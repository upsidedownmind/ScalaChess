package chess.movimientos

import chess._
import chess.tablero._ 
import chess.builders.GeneradorDePiezas

object GeneradorDeMovimiento {

  def generar(mov: Movimiento, tablero: Tablero): Tablero = {

    val trebejo = tablero.trebejoEn(mov.desde).get

    tablero.map {
      case src if (src.posicion == mov.desde) => new Escaque(src.color, src.posicion, GeneradorDePiezas.crear(TipoDeTrebejo.Ninguno)(trebejo.color))
      case to if (to.posicion == mov.hasta) => new Escaque(to.color, to.posicion, new Trebejo(trebejo.tipo, trebejo.color, trebejo.movimientos + 1))
      case x => x
    }
  }
}