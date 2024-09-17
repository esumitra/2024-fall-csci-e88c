package org.cscie88c.week2

// write code for class Administrator below
class Administrator(
    name: String,
    email: String,
    budget: Long
) extends UniversityEmployee(name, email) {
  override def description: String =
    s"Type: Faculty, Name: ${name}, Email: ${email}, Budget: ${budget}"

}
