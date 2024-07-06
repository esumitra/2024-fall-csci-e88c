package org.cscie88c.prereq

final case class CustomerTransaction(
    customerId: String,
    transactionDate: String,
    transactionAmount: Double
)

object CustomerTransaction {
  def apply(csvRow: String): CustomerTransaction = {
    val fields = csvRow.split(",")
    CustomerTransaction(
      customerId = fields(0),
      transactionDate = fields(1),
      transactionAmount = fields(2).toDouble
    )
  }
}
