package chess
 
import chess.Constantes._
import scala.collection.immutable.Stream


object GeneradorDePiezas {
	import chess.Constantes.TipoDeTrebejo._	
  
  def formacionInicial:List[Trebejo]  =  formacionNegra ++ { for (i <- 1 to (4*4)) yield nada } ++ formacionNegra 
	
  def formacionPeones(x:Color):List[Trebejo] =  { for (i <- 1 to 8) yield Peon deColor x } toList

  def formacionNegra:List[Trebejo] = {
     List( 
    	 ( Torre deColor negro  ), ( Caballo deColor negro )  , ( Alfil deColor negro ) , 
    	 ( Rey deColor negro  ) , ( Reina deColor negro )  ,
         ( Alfil deColor negro ) , ( Caballo deColor negro ) , ( Torre deColor negro ) 
     )	++ formacionPeones(negro) 
  }
  
  def formacionBlanca:List[Trebejo] = {
	  formacionPeones(blanco) ++ List(
     ( Torre deColor blanco  ) , ( Caballo deColor blanco )  , ( Alfil deColor blanco ) , 
     ( Reina deColor blanco  ) , ( Rey deColor blanco )  ,
     ( Alfil deColor blanco ) , ( Caballo deColor blanco ) , ( Torre deColor blanco )
     )
  }

  val _nada = Nada deColor blanco
  
  def nada = _nada
  
  implicit def TipoDeTrebejo2TrebejoBuilder(tipo: TipoDeTrebejo): TrebejoBuilder = new TrebejoBuilder(tipo)

  class TrebejoBuilder(val tipo: TipoDeTrebejo) {
    def deColor(c: Color) = new Trebejo(tipo, c)
  }

}