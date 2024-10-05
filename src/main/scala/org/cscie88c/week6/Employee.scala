package org.cscie88c.week6

final case class Employee(name: String, age: Int, salary: Int)

object Employee {

  implicit val employeeOrdering: Ordering[Employee] = ???

  def defaultSortEmployees(employees: List[Employee]): List[Employee] = ???

  def sortEmployeesBySalary(employees: List[Employee]): List[Employee] = ???
  
}
