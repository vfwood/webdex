package models

import scala.collection.mutable.ListBuffer

class Errors(errorMessages:ListBuffer[String] = ListBuffer()) {
	def hasErrors = !errorMessages.isEmpty
	def add(s:String) = errorMessages.append(s)
	def asErrorMessage = errorMessages.mkString("\n")
	
}

object Errors {
  def show(s:Option[String]):List[String] = s match {
    case Some(str) => str.split("\n").toList
    case None => Nil
  }
}