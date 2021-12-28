package scalacats.meetCats

import cats.implicits.catsSyntaxEq
import cats.{Eq, Show}
import cats.instances.long._

import java.util.Date

object CustomInstance {

  implicit val dateShow: Show[Date] = new Show[Date] {
    def show(date: Date): String = s"${date.getTime}ms since the epoch."
  }

  implicit val dateEq: Eq[Date] = Eq.instance[Date] {
    (date1, date2) =>
      date1.getTime === date2.getTime
  }
  /*
  * List(1,2,3).map(Option(_)).filter( i => i == 1)
  * */

}
