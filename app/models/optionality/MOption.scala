package models.optionality


sealed trait MOption[+A]
case class MSome[+A](a: A) extends MOption[A]
case object MNone extends MOption[Nothing]

//sealed MOption {
//
//}
