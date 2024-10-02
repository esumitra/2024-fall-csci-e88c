package org.cscie88c.week5

import scala.math

object FunctionUtils {

  case class CustomerTransaction(customerId: String,transactionDate: String,transactionAmount: Double)

  // Problem 1
  def colorToCode(color: String): (Int, Int, Int) = ???

  def fizzBuzzString(n: Int): String = ???

  def fizzBuzz(n: Int): List[String] = ???

  // Problem 2
  def tanDegrees: PartialFunction[Double, Double] = ???

  def totalHighValueTransactions(transactionList: List[CustomerTransaction]): Double = ???

  // Problem 3
  def flip2[A, B, C](f: (A, B) => C): (B, A) => C = ???

  // Write a generic function sampleList parameterized by type A, that returns the first 5 elements of a list of type A.
  
}
