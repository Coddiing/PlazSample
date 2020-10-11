package models

// AUTO-GENERATED Slick data model
/** Stand-alone Slick data model for immediate use */
//object V2Tables extends {
//  val profile = slick.jdbc.MySQLProfile
//} with V2Tables

/** Slick data model trait for extension, choice of backend or usage in the cake pattern. (Make sure to initialize this late.) */
trait Tables_V2 {
  val profile: slick.jdbc.JdbcProfile

  import profile.api._
  import slick.collection.heterogeneous._
  // NOTE: GetResult mappers for plain SQL are only generated for tables where Slick knows how to map the types of all columns.
  import slick.jdbc.{GetResult => GR}

  /** DDL for all tables. Call .create to execute. */
  lazy val schema: profile.SchemaDescription = Array(Abschluss.schema, Antr.schema, Auth.schema, Bew.schema, Docs.schema, DocsExtra.schema, Email.schema, Fach.schema, Fachbewertung.schema, Fachzusatz.schema, Gutachter.schema, GutachterBewerberid.schema, Immatriculation.schema, StudBemerkung.schema, StudBewertung.schema, Student.schema, Uni.schema, UniqueId.schema, UniStud.schema, UserComm.schema, UserRoles.schema, Users.schema).reduceLeft(_ ++ _)

  @deprecated("Use .schema instead of .ddl", "3.0")
  def ddl = schema

  /** Entity class storing rows of table Abschluss
   *
   * @param bemlang              Database column bemlang SqlType(VARCHAR), PrimaryKey, Length(255,true)
   * @param durchschnitt         Database column durchschnitt SqlType(DECIMAL), Default(None)
   * @param exmatrikulationdatum Database column ExmatrikulationDatum SqlType(DATE), Default(None) */
  case class AbschlussRow(bemlang: String, durchschnitt: Option[scala.math.BigDecimal] = None, exmatrikulationdatum: Option[java.sql.Date] = None)

  /** GetResult implicit for fetching AbschlussRow objects using plain SQL queries */
  implicit def GetResultAbschlussRow(implicit e0: GR[String], e1: GR[Option[scala.math.BigDecimal]], e2: GR[Option[java.sql.Date]]): GR[AbschlussRow] = GR {
    prs =>
      import prs._
      AbschlussRow.tupled((<<[String], <<?[scala.math.BigDecimal], <<?[java.sql.Date]))
  }

  /** Table description of table Abschluss. Objects of this class serve as prototypes for rows in queries. */
  class Abschluss(_tableTag: Tag) extends profile.api.Table[AbschlussRow](_tableTag, Some("stm_zulassung"), "Abschluss") {
    def * = (bemlang, durchschnitt, exmatrikulationdatum) <> (AbschlussRow.tupled, AbschlussRow.unapply)

    /** Maps whole row to an option. Useful for outer joins. */
    def ? = ((Rep.Some(bemlang), durchschnitt, exmatrikulationdatum)).shaped.<>({ r => import r._; _1.map(_ => AbschlussRow.tupled((_1.get, _2, _3))) }, (_: Any) => throw new Exception("Inserting into ? projection not supported."))

    /** Database column bemlang SqlType(VARCHAR), PrimaryKey, Length(255,true) */
    val bemlang: Rep[String] = column[String]("bemlang", O.PrimaryKey, O.Length(255, varying = true))
    /** Database column durchschnitt SqlType(DECIMAL), Default(None) */
    val durchschnitt: Rep[Option[scala.math.BigDecimal]] = column[Option[scala.math.BigDecimal]]("durchschnitt", O.Default(None))
    /** Database column ExmatrikulationDatum SqlType(DATE), Default(None) */
    val exmatrikulationdatum: Rep[Option[java.sql.Date]] = column[Option[java.sql.Date]]("ExmatrikulationDatum", O.Default(None))
  }

  /** Collection-like TableQuery object for table Abschluss */
  lazy val Abschluss = new TableQuery(tag => new Abschluss(tag))

  /** Entity class storing rows of table Antr
   *
   * @param bemlang           Database column bemlang SqlType(VARCHAR), PrimaryKey, Length(255,true)
   * @param stg               Database column stg SqlType(CHAR), Length(3,false), Default(STM)
   * @param abschl            Database column abschl SqlType(CHAR), Length(2,false), Default(Some(59))
   * @param stgsem            Database column stgsem SqlType(TINYINT), Default(Some(1))
   * @param hzbart            Database column hzbart SqlType(CHAR), Length(2,false), Default(None)
   * @param hzbdatum          Database column hzbdatum SqlType(DATE), Default(None)
   * @param hzbkfzkz          Database column hzbkfzkz SqlType(CHAR), Default(None)
   * @param hzbort            Database column hzbort SqlType(CHAR), Length(4,false), Default(None)
   * @param zusbew2           Database column zusbew2 SqlType(TINYINT), Default(None)
   * @param zusbew1           Database column zusbew1 SqlType(SMALLINT), Default(None)
   * @param zulassung         Database column zulassung SqlType(CHAR), Default(None)
   * @param sitzungnr         Database column sitzungNr SqlType(TINYINT), Default(None)
   * @param exportiert        Database column exportiert SqlType(TINYINT UNSIGNED), Default(0)
   * @param ischeckedComplete Database column isChecked_Complete SqlType(BIT), Default(None)
   * @param bemerkung         Database column Bemerkung SqlType(TINYTEXT), Length(255,true), Default(None)
   * @param dateZulSent       Database column date_Zul_sent SqlType(TIMESTAMP), Default(None) */
  case class AntrRow(bemlang: String, stg: String = "STM", abschl: Option[String] = Some("59"), stgsem: Option[Byte] = Some(1), hzbart: Option[String] = None, hzbdatum: Option[java.sql.Date] = None, hzbkfzkz: Option[Char] = None, hzbort: Option[String] = None, zusbew2: Option[Byte] = None, zusbew1: Option[Int] = None, zulassung: Option[Char] = None, sitzungnr: Option[Byte] = None, exportiert: Short = 0, ischeckedComplete: Option[Boolean] = None, bemerkung: Option[String] = None, dateZulSent: Option[java.sql.Timestamp] = None)

  /** GetResult implicit for fetching AntrRow objects using plain SQL queries */
  implicit def GetResultAntrRow(implicit e0: GR[String], e1: GR[Option[String]], e2: GR[Option[Byte]], e3: GR[Option[java.sql.Date]], e4: GR[Option[Char]], e5: GR[Option[Int]], e6: GR[Short], e7: GR[Option[Boolean]], e8: GR[Option[java.sql.Timestamp]]): GR[AntrRow] = GR {
    prs =>
      import prs._
      AntrRow.tupled((<<[String], <<[String], <<?[String], <<?[Byte], <<?[String], <<?[java.sql.Date], <<?[Char], <<?[String], <<?[Byte], <<?[Int], <<?[Char], <<?[Byte], <<[Short], <<?[Boolean], <<?[String], <<?[java.sql.Timestamp]))
  }

  /** Table description of table antr. Objects of this class serve as prototypes for rows in queries. */
  class Antr(_tableTag: Tag) extends profile.api.Table[AntrRow](_tableTag, Some("stm_zulassung"), "antr") {
    def * = (bemlang, stg, abschl, stgsem, hzbart, hzbdatum, hzbkfzkz, hzbort, zusbew2, zusbew1, zulassung, sitzungnr, exportiert, ischeckedComplete, bemerkung, dateZulSent) <> (AntrRow.tupled, AntrRow.unapply)

    /** Maps whole row to an option. Useful for outer joins. */
    def ? = ((Rep.Some(bemlang), Rep.Some(stg), abschl, stgsem, hzbart, hzbdatum, hzbkfzkz, hzbort, zusbew2, zusbew1, zulassung, sitzungnr, Rep.Some(exportiert), ischeckedComplete, bemerkung, dateZulSent)).shaped.<>({ r => import r._; _1.map(_ => AntrRow.tupled((_1.get, _2.get, _3, _4, _5, _6, _7, _8, _9, _10, _11, _12, _13.get, _14, _15, _16))) }, (_: Any) => throw new Exception("Inserting into ? projection not supported."))

    /** Database column bemlang SqlType(VARCHAR), PrimaryKey, Length(255,true) */
    val bemlang: Rep[String] = column[String]("bemlang", O.PrimaryKey, O.Length(255, varying = true))
    /** Database column stg SqlType(CHAR), Length(3,false), Default(STM) */
    val stg: Rep[String] = column[String]("stg", O.Length(3, varying = false), O.Default("STM"))
    /** Database column abschl SqlType(CHAR), Length(2,false), Default(Some(59)) */
    val abschl: Rep[Option[String]] = column[Option[String]]("abschl", O.Length(2, varying = false), O.Default(Some("59")))
    /** Database column stgsem SqlType(TINYINT), Default(Some(1)) */
    val stgsem: Rep[Option[Byte]] = column[Option[Byte]]("stgsem", O.Default(Some(1)))
    /** Database column hzbart SqlType(CHAR), Length(2,false), Default(None) */
    val hzbart: Rep[Option[String]] = column[Option[String]]("hzbart", O.Length(2, varying = false), O.Default(None))
    /** Database column hzbdatum SqlType(DATE), Default(None) */
    val hzbdatum: Rep[Option[java.sql.Date]] = column[Option[java.sql.Date]]("hzbdatum", O.Default(None))
    /** Database column hzbkfzkz SqlType(CHAR), Default(None) */
    val hzbkfzkz: Rep[Option[Char]] = column[Option[Char]]("hzbkfzkz", O.Default(None))
    /** Database column hzbort SqlType(CHAR), Length(4,false), Default(None) */
    val hzbort: Rep[Option[String]] = column[Option[String]]("hzbort", O.Length(4, varying = false), O.Default(None))
    /** Database column zusbew2 SqlType(TINYINT), Default(None) */
    val zusbew2: Rep[Option[Byte]] = column[Option[Byte]]("zusbew2", O.Default(None))
    /** Database column zusbew1 SqlType(SMALLINT), Default(None) */
    val zusbew1: Rep[Option[Int]] = column[Option[Int]]("zusbew1", O.Default(None))
    /** Database column zulassung SqlType(CHAR), Default(None) */
    val zulassung: Rep[Option[Char]] = column[Option[Char]]("zulassung", O.Default(None))
    /** Database column sitzungNr SqlType(TINYINT), Default(None) */
    val sitzungnr: Rep[Option[Byte]] = column[Option[Byte]]("sitzungNr", O.Default(None))
    /** Database column exportiert SqlType(TINYINT UNSIGNED), Default(0) */
    val exportiert: Rep[Short] = column[Short]("exportiert", O.Default(0))
    /** Database column isChecked_Complete SqlType(BIT), Default(None) */
    val ischeckedComplete: Rep[Option[Boolean]] = column[Option[Boolean]]("isChecked_Complete", O.Default(None))
    /** Database column Bemerkung SqlType(TINYTEXT), Length(255,true), Default(None) */
    val bemerkung: Rep[Option[String]] = column[Option[String]]("Bemerkung", O.Length(255, varying = true), O.Default(None))
    /** Database column date_Zul_sent SqlType(TIMESTAMP), Default(None) */
    val dateZulSent: Rep[Option[java.sql.Timestamp]] = column[Option[java.sql.Timestamp]]("date_Zul_sent", O.Default(None))
  }

