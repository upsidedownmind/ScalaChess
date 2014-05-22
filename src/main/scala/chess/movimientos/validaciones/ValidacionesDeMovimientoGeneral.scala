package chess.movimientos.validaciones

import chess._
import chess.tablero._

class ValidacionesDeMovimientoGeneral(implicit val movimiento: Movimiento, val tablero: Tablero) extends Validacion {
 
  def ejecutar: ResultadoDeValidacion = {
    
    List(
      elMovimientoNoPuedeEstarFueraDelTablero _,
      elMovimientoNoPuedeSerLoop _,
      elMovimientoTieneQueOriginarseEnUnTrebejo _)

    .foldRight(ok.asInstanceOf[ResultadoDeValidacion])((fnc, sobre) => sobre match {
      case Left(ok) => fnc()
      case err => err
    })

  }

  /// reglass

  def elMovimientoNoPuedeEstarFueraDelTablero(): ResultadoDeValidacion = {

    if (movimiento == movimientoInvalido
      || movimiento.desde == posicionInvalida
      || movimiento.hasta == posicionInvalida)
      error("Movimiento Invalido")
    else
      ok
  }

  def elMovimientoNoPuedeSerLoop(): ResultadoDeValidacion = {

    if (movimiento.desde == movimiento.hasta)
      error("Movimiento Invalido")
    else
      ok
  }

  def elMovimientoTieneQueOriginarseEnUnTrebejo(): ResultadoDeValidacion = {
    if (tablero.trebejoEn(movimiento.desde) isEmpty)
      error("Movimiento Invalido")
    else
      ok
  }

}