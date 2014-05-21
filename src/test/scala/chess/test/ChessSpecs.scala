package chess.test

import org.specs2.mutable._
import chess._
import chess.Constantes._  
import chess.Movimiento._  
import chess.Graficos._

class ChessSpecs extends Specification {

	"El Ajedrez "  should {
	  
	  
	  "iniciar el juego con 16 piezas" in {
	    
	    val aj = new Ajedrez()
	    
	    aj.cantidadDePiezas(  blanco  ) mustEqual 16
      }
	  
	  "iniciar el juego con la misma cantidad de piezas" in {
	    
	    val aj = new Ajedrez() 
	    
	    aj.cantidadDePiezas(   blanco  ) mustEqual aj.cantidadDePiezas(  negro  )
      }
	  
	  
	  "iniciar el juego con las blancas" in {
	     
	    val aj = new Ajedrez() 
	    
	    aj mover( "a2a3" ) must beSuccessfulTry(   )
	    
      }
	  
	}
   
  }