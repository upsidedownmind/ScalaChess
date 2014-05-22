package chess.test

import org.specs2.mutable._
import chess._
import chess.graficos._
import chess.movimientos._
import chess.tablero._
import org.junit.runner.RunWith
import org.specs2.runner.JUnitRunner
import chess.builders.GeneradorDePiezas

@RunWith(classOf[JUnitRunner])
class GeneradorDePiezasSpecs extends Specification {

  "El GeneradorDePiezasSpecs " should {

    val tableroEnBlanco = GeneradorDePiezas.tableroEnBlanco
    implicit val color = negro

    "generar un tablero en blanco" in {

      tableroEnBlanco.length must beEqualTo(8 * 8)

      tableroEnBlanco.cantidadDePiezas(negro) must beEqualTo(0)

      tableroEnBlanco.cantidadDePiezas(blanco) must beEqualTo(0)
    }

    "agregar una pieza en un tablero" in {

      val tablero = tableroEnBlanco.agregar("d4", GeneradorDePiezas.crear(TipoDeTrebejo.Peon))

      tablero.cantidadDePiezas must beEqualTo(1)
    }

  }

}