package chess.movimientos.validaciones

import chess.{ Movimiento, Tablero }

abstract class Validacion {
  def ejecutar: ResultadoDeValidacion

  def ok(implicit movimiento: Movimiento, tablero: Tablero) = Left(new MovimientoAValidar(movimiento, tablero))
  def error(msg: String) = Right(msg)
}
 