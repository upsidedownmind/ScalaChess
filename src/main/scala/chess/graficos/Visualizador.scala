package chess.graficos

import chess._
import TipoDeTrebejo._

abstract class Visualizador {
   def visualizar:String
}


class VisualizadorDeError(val error:Throwable) extends Visualizador {
  override def visualizar:String = {
    error.toString()
  }
}

class VisualizadorDeTablero(val tablero:Tablero) extends Visualizador {
   
    
    override def visualizar:String = {
      
      val top = "\n   a b c d e f g h\n  ╔═══════════════╗\n" 
      val btn = "\n  ╚═══════════════╝\n  a b c d e f g h\n" 
  
      val rows = 
        	tablero.map(_.trebejo).grouped( 8 ) 
        	.map{ _.map( VisualizadorSymbols.toChessChar ) mkString(" ") }                            
      
      val board = rows.zipWithIndex.map( 
          r => {
	      	val index = 8 - r._2
	      	index + " ║" + r._1 + "║ " + index
	      	
	      } ) mkString("\n")                           
                  
       top + board + btn   
      
    }
    
}

//draw symbols
private[graficos] object VisualizadorSymbols {
	
  val white = Map( 
		  'king 	-> "♔", 
		  'queen 	-> "♕",
		  'rook 	-> "♖",
		  'bishop 	-> "♗",
		  'knight 	-> "♘",
		  'pawn 	-> "♙"
		  );
  
  val black = Map( 
		  'king		-> "♚",
		  'queen	-> "♛",
		  'rook		-> "♜",
		  'bishop	-> "♝",
		  'knight	-> "♞",
		  'pawn		-> "♟"
		  );
  
  val make = Map[Color,Map[Symbol,String]](blanco -> white, negro -> black)
  
  def toChessChar(trebejo:Trebejo) = trebejo match {
    case Trebejo(Rey, color, _) 	=> make(color)('king)
    case Trebejo(Reina, color, _) 	=> make(color)('queen)
    case Trebejo(Torre, color, _) 	=> make(color)('rook)
    case Trebejo(Alfil, color, _) 	=> make(color)('bishop)
    case Trebejo(Caballo, color, _) => make(color)('knight)
    case Trebejo(Peon, color, _) 	=> make(color)('pawn)
    case _ => " "
  }
}
  
	/*
	white chess king	♔	U+2654	&#9812;
	white chess queen	♕	U+2655	&#9813;
	white chess rook	♖	U+2656	&#9814;
	white chess bishop	♗	U+2657	&#9815;
	white chess knight	♘	U+2658	&#9816;
	white chess pawn	♙	U+2659	&#9817;
	
	black chess king	♚	U+265A	&#9818;
	black chess queen	♛	U+265B	&#9819;
	black chess rook	♜	U+265C	&#9820;
	black chess bishop	♝	U+265D	&#9821;
	black chess knight	♞	U+265E	&#9822;
	black chess pawn	♟	U+265F	&#9823;
	*/