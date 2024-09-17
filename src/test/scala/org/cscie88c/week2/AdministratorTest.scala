package org.cscie88c.week2

import org.cscie88c.testutils.{StandardTest}

// write unit tests for Administrator below
class AdministratorTest extends StandardTest {
  val admin1 = new Administrator("Hatice", "hatice@gmail.com", 15000)
  "AdministratorTest" when {
    "instantiated" should {
      "have a name property" in {
        admin1.name should be("Hatice")

      }
      "have an email property" in {

        admin1.email should be("hatice@gmail.com")

      }
      "have an description property" in {

        admin1.description should be(
          "Name: Hatice, Email: hatice@gmail.com, Budget: $15000"
        )

      }

    }
  }
}
