package scalacats.foldinglist


trait MList[+A]
case class MCons[+A](hd: A, tl: MList[A]) extends MList[A]
case object MNil extends MList[Nothing]


object Test {

  def sum(ints: MList[Int]): Int = ints match {
    case MNil => 0
    case MCons(h, t) => h + sum(t)
  }

}