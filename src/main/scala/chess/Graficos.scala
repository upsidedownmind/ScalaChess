package chess
import chess.Constantes._

object Graficos {
  
  class Visualizador(val aj:Ajedrez) {
  
    import TipoDeTrebejo._
    
    def visualizar = {
      
      val top = "\n   a b c d e f g h\n  ╔═══════════════╗\n" 
      val btn = "\n  ╚═══════════════╝\n  a b c d e f g h\n" 
  
      val columnas = aj.tablero.map(_.trebejo).grouped( 8 ) .map( _.map{
        case Trebejo(Rey, color, _) => Symbols.all(color)('king)
        case Trebejo(Reina, color, _) => Symbols.all(color)('queen)
        case Trebejo(Torre, color, _) => Symbols.all(color)('rook)
        case Trebejo(Alfil, color, _) => Symbols.all(color)('bishop)
        case Trebejo(Caballo, color, _) => Symbols.all(color)('knight)
        case Trebejo(Peon, color, _) => Symbols.all(color)('pawn)
        case _ => " "
      } mkString(" ") )                            
      
      val board = columnas.zipWithIndex.map( r => {
      	val index = 8 - r._2
      	index + " ║" + r._1 + "║ " + index
      } ) mkString("\n")                           
                  
       top + board + btn   
      
    }
    
  }
  
  implicit def ajedres2Visualizador(aj:Ajedrez):Visualizador = new Visualizador( aj )
  
}

//draw symbols
object Symbols {
	
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
  
  val all = Map[Color,Map[Symbol,String]](blanco -> white, negro -> black)
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
}