  /** Collection-like TableQuery object for table Antr */
  lazy val Antr = new TableQuery(tag => new Antr(tag))

  /** Entity class storing rows of table Auth
   *
   * @param authno  Database column authno SqlType(VARCHAR), PrimaryKey, Length(25,true)
   * @param email   Database column email SqlType(VARCHAR), Length(45,true)
   * @param bemlang Database column bemlang SqlType(VARCHAR), Length(255,true), Default(None)
   * @param changed Database column changed SqlType(TIMESTAMP), Default(None)
   * @param created Database column created SqlType(TIMESTAMP), Default(None)
   * @param closed  Database column closed SqlType(TIMESTAMP), Default(None) */
  case class AuthRow(authno: String, email: String, bemlang: Option[String] = None, changed: Option[java.sql.Timestamp] = None, created: Option[java.sql.Timestamp] = None, closed: Option[java.sql.Timestamp] = None)

  /** GetResult implicit for fetching AuthRow objects using plain SQL queries */
  implicit def GetResultAuthRow(implicit e0: GR[String], e1: GR[Option[String]], e2: GR[Option[java.sql.Timestamp]]): GR[AuthRow] = GR {
    prs =>
      import prs._
      AuthRow.tupled((<<[String], <<[String], <<?[String], <<?[java.sql.Timestamp], <<?[java.sql.Timestamp], <<?[java.sql.Timestamp]))
  }

  /** Table description of table auth. Objects of this class serve as prototypes for rows in queries. */
  class Auth(_tableTag: Tag) extends profile.api.Table[AuthRow](_tableTag, Some("stm_zulassung"), "auth") {
    def * = (authno, email, bemlang, changed, created, closed) <> (AuthRow.tupled, AuthRow.unapply)

    /** Maps whole row to an option. Useful for outer joins. */
    def ? = ((Rep.Some(authno), Rep.Some(email), bemlang, changed, created, closed)).shaped.<>({ r => import r._; _1.map(_ => AuthRow.tupled((_1.get, _2.get, _3, _4, _5, _6))) }, (_: Any) => throw new Exception("Inserting into ? projection not supported."))

    /** Database column authno SqlType(VARCHAR), PrimaryKey, Length(25,true) */
    val authno: Rep[String] = column[String]("authno", O.PrimaryKey, O.Length(25, varying = true))
    /** Database column email SqlType(VARCHAR), Length(45,true) */
    val email: Rep[String] = column[String]("email", O.Length(45, varying = true))
    /** Database column bemlang SqlType(VARCHAR), Length(255,true), Default(None) */
    val bemlang: Rep[Option[String]] = column[Option[String]]("bemlang", O.Length(255, varying = true), O.Default(None))
    /** Database column changed SqlType(TIMESTAMP), Default(None) */
    val changed: Rep[Option[java.sql.Timestamp]] = column[Option[java.sql.Timestamp]]("changed", O.Default(None))
    /** Database column created SqlType(TIMESTAMP), Default(None) */
    val created: Rep[Option[java.sql.Timestamp]] = column[Option[java.sql.Timestamp]]("created", O.Default(None))
    /** Database column closed SqlType(TIMESTAMP), Default(None) */
    val closed: Rep[Option[java.sql.Timestamp]] = column[Option[java.sql.Timestamp]]("closed", O.Default(None))

    /** Uniqueness Index over (email) (database name email_UNIQUE) */
    val index1 = index("email_UNIQUE", email, unique = true)
  }

  /** Collection-like TableQuery object for table Auth */
  lazy val Auth = new TableQuery(tag => new Auth(tag))

  /** Entity class storing rows of table Bew
   *
   * @param bemlang          Database column bemlang SqlType(VARCHAR), PrimaryKey, Length(255,true), Default()
   * @param anti             Database column anti SqlType(CHAR), Length(25,false)
   * @param nachname         Database column nachname SqlType(CHAR), Length(35,false)
   * @param vorname          Database column vorname SqlType(CHAR), Length(30,false)
   * @param gebname          Database column gebname SqlType(CHAR), Length(35,false), Default(None)
   * @param gebort           Database column gebort SqlType(CHAR), Length(25,false)
   * @param gebdat           Database column gebdat SqlType(DATE), Default(None)
   * @param geschl           Database column geschl SqlType(CHAR)
   * @param staat            Database column staat SqlType(CHAR), Length(3,false), Default(None)
   * @param pozusatz         Database column pozusatz SqlType(VARCHAR), Length(255,true), Default(None)
   * @param postrasse        Database column postrasse SqlType(VARCHAR), Length(255,true), Default(None)
   * @param poplz            Database column poplz SqlType(CHAR), Length(10,false), Default(None)
   * @param poort            Database column poort SqlType(VARCHAR), Length(255,true), Default(None)
   * @param pokfz            Database column pokfz SqlType(CHAR), Length(3,false), Default(None)
   * @param potel            Database column potel SqlType(CHAR), Length(50,false), Default(None)
   * @param bishsem          Database column bishsem SqlType(TINYINT), Default(None)
   * @param zweitst          Database column zweitst SqlType(CHAR), Default(Some(J))
   * @param hmkfzkz          Database column hmkfzkz SqlType(CHAR)
   * @param hmkfz            Database column hmkfz SqlType(CHAR), Length(4,false), Default(None)
   * @param fehlunt          Database column fehlunt SqlType(CHAR), Default(-)
   * @param verarbkz         Database column verarbkz SqlType(CHAR), Length(2,false), Default(None)
   * @param staatkez         Database column staatkez SqlType(CHAR), Default(None)
   * @param berufab          Database column berufab SqlType(CHAR), Default(None)
   * @param prakt1           Database column prakt1 SqlType(CHAR), Default(None)
   * @param sonsttaet        Database column sonsttaet SqlType(CHAR), Default(None)
   * @param gesadauer        Database column gesadauer SqlType(TINYINT), Default(None)
   * @param erhskfz          Database column erhskfz SqlType(CHAR), Length(4,false), Default(None)
   * @param erhsart          Database column erhsart SqlType(CHAR), Length(2,false), Default(None)
   * @param erhssembrd       Database column erhssembrd SqlType(SMALLINT), Default(None)
   * @param hssem            Database column hssem SqlType(TINYINT), Default(None)
   * @param urlsem           Database column urlsem SqlType(TINYINT), Default(None)
   * @param praxsem          Database column praxsem SqlType(TINYINT), Default(None)
   * @param zustimmungAlumni Database column zustimmung_alumni SqlType(CHAR), Default(None)
   * @param photo            Database column photo SqlType(MEDIUMBLOB), Default(None)
   * @param hochschulname    Database column hochschulname SqlType(VARCHAR), Length(160,true), Default(None)
   * @param hochschulort     Database column hochschulort SqlType(VARCHAR), Length(255,true), Default(None)
   * @param studiengangname  Database column studiengangname SqlType(VARCHAR), Length(255,true), Default(None)
   * @param abschluss        Database column abschluss SqlType(VARCHAR), Length(10,true), Default(None)
   * @param average          Database column average SqlType(VARCHAR), Length(10,true), Default(None)
   * @param bestmark         Database column bestmark SqlType(VARCHAR), Length(10,true), Default(None)
   * @param passmark         Database column passmark SqlType(VARCHAR), Length(10,true), Default(None)
   * @param bachstartdate    Database column bachstartdate SqlType(DATE), Default(None)
   * @param bachenddate      Database column bachenddate SqlType(DATE), Default(None)
   * @param brdCourse        Database column BRD_course SqlType(VARCHAR), Length(255,true), Default(None)
   * @param brdDiploma       Database column BRD_diploma SqlType(VARCHAR), Length(2,true), Default(None)
   * @param brdstart         Database column brdstart SqlType(DATE), Default(None)
   * @param brdend           Database column brdend SqlType(DATE), Default(None) */
  case class BewRow(bemlang: String = "", anti: String, nachname: String, vorname: String, gebname: Option[String] = None, gebort: String, gebdat: Option[java.sql.Date] = None, geschl: Char, staat: Option[String] = None, pozusatz: Option[String] = None, postrasse: Option[String] = None, poplz: Option[String] = None, poort: Option[String] = None, pokfz: Option[String] = None, potel: Option[String] = None, bishsem: Option[Byte] = None, zweitst: Option[Char] = Some('J'), hmkfzkz: Char, hmkfz: Option[String] = None, fehlunt: Char = '-', verarbkz: Option[String] = None, staatkez: Option[Char] = None, berufab: Option[Char] = None, prakt1: Option[Char] = None, sonsttaet: Option[Char] = None, gesadauer: Option[Byte] = None, erhskfz: Option[String] = None, erhsart: Option[String] = None, erhssembrd: Option[Int] = None, hssem: Option[Byte] = None, urlsem: Option[Byte] = None, praxsem: Option[Byte] = None, zustimmungAlumni: Option[Char] = None, photo: Option[java.sql.Blob] = None, hochschulname: Option[String] = None, hochschulort: Option[String] = None, studiengangname: Option[String] = None, abschluss: Option[String] = None, average: Option[String] = None, bestmark: Option[String] = None, passmark: Option[String] = None, bachstartdate: Option[java.sql.Date] = None, bachenddate: Option[java.sql.Date] = None, brdCourse: Option[String] = None, brdDiploma: Option[String] = None, brdstart: Option[java.sql.Date] = None, brdend: Option[java.sql.Date] = None)

