package chess.test

import org.specs2.mutable._
import chess._
import chess.Constantes._  
import chess.Movimientos._  
import chess.Graficos._ 
import chess.Tablero._

class ChessSpecs extends Specification {

	"El Ajedrez "  should {
	  
	  "dibujarse" in {
	    
	    val grafico = """
   a b c d e f g h
  ╔═══════════════╗
8 ║♜ ♞ ♝ ♚ ♛ ♝ ♞ ♜║ 8
7 ║♟ ♟ ♟ ♟ ♟ ♟ ♟ ♟║ 7
6 ║               ║ 6
5 ║               ║ 5
4 ║               ║ 4
3 ║               ║ 3
2 ║♙ ♙ ♙ ♙ ♙ ♙ ♙ ♙║ 2
1 ║♖ ♘ ♗ ♕ ♔ ♗ ♘ ♖║ 1
  ╚═══════════════╝
  a b c d e f g h
"""
	      
	      new Ajedrez().visualizar mustEqual grafico
	  }
	  
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