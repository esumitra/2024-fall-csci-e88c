package org.cscie88c.week2

// write code for class Faculty below
class Faculty(
    name: String,
    email: String,
    courseId: String
) extends UniversityEmployee(name, email) {
  override def description: String =
    s"Name: ${name}, Email: ${email}, CourseId: ${courseId}"

}

object Faculty {
  def apply(name: String, email: String, courseId: String): Faculty =
    new Faculty(name, email, courseId)

}
