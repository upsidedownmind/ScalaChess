package chess
import scala.util.{Try, Success, Failure}
import chess.Constantes._
import chess.Constantes.TipoDeTrebejo._	
import scala.util.Failure
 

case class Trebejo(val tipo:TipoDeTrebejo, color: Color)
case class Jugador(val nombre:String, val color:Color) {
  def esDeColor(c:Color) = c == color
}
case class Escaque(val color:Color, posicion:Posicion, val trebejo:Trebejo)
case class Movimiento( val desde:Posicion, val hasta:Posicion )

// el juego!
class Ajedrez {
  
	var _jugadores = List[Jugador]()
	//getter
	def jugadores:List[Jugador] = _jugadores
	
	//tablero
	var tablero:Tablero = { 
	  
	  val posiciones = for ( r <- 1 to 1; c <- 'a' to 'h') yield (r, c)
	  
	  GeneradorDePiezas.formacionInicial zip(posiciones) map( z  => new Escaque( blanco, z._2 , z._1 ) ) toList
	}
	
	//proxima jugada
	var proximoTurno = blanco
	
	//registrar jugador
	def agregarJugador(j:Jugador):Try[Jugador] = j match {
	  
	  case Jugador(_, color:Symbol) if (color == blanco || color == negro) =>
	    
	    	if (! jugador(color).isEmpty )
	    	  new Failure(new Exception("El jugador ya existe")) 
	    	else
	    		_jugadores =  j :: _jugadores
	    		new Success(j)
	    	
	  case _ => new Failure(new Exception("El jugador no es valido")) 
		
	}
	
	//buscar jugador
	def jugador(color:Color) = jugadores find( _.color == color )
	
	//conteo de piezas
	def cantidadDePiezas(j:Option[Jugador]) = j match {
	  case Some(j) => tablero.foldRight(0)( (e,acc) => if (e.color == j.color) acc+1 else acc  )
	  case None => 0
	}
	
	//quien esta en XY
	def jugadorEn( en:Posicion ):Option[Jugador] = tablero.find( e => e.posicion == en && e.trebejo.tipo != Nada ) match {
	  case e:Escaque => jugador(e.trebejo.color)
	  case _ => None
	}
 
	
	//moves
	def mover( mov:Movimiento ):Try[Trebejo] = mov match {
	  case Movimiento( desde, hasta ) if desde == posicionInvalida || hasta == posicionInvalida =>  "Posicion Invalida"
	  case Movimiento( desde, hasta ) if  jugadorEn( desde ).fold(false)(_.esDeColor( proximoTurno )) => validarYGenerarMovimiento( Some(mov) ) 
	  //""//tablero mover(new Movimiento(jugadorEn( desde ), desde, hasta))  
	  case _ => "Movimiento Invalido"
	}
	
	private[this] def validarYGenerarMovimiento( mov:Option[Movimiento] ):Try[Trebejo] = "TODO"
			//for( m <- mov if ReglasDeMovimiento.esValido( mov ) ) yield new ""
  
}
 
//dsl sugar
object Jugador { 
	class JugadorSugar(val nombre:String) {
		def color( color:Symbol ) = new Jugador(nombre, color)	
	}

	implicit def String2JugadorSugar( nombre:String  ) = new JugadorSugar(nombre)
	
  
}
object Movimiento {
  
  private[this] def movimientoSimple( mov:String ) = movimientoInvalido
  
  implicit def String2Movimiento( mov:String  ):Movimiento = mov match {
    case simple:String if simple.length() == 4 => movimientoSimple( simple )
    case _ => movimientoInvalido
  }
}