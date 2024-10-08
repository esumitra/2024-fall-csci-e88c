package org.cscie88c.week6

// Write a generic trait AddableTypeclass parameterized by type A 
trait AddableTypeclass[A] {
  // add trait methods below
}

object AddableTypeclass {
  
  implicit val intAddableTypeclass: AddableTypeclass[Int] = ???

  implicit val boolAddableTypeclass: AddableTypeclass[Boolean] = ???

}

object AddableAggregator {
  def sumWithAddable[A](list: List[A])(implicit addable: AddableTypeclass[A]): A = ???
}
