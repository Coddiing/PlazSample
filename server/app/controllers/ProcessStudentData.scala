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



@Singleton
class ProcessStudentData @Inject()(protected val dbConfigProvider: DatabaseConfigProvider, cc: MessagesControllerComponents,
                                mailerClient: MailerClient, config: Configuration,
                                addToken: CSRFAddToken, checkToken: CSRFCheck)(implicit ex: ExecutionContext)
  extends MessagesAbstractController(cc)
    with HasDatabaseConfigProvider[JdbcProfile] {

  val timeout: Duration = Duration.fromNanos(config.getOptional[Double]("database_timeout").getOrElse(60.0) * 1E9)
  private val logger = LoggerFactory.getLogger(classOf[UsersController])

  def processData: List[StudentsData] = {


        val q = Tables.Bew //.filter(_.email === email)
        val f = db.run(q.result)
        val res = Await.result(f, timeout)
        var count = 0
        var vList: List[StudentsData] = List() // To collect the objects of the StudentsData class
        var vList2: List[StudentsData] = List() // To collect the objects of the StudentsData class

        var dummyList: List[String] = List()
        var shortNachName = ""

    breakable {
          for (index <- 0 until res.size) { // Running the entire Bew table to start comparing different tables
            val size = res(index).length.toString().toInt

            for (index2 <- 0 until size) {
              val bemlang = res(index)(0).toString
              var nachName = res(index)(2).toString
              var vorName = res(index)(3).toString
              val staat = res(index)(8) match { // Resolving Some
                case Some(i) => i
                case None => ""
              }



              // Fetching from the Antr table and filtering
              val antr = Tables.Antr.filter( _.bemlang===bemlang ) // Comparing bemlang of Antr table and Bew table.
              val runAntr = db.run(antr.result)
              val antrRes = Await.result(runAntr, timeout)

              if ( !antrRes.isEmpty )
                {
                    val zulassung = antrRes(0).zulassung.getOrElse("").toString
                    val sitzungnr = antrRes(0).sitzungnr.getOrElse(0).toString.toInt
                    val ischeckedComplete = antrRes(0).ischeckedComplete.getOrElse(false)
                    val bemerkung = antrRes(0).bemerkung.getOrElse("")
                    val dateZulSent = antrRes(0).dateZulSent.getOrElse( "" ).toString

                    var checked = 0
                    if ( ischeckedComplete )
                      {
                          checked = 1 // Using "checked" to match argumment
                      }

                  val bew1 = new StudentsData()

                  bew1.setBemlang(bemlang) // set bemlang

                  bew1.setShortNachname(checkForLongNachName(nachName)) // set last Name
                  bew1.setNachname(nachName) // set last Name


                  bew1.setShortVorname(checkForLongVorName(vorName)) // set first name
                  bew1.setVorname(vorName) // set first name

                  bew1.setStaat(staat.toString) // set Nationality

                  bew1.setZulassung(zulassung)
                  bew1.setSitzungNr(sitzungnr)
                  bew1.setisChecked(checked)
                  bew1.setBemerkung(bemerkung)
                  bew1.setDate_Zul_Sent(dateZulSent)

                  if (!dummyList.contains( bemlang )){ // expel redundancy
                    vList = bew1::vList
                    dummyList = bemlang::dummyList
                  }

                }


            }

           // logger.trace( "\n\n###################### END ####################### \n\n" )
            if (index > 50) break
          }
        }

    //logger.trace( "zulassung: "+ vList + "\n" )

              vList.reverse
      }


      def checkForLongNachName(  nachName: String ): String = {
        var shortName = ""

        if ( nachName.length>=19 )
        {
          var thereIsWhiteSpace: Boolean = false
          for ( i <- 0 until nachName.length )
          {
            if ( nachName.charAt( i )==" " )
            {
              thereIsWhiteSpace = true
            }
          }

          if ( !thereIsWhiteSpace )
          {
            val startIndex: Int = nachName.length/2
            shortName = nachName.substring(0, 10 )+" ..."


          }
        }
        shortName
      }

      def checkForLongVorName(  vorName: String ): String = {
            var shortName = ""

            if ( vorName.length>=19 )
            {
              var thereIsWhiteSpace: Boolean = false
              for ( i <- 0 until vorName.length )
              {
                if ( vorName.charAt( i )==" " )
                {
                  thereIsWhiteSpace = true
                }
              }

              if ( !thereIsWhiteSpace )
              {
                val startIndex: Int = vorName.length/2
                shortName = vorName.substring(0, 10 )+" ..."


              }
            }
            shortName
      }

    }