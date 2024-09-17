package org.cscie88c.week2

// complete the definition of the Subject case class and companion object
final case class Subject(
    id: Int,
    name: String,
    isSTEM: Boolean
)

object Subject {
  def apply(tufanCSV: String): Subject = {
    val subjectvalues = tufanCSV.split(",")
    Subject(
      id = subjectvalues(0).toInt,
      name = subjectvalues(1),
      isSTEM = subjectvalues(2).toBoolean
    )

  }
  val allSubjects: List[Subject] = List(
    Subject("1,Physics,true"),
    Subject("2,Chemistry,true"),
    Subject("3,Math,true"),
    Subject("4,English,false")
  )

  def stemSubjects: List[Subject] = {
    allSubjects.filter(_.isSTEM)

  }

}
