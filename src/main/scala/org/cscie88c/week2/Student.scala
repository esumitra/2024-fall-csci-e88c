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
  val allStudents: List[Student] = List(
    Student("1,Emmy,Conrart,econrart0@gizmodo.com,Male,China"),
    Student("2,Marin,Blasoni,mblasoni1@edublogs.org,Female,United States"),
    Student("3,Jesse,Chismon,jchismon2@hostgator.com,Male,China"),
    Student("4,Delmore,Scriver,dscriver3@boston.com,Male,United States"),
    Student("5,Jocelyn,Blaxlande,jblaxlande4@europa.eu,Female,China")
  )

  def studentNamesByCountry(country: String): List[String] = {
    allStudents
      .filter(_.country.equals(country))
      .map(values => s"${values.firstName} ${values.lastName}")

    // .map(values())
    // transactions.filter(_.transactionAmount > 100)
    //// val total = transactions.map(_.transactionAmount).sum
    //// total / transactions.length
  }

  def studentTotalsByCountry(country: String): Int = {
    allStudents.count(_.country.equals(country))

  }

}
