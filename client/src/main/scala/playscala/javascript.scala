/**
 * Project B - SSTM 2020 summer semester
 * Victory Uzochukwu 66116
 *
 */

package playscala


import org.querki.jquery._
import shared.SharedMessages
import org.scalajs.dom
import org.scalajs.dom.{console, html}
import org.scalajs.dom.raw.Element
import slinky.web.ReactDOM
import slinky.web.html.h1

import scala.scalajs.js.annotation.JSExportTopLevel
import scala.scalajs.js.special.debugger

object javascript {

  def main(args: Array[String]): Unit = {
    getElementsBySelector()
  }

  /***
   * This method helps select elements by their selectors
   *
   */
  def getElementsBySelector(): Unit = {
     val secButton = dom.document.getElementById("sec-page-button-div")
     val createUser = dom.document.getElementById("register-new-user-div")
     val secRoute = dom.document.getElementById("secretary")




    /**
     * Here all relevant methods are called
     */

    createNewUser( createUser )
    gotoSecretaryPage( secButton, secRoute )
  }



  /**
   * Function that toggles the checkbox
   * @param checkBox -> instance of office target element
   */
  @JSExportTopLevel("toggleCheck")
  def toggleCheck( checkBox: Element ): Unit = {

    val childCheckDiv = checkBox.asInstanceOf[html.Div].firstElementChild
    val child = childCheckDiv.asInstanceOf[html.Div];
    if ( dom.window.getComputedStyle( childCheckDiv ).display=="none" )
      {
        child.setAttribute( "data-toggle-value", "visible" )
        child.style.display = "block"
      } else
           {
             child.setAttribute( "data-toggle-value", "hidden" )
             child.style.display = "none"
           }
  }
 /**
   * Function that takes you to the international office page
   * @param office -> instance of office target element
   */
  @JSExportTopLevel("gotoInternationalOfficePage")
  def gotoInternationalOfficePage( office: Element ): Unit = {
    var id = office.id
    dom.window.location.href = "http://www.hs-karlsruhe.de/en/io.html"
  }

  /**
   * Function that takes you to our university home page
   * @param home -> the instance of home target element
   */
  @JSExportTopLevel("gotoOurUniversityPage")
  def gotoOurUniversityPage( home: Element ): Unit = {
    var id = home.id
    dom.window.location.href = "http://www.hs-karlsruhe.de/"
  }

  /**
   *  Function that destroys user's session and takes them to the login page
   * @param logOutButton ->  the instance of the target element
   */
  @JSExportTopLevel("logOut")
  def logOut( logOutButton: Element ): Unit = {
    var id = logOutButton.id
    dom.window.location.href = "/logout"
  }

  /**
   * function to get the bemlang id and to open a new window with the documents of this this bemlang
   * @param button the instance of the target element
   */
  @JSExportTopLevel("getTaskId")
  def getTaskId( button: Element ): Unit = {
    val form = button.asInstanceOf[html.Button].parentElement.parentElement.parentElement // Necessary :-)
    form.onsubmit = (e: dom.Event) => {
      e.preventDefault() // Prevent form from submitting if this particular button is clicked
    }

    var id = button.id
    dom.window.location.href = "/detailedStudentInformation?bemlang="+id
  }

  /**
   * Function to get the bemlang id and to open a new window with the documents of this this bemlang
   * @param button the instance of the target element
   */
  @JSExportTopLevel("getDocsId")
  def getDocsId( button: Element ): Unit = {
    val form = button.asInstanceOf[html.Button].parentElement.parentElement.parentElement // Necessary :-)
    form.onsubmit = (e: dom.Event) => {
        e.preventDefault() // Prevent form from submiting if this particular button is clicked
      }
      var id = button.id
      dom.window.location.href = "/documentsUpload?bemlang="+id

  }

  /**
   *
   * @param showAllStudents shows the rest of the students on the table
   */
  @JSExportTopLevel("showAll")
  def showAll(showAllStudents: Element): Unit = {
        var id = showAllStudents.id
        dom.window.location.href = "?all=1"
  }

  /***
   *
   * @param createNewUser calls onClick to direct to a new page
   */
  def createNewUser( createNewUser: Element ): Unit = {
      if ( createNewUser!=null )
        {
          createNewUser.asInstanceOf[html.Div].onclick = e => {
            dom.window.location.href = "/appNewStudent"
          }
        }
  }

  /**
   * Allows us go to the secretary page from the lead page
   */
  def gotoSecretaryPage( secButton: Element, secRoute: Element ) {
    if ( secButton!= null) {
      secButton.asInstanceOf[html.Div].onclick = e => {
        var route = secRoute.asInstanceOf[html.Input].value // For reverse routing
        dom.window.location.href = "/secretary"//secRoute
      }
    }
  }

}
