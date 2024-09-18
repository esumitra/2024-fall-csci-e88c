package org.cscie88c.week3

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers
import org.scalatestplus.scalacheck.ScalaCheckPropertyChecks
import org.scalacheck._

class UtilFunctionsPropertyTest
    extends AnyFunSuite
       with Matchers
       with ScalaCheckPropertyChecks {

  val triplesGen: Gen[(Int, Int, Int)] = ???

  test("mult2 result test") {
    forAll { (x: Int, y: Int) =>
      UtilFunctions.mult2(x, y) shouldBe x * y
    }
  }

  // write more property tests below
}
