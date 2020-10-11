package controllers

import play.api.mvc._

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.{ExecutionContext, Future}

case class Authenticated[A](action: Action[A]) extends Action[A] {
  override def apply(request: Request[A]): Future[Result] = {
    val username = request.session.get("username").getOrElse("")
    if (username != "")
      action(request)
    else
      Future(Results.Redirect(routes.UsersController.login())).map(_.withNewSession)
  }

  override def parser: BodyParser[A] = action.parser

  override def executionContext: ExecutionContext = action.executionContext
}
