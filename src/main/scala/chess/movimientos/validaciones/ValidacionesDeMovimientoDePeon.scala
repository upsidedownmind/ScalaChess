package chess.movimientos.validaciones

import chess._
import chess.tablero._

class ValidacionesDeMovimientoDePeon(implicit val movimiento: Movimiento, val tablero: Tablero) extends Validacion {

  def peon = tablero.trebejoEn(movimiento.desde).get
  def direccion = if (peon.color == blanco) 1 else -1
  def captura = tablero.trebejoEn(movimiento.hasta).isDefined

  def elPeonNoRetrocede(): ResultadoDeValidacion = {
    if (movimiento.desde.fila + (movimiento.distanciaDeFilas * direccion) != movimiento.hasta.fila)
      error("El peon no puede retroceder")
    else
      ok
  }

  def elPeonCaminaEnLineaRecta(): ResultadoDeValidacion = {
    if (!captura && movimiento.distanciaDeColumas != 0)
      error("El peon camina recto")
    else ok
  }

  def elPeonCaminaDeAUno(): ResultadoDeValidacion = {
    val pasoValido = movimiento.distanciaDeFilas == 1 || (peon.movimientos == 0 && movimiento.distanciaDeFilas == 2)

    if (!captura && !pasoValido)
      error("El peon avanza una posicion (o dos en la primera jugada)")
    else ok
  }

  def elPeonCapturaEnDiagonal(): ResultadoDeValidacion = {
    if (captura && movimiento.distanciaDeColumas != 1 && movimiento.distanciaDeFilas != 1)
      error("El peon avanza una posicion y captura en diagonal")
    else ok
  }
  
  def elPeonNoCapturaSuPropioColor(): ResultadoDeValidacion = {
    if (captura && tablero.trebejoEn(movimiento.hasta).get.color == peon.color)
      error("El peon camina recto")
    else ok
  }

  def ejecutar: ResultadoDeValidacion = {

    List(
      elPeonCaminaDeAUno _,
      elPeonCaminaEnLineaRecta _,
      elPeonCapturaEnDiagonal _,
      elPeonNoRetrocede _,
      elPeonNoCapturaSuPropioColor _)
 
      .foldRight(ok.asInstanceOf[ResultadoDeValidacion])((fnc, sobre) => sobre match {
        case Left(ok) => fnc()
        case Right(err) => error("Peon: " + err)
      })
       
  }

}