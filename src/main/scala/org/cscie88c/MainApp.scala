/** main entry point for application
  */

package org.cscie88c

import org.cscie88c.config.{ConfigUtils, CookieSettings}
import pureconfig.generic.auto._
import com.typesafe.scalalogging.{LazyLogging}

object MainApp extends LazyLogging {

  val COOKIE_CONFIG_PATH = "org.cscie88c.cookie"

  def hello(name: String)(implicit conf: CookieSettings): String = {
    logger.info(s"running application version with ttl: ${conf.ttl}")
    s"Hello ${name}"
  }

  def main(args: Array[String]): Unit = {
    implicit val cookie =
      ConfigUtils.loadAppConfig[CookieSettings](COOKIE_CONFIG_PATH)

    val name = args.length match {
      case 0 => "Anonymous"
      case _ => args(0)
    }
    val message = hello(name)
    println(message)
  }
}
