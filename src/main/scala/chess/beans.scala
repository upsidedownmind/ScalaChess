package chess {

  case class Posicion(val columna: Char, val fila: Int)

  case class Movimiento(val desde: Posicion, val hasta: Posicion)

  object TipoDeTrebejo extends Enumeration {
    type TipoDeTrebejo = Value
    val Rey, Reina, Alfil, Caballo, Torre, Peon, Nada = Value
    //Nada == escaque en blanco
  }
  import TipoDeTrebejo._

  case class Trebejo(val tipo: TipoDeTrebejo, val color: Color, val movimientos: Int) {
    def esDeColor(c: Color) = c == color
  }

  case class Escaque(val color: Color, val posicion: Posicion, val trebejo: Trebejo) {
    def estaVacio = trebejo.tipo == Nada
  }
  
}