package models.validated

import cats._

sealed trait Validated[+A]

object Validated {
  case class Valid[+A](a: A) extends Validated[A]
  case class Invalid(errors: List[String]) extends Validated[Nothing]

  implicit val applicative: Applicative[Validated] = new Applicative[Validated] {
    override def pure[A](x: A): Validated[A] = Valid(x)

    override def ap[A, B](ff: Validated[A => B])(fa: Validated[A]): Validated[B] = map2(ff, fa)((f, a) => f(a))

    override def map2[A, B, Z](fa: Validated[A], fb: Validated[B])(f: (A, B) => Z): Validated[Z] = (fa, fb) match {
      case (Valid(a), Valid(b))         => Valid(f(a, b))
      case (Invalid(e1), Valid(b))      => Invalid(e1)
      case (Valid(a), Invalid(e2))      => Invalid(e2)
      case (Invalid(e1), Invalid(e2))   => Invalid(e1 ++ e2)
    }
  }
}
