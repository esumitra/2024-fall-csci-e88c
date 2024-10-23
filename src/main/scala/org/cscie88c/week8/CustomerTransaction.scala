package org.cscie88c.week8

import scala.util.{Try}

final case class RawTransaction(
  customer_id: String,
  trans_date: String,
  tran_amount: Double
)

final case class CustomerTransaction(
  customerId: String,
  transactionDate: String,
  transactionAmount: Double
) {
  def transactionYear: String = {
    transactionDate.split("-")(2)
  }
  def transactionCategory: String = {
    if (transactionAmount > 80) "High"
    else "Standard"
  }
}

object CustomerTransaction {
  def apply(csvRow: String): Option[CustomerTransaction] = Try {
    val fields = csvRow.split(",")
    CustomerTransaction(
      customerId = fields(0),
      transactionDate = fields(1),
      transactionAmount = fields(2).toDouble
    )
  }.toOption

  def apply(raw: RawTransaction): CustomerTransaction =
    CustomerTransaction(
      customerId = raw.customer_id,
      transactionDate = raw.trans_date,
      transactionAmount = raw.tran_amount)
}