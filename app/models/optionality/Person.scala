package models.optionality

case class Person(name: String)
case class Account(balance: Double, owner: Person)
case class Transfer(source: Account, dest: Account, amount: Double)


  /*
  *   2, 3, (1,2,3,4,5,6)
  *
  *  1 :: (2,3,4,5,6), 3 =>   splitAt(2, 3 - 1, (2,3,4,5,6)
  *
  *  (2,3,4,5,6), if 2 == 2   =>   ((2,3,4,5,6), Nil )
  *
  * */
