package chess.movimientos

import chess.{ Movimiento, Tablero }

package object validaciones {

  type MovimientoAValidar = Pair[Movimiento, Tablero]
  type ResultadoDeValidacion = Either[MovimientoAValidar, String]

}