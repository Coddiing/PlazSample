package models

/**
 * Slick 3: Create file Tables.scala aus der Datenbank. Direkt hier.
 */

import slick.codegen


object CreateTables extends App {
 // val dbURL = "jdbc:postgresql://localhost/stm_zulassung"

  override def main (args: Array[ String ]): Unit = {
    val dbURL =  "jdbc:postgresql://localhost:5432/stm_zulassung?nullNamePatternMatchesAll=true";
    val dbDriver = "org.postgresql.Driver"
    Console.println("Create DB classes from Database")
    Console.println()
    codegen.SourceCodeGenerator.main(
      Array("slick.jdbc.PostgresqlProfile",
        dbDriver,
        dbURL,
        "./app",
        "models",
        "postgres",
        "victory"))

    //Array("slick.jdbc.PostgresqlProfile",
    //  dbDriver, dbURL, "./app/", "model", "sstm", "sstmtest"))
    Console.println("Finished.")
  }

}