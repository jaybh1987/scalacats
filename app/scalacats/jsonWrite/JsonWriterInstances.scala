package scalacats.jsonWrite

object JsonWriterInstances {

  implicit val stringWriter: JsonWriter[String] = new JsonWriter[String] {
    override def write(value: String): Json = JsString(value)
  }

  val k  = JsObject(
    Map(
      "name" ->   JsString("value.name"),
      "email" ->  JsString("value.email")
    )
  )


  implicit val personWriter: JsonWriter[Person] = new JsonWriter[Person] {
    override def write(value: Person): Json = JsObject(Map(
      "name" ->   JsString(value.name),
      "email" ->  JsString(value.email)))
  }

  object Json {
    def toJson[A](value: A)(implicit w: JsonWriter[A]): Json = w.write(value)
  }

  object JsonSyntax {
    implicit class JsonWriterOps[A](value: A) {
      def toJson(implicit w: JsonWriter[A]): Json = w.write(value)
    }
  }
}
