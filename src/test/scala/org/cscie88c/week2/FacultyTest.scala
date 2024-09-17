package org.cscie88c.week2

import org.cscie88c.testutils.{StandardTest}

// write unit tests for Faculty below
class FacultyTest extends StandardTest {
  val faculty1 = new Faculty("Ferdi", "ferdi@gmail.com", "Science101")
  val faculty2 =
    new Faculty("De Souza", "desouza@gmail.com", "History101")
  "FacultyTest" when {
    "instantiated" should {
      "have a name property" in {
        faculty1.name should be("Ferdi")
        faculty2.name should be("De Souza")
      }
      "have an email property" in {

        faculty1.email should be("ferdi@gmail.com")
        faculty2.email should be("desouza@gmail.com")

      }
      "have an description property" in {

        faculty1.description should be(
          "Name: Ferdi, Email: ferdi@gmail.com, CourseId: Science101"
        )
        faculty2.description should be(
          "Name: De Souza, Email: desouza@gmail.com, CourseId: History101"
        )

      }

    }
  }

}
