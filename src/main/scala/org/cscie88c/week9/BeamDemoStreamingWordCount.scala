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
 * output stream: watch -n1 ls target/streaming-word-count-output
 * run with
 sbt "runMain org.cscie88c.week9.BeamDemoStreamingWordCount \
 --input-file=./target/streaming-word-count-input \
 --num-words=10 \
 --output-dir=./target/streaming-word-count-output"
 */

object BeamDemoStreamingWordCount extends LazyLogging {

  def main(cmdLineArgs: Array[String]): Unit = {
    // 1. Create context
    val (sc: ScioContext, args: Args) = ContextAndArgs(cmdLineArgs)
    implicit val scImplicit: ScioContext = sc

    // 2. Read command line arguments
    val inputFile: String = args("input-file")
    val numWords: Int = args("num-words").toInt
    val outputFile: String = args("output-dir")

    // 3. Run pipeline
    logger.info(s"running top N words program ...")
    runPipeline(inputFile, numWords, outputFile)
    logger.info(s"program complete")

  }

  def runPipeline(inputFile: String, numWords: Int, outputFile: String)(implicit sc: ScioContext): Unit = {
    // 4. Read input data
    val filePattern = s"${inputFile}/*.txt"
    logger.info(s"Reading files with pattern: ${filePattern}")
    val textRead: PTransform[PBegin, PCollection[String]] =
      TextIO
        .read()
        .from(filePattern)
        .watchForNewFiles(Duration.standardMinutes(1), Watch.Growth.afterTimeSinceNewOutput(Duration.standardHours(1)))
    val lines: SCollection[String] = sc.customInput("Read CSV", textRead)

    // 5. Transform and aggregate data
    val result: SCollection[String] = topNWords(numWords, lines)

    // 6. Write results
    result.saveAsTextFile(path = outputFile, numShards = 1)
    val ec = sc.run()
    ec.waitUntilFinish()
  }

  def stopWords(input: SCollection[String]): SCollection[String] =
    input.map(identity)

  def topNWords(numWords: Int, lines: SCollection[String]): SCollection[String] = {
    lines
      .withFixedWindows(Duration.standardMinutes(1L))
      .flatMap(_.split(" "))
      .countByValue             // SCollection[(String, Long)]
      .swap                     // SCollection[(Long, String)]
      .top(numWords)            // SCollection[Iterable[(Long, String)]], iterable of top n
      .map { iter =>
        iter.map {
          case (count, word) => s"($count, $word)"
        }.mkString("\n")
      }
  }
}
