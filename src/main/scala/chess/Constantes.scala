package chess

object Constantes {
  
  object TipoDeTrebejo extends Enumeration {
    type TipoDeTrebejo = Value
    val Rey, Reina, Alfil, Caballo, Torre, Peon, Nada = Value
    
  }
  
  
  type Tablero = List[Escaque]

  type Color = Symbol

  val blanco:Color = 'blanco
  val negro:Color  = 'negro
  
}