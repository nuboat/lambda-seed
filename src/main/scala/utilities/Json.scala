package utilities

import java.io.InputStream

import com.fasterxml.jackson.annotation.JsonInclude.Include
import com.fasterxml.jackson.databind.{DeserializationFeature, ObjectMapper}
import com.fasterxml.jackson.module.scala.DefaultScalaModule
import com.fasterxml.jackson.module.scala.experimental.ScalaObjectMapper

import scala.util.Try

/**
  * Created by Peerapat A on Jun 22, 2018
  */
object Json {

  private val mapper = new ObjectMapper with ScalaObjectMapper

  mapper.registerModule(DefaultScalaModule)
  mapper.setSerializationInclusion(Include.NON_NULL)
  mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)

  def toText(obj: AnyRef): String = mapper.writeValueAsString(obj)

  def toClass[T: Manifest](content: InputStream): Option[T] = {
    if (content == null)
      None
    else
      Try(mapper.readValue[T](content)).toOption
  }

}
