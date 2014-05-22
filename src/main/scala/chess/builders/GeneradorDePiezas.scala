package chess.builders
 	
import chess._
import TipoDeTrebejo._

// se encarga de crear las piezas y acomodar la posicion inicial del tablero
object GeneradorDePiezas {
   
  def posiciones = for ( r <- (1 to 8).reverse; c <- 'a' to 'h') yield new Posicion(c, r)
  
  def determinarColor(pos:Posicion) = if (pos.columna.toInt % 2 != 0 && pos.fila % 2 == 0) blanco else negro
	  
  // el tablero desde 0
  def tableroInicial:Tablero = { 
	formacionInicial 
		.zip(posiciones) 
		.map( z  => new Escaque( determinarColor(z._2), z._2 , z._1 ) ) toList
   }
  
  def tableroEnBlanco:Tablero = {
    { for (i <- 1 to (8*8)) yield (Ninguno deColor blanco) } 
    	.zip(posiciones) 
    	.map( z  => new Escaque( determinarColor(z._2), z._2 , z._1 ) ) toList
  }
	
  //formaciones iniciales
  def formacionInicial:List[Trebejo]  =  formacionNegra ++ { for (i <- 1 to (4*8)) yield (Ninguno deColor blanco) } ++ formacionBlanca 
	
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
  
  def crear(tipo:TipoDeTrebejo)(implicit color:Color) = tipo deColor color
  

}