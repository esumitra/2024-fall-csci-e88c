package org.cscie88c.week5

import java.util.UUID
import scala.util.Random

object Streams {
  val rnd = new Random()
  def uuid: String = UUID.randomUUID.toString.replaceAll("-", "")

  case class Dog(name: String, age: Int, hasCurrentShots: Boolean)

  val mult5: LazyList[Int] = ???

  val randIntStream: LazyList[Int] = ???

  val dogs: LazyList[Dog] = ???

  def healthyDogs(dogs: LazyList[Dog]): LazyList[Dog] = ???

  def averageHealthyAge(allDogs: LazyList[Dog], sampleSize: Int): Double = ???


}
