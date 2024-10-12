package org.cscie88c.week7

import scala.concurrent.{Future}
import scala.util.{Try, Success, Failure}
import scala.concurrent.ExecutionContext.Implicits.global
import scala.util.Random
import scala.collection.parallel.CollectionConverters._

object FutureUtils {
  
  val rnd = new Random()

  def creditScoreAPI(applicantId: Int): Future[Int] = ???

  def printCreditScore(applicantId: Int): Unit = ???

  def passedCreditCheck(applicantId: Int): Future[Boolean] = ???

  def futureFactorial(n: Int): Future[Int] = ???

  def futurePermuations(n: Int, r: Int): Future[Int] = ???

  def asyncAverageCreditScore(idList: List[Int]): Future[Double] = ???

  def slowMultiplication(x: Long, y: Long): Long = ???

  def concurrentFactorial(n: Long): Long = ???

  def sequentialFactorial(n: Long): Long = ???

}
