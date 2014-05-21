package chess.test

import chess.TipoDeTrebejo
 

object chessws {
	
	import chess._
	import chess.graficos._
	import chess.movimientos._
	import chess.tablero._
	
	import TipoDeTrebejo._
	  
	//val lonly = GeneradorDePiezas.tableroEnBlanco.agregar( "d4", GeneradorDePiezas.crear( Peon ) (negro) )
	 
	//lonly.visualizar

  val aj = new Ajedrez                            //> aj  : chess.Ajedrez = chess.Ajedrez@3fa3a66c
   
  aj. mover( "a2a3" ) .visualizar                 //> res0: String = "
                                                  //|    a b c d e f g h
                                                  //|   ╔═══════════════╗
                                                  //| 8 ║♜ ♞ ♝ ♚ ♛ ♝ ♞ ♜║ 8
                                                  //| 7 ║♟ ♟ ♟ ♟ ♟ ♟ ♟ ♟║ 7
                                                  //| 6 ║               ║ 6
                                                  //| 5 ║               ║ 5
                                                  //| 4 ║               ║ 4
                                                  //| 3 ║♙              ║ 3
                                                  //| 2 ║  ♙ ♙ ♙ ♙ ♙ ♙ ♙║ 2
                                                  //| 1 ║♖ ♘ ♗ ♕ ♔ ♗ ♘ ♖║ 1
                                                  //|   ╚═══════════════╝
                                                  //|   a b c d e f g h
                                                  //| "
  
  //GeneradorDePiezas.tableroInicial
  
  //aj.tablero
       
   
}