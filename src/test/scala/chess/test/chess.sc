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

  val aj = new Ajedrez                            //> aj  : chess.Ajedrez = chess.Ajedrez@79a55f23
   
  aj. mover( "a2a3" ) .visualizar                 //> res0: String = java.lang.Exception: Peon: (Movimiento(Posicion(a,2),Posicion
                                                  //| (a,3)),List(Escaque('blanco,Posicion(a,8),Trebejo(Torre,'negro,0)), Escaque(
                                                  //| 'negro,Posicion(b,8),Trebejo(Caballo,'negro,0)), Escaque('blanco,Posicion(c,
                                                  //| 8),Trebejo(Alfil,'negro,0)), Escaque('negro,Posicion(d,8),Trebejo(Rey,'negro
                                                  //| ,0)), Escaque('blanco,Posicion(e,8),Trebejo(Reina,'negro,0)), Escaque('negro
                                                  //| ,Posicion(f,8),Trebejo(Alfil,'negro,0)), Escaque('blanco,Posicion(g,8),Trebe
                                                  //| jo(Caballo,'negro,0)), Escaque('negro,Posicion(h,8),Trebejo(Torre,'negro,0))
                                                  //| , Escaque('negro,Posicion(a,7),Trebejo(Peon,'negro,0)), Escaque('negro,Posic
                                                  //| ion(b,7),Trebejo(Peon,'negro,0)), Escaque('negro,Posicion(c,7),Trebejo(Peon,
                                                  //| 'negro,0)), Escaque('negro,Posicion(d,7),Trebejo(Peon,'negro,0)), Escaque('n
                                                  //| egro,Posicion(e,7),Trebejo(Peon,'negro,0)), Escaque('negro,Posicion(f,7),Tre
                                                  //| bejo(Peon,'negro,0)), Escaque('negro,Posicion(g,7),Trebejo(Peon,'negro,0)), 
                                                  //| Escaque('negro,Posicion(
                                                  //| Output exceeds cutoff limit.
  
  //GeneradorDePiezas.tableroInicial
  
  //aj.tablero
       
   
}