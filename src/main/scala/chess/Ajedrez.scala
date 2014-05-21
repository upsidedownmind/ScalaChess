package chess
import scala.util.{Try, Success, Failure}
import chess.Constantes._
import chess.Constantes.TipoDeTrebejo._	
import scala.util.Failure
 

case class Movimiento( val desde:Posicion, val hasta:Posicion )
case class Trebejo(val tipo:TipoDeTrebejo, val color: Color, val movimientos:Int)
case class Escaque(val color:Color, val posicion:Posicion, val trebejo:Trebejo){
  def estaVacio  = trebejo.tipo == Nada
}

// el juego!
class Ajedrez {
   
	
	//tablero
	var tablero:Tablero = GeneradorDePiezas.tableroInicial
	
	//proxima jugada
	var proximoTurno = blanco
	  
	//conteo de piezas
	def cantidadDePiezas(color:Color) = tablero.foldRight(0)( (e,acc) => if (e.trebejo.color == color && !e.estaVacio ) acc+1 else acc  ) 
	
	//quien esta en XY
	def trebejoEn( en:Posicion ):Option[Trebejo] = tablero.find( e => e.posicion == en && !e.estaVacio ) map(_.trebejo)
 
	
	//moves
	def mover( mov:Movimiento ):Try[Trebejo] = mov match {
	  case Movimiento( desde, hasta ) if desde == posicionInvalida || hasta == posicionInvalida =>  "Posicion Invalida"
	  case Movimiento( desde, hasta ) if  trebejoEn( desde ).fold(false)(_.color == proximoTurno) => validarYGenerarMovimiento( Some(mov) ) 
	  //""//tablero mover(new Movimiento(jugadorEn( desde ), desde, hasta))  
	  case _ => "Movimiento Invalido"
	}
	
	private[this] def validarYGenerarMovimiento( mov:Option[Movimiento] ):Try[Trebejo] = "TODO"
			//for( m <- mov if ReglasDeMovimiento.esValido( mov ) ) yield new ""
  
}
 
//dsl sugar 
object Movimiento {
  
  private[this] def movimientoSimple( mov:String ) = movimientoInvalido
  
  implicit def String2Movimiento( mov:String  ):Movimiento = mov match {
    case simple:String if simple.length() == 4 => movimientoSimple( simple )
    case _ => movimientoInvalido
  }
}