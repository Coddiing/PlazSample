package controllers

import java.sql.Timestamp
import java.time.Instant

import javax.inject.{Inject, Singleton}
import models._
import org.mindrot.jbcrypt.BCrypt
import org.slf4j.LoggerFactory
import play.api.Configuration
import play.api.data.Forms._
import play.api.data._
import play.api.db.slick.{DatabaseConfigProvider, HasDatabaseConfigProvider}
import play.api.libs.mailer._
import play.api.mvc._
import play.filters.csrf.CSRF.Token
import play.filters.csrf._
import slick.jdbc.JdbcProfile
import slick.jdbc.PostgresProfile.api._

import scala.concurrent.duration._
import scala.concurrent.{Await, ExecutionContext}
import scala.util.Random
import scala.util.control.Breaks._
case class StudentData(username: String, email: String)




@Singleton
class UsersController @Inject()(protected val dbConfigProvider: DatabaseConfigProvider, cc: MessagesControllerComponents,
                                mailerClient: MailerClient, config: Configuration,
                                addToken: CSRFAddToken, checkToken: CSRFCheck)(implicit ex: ExecutionContext)
  extends MessagesAbstractController(cc)
    with HasDatabaseConfigProvider[JdbcProfile] {

  //val database = Database.forConfig("slick.dbs.default")

  val timeout: Duration = Duration.fromNanos(config.getOptional[Double]("database_timeout").getOrElse(60.0) * 1E9)

  private val logger = LoggerFactory.getLogger(classOf[UsersController])


  val userForm = Form(
    mapping(
      "username" -> text,
      "email" -> text
    )(StudentData.apply)(StudentData.unapply)
  )

  /** For the CSRF check. Make sure the token is there. */
  def getToken =
    addToken(Action { implicit request =>
      val Token(name, value) = CSRF.getToken.get
      Ok(s"$name=$value")
    })

  /**
   * Takes you to the bewListeServlet
   *
   * @return
   */
  def bewListeServlet = Action { implicit request =>
    var docUserName = checkForLongUserNames(request.session.get("username")
      .lastOption.getOrElse(""))
    var lastLoggedIn = request.session.get("lastSeen").lastOption.getOrElse("not seen yet.")

    Ok(views.html.bew_liste_servlet(docUserName, lastLoggedIn))

  }


  /**
   * Takes you to the student info page
   *
   * @return
   */
  def detailedStudentInformation = Action { implicit request =>
    var docUserName = checkForLongUserNames(request.session.get("username")
      .lastOption.getOrElse(""))
    var lastLoggedIn = request.session.get("lastSeen").lastOption.getOrElse("not seen yet.")

    Ok(views.html.detailed_student_information(docUserName, lastLoggedIn))
    // Ok( views.html.project_index( ) )
  }

  /**
   * Takes us to document upload page
   *
   * @return
   */
  def documentsUpload = Action { implicit request =>
    var docUserName = checkForLongUserNames(request.session.get("username")
      .lastOption.getOrElse(""))
    var lastLoggedIn = request.session.get("lastSeen").lastOption.getOrElse("not seen yet.")
    Ok(views.html.documents_uplaod(docUserName, lastLoggedIn))
  }

  /**
   * For new students
   *
   * @return
   */
  def appNewStudent = Action { implicit request =>
    Ok(views.html.app_new_student(request.session.get("username").lastOption.getOrElse(""),
      request.session.get("lastSeen").lastOption.getOrElse("not seen yet.")))
  }

  /**
   * Goes to the secretary page on click
   */
  def secretary = Action { implicit request =>
    val userName = checkForLongUserNames(request.session.get("username").lastOption.getOrElse(""))
    var lastLoggedIn = request.session.get("lastSeen").lastOption.getOrElse("not seen yet.")

    var vList: List[StudentsData] = new ProcessStudentData(dbConfigProvider, cc,
    mailerClient, config,
    addToken, checkToken).processData


    Ok(views.html.secretary(  new BewerbeListe(),
      vList,
      userName,
      lastLoggedIn
    ))

}
  var userJoin = (_: String) + (_: String) // Help to check for long user names
  /**
   * Helper to make sure user name is not too long
   *
   * @param user -> user name passed
   * @return
   */
  def checkForLongUserNames(user: String): String = {
    var userName = user
    if (userName.length >= 20) // Checks for long user names
      userName = userJoin(userName.substring(0, 20), " ...")

    userName
  }









  /**
   *  ##############   Default methods. Came with the package ############
   * @return
   */
  def signup: Action[AnyContent] = Action { implicit request =>
    Ok(views.html.signup(userForm))
    //Ok(views.html.signup())
  }

  def login: Action[AnyContent] = Action { implicit request =>
    // Check the database connection.
    Ok(views.html.login())
  }

  def index: Authenticated[AnyContent] = Authenticated {
    Action { implicit request =>
     // Ok(views.html.index(request.session.get("username").lastOption.getOrElse(""),
       // request.session.get("lastSeen").lastOption.getOrElse("not seen yet.")))
    Ok(views.html.lead_page(request.session.get("username").lastOption.getOrElse(""),
        request.session.get("lastSeen").lastOption.getOrElse("not seen yet.")))
    }
  }

  def newPage: Authenticated[AnyContent] = Authenticated {
    Action { implicit request =>
      Ok(views.html.newPage(request.session.get("username").lastOption.getOrElse("")))
    }
  }


  def logout: Action[AnyContent] = Action { implicit request =>
    Redirect(routes.UsersController.login()).withNewSession
  }

  def validateLogin: Action[AnyContent] = Action { implicit request =>
    val postVals = request.body.asFormUrlEncoded
    postVals.map { args =>
      val username = args("username").head
      val password = args("password").head

      if (validateUser(username, password)) {
        val lastlogin = accessTime(username)
        logger.trace(s"user $username logged in.")
        Redirect(routes.UsersController.index())
          .withSession("username" -> username, "lastSeen" -> lastlogin)
      } else {
        logger.trace(s"login failed: $username, $password")
        Redirect(routes.UsersController.login())
          .flashing("error" -> "Username and Password do not match!")

      }
    }.getOrElse(Redirect(routes.UsersController.login()))
  }

  def createUser: Action[AnyContent] = Action { implicit request =>
    userForm.bindFromRequest.fold(
      formWithErrors => {
        // binding failure, you retrieve the form containing errors:
        //BadRequest(views.html.signup(formWithErrors))
        Ok("Bad req")
      },
      userData => {
        val username = userData.username
        val getEmail = userData.email
        logger.trace("Username is: " + username)
        logger.trace("EMail is: " + getEmail)
        val password = Random.alphanumeric.take(12).mkString("")
        if (username.length > 5) {
          logger.trace(s"Starting to create user $username, $password, $getEmail")
          if (createUser(username, password, getEmail)) {
            logger.trace("...Stored in DB")
            val email = Email(
              "Your new password for HsKA Application",
              "onl_app_test_mail@sensin.eu",
              Seq(getEmail),
              bodyText = Some("Dear " + username + "," + "\n" + "Your password is " + password)
            )
            mailerClient.send(email)
            logger.trace("...EMail sent.")
            Redirect(routes.UsersController.login())
          }
          else
            //Ok("Cool")
            Redirect(routes.UsersController.signup()).flashing("duplicate" -> "User already exists!")
        }
        else
          Ok("Yea")
          //Redirect(routes.UsersController.signup()).flashing("username" -> "Username should be at least 6 characters!")
      }
    )
  }

  /* ==== Database functions: ==== */

  private def hash(v: String): String = BCrypt.hashpw(v, BCrypt.gensalt())


  def createUser(username: String, password: String, email: String): Boolean = {
    try {
      val q = Tables.Users.filter(_.email === email)
      val f = db.run(q.result)
      val res = Await.result(f, timeout)
      res.foreach(println _)
      println( "Sequence nth: "+ res(0) )
      if (!res.isEmpty) {
        logger.trace("... email found.")
        false
      }
      else {
        val q = Tables.Users.filter(_.userName === username)
        val f = db.run(q.result)
        val res = Await.result(f, timeout)
        res.foreach(println _)
        if (!res.isEmpty) {
          logger.trace("... username found.")
          false
        }
        else {
          val q = Tables.Users += new Tables.UsersRow(username, hash(password), email, Option(Timestamp.from(Instant.now)), Option.empty)
          val f = db.run(q)
          Await.result(f, timeout)
          logger.trace("... new user stored in db.")
          true
        }
      }
    } catch {
      case e: Exception =>
        logger.error(s"createUser: ${e.getMessage}")
        logger.error(s"Esception: ${e.toString}")
        e.printStackTrace()
        false
    }
  }


  def validateUser(username: String, password: String): Boolean = {
    try {
      val q = for (c <- Tables.Users if c.userName === username) yield c.userPass
      val f = db.run(q.result)
      val ref = Await.result(f, timeout)
      val pw = ref.head
      val res = BCrypt.checkpw(password, pw)
      logger.trace(s"Passwort check: $password $pw $res")
      res
    } catch {
      case e: Exception => false // TODO: Log an error or even display.
    }
  }


  private def storeAccessTime(username: String): Unit = {
    val now: Timestamp = Timestamp.from(Instant.now)
    val q = Tables.Users.filter(_.userName === username).map(_.lastlogin).update(Option(now))
    val f = db.run(q)
    // Await.result(f,timeout)
  }

  def accessTime(username: String): String = {
    val q = Tables.Users.filter(_.userName === username).map(_.lastlogin)
    val f = db.run(q.result)
    val res = Await.result(f, timeout)
    if (!res.isEmpty) {
      val store = {
        if (res.head.isEmpty) "" else res.head.get.toString
      }
      storeAccessTime(username)
      store
    }
    else {
      storeAccessTime(username)
      "This is your first time!"
    }
  }

  def activeTime(username: String): Boolean = {
    true
    /* //TODO: Use Session for this.
    val ttl = 10000
    val now = System.currentTimeMillis()
    if (lastActiveTimes.contains(username)) {
      val difference = now - lastActiveTimes(username)
      if (difference < ttl) {
        lastActiveTimes(username) = System.currentTimeMillis()
        true
      }
      else {
        lastActiveTimes.remove(username)
        false
      }
    }
    else {
      lastActiveTimes(username) = System.currentTimeMillis()
      true
    }
  }

 */
  }


  }

