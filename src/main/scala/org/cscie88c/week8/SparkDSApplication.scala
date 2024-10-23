package org.cscie88c.week8

import org.apache.spark.sql.SparkSession
import com.typesafe.scalalogging.{LazyLogging}
import org.cscie88c.config.{ConfigUtils}
import org.cscie88c.utils.{SparkUtils}
import org.apache.spark.sql.{Dataset}
import pureconfig.generic.auto._

// write config case class below
case class SparkDSConfig(name: String, masterUrl: String)

// run with: sbt "runMain org.cscie88c.week9.SparkDSApplication"
object SparkDSApplication {

  // application main entry point
  def main(args: Array[String]): Unit = {
    implicit val conf:SparkDSConfig = readConfig()
    val spark = SparkUtils.sparkSession(conf.name, conf.masterUrl)
    val transactionDS = loadData(spark)
    val totalsByCategoryDS = transactionTotalsByCategory(spark,transactionDS)
    printTransactionTotalsByCategory(totalsByCategoryDS)
    spark.stop()
  }

  def readConfig(): SparkDSConfig = ???

  def loadData(spark: SparkSession)(implicit conf: SparkDSConfig): Dataset[CustomerTransaction] = ???

  def transactionTotalsByCategory(spark: SparkSession, transactions: Dataset[CustomerTransaction]): Dataset[(String, Double)] = ???

  def printTransactionTotalsByCategory(ds: Dataset[(String, Double)]): Unit = ???
}
