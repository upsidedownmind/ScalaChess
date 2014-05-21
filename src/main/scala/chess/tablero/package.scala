package chess

package object tablero {
  
  //dsl
  implicit def Ajedrez2TableroUtils( aj:Ajedrez  ):TableroUtils = new TableroUtils(aj.tablero)
  implicit def Tablero2TableroUtils( tablero:Tablero  ):TableroUtils = new TableroUtils(tablero)
  
}