package org.cscie88c.week8

import com.typesafe.scalalogging.LazyLogging
import scala.util.{Try, Success, Failure}
import scala.io.Source

// run using: sbt "runMain org.cscie88c.week8.SimpleApp1 <args>"
object SimpleApp1 extends LazyLogging {
  
  def lineStreamFromFile(fileName: String): Option[LazyList[String]] =
    Try {
      LazyList.from(Source.fromResource(fileName).getLines())
    }.toOption
  
  def monthLines(month: String)(lines: LazyList[String]): LazyList[String] = ???
      
  def main(args: Array[String]): Unit = ???

}
