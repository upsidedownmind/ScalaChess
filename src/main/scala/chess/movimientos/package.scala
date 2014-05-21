package chess

package object movimientos {

  //match
  val movimientoSimplePattern = "([a-hA-h][1-8])([a-hA-h][1-8])".r
  val posicionPattern = "([a-hA-h])([1-8])".r

  //DSL
  implicit def String2Movimiento(mov: String): Movimiento = mov match {
    case movimientoSimplePattern(desde, hasta) => new Movimiento(desde, hasta)
    case _ => movimientoInvalido
  }

  implicit def String2Posicion(pos: String): Posicion = pos match {
    case posicionPattern(char, num) => new Posicion(char.charAt(0), num.toInt)
    case _ => posicionInvalida
  }

  implicit def Tablero2MotorDeMovimiento(tablero: Tablero): MotorDeMovimiento = new MotorDeMovimiento(tablero)
  
}