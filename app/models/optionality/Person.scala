package models.optionality

import models.optionality.MOption.{MNone, MSome}

case class Person(name: String)
case class Account(balance: Double, owner: Person)
case class Transfer(source: Account, dest: Account, amount: Double) {

  def findPersonByName(name: String): MOption[Person] = ???
  def findAccountByPerson(person: Person): MOption[Account] = ???
  def findLastTransferBySourceAccount(account: Account): MOption[Transfer] = ???
  def findLastTransferByPersonName(name: String): MOption[Transfer] = findPersonByName(name) match {
    case MSome(person)  =>
      findAccountByPerson(person) match {
        case MSome(acc)   =>findLastTransferBySourceAccount(acc)
        case MNone => MNone
      }
    case MNone  => MNone
  }
}

  /*
  *   2, 3, (1,2,3,4,5,6)
  *
  *  1 :: (2,3,4,5,6), 3 =>   splitAt(2, 3 - 1, (2,3,4,5,6)
  *
  *  (2,3,4,5,6), if 2 == 2   =>   ((2,3,4,5,6), Nil )
  *
  * */
