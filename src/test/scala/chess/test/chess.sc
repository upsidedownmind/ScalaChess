package chess.test
 

object chessws {
	
	import chess._
	import chess.Constantes._
	import chess.Constantes.TipoDeTrebejo._
	import chess.Movimientos._
	import chess.Graficos._
	import chess.Tablero._
	  
	//val lonly = GeneradorDePiezas.tableroEnBlanco.agregar( "d4", GeneradorDePiezas.crear( Peon) (negro) )
	 
	//lonly.visualizar


  val aj = new Ajedrez                            //> aj  : chess.Ajedrez = chess.Ajedrez@33e5013
   
  aj mover( "a2a3" )                              //> res0: scala.util.Try[chess.Tablero.Tablero] = Success(List(Escaque('blanco,(
                                                  //| 8,a),Trebejo(Torre,'negro,0)), Escaque('negro,(8,b),Trebejo(Caballo,'negro,0
                                                  //| )), Escaque('blanco,(8,c),Trebejo(Alfil,'negro,0)), Escaque('negro,(8,d),Tre
                                                  //| bejo(Rey,'negro,0)), Escaque('blanco,(8,e),Trebejo(Reina,'negro,0)), Escaque
                                                  //| ('negro,(8,f),Trebejo(Alfil,'negro,0)), Escaque('blanco,(8,g),Trebejo(Caball
                                                  //| o,'negro,0)), Escaque('negro,(8,h),Trebejo(Torre,'negro,0)), Escaque('negro,
                                                  //| (7,a),Trebejo(Peon,'negro,0)), Escaque('negro,(7,b),Trebejo(Peon,'negro,0)),
                                                  //|  Escaque('negro,(7,c),Trebejo(Peon,'negro,0)), Escaque('negro,(7,d),Trebejo(
                                                  //| Peon,'negro,0)), Escaque('negro,(7,e),Trebejo(Peon,'negro,0)), Escaque('negr
                                                  //| o,(7,f),Trebejo(Peon,'negro,0)), Escaque('negro,(7,g),Trebejo(Peon,'negro,0)
                                                  //| ), Escaque('negro,(7,h),Trebejo(Peon,'negro,0)), Escaque('blanco,(6,a),Trebe
                                                  //| jo(Nada,'blanco,0)), Escaque('negro,(6,b),Trebejo(Nada,'blanco,0)), Escaque(
                                                  //| 'blanco,(6,c),Trebejo(Na
                                                  //| Output exceeds cutoff limit.
  
  aj.visualizar                                   //> res1: String = "
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