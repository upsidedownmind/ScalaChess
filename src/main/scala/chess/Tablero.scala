package chess

import chess.Constantes._ 
import chess.Constantes.TipoDeTrebejo._	

object Tablero {

  type Tablero = List[Escaque]
  type Posicion = Pair[Int,Char]
  
  
  case class Trebejo(val tipo:TipoDeTrebejo, val color: Color, val movimientos:Int) {
    def esDeColor(c:Color) = c == color
  }
  
  case class Escaque(val color:Color, val posicion:Posicion, val trebejo:Trebejo){
    def estaVacio  = trebejo.tipo == Nada
  }
  
  class TableroUtils(val tablero:Tablero) {
    
	//conteo de piezas
	def cantidadDePiezas(color:Color) = tablero.foldRight(0)( (e,acc) => if (e.trebejo.color == color && !e.estaVacio ) acc+1 else acc  ) 
	
	//quien esta en XY
	def trebejoEn( en:Posicion ):Option[Trebejo] = tablero.find( e => e.posicion == en && !e.estaVacio ) map(_.trebejo)
 
	def agregar( en:Posicion, trebejo:Trebejo ) = tablero
	
  }
  //dsl
  implicit def Ajedrez2TableroUtils( aj:Ajedrez  ):TableroUtils = new TableroUtils(aj.tablero)
  implicit def Tablero2TableroUtils( tablero:Tablero  ):TableroUtils = new TableroUtils(tablero)
}