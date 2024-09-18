package org.cscie88c.week3
import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers
import org.scalatestplus.scalacheck.ScalaCheckPropertyChecks
import org.scalacheck._

class StudentPropertyTest
    extends AnyFunSuite
       with Matchers
       with ScalaCheckPropertyChecks {

  val studentGen: Gen[Student] = ???

  // complete the student list generator below if attempting bonus problem
  // val studentListGen: Gen[List[Student]] = ???

  test("description contains name and email") {
    // write your property test below
  }
}
