package org.cscie88c.week2

// complete the definition of the Student case class and companion object
final case class Student(
    id: Int,
    firstName: String,
    lastName: String,
    email: String,
    gender: String,
    country: String
)

object Student {
  def apply(csvTufan: String): Student = {
    val values = csvTufan.split(",")
    Student(
      id = values(0).toInt,
      firstName = values(1),
      lastName = values(2),
      email = values(3),
      gender = values(4),
      country = values(5)
    )

  }
  val allStudents: List[Student] = ???

  def studentNamesByCountry(country: String): List[String] = ???

  def studentTotalsByCountry(country: String): Int = ???

}
