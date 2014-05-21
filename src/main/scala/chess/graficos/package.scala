package chess

package object graficos { 

  implicit def Ajedres2Visualizador(aj: Ajedrez): Visualizador = new Visualizador(aj.tablero)
  implicit def Tablero2Visualizador(tablero: Tablero): Visualizador = new Visualizador(tablero)

}