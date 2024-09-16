package org.cscie88c.week2

import org.cscie88c.testutils.{StandardTest}

class UtilFunctionsTest extends StandardTest {

  "UtilFunctions" when {
    "maximum" should {
      "return maximum of two ints when first integer is greater" in {
        UtilFunctions.maximum(2, 1) should be(2)
      }
      // add more unit tests for maximum below
      "return maximum of two ints when second integer is greater" in {
        UtilFunctions.maximum(4, 9) should be(9)
      }
      "return maximum of two ints when both integer is equal" in {
        UtilFunctions.maximum(67, 67) should be(67)
      }

    }
  }

  // add unit tests for average below
  "UtilFunctions" when {
    "average" should {
      "return average of two different integers(a and b; a<b)" in {
        UtilFunctions.average(10, 18) should be(14.0)
      }
      "return average of two different integers(a and b; a>b)" in {
        UtilFunctions.average(20, 15) should be(17.5)
      }
      "return average of two same integers(a and b; a=b)" in {
        UtilFunctions.average(30, 30) should be(30.0)
      }
    }
  }

}
