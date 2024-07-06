package org.cscie88c.prereq

import org.cscie88c.testutils.{StandardTest}

class PrerequisiteTest extends StandardTest {

 "Prerequisite functions" when {
   val testData: List[CustomerTransaction] = List(
    "CS6043,15-Jan-14,98",
    "CS4147,08-Jul-13,121",
    "CS4655,30-Mar-13,93",
    "CS3904,20-Jul-14,103",
    "CS4102,09-Jul-13,96",
    "CS2086,05-Mar-13,75"
   ).map(CustomerTransaction(_))

  "executed" should {
    "filter transactions greater than $100" in {
      val expectedResult = List("CS4147,08-Jul-13,121","CS3904,20-Jul-14,103").map(CustomerTransaction(_))
      Prerequisite.getFilteredTransactions(testData) shouldBe(expectedResult)
    }

    "calculate average transaction amount by month and year" in {
      Prerequisite.getAverageTransactionAmountByMonthAndYear(testData) should contain (("Jan","14") -> 98.0)
      Prerequisite.getAverageTransactionAmountByMonthAndYear(testData) should contain (("Mar","13") -> (93.0 + 75.0) / 2)
    }
  }
 }
}
