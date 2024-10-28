package org.cscie88c.week9

import java.time.LocalDateTime
import scala.util.{Try}
import java.time.format.DateTimeFormatter
final case class TaxiTripData(
  VendorID:String,
  lpep_pickup_datetime:LocalDateTime,
  lpep_dropoff_datetime:LocalDateTime,
  store_and_fwd_flag:String,
  RatecodeID:Integer,
  PULocationID:Integer,
  DOLocationID:Integer,
  passenger_count:Integer,
  trip_distance:Double,
  fare_amount:Double,
  extra:Double,
  mta_tax:Double,
  tip_amount:Double,
  tolls_amount:Double,
  // ehail_fee:Double,
  improvement_surcharge:Double,
  total_amount:Double,
  payment_type:Integer,
  trip_type:Integer,
  congestion_surcharge:Double
)

object TaxiTripData {
  def apply(csvRow: String): Option[TaxiTripData] = {
     Try {
      val fields = csvRow.split(",").map(_.trim)
      val dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")

      TaxiTripData(
        VendorID = fields(0),
        lpep_pickup_datetime = LocalDateTime.parse(fields(1), dateTimeFormatter),
        lpep_dropoff_datetime = LocalDateTime.parse(fields(2), dateTimeFormatter),
        store_and_fwd_flag = fields(3),
        RatecodeID = fields(4).toInt,
        PULocationID = fields(5).toInt,
        DOLocationID = fields(6).toInt,
        passenger_count = fields(7).toInt,
        trip_distance = fields(8).toDouble,
        fare_amount = fields(9).toDouble,
        extra = fields(10).toDouble,
        mta_tax = fields(11).toDouble,
        tip_amount = fields(12).toDouble,
        tolls_amount = fields(13).toDouble,
        // ehail_fee = fields(14).toDouble,
        improvement_surcharge = fields(15).toDouble,
        total_amount = fields(16).toDouble,
        payment_type = fields(17).toInt,
        trip_type = fields(18).toInt,
        congestion_surcharge = fields(19).toDouble
      )
    }.toOption
  }
}