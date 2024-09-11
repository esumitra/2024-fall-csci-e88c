package org.cscie88c.week2

import org.cscie88c.testutils.{StandardTest}

class UtilFunctionsTest extends StandardTest {
  
  "UtilFunctions" when {
    "maximum" should {
      "return maximum of two ints when first integer is greater" in {
        UtilFunctions.maximum(2, 1) should be (2)
      }
      // add more unit tests for maximum below
    }

    // add unit tests for average below
    
  }
}
