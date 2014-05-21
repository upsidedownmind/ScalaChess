package object chess {

  //usefull alias
  type Tablero = List[Escaque]
  type Color = Symbol

  //contantes

  val blanco: Color = 'blanco
  val negro: Color = 'negro

  //objetos "null" o de valor incorrecto
  lazy val posicionInvalida: Posicion = new Posicion('0', -1)
  lazy val movimientoInvalido: Movimiento = new Movimiento(posicionInvalida, posicionInvalida)

  import scala.util.Failure

  /* DSL constants and helpers */
  implicit def string2Failure(msg: String) = new Failure(new Exception(msg))
}