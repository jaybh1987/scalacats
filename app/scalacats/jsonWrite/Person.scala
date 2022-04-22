package scalacats.jsonWrite

final case class Person(name: String, email: String)

sealed trait Json
final case class JsObject(get: Map[String, Json]) extends Json
final case class JsString(get: String) extends Json
final case class JsNumber(get: Double) extends Json
case object JsNull extends Json

trait JsonWriter[A] {
  def writer(value: A): Json
}


object JsonWriterInstances {

  implicit val stringWriter: JsonWriter[String] = new JsonWriter[String] {
    override def writer(value: String): Json = JsString(value)
  }

  implicit val personWriter: JsonWriter[Person] = new JsonWriter[Person] {
    override def writer(value: Person): Json = JsObject(
      Map(
        "name" -> JsString(value.name),
        "email" -> JsString(value.email)))
  }
}


object Json {
  def toJson[A](value: A)(implicit w: JsonWriter[A]): Json = w.writer(value)
}

object JsonSyntax {
  implicit class JsonWriterOp[A](value: A) {
    def toJson(implicit w: JsonWriter[A]): Json = w.writer(value)
  }
}

sealed trait Shape
case class Circle(radius: Double) extends Shape

object TestShape {

  val circles: List[Circle] = ???
  val shapes: List[Shape] = ???

  val shapeWriter: JsonWriter[Shape] = ???
  val circleWriter: JsonWriter[Circle] = ???

  def format[A](value: A, writer: JsonWriter[A]): Json = writer.writer(value)
}


/*
*   F[B] < F[A]
* */






















