package models

case class FetchedDocument(uri: String, added: String, id: String, title:String, score:Float) {
  def scoreAsInt = {
    val s = (score * 10).toInt
    if (s >= 1) s else 1
  }
}