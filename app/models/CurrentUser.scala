package models

import scala.util.Random
import java.util.UUID
import play.api.db.DB
import scala.collection.mutable.ListBuffer
import views.html.users

object CurrentUser {

  /** @return the roles for the given username.*/
  def getRoles(username: String): List[String] = {
    val roles = ListBuffer[String]()
    import play.api.Play.current
    DB.withConnection { conn =>
      val stm = conn.prepareStatement("select rolename from roles where username = ?")
      stm.setString(1, username)
      val results = stm.executeQuery()
      while (results.next) {
        val rolename = results.getString(1)
        roles.append(rolename)
      }
    }
    roles.toList
  }

  def getUsers() = {
    val users = scala.collection.mutable.ListBuffer[User]()
    import play.api.Play.current
    DB.withConnection { conn =>
      val stm = conn.createStatement
      val results = stm.executeQuery("select * from users")
      while (results.next) {
        val username = results.getString(1)
        val password = results.getString(2)
        val loginId = results.getString(3)
        users.append(User(username, password, loginId, getRoles(username)))
      }
    }
    users
  }
  
  def insertUser(user:User) = {
    import play.api.Play.current
    DB.withConnection { conn =>
      val stm = conn.prepareStatement("insert into users (username, password, loginId) values(?,?,?)")
      stm.setString(1, user.name)
      stm.setString(2, user.password)
      stm.setString(3, user.loginId)
      stm.execute()
    }
  }
  
  def updateUser(user:User) = {
    import play.api.Play.current
    DB.withConnection { conn =>
      val stm = conn.prepareStatement("update users set password=?, loginId=? where username=?")
      stm.setString(1, user.password)
      stm.setString(2, user.loginId)
      stm.setString(3, user.name)
      stm.execute()
    }
  }

  // Does user exist?
  def getUser(name: String, password: String): Option[User] = {
    val u = getUsers()
    val found = getUsers().filter(u => u.name == name && u.password == password)
    println("Getting user = " + found)
    if (found.size == 1) Some(found(0)) else None
  }

  def generateLoginId = UUID.randomUUID()

  // find if set and if so return it.
  def from(request: play.api.mvc.Request[Any]): Option[User] = request.session.get("username") match {
    case None => None
    case Some(s) => getUsers().find(_.name == s)
  }
}

case class User(name: String, password: String, var loginId: String, roles: List[String] = List())