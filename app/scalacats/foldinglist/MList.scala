package scalacats.foldinglist


trait MList[+A]
case class MCons[+A](hd: A, tl: MList[A]) extends MList[A]
case object MNil extends MList[Nothing]


object Test {

  def sum(ints: MList[Int]): Int = ints match {
    case MNil => 0
    case MCons(h, t) => h + sum(t)
  }

  def foldLeft[A, B](l: List[A])(z: B)(f: (A, B) => B): B = l match {
    case h :: t => f(h, foldLeft(t)(z)(f))
    case Nil => z
  }
}


case class Person(id: Int)
object Person{


  def apply(x: Int, y: String): (Int, String) = (x, y)
}
























