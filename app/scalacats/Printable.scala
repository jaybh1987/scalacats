package scalacats

trait Printable[A] {
  def format(value: A): String
}

