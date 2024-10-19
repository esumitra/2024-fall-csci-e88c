package org.cscie88c.week8

import org.apache.spark.sql.SparkSession
import com.typesafe.scalalogging.{LazyLogging}
import org.cscie88c.config.{ConfigUtils}
import org.cscie88c.utils.{SparkUtils}
import org.apache.spark.sql.{Dataset, DataFrame, Row}
import pureconfig.generic.auto._
import org.apache.spark.sql.functions.{when}

// run with: sbt "runMain org.cscie88c.week9.SparkSQLApplication"
object SparkSQLApplication {

  def main(args: Array[String]): Unit = {
    implicit val conf:SparkDSConfig = readConfig()
    val spark = SparkUtils.sparkSession(conf.name, conf.masterUrl)
    val transactionDF = loadData(spark)
    val augmentedTransactionsDF = addCategoryColumn(transactionDF)
    augmentedTransactionsDF.createOrReplaceTempView("transactions")
    val sparkSQL = ???
    val totalsByCategoryDF = spark.sql(sparkSQL)
    printTransactionTotalsByCategory(totalsByCategoryDF)
    spark.stop()
  }

  def readConfig(): SparkDSConfig = ???

  def loadData(spark: SparkSession)(implicit conf: SparkDSConfig): DataFrame = ???

  def addCategoryColumn(raw: DataFrame): DataFrame = ???

  def printTransactionTotalsByCategory(df: DataFrame): Unit = ???

}
