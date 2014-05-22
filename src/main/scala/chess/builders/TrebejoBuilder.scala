package chess.builders

import chess.Color
import chess.TipoDeTrebejo._
import chess.Trebejo

class TrebejoBuilder(val tipo: TipoDeTrebejo) {
  def deColor(c: Color) = new Trebejo(tipo, c, 0)
}