  /** GetResult implicit for fetching BewRow objects using plain SQL queries */
  implicit def GetResultBewRow(implicit e0: GR[String], e1: GR[Option[String]], e2: GR[Option[java.sql.Date]], e3: GR[Char], e4: GR[Option[Byte]], e5: GR[Option[Char]], e6: GR[Option[Int]], e7: GR[Option[java.sql.Blob]]): GR[BewRow] = GR {
    prs =>
      import prs._
      BewRow(<<[String], <<[String], <<[String], <<[String], <<?[String], <<[String], <<?[java.sql.Date], <<[Char], <<?[String], <<?[String], <<?[String], <<?[String], <<?[String], <<?[String], <<?[String], <<?[Byte], <<?[Char], <<[Char], <<?[String], <<[Char], <<?[String], <<?[Char], <<?[Char], <<?[Char], <<?[Char], <<?[Byte], <<?[String], <<?[String], <<?[Int], <<?[Byte], <<?[Byte], <<?[Byte], <<?[Char], <<?[java.sql.Blob], <<?[String], <<?[String], <<?[String], <<?[String], <<?[String], <<?[String], <<?[String], <<?[java.sql.Date], <<?[java.sql.Date], <<?[String], <<?[String], <<?[java.sql.Date], <<?[java.sql.Date])
  }

  /** Table description of table bew. Objects of this class serve as prototypes for rows in queries. */
  class Bew(_tableTag: Tag) extends profile.api.Table[BewRow](_tableTag, Some("stm_zulassung"), "bew") {
    def * = (bemlang :: anti :: nachname :: vorname :: gebname :: gebort :: gebdat :: geschl :: staat :: pozusatz :: postrasse :: poplz :: poort :: pokfz :: potel :: bishsem :: zweitst :: hmkfzkz :: hmkfz :: fehlunt :: verarbkz :: staatkez :: berufab :: prakt1 :: sonsttaet :: gesadauer :: erhskfz :: erhsart :: erhssembrd :: hssem :: urlsem :: praxsem :: zustimmungAlumni :: photo :: hochschulname :: hochschulort :: studiengangname :: abschluss :: average :: bestmark :: passmark :: bachstartdate :: bachenddate :: brdCourse :: brdDiploma :: brdstart :: brdend :: HNil).mapTo[BewRow]

    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(bemlang) :: Rep.Some(anti) :: Rep.Some(nachname) :: Rep.Some(vorname) :: gebname :: Rep.Some(gebort) :: gebdat :: Rep.Some(geschl) :: staat :: pozusatz :: postrasse :: poplz :: poort :: pokfz :: potel :: bishsem :: zweitst :: Rep.Some(hmkfzkz) :: hmkfz :: Rep.Some(fehlunt) :: verarbkz :: staatkez :: berufab :: prakt1 :: sonsttaet :: gesadauer :: erhskfz :: erhsart :: erhssembrd :: hssem :: urlsem :: praxsem :: zustimmungAlumni :: photo :: hochschulname :: hochschulort :: studiengangname :: abschluss :: average :: bestmark :: passmark :: bachstartdate :: bachenddate :: brdCourse :: brdDiploma :: brdstart :: brdend :: HNil).shaped.<>(r => BewRow(r(0).asInstanceOf[Option[String]].get, r(1).asInstanceOf[Option[String]].get, r(2).asInstanceOf[Option[String]].get, r(3).asInstanceOf[Option[String]].get, r(4).asInstanceOf[Option[String]], r(5).asInstanceOf[Option[String]].get, r(6).asInstanceOf[Option[java.sql.Date]], r(7).asInstanceOf[Option[Char]].get, r(8).asInstanceOf[Option[String]], r(9).asInstanceOf[Option[String]], r(10).asInstanceOf[Option[String]], r(11).asInstanceOf[Option[String]], r(12).asInstanceOf[Option[String]], r(13).asInstanceOf[Option[String]], r(14).asInstanceOf[Option[String]], r(15).asInstanceOf[Option[Byte]], r(16).asInstanceOf[Option[Char]], r(17).asInstanceOf[Option[Char]].get, r(18).asInstanceOf[Option[String]], r(19).asInstanceOf[Option[Char]].get, r(20).asInstanceOf[Option[String]], r(21).asInstanceOf[Option[Char]], r(22).asInstanceOf[Option[Char]], r(23).asInstanceOf[Option[Char]], r(24).asInstanceOf[Option[Char]], r(25).asInstanceOf[Option[Byte]], r(26).asInstanceOf[Option[String]], r(27).asInstanceOf[Option[String]], r(28).asInstanceOf[Option[Int]], r(29).asInstanceOf[Option[Byte]], r(30).asInstanceOf[Option[Byte]], r(31).asInstanceOf[Option[Byte]], r(32).asInstanceOf[Option[Char]], r(33).asInstanceOf[Option[java.sql.Blob]], r(34).asInstanceOf[Option[String]], r(35).asInstanceOf[Option[String]], r(36).asInstanceOf[Option[String]], r(37).asInstanceOf[Option[String]], r(38).asInstanceOf[Option[String]], r(39).asInstanceOf[Option[String]], r(40).asInstanceOf[Option[String]], r(41).asInstanceOf[Option[java.sql.Date]], r(42).asInstanceOf[Option[java.sql.Date]], r(43).asInstanceOf[Option[String]], r(44).asInstanceOf[Option[String]], r(45).asInstanceOf[Option[java.sql.Date]], r(46).asInstanceOf[Option[java.sql.Date]]), (_: Any) => throw new Exception("Inserting into ? projection not supported."))

