package org.cscie88c.week2

import org.cscie88c.testutils.{StandardTest}

// write unit tests for Faculty below
class FacultyTest extends StandardTest {
  val first_faculty =
    new Faculty("Alex", "alex@gmail.com", "Math101")
  val second_faculty =
    new Faculty("De Souza", "desouza@gmail.com", "History101")
  "FacultyTest" when {
    "instantiated" should {
      "have a name property" in {
        first_faculty.name should be("Alex")
        second_faculty.name should be("De Souza")
      }
      "have an email property" in {
        first_faculty.email should be("alex@gmail.com")
        second_faculty.email should be("desouza@gmail.com")
      }
      "have a courseId property" in {
        first_faculty.courseId should be("Math101")
        second_faculty.courseId should be("History101")
      }
    }
  }
}
