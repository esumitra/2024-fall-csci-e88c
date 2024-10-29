package org.cscie88c.week9

import com.spotify.scio._
import com.spotify.scio.values.SCollection
import com.typesafe.scalalogging.{LazyLogging}
import org.joda.time.{DateTimeZone, Duration, Instant}
import java.time.ZoneId
import java.time.ZoneOffset
import org.apache.beam.sdk.transforms.windowing.IntervalWindow
import org.apache.beam.sdk.options.StreamingOptions
import org.apache.beam.sdk.transforms.PTransform
import org.apache.beam.sdk.values.{PBegin, PCollection}
import org.apache.beam.sdk.io.TextIO
import org.apache.beam.sdk.transforms.Watch

/*
 * input stream: docker/beam/apps/data-streamer.sh after modifying input and output locations
 * output stream: watch -n1 ls <output folder>
 * run with
 sbt "runMain org.cscie88c.week9.BeamSimpleStreamApplication \
 --input-folder=
 --output-folder="
 */

object BeamSimpleStreamApplication extends LazyLogging {

  def main(cmdLineArgs: Array[String]): Unit = {
    // 1. Create context

    // 2. Read command line arguments

    // 3. Run pipeline
    // uncomment line below to run beam pipeline
    // runPipeline(inputPath, outputPath)

  }

  def runPipeline(inputPath: String, outputPath: String)(implicit sc: ScioContext): Unit = {
    // 4. Read input data
    val lines: SCollection[String] = readTransactions(inputPath)

    // 5. Transform and aggregate data
    val result: SCollection[Double] = calculateWindowAggregate(lines)

    // 6. Write results
    writeAggregateToFile(outputPath, result)
    val ec = sc.run()
    ec.waitUntilFinish()
  }

  def readTransactions(inputFile: String): SCollection[String] = ???

  def calculateWindowAggregate(lines: SCollection[String]): SCollection[Double] = ???

  def writeAggregateToFile(outputPath: String, results: SCollection[Double]): Unit = ???
}
