package chess.test

import org.specs2.mutable._
import chess._
import chess.Constantes._ 
import chess.Jugador._
import chess.Movimiento._  

class ChessSpecs extends Specification {

	"El Ajedrez "  should {
	  
	  "ser creado y registrar jugadores" in {
	    
	    val aj = new Ajedrez()
	    
	    aj agregarJugador("j1" color blanco)
	    
	    aj.jugadores.length mustEqual 1 
	    
	    aj agregarJugador("j2" color negro)
	    
	    aj.jugadores.length mustEqual 2
      }
	  
	  "obtener jugador" in {
	    
	    var j = "j1" color blanco
	    
	    val aj = new Ajedrez() 
	    aj agregarJugador(j)
	    
	    aj.jugadores.length mustEqual 1 
	    
	    aj agregarJugador("j2" color negro)
	    
	    aj.jugador(j.color) must beSome( j )
	    
      }
	  
	  "iniciar el juego con 16 piezas" in {
	    
	    val aj = new Ajedrez()
	    aj agregarJugador("j1" color blanco)
	    aj agregarJugador("j2" color negro)
	    
	    aj.cantidadDePiezas( aj jugador blanco  ) mustEqual 8
      }
	  
	  "iniciar el juego con la misma cantidad de piezas" in {
	    
	    val aj = new Ajedrez()
	    aj agregarJugador("j1" color blanco)
	    aj agregarJugador("j2" color negro)
	    
	    aj.cantidadDePiezas( aj jugador blanco  ) mustEqual aj.cantidadDePiezas( aj jugador negro  )
      }
	  
	  
	  "iniciar el juego con las blancas" in {
	    
	    val jb = "j1" color blanco
	    
	    val aj = new Ajedrez()
	    aj agregarJugador(jb)
	    aj agregarJugador("j2" color negro)
	    
	    aj mover( "a2a3" ) must beSuccessfulTry(   )
	    
      }
	  
	}
   
  }