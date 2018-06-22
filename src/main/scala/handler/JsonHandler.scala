package handler

import java.io.{InputStream, OutputStream}

import com.amazonaws.services.lambda.runtime.Context
import com.typesafe.scalalogging.Logger
import utilities.Json

/**
  * Created by Peerapat A on Jun 22, 2017
  */
trait JsonHandler[A, R <: AnyRef] {

  protected def log: Logger

  def run(body: A)(implicit context: Context): R

  def handle(input: InputStream, output: OutputStream)
            (implicit context: Context): Unit = {
    val start = System.currentTimeMillis()
    try {

      val a = Json.toClass(input)
      val r = a.map { a =>
        Json.toText(run(a))
      } getOrElse {
        "Failed"
      }

      output.write(r.getBytes)
    } finally {
      val end = System.currentTimeMillis()
      println(s"Execution in ${end - start} ms.")
    }
  }

}
