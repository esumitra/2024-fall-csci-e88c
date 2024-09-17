package org.cscie88c.week2

// write code for class Administrator below
class Administrator(
    name: String,
    email: String,
    budget: Long
) extends UniversityEmployee(name, email) {
  override def description: String =
    s"Name: ${name}, Email: ${email}, Budget: $$${budget}"

}

object Administrator {
  def apply(name: String, email: String, budget: Long): Administrator =
    new Administrator(name, email, budget)

}
