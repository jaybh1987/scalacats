package models.optionality

import cats.Monad


sealed trait MOption[+A]

object MOption {

  case class MSome[+A](a: A) extends MOption[A]
  case object MNone extends MOption[Nothing]


  implicit val monadMOption: Monad[MOption] = new Monad[MOption] {
    override def flatMap[A, B](fa: MOption[A])(f: A => MOption[B]): MOption[B] = ???

    override def tailRecM[A, B](a: A)(f: A => MOption[Either[A, B]]): MOption[B] = ???

    override def pure[A](x: A): MOption[A] = ???
  }


  val listMonad: Monad[List] = new Monad[List] {
    override def flatMap[A, B](fa: List[A])(f: A => List[B]): List[B] = fa match {
      case h :: tail => f(h) ::: flatMap(tail)(f)
      case Nil => Nil
    }

    override def tailRecM[A, B](a: A)(f: A => List[Either[A, B]]): List[B] = ???

    override def pure[A](x: A): List[A] = ???
  }
}




