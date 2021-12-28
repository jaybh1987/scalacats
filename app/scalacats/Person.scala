package scalacats

import scalacats.jsonWrite.{JsObject, JsString, Json, JsonWriter}

final case class Person(name: String, email: String)

object JsonWriterInstances {
  implicit val stringWriter: JsonWriter[String] = new JsonWriter[String] {
    override def write(value: String): Json = JsString(value)
  }

  implicit val personWriter: JsonWriter[Person] = new JsonWriter[Person] {
    override def write(value: Person): Json = JsObject(
      Map(
        "name" -> JsString(value.name),
        "email" -> JsString(value.email)
      )
    )
  }

  object Json {
    def toJson[A](value: A)(implicit w: JsonWriter[A]): Json = w.write(value)
  }
}