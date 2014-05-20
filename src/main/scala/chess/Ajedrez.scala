package chess
import scala.util.{Try, Success, Failure} 
import chess.Constantes._
import chess.Constantes.TipoDeTrebejo._	
 

case class Trebejo(val tipo:TipoDeTrebejo, color: Color)
case class Jugador(val nombre:String, val color:Color) 
case class Escaque(val color:Color, posicion:Pair[Int,Char], val trebejo:Trebejo)

  
class Ajedrez {
  
	var _jugadores = List[Jugador]()
	//getter
	def jugadores:List[Jugador] = _jugadores
	
	//tablero
	val tablero:Tablero = { 
	  
	  val posiciones = for ( r <- 1 to 8; c <- 'a'.toInt to 'h'.toInt) yield (r, c.toChar)
	  
	  GeneradorDePiezas.formacionInicial.zip(posiciones).map( z  => new Escaque( blanco, z._2 , z._1 ) ) toList
	}
	
	//proxima jugada
	var proximaJugada = blanco
	
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
	def jugador(color:Color) = jugadores.find( _.color == color )
	
	//start!
	def iniciarPartido = {
	  tablero posicionInicial
	  
	  proximaJugada = blanco
	  
	}
	
	//conteo de piezas
	def cantidadDePiezas(j:Option[Jugador]) = 0
  
}
 

object Jugador { 
	class JugadorBuilder(val nombre:String) {
		def color( color:Symbol ) = new Jugador(nombre, color)	
	  
	}

	implicit def String2JugadorBuilder( nombre:String  ) = new JugadorBuilder(nombre)
  
}
