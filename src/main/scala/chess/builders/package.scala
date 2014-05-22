package chess

import TipoDeTrebejo._

package object builders {

  //dsl
  implicit def TipoDeTrebejo2TrebejoBuilder(tipo: TipoDeTrebejo): TrebejoBuilder = new TrebejoBuilder(tipo)
 
}