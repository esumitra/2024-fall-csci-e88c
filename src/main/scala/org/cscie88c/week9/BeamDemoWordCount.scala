package org.cscie88c.week9
import com.spotify.scio._
import com.spotify.scio.values.SCollection
import com.typesafe.scalalogging.{LazyLogging}

/*
 * run with
 sbt "runMain org.cscie88c.week9.BeamDemoWordCount \
 --input-file=./src/main/resources/data/alice-in-wonderland.txt \
 --num-words=10 \
 --output-dir=./target/word-count-output"
 */

object BeamDemoWordCount extends LazyLogging {

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
    val lines: SCollection[String] = sc.textFile(inputFile)

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
