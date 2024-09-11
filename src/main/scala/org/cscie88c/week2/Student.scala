package org.cscie88c.week2

// complete the definition of the Student case class and companion object
final case class Student()

object Student {
  
  val allStudents: List[Student] = ???

  def studentNamesByCountry(country: String): List[String] = ???

  def studentTotalsByCountry(country: String): Int = ???
  
}