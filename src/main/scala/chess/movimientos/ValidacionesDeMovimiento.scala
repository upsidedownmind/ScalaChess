package chess.movimientos

import chess._
import chess.tablero._
import scala.util.Either
import scala.util.Failure
import scala.util.Try
import chess.GeneradorDePiezas
import chess.movimientos.validaciones._

object ValidacionesDeMovimiento {

  def elMovimientoTieneQueSerValidoParaElTablero(sobre: MovimientoAValidar): ResultadoDeValidacion = {
    new ValidacionesDeMovimientoGeneral()(sobre._1, sobre._2).ejecutar
  }

  def elMovimientoTieneQueSerValidoParaLaPieza(result: ResultadoDeValidacion): ResultadoDeValidacion = {

    if (result.isLeft) {

      val sobre = result.left.get

      val mov = sobre._1
      val trebejo = sobre._2.trebejoEn(mov.desde).get

      trebejo match {
        case p if (p.tipo == TipoDeTrebejo.Peon) => new ValidacionesDeMovimientoDePeon()(sobre._1, sobre._2).ejecutar
        case t => Right("trebejo no modelado: " + t.tipo)
      }

    } else result

  }

  //

  def validar(mov: Movimiento, tablero: Tablero) = {
    (
      elMovimientoTieneQueSerValidoParaElTablero _ andThen
      elMovimientoTieneQueSerValidoParaLaPieza)(new MovimientoAValidar(mov, tablero))
  }

}