package chess.test

import org.specs2.mutable._
import chess._
import chess.Constantes._  
import chess.Movimiento._  

class ReglasDeMovimientoSpecs  extends Specification {

  "El Conjunto de reglas para movimientos "  should {
    
    "permitir mover un peon hacia adelante cuando el escaque esta Empty" in {
      true must beFalse //bum!
    }
    
  }
}