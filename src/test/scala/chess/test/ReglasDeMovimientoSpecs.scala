package chess.test

import org.specs2.mutable._
import chess._
import chess.graficos._
import chess.movimientos._
import chess.tablero._
import org.junit.runner.RunWith
import org.specs2.runner.JUnitRunner
import TipoDeTrebejo._
import chess.builders.GeneradorDePiezas

@RunWith(classOf[JUnitRunner])
class ReglasDeMovimientoSpecs extends Specification {

  "El Conjunto de reglas para movimientos " should {

    val tableroEnBlanco = GeneradorDePiezas.tableroEnBlanco
    implicit val color = blanco

    "permitir mover un peon hacia adelante cuando el escaque esta Empty" in {

      val tablero = tableroEnBlanco.agregar("d4", GeneradorDePiezas.crear(Peon))

      tablero mover ("d4d5") must beSuccessfulTry
    }

    "no capturar trebjos del mismo color" in {

      val tablero = tableroEnBlanco
        .agregar("d4", GeneradorDePiezas.crear(Peon))
        .agregar("d5", GeneradorDePiezas.crear(Peon))

      tablero mover ("d4d5") must beFailedTry
    }

  }
}