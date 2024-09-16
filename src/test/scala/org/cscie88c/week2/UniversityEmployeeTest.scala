package org.cscie88c.week2

import org.cscie88c.testutils.{StandardTest}

// write unit tests for University employee below
class UniversityEmployeeTest extends StandardTest {
  val first_employee = new UniversityEmployee("Tufan", "tufan@gmail.com")
  val second_employee = new UniversityEmployee("Erdogdu", "erdogdu@gmail.com")
  "UniversityEmployee" when {
    "instantiated" should {
      "have a name property" in {
        first_employee.name should be("Tufan")
        second_employee.name should be("Erdogdu")
      }
      "have an email property" in {

        first_employee.email should be("tufan@gmail.com")
        second_employee.email should be("erdogdu@gmail.com")
      }

    }
  }

}
