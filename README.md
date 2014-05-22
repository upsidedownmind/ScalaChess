ScalaChess
==========

Simple Scala Chess Game


Example
-------
En SBT:

	import chess._
	import chess.Constantes._
	import chess.Constantes.TipoDeTrebejo._
	import chess.Movimientos._
	import chess.Graficos._
	import chess.Tablero._
	
	val aj = new Ajedrez 
	
	aj mover( "a2a3" )
	
	aj.visualizar
	
	//    a b c d e f g h
	//   ╔═══════════════╗
	// 8 ║♜ ♞ ♝ ♚ ♛ ♝ ♞ ♜║ 8
	// 7 ║♟ ♟ ♟ ♟ ♟ ♟ ♟ ♟║ 7
	// 6 ║               ║ 6
	// 5 ║               ║ 5
	// 4 ║               ║ 4
	// 3 ║♙              ║ 3
	// 2 ║  ♙ ♙ ♙ ♙ ♙ ♙ ♙║ 2
	// 1 ║♖ ♘ ♗ ♕ ♔ ♗ ♘ ♖║ 1
	//   ╚═══════════════╝
	//   a b c d e f g h 

To Do
-----

* a lot...

Copyright
---------

Copyright (c) 2014. See LICENSE for details.
