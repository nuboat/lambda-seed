package handler.lookup

import mocks.UnitContext
import org.scalatest.FunSuite

class LookupHandlerTest extends FunSuite {

  private lazy val handler = new LookupHandler()

  private implicit val context = UnitContext()

  test("1") {
    val expect = Result("end")
    val result = handler.run(Form("Yo!!"))

    assert(result === expect)
    println(result)
  }

  test("func") {
    val expect = 4
    val result = handler.func(4)

    assert(result === expect)
    println(result)
  }
}