    /** Database column bemlang SqlType(VARCHAR), PrimaryKey, Length(255,true), Default() */
    val bemlang: Rep[String] = column[String]("bemlang", O.PrimaryKey, O.Length(255, varying = true), O.Default(""))
    /** Database column anti SqlType(CHAR), Length(25,false) */
    val anti: Rep[String] = column[String]("anti", O.Length(25, varying = false))
    /** Database column nachname SqlType(CHAR), Length(35,false) */
    val nachname: Rep[String] = column[String]("nachname", O.Length(35, varying = false))
    /** Database column vorname SqlType(CHAR), Length(30,false) */
    val vorname: Rep[String] = column[String]("vorname", O.Length(30, varying = false))
    /** Database column gebname SqlType(CHAR), Length(35,false), Default(None) */
    val gebname: Rep[Option[String]] = column[Option[String]]("gebname", O.Length(35, varying = false), O.Default(None))
    /** Database column gebort SqlType(CHAR), Length(25,false) */
    val gebort: Rep[String] = column[String]("gebort", O.Length(25, varying = false))
    /** Database column gebdat SqlType(DATE), Default(None) */
    val gebdat: Rep[Option[java.sql.Date]] = column[Option[java.sql.Date]]("gebdat", O.Default(None))
    /** Database column geschl SqlType(CHAR) */
    val geschl: Rep[Char] = column[Char]("geschl")
    /** Database column staat SqlType(CHAR), Length(3,false), Default(None) */
    val staat: Rep[Option[String]] = column[Option[String]]("staat", O.Length(3, varying = false), O.Default(None))
    /** Database column pozusatz SqlType(VARCHAR), Length(255,true), Default(None) */
    val pozusatz: Rep[Option[String]] = column[Option[String]]("pozusatz", O.Length(255, varying = true), O.Default(None))
    /** Database column postrasse SqlType(VARCHAR), Length(255,true), Default(None) */
    val postrasse: Rep[Option[String]] = column[Option[String]]("postrasse", O.Length(255, varying = true), O.Default(None))
    /** Database column poplz SqlType(CHAR), Length(10,false), Default(None) */
    val poplz: Rep[Option[String]] = column[Option[String]]("poplz", O.Length(10, varying = false), O.Default(None))
    /** Database column poort SqlType(VARCHAR), Length(255,true), Default(None) */
    val poort: Rep[Option[String]] = column[Option[String]]("poort", O.Length(255, varying = true), O.Default(None))
    /** Database column pokfz SqlType(CHAR), Length(3,false), Default(None) */
    val pokfz: Rep[Option[String]] = column[Option[String]]("pokfz", O.Length(3, varying = false), O.Default(None))
    /** Database column potel SqlType(CHAR), Length(50,false), Default(None) */
    val potel: Rep[Option[String]] = column[Option[String]]("potel", O.Length(50, varying = false), O.Default(None))
    /** Database column bishsem SqlType(TINYINT), Default(None) */
    val bishsem: Rep[Option[Byte]] = column[Option[Byte]]("bishsem", O.Default(None))
    /** Database column zweitst SqlType(CHAR), Default(Some(J)) */
    val zweitst: Rep[Option[Char]] = column[Option[Char]]("zweitst", O.Default(Some('J')))
    /** Database column hmkfzkz SqlType(CHAR) */
    val hmkfzkz: Rep[Char] = column[Char]("hmkfzkz")
    /** Database column hmkfz SqlType(CHAR), Length(4,false), Default(None) */
    val hmkfz: Rep[Option[String]] = column[Option[String]]("hmkfz", O.Length(4, varying = false), O.Default(None))
    /** Database column fehlunt SqlType(CHAR), Default(-) */
    val fehlunt: Rep[Char] = column[Char]("fehlunt", O.Default('-'))
    /** Database column verarbkz SqlType(CHAR), Length(2,false), Default(None) */
    val verarbkz: Rep[Option[String]] = column[Option[String]]("verarbkz", O.Length(2, varying = false), O.Default(None))
    /** Database column staatkez SqlType(CHAR), Default(None) */
    val staatkez: Rep[Option[Char]] = column[Option[Char]]("staatkez", O.Default(None))
    /** Database column berufab SqlType(CHAR), Default(None) */
    val berufab: Rep[Option[Char]] = column[Option[Char]]("berufab", O.Default(None))
    /** Database column prakt1 SqlType(CHAR), Default(None) */
    val prakt1: Rep[Option[Char]] = column[Option[Char]]("prakt1", O.Default(None))
    /** Database column sonsttaet SqlType(CHAR), Default(None) */
    val sonsttaet: Rep[Option[Char]] = column[Option[Char]]("sonsttaet", O.Default(None))
    /** Database column gesadauer SqlType(TINYINT), Default(None) */
    val gesadauer: Rep[Option[Byte]] = column[Option[Byte]]("gesadauer", O.Default(None))
    /** Database column erhskfz SqlType(CHAR), Length(4,false), Default(None) */
    val erhskfz: Rep[Option[String]] = column[Option[String]]("erhskfz", O.Length(4, varying = false), O.Default(None))
    /** Database column erhsart SqlType(CHAR), Length(2,false), Default(None) */
    val erhsart: Rep[Option[String]] = column[Option[String]]("erhsart", O.Length(2, varying = false), O.Default(None))
    /** Database column erhssembrd SqlType(SMALLINT), Default(None) */
    val erhssembrd: Rep[Option[Int]] = column[Option[Int]]("erhssembrd", O.Default(None))
    /** Database column hssem SqlType(TINYINT), Default(None) */
    val hssem: Rep[Option[Byte]] = column[Option[Byte]]("hssem", O.Default(None))
    /** Database column urlsem SqlType(TINYINT), Default(None) */
    val urlsem: Rep[Option[Byte]] = column[Option[Byte]]("urlsem", O.Default(None))
    /** Database column praxsem SqlType(TINYINT), Default(None) */
    val praxsem: Rep[Option[Byte]] = column[Option[Byte]]("praxsem", O.Default(None))
    /** Database column zustimmung_alumni SqlType(CHAR), Default(None) */
    val zustimmungAlumni: Rep[Option[Char]] = column[Option[Char]]("zustimmung_alumni", O.Default(None))
    /** Database column photo SqlType(MEDIUMBLOB), Default(None) */
    val photo: Rep[Option[java.sql.Blob]] = column[Option[java.sql.Blob]]("photo", O.Default(None))
    /** Database column hochschulname SqlType(VARCHAR), Length(160,true), Default(None) */
    val hochschulname: Rep[Option[String]] = column[Option[String]]("hochschulname", O.Length(160, varying = true), O.Default(None))
    /** Database column hochschulort SqlType(VARCHAR), Length(255,true), Default(None) */
    val hochschulort: Rep[Option[String]] = column[Option[String]]("hochschulort", O.Length(255, varying = true), O.Default(None))
    /** Database column studiengangname SqlType(VARCHAR), Length(255,true), Default(None) */
    val studiengangname: Rep[Option[String]] = column[Option[String]]("studiengangname", O.Length(255, varying = true), O.Default(None))
    /** Database column abschluss SqlType(VARCHAR), Length(10,true), Default(None) */
    val abschluss: Rep[Option[String]] = column[Option[String]]("abschluss", O.Length(10, varying = true), O.Default(None))
    /** Database column average SqlType(VARCHAR), Length(10,true), Default(None) */
    val average: Rep[Option[String]] = column[Option[String]]("average", O.Length(10, varying = true), O.Default(None))
    /** Database column bestmark SqlType(VARCHAR), Length(10,true), Default(None) */
    val bestmark: Rep[Option[String]] = column[Option[String]]("bestmark", O.Length(10, varying = true), O.Default(None))
    /** Database column passmark SqlType(VARCHAR), Length(10,true), Default(None) */
    val passmark: Rep[Option[String]] = column[Option[String]]("passmark", O.Length(10, varying = true), O.Default(None))
    /** Database column bachstartdate SqlType(DATE), Default(None) */
    val bachstartdate: Rep[Option[java.sql.Date]] = column[Option[java.sql.Date]]("bachstartdate", O.Default(None))
    /** Database column bachenddate SqlType(DATE), Default(None) */
    val bachenddate: Rep[Option[java.sql.Date]] = column[Option[java.sql.Date]]("bachenddate", O.Default(None))
    /** Database column BRD_course SqlType(VARCHAR), Length(255,true), Default(None) */
    val brdCourse: Rep[Option[String]] = column[Option[String]]("BRD_course", O.Length(255, varying = true), O.Default(None))
    /** Database column BRD_diploma SqlType(VARCHAR), Length(2,true), Default(None) */
    val brdDiploma: Rep[Option[String]] = column[Option[String]]("BRD_diploma", O.Length(2, varying = true), O.Default(None))
    /** Database column brdstart SqlType(DATE), Default(None) */
    val brdstart: Rep[Option[java.sql.Date]] = column[Option[java.sql.Date]]("brdstart", O.Default(None))
    /** Database column brdend SqlType(DATE), Default(None) */
    val brdend: Rep[Option[java.sql.Date]] = column[Option[java.sql.Date]]("brdend", O.Default(None))
  }

  /** Collection-like TableQuery object for table Bew */
  lazy val Bew = new TableQuery(tag => new Bew(tag))

  /** Entity class storing rows of table Docs
   *
   * @param bemlang     Database column bemlang SqlType(VARCHAR), PrimaryKey, Length(255,true)
   * @param hzb         Database column hzb SqlType(MEDIUMBLOB), Default(None)
   * @param bach        Database column bach SqlType(MEDIUMBLOB), Default(None)
   * @param transcript  Database column transcript SqlType(MEDIUMBLOB), Default(None)
   * @param engl        Database column engl SqlType(MEDIUMBLOB), Default(None)
   * @param cv          Database column cv SqlType(MEDIUMBLOB), Default(None)
   * @param rec1        Database column rec1 SqlType(MEDIUMBLOB), Default(None)
   * @param rec2        Database column rec2 SqlType(MEDIUMBLOB), Default(None)
   * @param motivletter Database column motivletter SqlType(MEDIUMBLOB), Default(None) */
  case class DocsRow(bemlang: String, hzb: Option[java.sql.Blob] = None, bach: Option[java.sql.Blob] = None, transcript: Option[java.sql.Blob] = None, engl: Option[java.sql.Blob] = None, cv: Option[java.sql.Blob] = None, rec1: Option[java.sql.Blob] = None, rec2: Option[java.sql.Blob] = None, motivletter: Option[java.sql.Blob] = None)

  /** GetResult implicit for fetching DocsRow objects using plain SQL queries */
  implicit def GetResultDocsRow(implicit e0: GR[String], e1: GR[Option[java.sql.Blob]]): GR[DocsRow] = GR {
    prs =>
      import prs._
      DocsRow.tupled((<<[String], <<?[java.sql.Blob], <<?[java.sql.Blob], <<?[java.sql.Blob], <<?[java.sql.Blob], <<?[java.sql.Blob], <<?[java.sql.Blob], <<?[java.sql.Blob], <<?[java.sql.Blob]))
  }

  /** Table description of table docs. Objects of this class serve as prototypes for rows in queries. */
  class Docs(_tableTag: Tag) extends profile.api.Table[DocsRow](_tableTag, Some("stm_zulassung"), "docs") {
    def * = (bemlang, hzb, bach, transcript, engl, cv, rec1, rec2, motivletter) <> (DocsRow.tupled, DocsRow.unapply)

    /** Maps whole row to an option. Useful for outer joins. */
    def ? = ((Rep.Some(bemlang), hzb, bach, transcript, engl, cv, rec1, rec2, motivletter)).shaped.<>({ r => import r._; _1.map(_ => DocsRow.tupled((_1.get, _2, _3, _4, _5, _6, _7, _8, _9))) }, (_: Any) => throw new Exception("Inserting into ? projection not supported."))

    /** Database column bemlang SqlType(VARCHAR), PrimaryKey, Length(255,true) */
    val bemlang: Rep[String] = column[String]("bemlang", O.PrimaryKey, O.Length(255, varying = true))
    /** Database column hzb SqlType(MEDIUMBLOB), Default(None) */
    val hzb: Rep[Option[java.sql.Blob]] = column[Option[java.sql.Blob]]("hzb", O.Default(None))
    /** Database column bach SqlType(MEDIUMBLOB), Default(None) */
    val bach: Rep[Option[java.sql.Blob]] = column[Option[java.sql.Blob]]("bach", O.Default(None))
    /** Database column transcript SqlType(MEDIUMBLOB), Default(None) */
    val transcript: Rep[Option[java.sql.Blob]] = column[Option[java.sql.Blob]]("transcript", O.Default(None))
    /** Database column engl SqlType(MEDIUMBLOB), Default(None) */
    val engl: Rep[Option[java.sql.Blob]] = column[Option[java.sql.Blob]]("engl", O.Default(None))
    /** Database column cv SqlType(MEDIUMBLOB), Default(None) */
    val cv: Rep[Option[java.sql.Blob]] = column[Option[java.sql.Blob]]("cv", O.Default(None))
    /** Database column rec1 SqlType(MEDIUMBLOB), Default(None) */
    val rec1: Rep[Option[java.sql.Blob]] = column[Option[java.sql.Blob]]("rec1", O.Default(None))
    /** Database column rec2 SqlType(MEDIUMBLOB), Default(None) */
    val rec2: Rep[Option[java.sql.Blob]] = column[Option[java.sql.Blob]]("rec2", O.Default(None))
    /** Database column motivletter SqlType(MEDIUMBLOB), Default(None) */
    val motivletter: Rep[Option[java.sql.Blob]] = column[Option[java.sql.Blob]]("motivletter", O.Default(None))
  }

  /** Collection-like TableQuery object for table Docs */
  lazy val Docs = new TableQuery(tag => new Docs(tag))

  /** Entity class storing rows of table DocsExtra
   *
   * @param bemlang     Database column bemlang SqlType(VARCHAR), Length(255,true)
   * @param bezeichnung Database column bezeichnung SqlType(VARCHAR), Length(45,true)
   * @param doc         Database column doc SqlType(MEDIUMBLOB) */
  case class DocsExtraRow(bemlang: String, bezeichnung: String, doc: java.sql.Blob)

  /** GetResult implicit for fetching DocsExtraRow objects using plain SQL queries */
  implicit def GetResultDocsExtraRow(implicit e0: GR[String], e1: GR[java.sql.Blob]): GR[DocsExtraRow] = GR {
    prs =>
      import prs._
      DocsExtraRow.tupled((<<[String], <<[String], <<[java.sql.Blob]))
  }

  /** Table description of table docs_extra. Objects of this class serve as prototypes for rows in queries. */
  class DocsExtra(_tableTag: Tag) extends profile.api.Table[DocsExtraRow](_tableTag, Some("stm_zulassung"), "docs_extra") {
    def * = (bemlang, bezeichnung, doc) <> (DocsExtraRow.tupled, DocsExtraRow.unapply)

    /** Maps whole row to an option. Useful for outer joins. */
    def ? = ((Rep.Some(bemlang), Rep.Some(bezeichnung), Rep.Some(doc))).shaped.<>({ r => import r._; _1.map(_ => DocsExtraRow.tupled((_1.get, _2.get, _3.get))) }, (_: Any) => throw new Exception("Inserting into ? projection not supported."))

    /** Database column bemlang SqlType(VARCHAR), Length(255,true) */
    val bemlang: Rep[String] = column[String]("bemlang", O.Length(255, varying = true))
    /** Database column bezeichnung SqlType(VARCHAR), Length(45,true) */
    val bezeichnung: Rep[String] = column[String]("bezeichnung", O.Length(45, varying = true))
    /** Database column doc SqlType(MEDIUMBLOB) */
    val doc: Rep[java.sql.Blob] = column[java.sql.Blob]("doc")

    /** Primary key of DocsExtra (database name docs_extra_PK) */
    val pk = primaryKey("docs_extra_PK", (bemlang, bezeichnung))

    /** Index over (bemlang) (database name bemlang_ind) */
    val index1 = index("bemlang_ind", bemlang)
    /** Index over (bezeichnung) (database name bez_ind) */
    val index2 = index("bez_ind", bezeichnung)
  }

  /** Collection-like TableQuery object for table DocsExtra */
  lazy val DocsExtra = new TableQuery(tag => new DocsExtra(tag))

  /** Entity class storing rows of table Email
   *
   * @param bemlang Database column bemlang SqlType(VARCHAR), Length(255,true), Default()
   * @param email   Database column email SqlType(VARCHAR), Length(100,true) */
  case class EmailRow(bemlang: String = "", email: String)

  /** GetResult implicit for fetching EmailRow objects using plain SQL queries */
  implicit def GetResultEmailRow(implicit e0: GR[String]): GR[EmailRow] = GR {
    prs =>
      import prs._
      EmailRow.tupled((<<[String], <<[String]))
  }

  /** Table description of table email. Objects of this class serve as prototypes for rows in queries. */
  class Email(_tableTag: Tag) extends profile.api.Table[EmailRow](_tableTag, Some("stm_zulassung"), "email") {
    def * = (bemlang, email) <> (EmailRow.tupled, EmailRow.unapply)

    /** Maps whole row to an option. Useful for outer joins. */
    def ? = ((Rep.Some(bemlang), Rep.Some(email))).shaped.<>({ r => import r._; _1.map(_ => EmailRow.tupled((_1.get, _2.get))) }, (_: Any) => throw new Exception("Inserting into ? projection not supported."))

    /** Database column bemlang SqlType(VARCHAR), Length(255,true), Default() */
    val bemlang: Rep[String] = column[String]("bemlang", O.Length(255, varying = true), O.Default(""))
    /** Database column email SqlType(VARCHAR), Length(100,true) */
    val email: Rep[String] = column[String]("email", O.Length(100, varying = true))

    /** Index over (bemlang) (database name bemlang) */
    val index1 = index("bemlang", bemlang)
  }

  /** Collection-like TableQuery object for table Email */
  lazy val Email = new TableQuery(tag => new Email(tag))

  /** Entity class storing rows of table Fach
   *
   * @param fachid Database column FachID SqlType(SMALLINT UNSIGNED), AutoInc, PrimaryKey
   * @param fach   Database column Fach SqlType(VARCHAR), Length(30,true), Default(None) */
  case class FachRow(fachid: Int, fach: Option[String] = None)

  /** GetResult implicit for fetching FachRow objects using plain SQL queries */
  implicit def GetResultFachRow(implicit e0: GR[Int], e1: GR[Option[String]]): GR[FachRow] = GR {
    prs =>
      import prs._
      FachRow.tupled((<<[Int], <<?[String]))
  }

  /** Table description of table Fach. Objects of this class serve as prototypes for rows in queries. */
  class Fach(_tableTag: Tag) extends profile.api.Table[FachRow](_tableTag, Some("stm_zulassung"), "Fach") {
    def * = (fachid, fach) <> (FachRow.tupled, FachRow.unapply)

    /** Maps whole row to an option. Useful for outer joins. */
    def ? = ((Rep.Some(fachid), fach)).shaped.<>({ r => import r._; _1.map(_ => FachRow.tupled((_1.get, _2))) }, (_: Any) => throw new Exception("Inserting into ? projection not supported."))

    /** Database column FachID SqlType(SMALLINT UNSIGNED), AutoInc, PrimaryKey */
    val fachid: Rep[Int] = column[Int]("FachID", O.AutoInc, O.PrimaryKey)
    /** Database column Fach SqlType(VARCHAR), Length(30,true), Default(None) */
    val fach: Rep[Option[String]] = column[Option[String]]("Fach", O.Length(30, varying = true), O.Default(None))
  }

  /** Collection-like TableQuery object for table Fach */
  lazy val Fach = new TableQuery(tag => new Fach(tag))

  /** Entity class storing rows of table Fachbewertung
   *
   * @param bewerberid  Database column BewerberID SqlType(VARCHAR), Length(255,true)
   * @param fachid      Database column FachID SqlType(SMALLINT)
   * @param noteadcde   Database column NoteADCDE SqlType(VARCHAR), Length(254,true), Default(Some(NULL))
   * @param pktemin     Database column PkteMin SqlType(SMALLINT), Default(None)
   * @param pktemax     Database column PkteMax SqlType(SMALLINT), Default(None)
   * @param pkte        Database column Pkte SqlType(SMALLINT), Default(None)
   * @param note16      Database column Note1_6 SqlType(FLOAT), Default(None)
   * @param ergnormiert Database column ErgNormiert SqlType(DECIMAL), Default(None) */
  case class FachbewertungRow(bewerberid: String, fachid: Int, noteadcde: Option[String] = Some("NULL"), pktemin: Option[Int] = None, pktemax: Option[Int] = None, pkte: Option[Int] = None, note16: Option[Float] = None, ergnormiert: Option[scala.math.BigDecimal] = None)

  /** GetResult implicit for fetching FachbewertungRow objects using plain SQL queries */
  implicit def GetResultFachbewertungRow(implicit e0: GR[String], e1: GR[Int], e2: GR[Option[String]], e3: GR[Option[Int]], e4: GR[Option[Float]], e5: GR[Option[scala.math.BigDecimal]]): GR[FachbewertungRow] = GR {
    prs =>
      import prs._
      FachbewertungRow.tupled((<<[String], <<[Int], <<?[String], <<?[Int], <<?[Int], <<?[Int], <<?[Float], <<?[scala.math.BigDecimal]))
  }

  /** Table description of table FachBewertung. Objects of this class serve as prototypes for rows in queries. */
  class Fachbewertung(_tableTag: Tag) extends profile.api.Table[FachbewertungRow](_tableTag, Some("stm_zulassung"), "FachBewertung") {
    def * = (bewerberid, fachid, noteadcde, pktemin, pktemax, pkte, note16, ergnormiert) <> (FachbewertungRow.tupled, FachbewertungRow.unapply)

    /** Maps whole row to an option. Useful for outer joins. */
    def ? = ((Rep.Some(bewerberid), Rep.Some(fachid), noteadcde, pktemin, pktemax, pkte, note16, ergnormiert)).shaped.<>({ r => import r._; _1.map(_ => FachbewertungRow.tupled((_1.get, _2.get, _3, _4, _5, _6, _7, _8))) }, (_: Any) => throw new Exception("Inserting into ? projection not supported."))

    /** Database column BewerberID SqlType(VARCHAR), Length(255,true) */
    val bewerberid: Rep[String] = column[String]("BewerberID", O.Length(255, varying = true))
    /** Database column FachID SqlType(SMALLINT) */
    val fachid: Rep[Int] = column[Int]("FachID")
    /** Database column NoteADCDE SqlType(VARCHAR), Length(254,true), Default(Some(NULL)) */
    val noteadcde: Rep[Option[String]] = column[Option[String]]("NoteADCDE", O.Length(254, varying = true), O.Default(Some("NULL")))
    /** Database column PkteMin SqlType(SMALLINT), Default(None) */
    val pktemin: Rep[Option[Int]] = column[Option[Int]]("PkteMin", O.Default(None))
    /** Database column PkteMax SqlType(SMALLINT), Default(None) */
    val pktemax: Rep[Option[Int]] = column[Option[Int]]("PkteMax", O.Default(None))
    /** Database column Pkte SqlType(SMALLINT), Default(None) */
    val pkte: Rep[Option[Int]] = column[Option[Int]]("Pkte", O.Default(None))
    /** Database column Note1_6 SqlType(FLOAT), Default(None) */
    val note16: Rep[Option[Float]] = column[Option[Float]]("Note1_6", O.Default(None))
    /** Database column ErgNormiert SqlType(DECIMAL), Default(None) */
    val ergnormiert: Rep[Option[scala.math.BigDecimal]] = column[Option[scala.math.BigDecimal]]("ErgNormiert", O.Default(None))

    /** Primary key of Fachbewertung (database name FachBewertung_PK) */
    val pk = primaryKey("FachBewertung_PK", (bewerberid, fachid))
  }

  /** Collection-like TableQuery object for table Fachbewertung */
  lazy val Fachbewertung = new TableQuery(tag => new Fachbewertung(tag))

  /** Entity class storing rows of table Fachzusatz
   *
   * @param bewerberid Database column BewerberID SqlType(VARCHAR), Length(255,true)
   * @param zusatz     Database column Zusatz SqlType(VARCHAR), Length(80,true), Default(None) */
  case class FachzusatzRow(bewerberid: String, zusatz: Option[String] = None)

  /** GetResult implicit for fetching FachzusatzRow objects using plain SQL queries */
  implicit def GetResultFachzusatzRow(implicit e0: GR[String], e1: GR[Option[String]]): GR[FachzusatzRow] = GR {
    prs =>
      import prs._
      FachzusatzRow.tupled((<<[String], <<?[String]))
  }

  /** Table description of table FachZusatz. Objects of this class serve as prototypes for rows in queries. */
  class Fachzusatz(_tableTag: Tag) extends profile.api.Table[FachzusatzRow](_tableTag, Some("stm_zulassung"), "FachZusatz") {
    def * = (bewerberid, zusatz) <> (FachzusatzRow.tupled, FachzusatzRow.unapply)

    /** Maps whole row to an option. Useful for outer joins. */
    def ? = ((Rep.Some(bewerberid), zusatz)).shaped.<>({ r => import r._; _1.map(_ => FachzusatzRow.tupled((_1.get, _2))) }, (_: Any) => throw new Exception("Inserting into ? projection not supported."))

    /** Database column BewerberID SqlType(VARCHAR), Length(255,true) */
    val bewerberid: Rep[String] = column[String]("BewerberID", O.Length(255, varying = true))
    /** Database column Zusatz SqlType(VARCHAR), Length(80,true), Default(None) */
    val zusatz: Rep[Option[String]] = column[Option[String]]("Zusatz", O.Length(80, varying = true), O.Default(None))
  }

  /** Collection-like TableQuery object for table Fachzusatz */
  lazy val Fachzusatz = new TableQuery(tag => new Fachzusatz(tag))

  /** Entity class storing rows of table Gutachter
   *
   * @param gutachterid Database column GutachterID SqlType(SMALLINT UNSIGNED), AutoInc, PrimaryKey
   * @param gutachter   Database column Gutachter SqlType(VARCHAR), Length(30,true), Default(None) */
  case class GutachterRow(gutachterid: Int, gutachter: Option[String] = None)

  /** GetResult implicit for fetching GutachterRow objects using plain SQL queries */
  implicit def GetResultGutachterRow(implicit e0: GR[Int], e1: GR[Option[String]]): GR[GutachterRow] = GR {
    prs =>
      import prs._
      GutachterRow.tupled((<<[Int], <<?[String]))
  }

  /** Table description of table Gutachter. Objects of this class serve as prototypes for rows in queries. */
  class Gutachter(_tableTag: Tag) extends profile.api.Table[GutachterRow](_tableTag, Some("stm_zulassung"), "Gutachter") {
    def * = (gutachterid, gutachter) <> (GutachterRow.tupled, GutachterRow.unapply)

    /** Maps whole row to an option. Useful for outer joins. */
    def ? = ((Rep.Some(gutachterid), gutachter)).shaped.<>({ r => import r._; _1.map(_ => GutachterRow.tupled((_1.get, _2))) }, (_: Any) => throw new Exception("Inserting into ? projection not supported."))

    /** Database column GutachterID SqlType(SMALLINT UNSIGNED), AutoInc, PrimaryKey */
    val gutachterid: Rep[Int] = column[Int]("GutachterID", O.AutoInc, O.PrimaryKey)
    /** Database column Gutachter SqlType(VARCHAR), Length(30,true), Default(None) */
    val gutachter: Rep[Option[String]] = column[Option[String]]("Gutachter", O.Length(30, varying = true), O.Default(None))
  }

  /** Collection-like TableQuery object for table Gutachter */
  lazy val Gutachter = new TableQuery(tag => new Gutachter(tag))

  /** Entity class storing rows of table GutachterBewerberid
   *
   * @param gutachterid Database column GutachterID SqlType(SMALLINT)
   * @param bewerberid  Database column BewerberID SqlType(VARCHAR), Length(255,true) */
  case class GutachterBewerberidRow(gutachterid: Int, bewerberid: String)

  /** GetResult implicit for fetching GutachterBewerberidRow objects using plain SQL queries */
  implicit def GetResultGutachterBewerberidRow(implicit e0: GR[Int], e1: GR[String]): GR[GutachterBewerberidRow] = GR {
    prs =>
      import prs._
      GutachterBewerberidRow.tupled((<<[Int], <<[String]))
  }

  /** Table description of table Gutachter_BewerberID. Objects of this class serve as prototypes for rows in queries. */
  class GutachterBewerberid(_tableTag: Tag) extends profile.api.Table[GutachterBewerberidRow](_tableTag, Some("stm_zulassung"), "Gutachter_BewerberID") {
    def * = (gutachterid, bewerberid) <> (GutachterBewerberidRow.tupled, GutachterBewerberidRow.unapply)

    /** Maps whole row to an option. Useful for outer joins. */
    def ? = ((Rep.Some(gutachterid), Rep.Some(bewerberid))).shaped.<>({ r => import r._; _1.map(_ => GutachterBewerberidRow.tupled((_1.get, _2.get))) }, (_: Any) => throw new Exception("Inserting into ? projection not supported."))

    /** Database column GutachterID SqlType(SMALLINT) */
    val gutachterid: Rep[Int] = column[Int]("GutachterID")
    /** Database column BewerberID SqlType(VARCHAR), Length(255,true) */
    val bewerberid: Rep[String] = column[String]("BewerberID", O.Length(255, varying = true))
  }

  /** Collection-like TableQuery object for table GutachterBewerberid */
  lazy val GutachterBewerberid = new TableQuery(tag => new GutachterBewerberid(tag))

  /** Entity class storing rows of table Immatriculation
   *
   * @param bemlang   Database column bemlang SqlType(VARCHAR), PrimaryKey, Length(255,true)
   * @param matrikel  Database column matrikel SqlType(INT)
   * @param izkennung Database column IZKennung SqlType(VARCHAR), Length(10,true), Default(None) */
  case class ImmatriculationRow(bemlang: String, matrikel: Int, izkennung: Option[String] = None)

  /** GetResult implicit for fetching ImmatriculationRow objects using plain SQL queries */
  implicit def GetResultImmatriculationRow(implicit e0: GR[String], e1: GR[Int], e2: GR[Option[String]]): GR[ImmatriculationRow] = GR {
    prs =>
      import prs._
      ImmatriculationRow.tupled((<<[String], <<[Int], <<?[String]))
  }

  /** Table description of table immatriculation. Objects of this class serve as prototypes for rows in queries. */
  class Immatriculation(_tableTag: Tag) extends profile.api.Table[ImmatriculationRow](_tableTag, Some("stm_zulassung"), "immatriculation") {
    def * = (bemlang, matrikel, izkennung) <> (ImmatriculationRow.tupled, ImmatriculationRow.unapply)

    /** Maps whole row to an option. Useful for outer joins. */
    def ? = ((Rep.Some(bemlang), Rep.Some(matrikel), izkennung)).shaped.<>({ r => import r._; _1.map(_ => ImmatriculationRow.tupled((_1.get, _2.get, _3))) }, (_: Any) => throw new Exception("Inserting into ? projection not supported."))

    /** Database column bemlang SqlType(VARCHAR), PrimaryKey, Length(255,true) */
    val bemlang: Rep[String] = column[String]("bemlang", O.PrimaryKey, O.Length(255, varying = true))
    /** Database column matrikel SqlType(INT) */
    val matrikel: Rep[Int] = column[Int]("matrikel")
    /** Database column IZKennung SqlType(VARCHAR), Length(10,true), Default(None) */
    val izkennung: Rep[Option[String]] = column[Option[String]]("IZKennung", O.Length(10, varying = true), O.Default(None))

    /** Uniqueness Index over (matrikel) (database name matrikel_UNIQUE) */
    val index1 = index("matrikel_UNIQUE", matrikel, unique = true)
  }

  /** Collection-like TableQuery object for table Immatriculation */
  lazy val Immatriculation = new TableQuery(tag => new Immatriculation(tag))

  /** Entity class storing rows of table StudBemerkung
   *
   * @param bewerberid Database column BewerberID SqlType(VARCHAR), PrimaryKey, Length(255,true)
   * @param bemerkung  Database column Bemerkung SqlType(VARCHAR), Length(254,true) */
  case class StudBemerkungRow(bewerberid: String, bemerkung: String)

  /** GetResult implicit for fetching StudBemerkungRow objects using plain SQL queries */
  implicit def GetResultStudBemerkungRow(implicit e0: GR[String]): GR[StudBemerkungRow] = GR {
    prs =>
      import prs._
      StudBemerkungRow.tupled((<<[String], <<[String]))
  }

  /** Table description of table Stud_Bemerkung. Objects of this class serve as prototypes for rows in queries. */
  class StudBemerkung(_tableTag: Tag) extends profile.api.Table[StudBemerkungRow](_tableTag, Some("stm_zulassung"), "Stud_Bemerkung") {
    def * = (bewerberid, bemerkung) <> (StudBemerkungRow.tupled, StudBemerkungRow.unapply)

    /** Maps whole row to an option. Useful for outer joins. */
    def ? = ((Rep.Some(bewerberid), Rep.Some(bemerkung))).shaped.<>({ r => import r._; _1.map(_ => StudBemerkungRow.tupled((_1.get, _2.get))) }, (_: Any) => throw new Exception("Inserting into ? projection not supported."))

    /** Database column BewerberID SqlType(VARCHAR), PrimaryKey, Length(255,true) */
    val bewerberid: Rep[String] = column[String]("BewerberID", O.PrimaryKey, O.Length(255, varying = true))
    /** Database column Bemerkung SqlType(VARCHAR), Length(254,true) */
    val bemerkung: Rep[String] = column[String]("Bemerkung", O.Length(254, varying = true))
  }

  /** Collection-like TableQuery object for table StudBemerkung */
  lazy val StudBemerkung = new TableQuery(tag => new StudBemerkung(tag))

  /** Entity class storing rows of table StudBewertung
   *
   * @param bewerberid     Database column BewerberID SqlType(VARCHAR), PrimaryKey, Length(255,true)
   * @param anzahlprofil   Database column AnzahlProfil SqlType(SMALLINT)
   * @param ergnorm        Database column ErgNorm SqlType(FLOAT)
   * @param bewertungszahl Database column Bewertungszahl SqlType(SMALLINT)
   * @param zul            Database column zul SqlType(CHAR), Default(None) */
  case class StudBewertungRow(bewerberid: String, anzahlprofil: Int, ergnorm: Float, bewertungszahl: Int, zul: Option[Char] = None)

  /** GetResult implicit for fetching StudBewertungRow objects using plain SQL queries */
  implicit def GetResultStudBewertungRow(implicit e0: GR[String], e1: GR[Int], e2: GR[Float], e3: GR[Option[Char]]): GR[StudBewertungRow] = GR {
    prs =>
      import prs._
      StudBewertungRow.tupled((<<[String], <<[Int], <<[Float], <<[Int], <<?[Char]))
  }

  /** Table description of table Stud_Bewertung. Objects of this class serve as prototypes for rows in queries. */
  class StudBewertung(_tableTag: Tag) extends profile.api.Table[StudBewertungRow](_tableTag, Some("stm_zulassung"), "Stud_Bewertung") {
    def * = (bewerberid, anzahlprofil, ergnorm, bewertungszahl, zul) <> (StudBewertungRow.tupled, StudBewertungRow.unapply)

    /** Maps whole row to an option. Useful for outer joins. */
    def ? = ((Rep.Some(bewerberid), Rep.Some(anzahlprofil), Rep.Some(ergnorm), Rep.Some(bewertungszahl), zul)).shaped.<>({ r => import r._; _1.map(_ => StudBewertungRow.tupled((_1.get, _2.get, _3.get, _4.get, _5))) }, (_: Any) => throw new Exception("Inserting into ? projection not supported."))

    /** Database column BewerberID SqlType(VARCHAR), PrimaryKey, Length(255,true) */
    val bewerberid: Rep[String] = column[String]("BewerberID", O.PrimaryKey, O.Length(255, varying = true))
    /** Database column AnzahlProfil SqlType(SMALLINT) */
    val anzahlprofil: Rep[Int] = column[Int]("AnzahlProfil")
    /** Database column ErgNorm SqlType(FLOAT) */
    val ergnorm: Rep[Float] = column[Float]("ErgNorm")
    /** Database column Bewertungszahl SqlType(SMALLINT) */
    val bewertungszahl: Rep[Int] = column[Int]("Bewertungszahl")
    /** Database column zul SqlType(CHAR), Default(None) */
    val zul: Rep[Option[Char]] = column[Option[Char]]("zul", O.Default(None))
  }

  /** Collection-like TableQuery object for table StudBewertung */
  lazy val StudBewertung = new TableQuery(tag => new StudBewertung(tag))

  /** Entity class storing rows of table Student
   *
   * @param matrikel   Database column Matrikel SqlType(INT UNSIGNED), Default(None)
   * @param name       Database column Name SqlType(VARCHAR), Length(100,true), Default(None)
   * @param vorname    Database column Vorname SqlType(VARCHAR), Length(100,true), Default(None)
   * @param bewerberid Database column BewerberID SqlType(VARCHAR), PrimaryKey, Length(255,true) */
  case class StudentRow(matrikel: Option[Long] = None, name: Option[String] = None, vorname: Option[String] = None, bewerberid: String)

  /** GetResult implicit for fetching StudentRow objects using plain SQL queries */
  implicit def GetResultStudentRow(implicit e0: GR[Option[Long]], e1: GR[Option[String]], e2: GR[String]): GR[StudentRow] = GR {
    prs =>
      import prs._
      StudentRow.tupled((<<?[Long], <<?[String], <<?[String], <<[String]))
  }

  /** Table description of table Student. Objects of this class serve as prototypes for rows in queries. */
  class Student(_tableTag: Tag) extends profile.api.Table[StudentRow](_tableTag, Some("stm_zulassung"), "Student") {
    def * = (matrikel, name, vorname, bewerberid) <> (StudentRow.tupled, StudentRow.unapply)

    /** Maps whole row to an option. Useful for outer joins. */
    def ? = ((matrikel, name, vorname, Rep.Some(bewerberid))).shaped.<>({ r => import r._; _4.map(_ => StudentRow.tupled((_1, _2, _3, _4.get))) }, (_: Any) => throw new Exception("Inserting into ? projection not supported."))

    /** Database column Matrikel SqlType(INT UNSIGNED), Default(None) */
    val matrikel: Rep[Option[Long]] = column[Option[Long]]("Matrikel", O.Default(None))
    /** Database column Name SqlType(VARCHAR), Length(100,true), Default(None) */
    val name: Rep[Option[String]] = column[Option[String]]("Name", O.Length(100, varying = true), O.Default(None))
    /** Database column Vorname SqlType(VARCHAR), Length(100,true), Default(None) */
    val vorname: Rep[Option[String]] = column[Option[String]]("Vorname", O.Length(100, varying = true), O.Default(None))
    /** Database column BewerberID SqlType(VARCHAR), PrimaryKey, Length(255,true) */
    val bewerberid: Rep[String] = column[String]("BewerberID", O.PrimaryKey, O.Length(255, varying = true))
  }

  /** Collection-like TableQuery object for table Student */
  lazy val Student = new TableQuery(tag => new Student(tag))

  /** Entity class storing rows of table Uni
   *
   * @param uniid   Database column UniID SqlType(INT UNSIGNED), AutoInc, PrimaryKey
   * @param uni     Database column Uni SqlType(VARCHAR), Length(100,true), Default(None)
   * @param faktor  Database column Faktor SqlType(DECIMAL), Default(None)
   * @param country Database column country SqlType(VARCHAR), Length(45,true), Default(None)
   * @param town    Database column town SqlType(VARCHAR), Length(45,true), Default(None) */
  case class UniRow(uniid: Long, uni: Option[String] = None, faktor: Option[scala.math.BigDecimal] = None, country: Option[String] = None, town: Option[String] = None)

  /** GetResult implicit for fetching UniRow objects using plain SQL queries */
  implicit def GetResultUniRow(implicit e0: GR[Long], e1: GR[Option[String]], e2: GR[Option[scala.math.BigDecimal]]): GR[UniRow] = GR {
    prs =>
      import prs._
      UniRow.tupled((<<[Long], <<?[String], <<?[scala.math.BigDecimal], <<?[String], <<?[String]))
  }

  /** Table description of table Uni. Objects of this class serve as prototypes for rows in queries. */
  class Uni(_tableTag: Tag) extends profile.api.Table[UniRow](_tableTag, Some("stm_zulassung"), "Uni") {
    def * = (uniid, uni, faktor, country, town) <> (UniRow.tupled, UniRow.unapply)

    /** Maps whole row to an option. Useful for outer joins. */
    def ? = ((Rep.Some(uniid), uni, faktor, country, town)).shaped.<>({ r => import r._; _1.map(_ => UniRow.tupled((_1.get, _2, _3, _4, _5))) }, (_: Any) => throw new Exception("Inserting into ? projection not supported."))

    /** Database column UniID SqlType(INT UNSIGNED), AutoInc, PrimaryKey */
    val uniid: Rep[Long] = column[Long]("UniID", O.AutoInc, O.PrimaryKey)
    /** Database column Uni SqlType(VARCHAR), Length(100,true), Default(None) */
    val uni: Rep[Option[String]] = column[Option[String]]("Uni", O.Length(100, varying = true), O.Default(None))
    /** Database column Faktor SqlType(DECIMAL), Default(None) */
    val faktor: Rep[Option[scala.math.BigDecimal]] = column[Option[scala.math.BigDecimal]]("Faktor", O.Default(None))
    /** Database column country SqlType(VARCHAR), Length(45,true), Default(None) */
    val country: Rep[Option[String]] = column[Option[String]]("country", O.Length(45, varying = true), O.Default(None))
    /** Database column town SqlType(VARCHAR), Length(45,true), Default(None) */
    val town: Rep[Option[String]] = column[Option[String]]("town", O.Length(45, varying = true), O.Default(None))
  }

  /** Collection-like TableQuery object for table Uni */
  lazy val Uni = new TableQuery(tag => new Uni(tag))

  /** Entity class storing rows of table UniqueId
   *
   * @param stg       Database column Stg SqlType(CHAR), Length(4,false), Default(STM)
   * @param sem       Database column Sem SqlType(TINYINT), Default(1)
   * @param jahr      Database column Jahr SqlType(INT)
   * @param maxUsedId Database column max_used_id SqlType(INT), Default(0) */
  case class UniqueIdRow(stg: String = "STM", sem: Byte = 1, jahr: Int, maxUsedId: Int = 0)

  /** GetResult implicit for fetching UniqueIdRow objects using plain SQL queries */
  implicit def GetResultUniqueIdRow(implicit e0: GR[String], e1: GR[Byte], e2: GR[Int]): GR[UniqueIdRow] = GR {
    prs =>
      import prs._
      UniqueIdRow.tupled((<<[String], <<[Byte], <<[Int], <<[Int]))
  }

  /** Table description of table unique_id. Objects of this class serve as prototypes for rows in queries. */
  class UniqueId(_tableTag: Tag) extends profile.api.Table[UniqueIdRow](_tableTag, Some("stm_zulassung"), "unique_id") {
    def * = (stg, sem, jahr, maxUsedId) <> (UniqueIdRow.tupled, UniqueIdRow.unapply)

    /** Maps whole row to an option. Useful for outer joins. */
    def ? = ((Rep.Some(stg), Rep.Some(sem), Rep.Some(jahr), Rep.Some(maxUsedId))).shaped.<>({ r => import r._; _1.map(_ => UniqueIdRow.tupled((_1.get, _2.get, _3.get, _4.get))) }, (_: Any) => throw new Exception("Inserting into ? projection not supported."))

    /** Database column Stg SqlType(CHAR), Length(4,false), Default(STM) */
    val stg: Rep[String] = column[String]("Stg", O.Length(4, varying = false), O.Default("STM"))
    /** Database column Sem SqlType(TINYINT), Default(1) */
    val sem: Rep[Byte] = column[Byte]("Sem", O.Default(1))
    /** Database column Jahr SqlType(INT) */
    val jahr: Rep[Int] = column[Int]("Jahr")
    /** Database column max_used_id SqlType(INT), Default(0) */
    val maxUsedId: Rep[Int] = column[Int]("max_used_id", O.Default(0))

    /** Primary key of UniqueId (database name unique_id_PK) */
    val pk = primaryKey("unique_id_PK", (stg, sem, jahr))
  }

  /** Collection-like TableQuery object for table UniqueId */
  lazy val UniqueId = new TableQuery(tag => new UniqueId(tag))

  /** Entity class storing rows of table UniStud
   *
   * @param uniid      Database column UniID SqlType(INT UNSIGNED), Default(None)
   * @param bewerberid Database column BewerberID SqlType(VARCHAR), PrimaryKey, Length(255,true), Default(0) */
  case class UniStudRow(uniid: Option[Long] = None, bewerberid: String = "0")

  /** GetResult implicit for fetching UniStudRow objects using plain SQL queries */
  implicit def GetResultUniStudRow(implicit e0: GR[Option[Long]], e1: GR[String]): GR[UniStudRow] = GR {
    prs =>
      import prs._
      UniStudRow.tupled((<<?[Long], <<[String]))
  }

  /** Table description of table Uni_Stud. Objects of this class serve as prototypes for rows in queries. */
  class UniStud(_tableTag: Tag) extends profile.api.Table[UniStudRow](_tableTag, Some("stm_zulassung"), "Uni_Stud") {
    def * = (uniid, bewerberid) <> (UniStudRow.tupled, UniStudRow.unapply)

    /** Maps whole row to an option. Useful for outer joins. */
    def ? = ((uniid, Rep.Some(bewerberid))).shaped.<>({ r => import r._; _2.map(_ => UniStudRow.tupled((_1, _2.get))) }, (_: Any) => throw new Exception("Inserting into ? projection not supported."))

    /** Database column UniID SqlType(INT UNSIGNED), Default(None) */
    val uniid: Rep[Option[Long]] = column[Option[Long]]("UniID", O.Default(None))
    /** Database column BewerberID SqlType(VARCHAR), PrimaryKey, Length(255,true), Default(0) */
    val bewerberid: Rep[String] = column[String]("BewerberID", O.PrimaryKey, O.Length(255, varying = true), O.Default("0"))
  }

  /** Collection-like TableQuery object for table UniStud */
  lazy val UniStud = new TableQuery(tag => new UniStud(tag))

  /** Entity class storing rows of table UserComm
   *
   * @param userName Database column user_name SqlType(VARCHAR), PrimaryKey, Length(15,true)
   * @param commId   Database column comm_id SqlType(TINYINT), Default(None) */
  case class UserCommRow(userName: String, commId: Option[Byte] = None)

  /** GetResult implicit for fetching UserCommRow objects using plain SQL queries */
  implicit def GetResultUserCommRow(implicit e0: GR[String], e1: GR[Option[Byte]]): GR[UserCommRow] = GR {
    prs =>
      import prs._
      UserCommRow.tupled((<<[String], <<?[Byte]))
  }

  /** Table description of table user_comm. Objects of this class serve as prototypes for rows in queries. */
  class UserComm(_tableTag: Tag) extends profile.api.Table[UserCommRow](_tableTag, Some("stm_zulassung"), "user_comm") {
    def * = (userName, commId) <> (UserCommRow.tupled, UserCommRow.unapply)

    /** Maps whole row to an option. Useful for outer joins. */
    def ? = ((Rep.Some(userName), commId)).shaped.<>({ r => import r._; _1.map(_ => UserCommRow.tupled((_1.get, _2))) }, (_: Any) => throw new Exception("Inserting into ? projection not supported."))

    /** Database column user_name SqlType(VARCHAR), PrimaryKey, Length(15,true) */
    val userName: Rep[String] = column[String]("user_name", O.PrimaryKey, O.Length(15, varying = true))
    /** Database column comm_id SqlType(TINYINT), Default(None) */
    val commId: Rep[Option[Byte]] = column[Option[Byte]]("comm_id", O.Default(None))

    /** Uniqueness Index over (commId) (database name comm_id_UNIQUE) */
    val index1 = index("comm_id_UNIQUE", commId, unique = true)
  }

  /** Collection-like TableQuery object for table UserComm */
  lazy val UserComm = new TableQuery(tag => new UserComm(tag))

  /** Entity class storing rows of table UserRoles
   *
   * @param userName Database column user_name SqlType(VARCHAR), Length(15,true)
   * @param roleName Database column role_name SqlType(VARCHAR), Length(15,true) */
  case class UserRolesRow(userName: String, roleName: String)

  /** GetResult implicit for fetching UserRolesRow objects using plain SQL queries */
  implicit def GetResultUserRolesRow(implicit e0: GR[String]): GR[UserRolesRow] = GR {
    prs =>
      import prs._
      UserRolesRow.tupled((<<[String], <<[String]))
  }

  /** Table description of table user_roles. Objects of this class serve as prototypes for rows in queries. */
  class UserRoles(_tableTag: Tag) extends profile.api.Table[UserRolesRow](_tableTag, Some("stm_zulassung"), "user_roles") {
    def * = (userName, roleName) <> (UserRolesRow.tupled, UserRolesRow.unapply)

    /** Maps whole row to an option. Useful for outer joins. */
    def ? = ((Rep.Some(userName), Rep.Some(roleName))).shaped.<>({ r => import r._; _1.map(_ => UserRolesRow.tupled((_1.get, _2.get))) }, (_: Any) => throw new Exception("Inserting into ? projection not supported."))

    /** Database column user_name SqlType(VARCHAR), Length(15,true) */
    val userName: Rep[String] = column[String]("user_name", O.Length(15, varying = true))
    /** Database column role_name SqlType(VARCHAR), Length(15,true) */
    val roleName: Rep[String] = column[String]("role_name", O.Length(15, varying = true))

    /** Primary key of UserRoles (database name user_roles_PK) */
    val pk = primaryKey("user_roles_PK", (userName, roleName))
  }

  /** Collection-like TableQuery object for table UserRoles */
  lazy val UserRoles = new TableQuery(tag => new UserRoles(tag))

  /** Entity class storing rows of table Users
   *
   * @param userName Database column user_name SqlType(VARCHAR), PrimaryKey, Length(15,true)
   * @param userPass Database column user_pass SqlType(VARCHAR), Length(15,true) */
  case class UsersRow(userName: String, userPass: String)

  /** GetResult implicit for fetching UsersRow objects using plain SQL queries */
  implicit def GetResultUsersRow(implicit e0: GR[String]): GR[UsersRow] = GR {
    prs =>
      import prs._
      UsersRow.tupled((<<[String], <<[String]))
  }

  /** Table description of table users. Objects of this class serve as prototypes for rows in queries. */
  class Users(_tableTag: Tag) extends profile.api.Table[UsersRow](_tableTag, Some("stm_zulassung"), "users") {
    def * = (userName, userPass) <> (UsersRow.tupled, UsersRow.unapply)

    /** Maps whole row to an option. Useful for outer joins. */
    def ? = ((Rep.Some(userName), Rep.Some(userPass))).shaped.<>({ r => import r._; _1.map(_ => UsersRow.tupled((_1.get, _2.get))) }, (_: Any) => throw new Exception("Inserting into ? projection not supported."))

    /** Database column user_name SqlType(VARCHAR), PrimaryKey, Length(15,true) */
    val userName: Rep[String] = column[String]("user_name", O.PrimaryKey, O.Length(35, varying = true))
    /** Database column user_pass SqlType(VARCHAR), Length(15,true) */
    val userPass: Rep[String] = column[String]("user_pass", O.Length(128, varying = true))
  }

  /** Collection-like TableQuery object for table Users */
  lazy val Users = new TableQuery(tag => new Users(tag))
}
