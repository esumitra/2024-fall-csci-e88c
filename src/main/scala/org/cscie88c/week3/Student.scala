package org.cscie88c.week3

final case class Student(
    name: String,
    email: String,
    subject: String,
    score: Int
  ) {
  def description: String =
    s"name: ${name}, email: ${email}, subject: ${subject}, score: ${score}"
}

object Student {

  def validateEmail(student: Student): Boolean = ???

  def averageScoreBySubject(
      subject: String,
      studentList: List[Student]
    ): Double = ???

  def averageScoreByStudent(
      student: Student,
      studentList: List[Student]
    ): Double = ???
}
