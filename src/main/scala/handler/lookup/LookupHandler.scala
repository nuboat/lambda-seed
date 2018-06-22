package handler.lookup

import com.amazonaws.services.lambda.runtime.Context
import com.typesafe.scalalogging.{LazyLogging, Logger}
import handler.JsonHandler

/**
  * Created by Peerapat A on Jun 22, 2017
  */
class LookupHandler extends JsonHandler[Form, Result]
  with LazyLogging {

  def log: Logger = logger

  override def run(body: Form)
                  (implicit context: Context): Result = {
    val urls = Seq("URL1", "URL2", "URL3")
    val list = urls.par
      .flatMap(callHTTP)
      .map(func)

    Result(s"${list.sum}")
  }

  private[lookup] def callHTTP(url: String): Option[Int] = try {
    Some(1)
  } catch {
    case _ => None
  }

  private[lookup] def func(i: Int) = i

}
