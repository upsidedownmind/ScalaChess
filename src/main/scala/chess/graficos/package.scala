package chess

import scala.util.Try

package object graficos { 

  implicit def Ajedres2Visualizador(aj: Ajedrez): Visualizador = new VisualizadorDeTablero(aj.tablero)
  
  implicit def Tablero2Visualizador(tablero: Tablero): Visualizador = new VisualizadorDeTablero(tablero)
  
  implicit def IntentoDeMov2Visualizador( movResult:Try[Tablero] ): Visualizador = {
   
    if (movResult.isSuccess) 
      new VisualizadorDeTablero(movResult.get)
    else
      new VisualizadorDeError(movResult.failed.get)
  }

}