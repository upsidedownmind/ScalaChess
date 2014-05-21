package chess.movimientos

import chess._
import chess.tablero._
import scala.util.Either
import scala.util.Failure
import scala.util.Try
import chess.GeneradorDePiezas

object ValidacionesDeMovimiento {

  //validaciones generales
  object ReglasDeValidacion {

    type ResultadoDeValidacion = Either[Pair[Movimiento, Tablero], String]

    def ejecutar(sobre: Pair[Movimiento, Tablero]): ResultadoDeValidacion = {

      //functional magic

      val ejecutarf = List(
        elMovimientoNoPuedeEstarFueraDelTablero _,
        elMovimientoNoPuedeSerLoop _,
        elMovimientoTieneQueOriginarseEnUnTrebejo _,
        elMovimientoTieneQueSerValidoParaLaPieza _)

      ejecutarf.foldRight(Left(sobre).asInstanceOf[ResultadoDeValidacion])((fnc, sobre) => sobre match {
        case Left(sobre) => fnc(sobre)
        case err => err
      })

    }

    /// reglass

    def elMovimientoNoPuedeEstarFueraDelTablero(sobre: Pair[Movimiento, Tablero]): ResultadoDeValidacion = {
      val mov = sobre._1

      if (mov == movimientoInvalido || mov.desde == posicionInvalida || mov.hasta == posicionInvalida)
        Right("Movimiento Invalido")
      else
        Left(sobre)
    }

    def elMovimientoNoPuedeSerLoop(sobre: Pair[Movimiento, Tablero]): ResultadoDeValidacion = {
      val mov = sobre._1

      if (mov.desde == mov.hasta)
        Right("Movimiento Invalido")
      else
        Left(sobre)
    }

    def elMovimientoTieneQueOriginarseEnUnTrebejo(sobre: Pair[Movimiento, Tablero]): ResultadoDeValidacion = {
      if (sobre._2.trebejoEn(sobre._1.desde) isEmpty)
        Right("Movimiento Invalido")
      else
        Left(sobre)
    }

    def elMovimientoTieneQueSerValidoParaLaPieza(sobre: Pair[Movimiento, Tablero]): ResultadoDeValidacion = {
      val trebejo = sobre._2.trebejoEn(sobre._1.desde).get

      trebejo match {
        case p if (p.tipo == TipoDeTrebejo.Peon) => validarMovimientoDePeon(sobre)
        case t => Right("trebejo no modelado: " + t.tipo)
      }
    }

    // reglas por trebejo

    def validarMovimientoDePeon(sobre: Pair[Movimiento, Tablero]): ResultadoDeValidacion = {
      val mov = sobre._1

      //TODO

      Left(sobre)
    }

  }

  def validar(mov: Movimiento, tablero: Tablero) = ReglasDeValidacion.ejecutar(mov, tablero)


}