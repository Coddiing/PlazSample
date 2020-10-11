package models

// AUTO-GENERATED Slick data model
/** Stand-alone Slick data model for immediate use */
object Tables extends {
  val profile = slick.jdbc.PostgresProfile
} with Tables

/** Slick data model trait for extension, choice of backend or usage in the cake pattern. (Make sure to initialize this late.) */
trait Tables {
  val profile: slick.jdbc.JdbcProfile

  import profile.api._
  import slick.collection.heterogeneous._
  import slick.collection.heterogeneous.syntax._
  // NOTE: GetResult mappers for plain SQL are only generated for tables where Slick knows how to map the types of all columns.
  import slick.jdbc.{GetResult => GR}

  /** DDL for all tables. Call .create to execute. */
  lazy val schema: profile.SchemaDescription = Array(Abschluss.schema, Antr.schema, Auth.schema, Bew.schema, Docs.schema, DocsExtra.schema, Email.schema, Fach.schema, Fachbewertung.schema, Fachzusatz.schema, Gutachter.schema, GutachterBewerberid.schema, Immatriculation.schema, Parameters.schema, StudBemerkung.schema, StudBewertung.schema, Student.schema, Uni.schema, UniqueId.schema, UniStud.schema, UserComm.schema, UserRoles.schema, Users.schema).reduceLeft(_ ++ _)

  @deprecated("Use .schema instead of .ddl", "3.0")
  def ddl = schema

  /** Entity class storing rows of table Abschluss
   *
   * @param bemlang              Database column bemlang SqlType(varchar), PrimaryKey, Length(255,true)
   * @param durchschnitt         Database column durchschnitt SqlType(numeric)
   * @param exmatrikulationdatum Database column exmatrikulationdatum SqlType(date), Default(None) */
  final case class AbschlussRow(bemlang: String, durchschnitt: Option[scala.math.BigDecimal], exmatrikulationdatum: Option[java.sql.Date] = None)

  /** GetResult implicit for fetching AbschlussRow objects using plain SQL queries */
  implicit def GetResultAbschlussRow(implicit e0: GR[String], e1: GR[Option[scala.math.BigDecimal]], e2: GR[Option[java.sql.Date]]): GR[AbschlussRow] = GR {
    prs =>
      import prs._
      AbschlussRow.tupled((<<[String], <<?[scala.math.BigDecimal], <<?[java.sql.Date]))
  }

  /** Table description of table abschluss. Objects of this class serve as prototypes for rows in queries. */
  class Abschluss(_tableTag: Tag) extends profile.api.Table[AbschlussRow](_tableTag, Some("stm_zulassung"), "abschluss") {
    def * = (bemlang, durchschnitt, exmatrikulationdatum) <> (AbschlussRow.tupled, AbschlussRow.unapply)

    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(bemlang), durchschnitt, exmatrikulationdatum).shaped.<>({ r => import r._; _1.map(_ => AbschlussRow.tupled((_1.get, _2, _3))) }, (_: Any) => throw new Exception("Inserting into ? projection not supported."))

    /** Database column bemlang SqlType(varchar), PrimaryKey, Length(255,true) */
    val bemlang: Rep[String] = column[String]("bemlang", O.PrimaryKey, O.Length(255, varying = true))
    /** Database column durchschnitt SqlType(numeric) */
    val durchschnitt: Rep[Option[scala.math.BigDecimal]] = column[Option[scala.math.BigDecimal]]("durchschnitt")
    /** Database column exmatrikulationdatum SqlType(date), Default(None) */
    val exmatrikulationdatum: Rep[Option[java.sql.Date]] = column[Option[java.sql.Date]]("exmatrikulationdatum", O.Default(None))
  }

  /** Collection-like TableQuery object for table Abschluss */
  lazy val Abschluss = new TableQuery(tag => new Abschluss(tag))

  /** Entity class storing rows of table Antr
   *
   * @param bemlang           Database column bemlang SqlType(varchar), PrimaryKey, Length(255,true)
   * @param stg               Database column stg SqlType(bpchar), Length(3,false), Default(STM)
   * @param abschl            Database column abschl SqlType(bpchar), Length(2,false), Default(Some(59))
   * @param stgsem            Database column stgsem SqlType(int2)
   * @param hzbart            Database column hzbart SqlType(bpchar), Length(2,false), Default(None)
   * @param hzbdatum          Database column hzbdatum SqlType(date), Default(None)
   * @param hzbkfzkz          Database column hzbkfzkz SqlType(bpchar), Default(None)
   * @param hzbort            Database column hzbort SqlType(bpchar), Length(4,false), Default(None)
   * @param zusbew2           Database column zusbew2 SqlType(int2), Default(None)
   * @param zusbew1           Database column zusbew1 SqlType(int2), Default(None)
   * @param zulassung         Database column zulassung SqlType(bpchar), Default(None)
   * @param sitzungnr         Database column sitzungnr SqlType(int2), Default(None)
   * @param exportiert        Database column exportiert SqlType(int2)
   * @param ischeckedComplete Database column ischecked_complete SqlType(bool), Default(None)
   * @param bemerkung         Database column bemerkung SqlType(text), Default(None)
   * @param dateZulSent       Database column date_zul_sent SqlType(timestamptz), Default(None) */
  final case class AntrRow(bemlang: String, stg: String = "STM", abschl: Option[String] = Some("59"), stgsem: Option[Short], hzbart: Option[String] = None, hzbdatum: Option[java.sql.Date] = None, hzbkfzkz: Option[Char] = None, hzbort: Option[String] = None, zusbew2: Option[Short] = None, zusbew1: Option[Short] = None, zulassung: Option[Char] = None, sitzungnr: Option[Short] = None, exportiert: Short, ischeckedComplete: Option[Boolean] = None, bemerkung: Option[String] = None, dateZulSent: Option[java.sql.Timestamp] = None)

  /** GetResult implicit for fetching AntrRow objects using plain SQL queries */
  implicit def GetResultAntrRow(implicit e0: GR[String], e1: GR[Option[String]], e2: GR[Option[Short]], e3: GR[Option[java.sql.Date]], e4: GR[Option[Char]], e5: GR[Short], e6: GR[Option[Boolean]], e7: GR[Option[java.sql.Timestamp]]): GR[AntrRow] = GR {
    prs =>
      import prs._
      AntrRow.tupled((<<[String], <<[String], <<?[String], <<?[Short], <<?[String], <<?[java.sql.Date], <<?[Char], <<?[String], <<?[Short], <<?[Short], <<?[Char], <<?[Short], <<[Short], <<?[Boolean], <<?[String], <<?[java.sql.Timestamp]))
  }

  /** Table description of table antr. Objects of this class serve as prototypes for rows in queries. */
  class Antr(_tableTag: Tag) extends profile.api.Table[AntrRow](_tableTag, Some("stm_zulassung"), "antr") {
    def * = (bemlang, stg, abschl, stgsem, hzbart, hzbdatum, hzbkfzkz, hzbort, zusbew2, zusbew1, zulassung, sitzungnr, exportiert, ischeckedComplete, bemerkung, dateZulSent) <> (AntrRow.tupled, AntrRow.unapply)

    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(bemlang), Rep.Some(stg), abschl, stgsem, hzbart, hzbdatum, hzbkfzkz, hzbort, zusbew2, zusbew1, zulassung, sitzungnr, Rep.Some(exportiert), ischeckedComplete, bemerkung, dateZulSent).shaped.<>({ r => import r._; _1.map(_ => AntrRow.tupled((_1.get, _2.get, _3, _4, _5, _6, _7, _8, _9, _10, _11, _12, _13.get, _14, _15, _16))) }, (_: Any) => throw new Exception("Inserting into ? projection not supported."))

    /** Database column bemlang SqlType(varchar), PrimaryKey, Length(255,true) */
    val bemlang: Rep[String] = column[String]("bemlang", O.PrimaryKey, O.Length(255, varying = true))
    /** Database column stg SqlType(bpchar), Length(3,false), Default(STM) */
    val stg: Rep[String] = column[String]("stg", O.Length(3, varying = false), O.Default("STM"))
    /** Database column abschl SqlType(bpchar), Length(2,false), Default(Some(59)) */
    val abschl: Rep[Option[String]] = column[Option[String]]("abschl", O.Length(2, varying = false), O.Default(Some("59")))
    /** Database column stgsem SqlType(int2) */
    val stgsem: Rep[Option[Short]] = column[Option[Short]]("stgsem")
    /** Database column hzbart SqlType(bpchar), Length(2,false), Default(None) */
    val hzbart: Rep[Option[String]] = column[Option[String]]("hzbart", O.Length(2, varying = false), O.Default(None))
    /** Database column hzbdatum SqlType(date), Default(None) */
    val hzbdatum: Rep[Option[java.sql.Date]] = column[Option[java.sql.Date]]("hzbdatum", O.Default(None))
    /** Database column hzbkfzkz SqlType(bpchar), Default(None) */
    val hzbkfzkz: Rep[Option[Char]] = column[Option[Char]]("hzbkfzkz", O.Default(None))
    /** Database column hzbort SqlType(bpchar), Length(4,false), Default(None) */
    val hzbort: Rep[Option[String]] = column[Option[String]]("hzbort", O.Length(4, varying = false), O.Default(None))
    /** Database column zusbew2 SqlType(int2), Default(None) */
    val zusbew2: Rep[Option[Short]] = column[Option[Short]]("zusbew2", O.Default(None))
    /** Database column zusbew1 SqlType(int2), Default(None) */
    val zusbew1: Rep[Option[Short]] = column[Option[Short]]("zusbew1", O.Default(None))
    /** Database column zulassung SqlType(bpchar), Default(None) */
    val zulassung: Rep[Option[Char]] = column[Option[Char]]("zulassung", O.Default(None))
    /** Database column sitzungnr SqlType(int2), Default(None) */
    val sitzungnr: Rep[Option[Short]] = column[Option[Short]]("sitzungnr", O.Default(None))
    /** Database column exportiert SqlType(int2) */
    val exportiert: Rep[Short] = column[Short]("exportiert")
    /** Database column ischecked_complete SqlType(bool), Default(None) */
    val ischeckedComplete: Rep[Option[Boolean]] = column[Option[Boolean]]("ischecked_complete", O.Default(None))
    /** Database column bemerkung SqlType(text), Default(None) */
    val bemerkung: Rep[Option[String]] = column[Option[String]]("bemerkung", O.Default(None))
    /** Database column date_zul_sent SqlType(timestamptz), Default(None) */
    val dateZulSent: Rep[Option[java.sql.Timestamp]] = column[Option[java.sql.Timestamp]]("date_zul_sent", O.Default(None))
  }

  /** Collection-like TableQuery object for table Antr */
  lazy val Antr = new TableQuery(tag => new Antr(tag))

  /** Entity class storing rows of table Auth
   *
   * @param authno  Database column authno SqlType(varchar), PrimaryKey, Length(25,true)
   * @param email   Database column email SqlType(varchar), Length(45,true)
   * @param bemlang Database column bemlang SqlType(varchar), Length(255,true)
   * @param changed Database column changed SqlType(timestamptz), Default(None)
   * @param created Database column created SqlType(timestamptz), Default(None)
   * @param closed  Database column closed SqlType(timestamptz), Default(None) */
  final case class AuthRow(authno: String, email: String, bemlang: Option[String], changed: Option[java.sql.Timestamp] = None, created: Option[java.sql.Timestamp] = None, closed: Option[java.sql.Timestamp] = None)

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
    def ? = (Rep.Some(authno), Rep.Some(email), bemlang, changed, created, closed).shaped.<>({ r => import r._; _1.map(_ => AuthRow.tupled((_1.get, _2.get, _3, _4, _5, _6))) }, (_: Any) => throw new Exception("Inserting into ? projection not supported."))

    /** Database column authno SqlType(varchar), PrimaryKey, Length(25,true) */
    val authno: Rep[String] = column[String]("authno", O.PrimaryKey, O.Length(25, varying = true))
    /** Database column email SqlType(varchar), Length(45,true) */
    val email: Rep[String] = column[String]("email", O.Length(45, varying = true))
    /** Database column bemlang SqlType(varchar), Length(255,true) */
    val bemlang: Rep[Option[String]] = column[Option[String]]("bemlang", O.Length(255, varying = true))
    /** Database column changed SqlType(timestamptz), Default(None) */
    val changed: Rep[Option[java.sql.Timestamp]] = column[Option[java.sql.Timestamp]]("changed", O.Default(None))
    /** Database column created SqlType(timestamptz), Default(None) */
    val created: Rep[Option[java.sql.Timestamp]] = column[Option[java.sql.Timestamp]]("created", O.Default(None))
    /** Database column closed SqlType(timestamptz), Default(None) */
    val closed: Rep[Option[java.sql.Timestamp]] = column[Option[java.sql.Timestamp]]("closed", O.Default(None))

    /** Uniqueness Index over (email) (database name idx_17830_email_unique) */
    val index1 = index("idx_17830_email_unique", email, unique = true)
  }

  /** Collection-like TableQuery object for table Auth */
  lazy val Auth = new TableQuery(tag => new Auth(tag))

  /** Row type of table Bew */
  type BewRow = HCons[String, HCons[String, HCons[String, HCons[String, HCons[Option[String], HCons[String, HCons[Option[java.sql.Date], HCons[Char, HCons[Option[String], HCons[Option[String], HCons[Option[String], HCons[Option[String], HCons[Option[String], HCons[Option[String], HCons[Option[String], HCons[Option[Short], HCons[Option[Char], HCons[Char, HCons[Option[String], HCons[Char, HCons[Option[String], HCons[Option[Char], HCons[Option[Char], HCons[Option[Char], HCons[Option[Char], HCons[Option[Short], HCons[Option[String], HCons[Option[String], HCons[Option[Short], HCons[Option[Short], HCons[Option[Short], HCons[Option[Short], HCons[Option[Char], HCons[Option[Array[Byte]], HCons[Option[String], HCons[Option[String], HCons[Option[String], HCons[Option[String], HCons[Option[String], HCons[Option[String], HCons[Option[String], HCons[Option[java.sql.Date], HCons[Option[java.sql.Date], HCons[Option[String], HCons[Option[String], HCons[Option[java.sql.Date], HCons[Option[java.sql.Date], HNil]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]

  /** Constructor for BewRow providing default values if available in the database schema. */
  def BewRow(bemlang: String = "", anti: String, nachname: String, vorname: String, gebname: Option[String] = None, gebort: String, gebdat: Option[java.sql.Date] = None, geschl: Char, staat: Option[String] = None, pozusatz: Option[String], postrasse: Option[String], poplz: Option[String] = None, poort: Option[String], pokfz: Option[String] = None, potel: Option[String] = None, bishsem: Option[Short] = None, zweitst: Option[Char] = Some('J'), hmkfzkz: Char, hmkfz: Option[String] = None, fehlunt: Char = '-', verarbkz: Option[String] = None, staatkez: Option[Char] = None, berufab: Option[Char] = None, prakt1: Option[Char] = None, sonsttaet: Option[Char] = None, gesadauer: Option[Short] = None, erhskfz: Option[String] = None, erhsart: Option[String] = None, erhssembrd: Option[Short] = None, hssem: Option[Short] = None, urlsem: Option[Short] = None, praxsem: Option[Short] = None, zustimmungAlumni: Option[Char] = None, photo: Option[Array[Byte]] = None, hochschulname: Option[String], hochschulort: Option[String], studiengangname: Option[String], abschluss: Option[String], average: Option[String], bestmark: Option[String], passmark: Option[String], bachstartdate: Option[java.sql.Date] = None, bachenddate: Option[java.sql.Date] = None, brdCourse: Option[String], brdDiploma: Option[String], brdstart: Option[java.sql.Date] = None, brdend: Option[java.sql.Date] = None): BewRow = {
    bemlang :: anti :: nachname :: vorname :: gebname :: gebort :: gebdat :: geschl :: staat :: pozusatz :: postrasse :: poplz :: poort :: pokfz :: potel :: bishsem :: zweitst :: hmkfzkz :: hmkfz :: fehlunt :: verarbkz :: staatkez :: berufab :: prakt1 :: sonsttaet :: gesadauer :: erhskfz :: erhsart :: erhssembrd :: hssem :: urlsem :: praxsem :: zustimmungAlumni :: photo :: hochschulname :: hochschulort :: studiengangname :: abschluss :: average :: bestmark :: passmark :: bachstartdate :: bachenddate :: brdCourse :: brdDiploma :: brdstart :: brdend :: HNil
  }

  /** GetResult implicit for fetching BewRow objects using plain SQL queries */
  implicit def GetResultBewRow(implicit e0: GR[String], e1: GR[Option[String]], e2: GR[Option[java.sql.Date]], e3: GR[Char], e4: GR[Option[Short]], e5: GR[Option[Char]], e6: GR[Option[Array[Byte]]]): GR[BewRow] = GR {
    prs =>
      import prs._
      <<[String] :: <<[String] :: <<[String] :: <<[String] :: <<?[String] :: <<[String] :: <<?[java.sql.Date] :: <<[Char] :: <<?[String] :: <<?[String] :: <<?[String] :: <<?[String] :: <<?[String] :: <<?[String] :: <<?[String] :: <<?[Short] :: <<?[Char] :: <<[Char] :: <<?[String] :: <<[Char] :: <<?[String] :: <<?[Char] :: <<?[Char] :: <<?[Char] :: <<?[Char] :: <<?[Short] :: <<?[String] :: <<?[String] :: <<?[Short] :: <<?[Short] :: <<?[Short] :: <<?[Short] :: <<?[Char] :: <<?[Array[Byte]] :: <<?[String] :: <<?[String] :: <<?[String] :: <<?[String] :: <<?[String] :: <<?[String] :: <<?[String] :: <<?[java.sql.Date] :: <<?[java.sql.Date] :: <<?[String] :: <<?[String] :: <<?[java.sql.Date] :: <<?[java.sql.Date] :: HNil
  }

  /** Table description of table bew. Objects of this class serve as prototypes for rows in queries. */
  class Bew(_tableTag: Tag) extends profile.api.Table[BewRow](_tableTag, Some("stm_zulassung"), "bew") {
    def * = bemlang :: anti :: nachname :: vorname :: gebname :: gebort :: gebdat :: geschl :: staat :: pozusatz :: postrasse :: poplz :: poort :: pokfz :: potel :: bishsem :: zweitst :: hmkfzkz :: hmkfz :: fehlunt :: verarbkz :: staatkez :: berufab :: prakt1 :: sonsttaet :: gesadauer :: erhskfz :: erhsart :: erhssembrd :: hssem :: urlsem :: praxsem :: zustimmungAlumni :: photo :: hochschulname :: hochschulort :: studiengangname :: abschluss :: average :: bestmark :: passmark :: bachstartdate :: bachenddate :: brdCourse :: brdDiploma :: brdstart :: brdend :: HNil

    /** Database column bemlang SqlType(varchar), PrimaryKey, Length(255,true), Default() */
    val bemlang: Rep[String] = column[String]("bemlang", O.PrimaryKey, O.Length(255, varying = true), O.Default(""))
    /** Database column anti SqlType(bpchar), Length(25,false) */
    val anti: Rep[String] = column[String]("anti", O.Length(25, varying = false))
    /** Database column nachname SqlType(bpchar), Length(35,false) */
    val nachname: Rep[String] = column[String]("nachname", O.Length(35, varying = false))
    /** Database column vorname SqlType(bpchar), Length(30,false) */
    val vorname: Rep[String] = column[String]("vorname", O.Length(30, varying = false))
    /** Database column gebname SqlType(bpchar), Length(35,false), Default(None) */
    val gebname: Rep[Option[String]] = column[Option[String]]("gebname", O.Length(35, varying = false), O.Default(None))
    /** Database column gebort SqlType(bpchar), Length(25,false) */
    val gebort: Rep[String] = column[String]("gebort", O.Length(25, varying = false))
    /** Database column gebdat SqlType(date), Default(None) */
    val gebdat: Rep[Option[java.sql.Date]] = column[Option[java.sql.Date]]("gebdat", O.Default(None))
    /** Database column geschl SqlType(bpchar) */
    val geschl: Rep[Char] = column[Char]("geschl")
    /** Database column staat SqlType(bpchar), Length(3,false), Default(None) */
    val staat: Rep[Option[String]] = column[Option[String]]("staat", O.Length(3, varying = false), O.Default(None))
    /** Database column pozusatz SqlType(varchar), Length(255,true) */
    val pozusatz: Rep[Option[String]] = column[Option[String]]("pozusatz", O.Length(255, varying = true))
    /** Database column postrasse SqlType(varchar), Length(255,true) */
    val postrasse: Rep[Option[String]] = column[Option[String]]("postrasse", O.Length(255, varying = true))
    /** Database column poplz SqlType(bpchar), Length(10,false), Default(None) */
    val poplz: Rep[Option[String]] = column[Option[String]]("poplz", O.Length(10, varying = false), O.Default(None))
    /** Database column poort SqlType(varchar), Length(255,true) */
    val poort: Rep[Option[String]] = column[Option[String]]("poort", O.Length(255, varying = true))
    /** Database column pokfz SqlType(bpchar), Length(3,false), Default(None) */
    val pokfz: Rep[Option[String]] = column[Option[String]]("pokfz", O.Length(3, varying = false), O.Default(None))
    /** Database column potel SqlType(bpchar), Length(50,false), Default(None) */
    val potel: Rep[Option[String]] = column[Option[String]]("potel", O.Length(50, varying = false), O.Default(None))
    /** Database column bishsem SqlType(int2), Default(None) */
    val bishsem: Rep[Option[Short]] = column[Option[Short]]("bishsem", O.Default(None))
    /** Database column zweitst SqlType(bpchar), Default(Some(J)) */
    val zweitst: Rep[Option[Char]] = column[Option[Char]]("zweitst", O.Default(Some('J')))
    /** Database column hmkfzkz SqlType(bpchar) */
    val hmkfzkz: Rep[Char] = column[Char]("hmkfzkz")
    /** Database column hmkfz SqlType(bpchar), Length(4,false), Default(None) */
    val hmkfz: Rep[Option[String]] = column[Option[String]]("hmkfz", O.Length(4, varying = false), O.Default(None))
    /** Database column fehlunt SqlType(bpchar), Default(-) */
    val fehlunt: Rep[Char] = column[Char]("fehlunt", O.Default('-'))
    /** Database column verarbkz SqlType(bpchar), Length(2,false), Default(None) */
    val verarbkz: Rep[Option[String]] = column[Option[String]]("verarbkz", O.Length(2, varying = false), O.Default(None))
    /** Database column staatkez SqlType(bpchar), Default(None) */
    val staatkez: Rep[Option[Char]] = column[Option[Char]]("staatkez", O.Default(None))
    /** Database column berufab SqlType(bpchar), Default(None) */
    val berufab: Rep[Option[Char]] = column[Option[Char]]("berufab", O.Default(None))
    /** Database column prakt1 SqlType(bpchar), Default(None) */
    val prakt1: Rep[Option[Char]] = column[Option[Char]]("prakt1", O.Default(None))
    /** Database column sonsttaet SqlType(bpchar), Default(None) */
    val sonsttaet: Rep[Option[Char]] = column[Option[Char]]("sonsttaet", O.Default(None))
    /** Database column gesadauer SqlType(int2), Default(None) */
    val gesadauer: Rep[Option[Short]] = column[Option[Short]]("gesadauer", O.Default(None))
    /** Database column erhskfz SqlType(bpchar), Length(4,false), Default(None) */
    val erhskfz: Rep[Option[String]] = column[Option[String]]("erhskfz", O.Length(4, varying = false), O.Default(None))
    /** Database column erhsart SqlType(bpchar), Length(2,false), Default(None) */
    val erhsart: Rep[Option[String]] = column[Option[String]]("erhsart", O.Length(2, varying = false), O.Default(None))
    /** Database column erhssembrd SqlType(int2), Default(None) */
    val erhssembrd: Rep[Option[Short]] = column[Option[Short]]("erhssembrd", O.Default(None))
    /** Database column hssem SqlType(int2), Default(None) */
    val hssem: Rep[Option[Short]] = column[Option[Short]]("hssem", O.Default(None))
    /** Database column urlsem SqlType(int2), Default(None) */
    val urlsem: Rep[Option[Short]] = column[Option[Short]]("urlsem", O.Default(None))
    /** Database column praxsem SqlType(int2), Default(None) */
    val praxsem: Rep[Option[Short]] = column[Option[Short]]("praxsem", O.Default(None))
    /** Database column zustimmung_alumni SqlType(bpchar), Default(None) */
    val zustimmungAlumni: Rep[Option[Char]] = column[Option[Char]]("zustimmung_alumni", O.Default(None))
    /** Database column photo SqlType(bytea), Default(None) */
    val photo: Rep[Option[Array[Byte]]] = column[Option[Array[Byte]]]("photo", O.Default(None))
    /** Database column hochschulname SqlType(varchar), Length(160,true) */
    val hochschulname: Rep[Option[String]] = column[Option[String]]("hochschulname", O.Length(160, varying = true))
    /** Database column hochschulort SqlType(varchar), Length(255,true) */
    val hochschulort: Rep[Option[String]] = column[Option[String]]("hochschulort", O.Length(255, varying = true))
    /** Database column studiengangname SqlType(varchar), Length(255,true) */
    val studiengangname: Rep[Option[String]] = column[Option[String]]("studiengangname", O.Length(255, varying = true))
    /** Database column abschluss SqlType(varchar), Length(10,true) */
    val abschluss: Rep[Option[String]] = column[Option[String]]("abschluss", O.Length(10, varying = true))
    /** Database column average SqlType(varchar), Length(10,true) */
    val average: Rep[Option[String]] = column[Option[String]]("average", O.Length(10, varying = true))
    /** Database column bestmark SqlType(varchar), Length(10,true) */
    val bestmark: Rep[Option[String]] = column[Option[String]]("bestmark", O.Length(10, varying = true))
    /** Database column passmark SqlType(varchar), Length(10,true) */
    val passmark: Rep[Option[String]] = column[Option[String]]("passmark", O.Length(10, varying = true))
    /** Database column bachstartdate SqlType(date), Default(None) */
    val bachstartdate: Rep[Option[java.sql.Date]] = column[Option[java.sql.Date]]("bachstartdate", O.Default(None))
    /** Database column bachenddate SqlType(date), Default(None) */
    val bachenddate: Rep[Option[java.sql.Date]] = column[Option[java.sql.Date]]("bachenddate", O.Default(None))
    /** Database column brd_course SqlType(varchar), Length(255,true) */
    val brdCourse: Rep[Option[String]] = column[Option[String]]("brd_course", O.Length(255, varying = true))
    /** Database column brd_diploma SqlType(varchar), Length(2,true) */
    val brdDiploma: Rep[Option[String]] = column[Option[String]]("brd_diploma", O.Length(2, varying = true))
    /** Database column brdstart SqlType(date), Default(None) */
    val brdstart: Rep[Option[java.sql.Date]] = column[Option[java.sql.Date]]("brdstart", O.Default(None))
    /** Database column brdend SqlType(date), Default(None) */
    val brdend: Rep[Option[java.sql.Date]] = column[Option[java.sql.Date]]("brdend", O.Default(None))
  }

  /** Collection-like TableQuery object for table Bew */
  lazy val Bew = new TableQuery(tag => new Bew(tag))

  /** Entity class storing rows of table Docs
   *
   * @param bemlang     Database column bemlang SqlType(varchar), PrimaryKey, Length(255,true)
   * @param hzb         Database column hzb SqlType(bytea), Default(None)
   * @param bach        Database column bach SqlType(bytea), Default(None)
   * @param transcript  Database column transcript SqlType(bytea), Default(None)
   * @param engl        Database column engl SqlType(bytea), Default(None)
   * @param cv          Database column cv SqlType(bytea), Default(None)
   * @param rec1        Database column rec1 SqlType(bytea), Default(None)
   * @param rec2        Database column rec2 SqlType(bytea), Default(None)
   * @param motivletter Database column motivletter SqlType(bytea), Default(None) */
  final case class DocsRow(bemlang: String, hzb: Option[Array[Byte]] = None, bach: Option[Array[Byte]] = None, transcript: Option[Array[Byte]] = None, engl: Option[Array[Byte]] = None, cv: Option[Array[Byte]] = None, rec1: Option[Array[Byte]] = None, rec2: Option[Array[Byte]] = None, motivletter: Option[Array[Byte]] = None)

  /** GetResult implicit for fetching DocsRow objects using plain SQL queries */
  implicit def GetResultDocsRow(implicit e0: GR[String], e1: GR[Option[Array[Byte]]]): GR[DocsRow] = GR {
    prs =>
      import prs._
      DocsRow.tupled((<<[String], <<?[Array[Byte]], <<?[Array[Byte]], <<?[Array[Byte]], <<?[Array[Byte]], <<?[Array[Byte]], <<?[Array[Byte]], <<?[Array[Byte]], <<?[Array[Byte]]))
  }

  /** Table description of table docs. Objects of this class serve as prototypes for rows in queries. */
  class Docs(_tableTag: Tag) extends profile.api.Table[DocsRow](_tableTag, Some("stm_zulassung"), "docs") {
    def * = (bemlang, hzb, bach, transcript, engl, cv, rec1, rec2, motivletter) <> (DocsRow.tupled, DocsRow.unapply)

    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(bemlang), hzb, bach, transcript, engl, cv, rec1, rec2, motivletter).shaped.<>({ r => import r._; _1.map(_ => DocsRow.tupled((_1.get, _2, _3, _4, _5, _6, _7, _8, _9))) }, (_: Any) => throw new Exception("Inserting into ? projection not supported."))

    /** Database column bemlang SqlType(varchar), PrimaryKey, Length(255,true) */
    val bemlang: Rep[String] = column[String]("bemlang", O.PrimaryKey, O.Length(255, varying = true))
    /** Database column hzb SqlType(bytea), Default(None) */
    val hzb: Rep[Option[Array[Byte]]] = column[Option[Array[Byte]]]("hzb", O.Default(None))
    /** Database column bach SqlType(bytea), Default(None) */
    val bach: Rep[Option[Array[Byte]]] = column[Option[Array[Byte]]]("bach", O.Default(None))
    /** Database column transcript SqlType(bytea), Default(None) */
    val transcript: Rep[Option[Array[Byte]]] = column[Option[Array[Byte]]]("transcript", O.Default(None))
    /** Database column engl SqlType(bytea), Default(None) */
    val engl: Rep[Option[Array[Byte]]] = column[Option[Array[Byte]]]("engl", O.Default(None))
    /** Database column cv SqlType(bytea), Default(None) */
    val cv: Rep[Option[Array[Byte]]] = column[Option[Array[Byte]]]("cv", O.Default(None))
    /** Database column rec1 SqlType(bytea), Default(None) */
    val rec1: Rep[Option[Array[Byte]]] = column[Option[Array[Byte]]]("rec1", O.Default(None))
    /** Database column rec2 SqlType(bytea), Default(None) */
    val rec2: Rep[Option[Array[Byte]]] = column[Option[Array[Byte]]]("rec2", O.Default(None))
    /** Database column motivletter SqlType(bytea), Default(None) */
    val motivletter: Rep[Option[Array[Byte]]] = column[Option[Array[Byte]]]("motivletter", O.Default(None))
  }

  /** Collection-like TableQuery object for table Docs */
  lazy val Docs = new TableQuery(tag => new Docs(tag))

  /** Entity class storing rows of table DocsExtra
   *
   * @param bemlang     Database column bemlang SqlType(varchar), Length(255,true)
   * @param bezeichnung Database column bezeichnung SqlType(varchar), Length(45,true)
   * @param doc         Database column doc SqlType(bytea) */
  final case class DocsExtraRow(bemlang: String, bezeichnung: String, doc: Array[Byte])

  /** GetResult implicit for fetching DocsExtraRow objects using plain SQL queries */
  implicit def GetResultDocsExtraRow(implicit e0: GR[String], e1: GR[Array[Byte]]): GR[DocsExtraRow] = GR {
    prs =>
      import prs._
      DocsExtraRow.tupled((<<[String], <<[String], <<[Array[Byte]]))
  }

  /** Table description of table docs_extra. Objects of this class serve as prototypes for rows in queries. */
  class DocsExtra(_tableTag: Tag) extends profile.api.Table[DocsExtraRow](_tableTag, Some("stm_zulassung"), "docs_extra") {
    def * = (bemlang, bezeichnung, doc) <> (DocsExtraRow.tupled, DocsExtraRow.unapply)

    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(bemlang), Rep.Some(bezeichnung), Rep.Some(doc)).shaped.<>({ r => import r._; _1.map(_ => DocsExtraRow.tupled((_1.get, _2.get, _3.get))) }, (_: Any) => throw new Exception("Inserting into ? projection not supported."))

    /** Database column bemlang SqlType(varchar), Length(255,true) */
    val bemlang: Rep[String] = column[String]("bemlang", O.Length(255, varying = true))
    /** Database column bezeichnung SqlType(varchar), Length(45,true) */
    val bezeichnung: Rep[String] = column[String]("bezeichnung", O.Length(45, varying = true))
    /** Database column doc SqlType(bytea) */
    val doc: Rep[Array[Byte]] = column[Array[Byte]]("doc")

    /** Primary key of DocsExtra (database name idx_17875_primary) */
    val pk = primaryKey("idx_17875_primary", (bemlang, bezeichnung))

    /** Index over (bemlang) (database name idx_17875_bemlang_ind) */
    val index1 = index("idx_17875_bemlang_ind", bemlang)
    /** Index over (bezeichnung) (database name idx_17875_bez_ind) */
    val index2 = index("idx_17875_bez_ind", bezeichnung)
  }

  /** Collection-like TableQuery object for table DocsExtra */
  lazy val DocsExtra = new TableQuery(tag => new DocsExtra(tag))

  /** Entity class storing rows of table Email
   *
   * @param bemlang Database column bemlang SqlType(varchar), Length(255,true), Default()
   * @param email   Database column email SqlType(varchar), Length(100,true) */
  final case class EmailRow(bemlang: String = "", email: String)

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
    def ? = (Rep.Some(bemlang), Rep.Some(email)).shaped.<>({ r => import r._; _1.map(_ => EmailRow.tupled((_1.get, _2.get))) }, (_: Any) => throw new Exception("Inserting into ? projection not supported."))

    /** Database column bemlang SqlType(varchar), Length(255,true), Default() */
    val bemlang: Rep[String] = column[String]("bemlang", O.Length(255, varying = true), O.Default(""))
    /** Database column email SqlType(varchar), Length(100,true) */
    val email: Rep[String] = column[String]("email", O.Length(100, varying = true))

    /** Index over (bemlang) (database name idx_17881_bemlang) */
    val index1 = index("idx_17881_bemlang", bemlang)
  }

  /** Collection-like TableQuery object for table Email */
  lazy val Email = new TableQuery(tag => new Email(tag))

  /** Entity class storing rows of table Fach
   *
   * @param fachid Database column fachid SqlType(serial), AutoInc, PrimaryKey
   * @param fach   Database column fach SqlType(varchar), Length(30,true) */
  final case class FachRow(fachid: Int, fach: Option[String])

  /** GetResult implicit for fetching FachRow objects using plain SQL queries */
  implicit def GetResultFachRow(implicit e0: GR[Int], e1: GR[Option[String]]): GR[FachRow] = GR {
    prs =>
      import prs._
      FachRow.tupled((<<[Int], <<?[String]))
  }

  /** Table description of table fach. Objects of this class serve as prototypes for rows in queries. */
  class Fach(_tableTag: Tag) extends profile.api.Table[FachRow](_tableTag, Some("stm_zulassung"), "fach") {
    def * = (fachid, fach) <> (FachRow.tupled, FachRow.unapply)

    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(fachid), fach).shaped.<>({ r => import r._; _1.map(_ => FachRow.tupled((_1.get, _2))) }, (_: Any) => throw new Exception("Inserting into ? projection not supported."))

    /** Database column fachid SqlType(serial), AutoInc, PrimaryKey */
    val fachid: Rep[Int] = column[Int]("fachid", O.AutoInc, O.PrimaryKey)
    /** Database column fach SqlType(varchar), Length(30,true) */
    val fach: Rep[Option[String]] = column[Option[String]]("fach", O.Length(30, varying = true))
  }

  /** Collection-like TableQuery object for table Fach */
  lazy val Fach = new TableQuery(tag => new Fach(tag))

  /** Entity class storing rows of table Fachbewertung
   *
   * @param bewerberid  Database column bewerberid SqlType(varchar), Length(255,true)
   * @param fachid      Database column fachid SqlType(int2)
   * @param noteadcde   Database column noteadcde SqlType(varchar), Length(254,true)
   * @param pktemin     Database column pktemin SqlType(int2), Default(None)
   * @param pktemax     Database column pktemax SqlType(int2), Default(None)
   * @param pkte        Database column pkte SqlType(int2), Default(None)
   * @param note16      Database column note1_6 SqlType(float8), Default(None)
   * @param ergnormiert Database column ergnormiert SqlType(numeric) */
  final case class FachbewertungRow(bewerberid: String, fachid: Short, noteadcde: Option[String], pktemin: Option[Short] = None, pktemax: Option[Short] = None, pkte: Option[Short] = None, note16: Option[Double] = None, ergnormiert: Option[scala.math.BigDecimal])

  /** GetResult implicit for fetching FachbewertungRow objects using plain SQL queries */
  implicit def GetResultFachbewertungRow(implicit e0: GR[String], e1: GR[Short], e2: GR[Option[String]], e3: GR[Option[Short]], e4: GR[Option[Double]], e5: GR[Option[scala.math.BigDecimal]]): GR[FachbewertungRow] = GR {
    prs =>
      import prs._
      FachbewertungRow.tupled((<<[String], <<[Short], <<?[String], <<?[Short], <<?[Short], <<?[Short], <<?[Double], <<?[scala.math.BigDecimal]))
  }

  /** Table description of table fachbewertung. Objects of this class serve as prototypes for rows in queries. */
  class Fachbewertung(_tableTag: Tag) extends profile.api.Table[FachbewertungRow](_tableTag, Some("stm_zulassung"), "fachbewertung") {
    def * = (bewerberid, fachid, noteadcde, pktemin, pktemax, pkte, note16, ergnormiert) <> (FachbewertungRow.tupled, FachbewertungRow.unapply)

    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(bewerberid), Rep.Some(fachid), noteadcde, pktemin, pktemax, pkte, note16, ergnormiert).shaped.<>({ r => import r._; _1.map(_ => FachbewertungRow.tupled((_1.get, _2.get, _3, _4, _5, _6, _7, _8))) }, (_: Any) => throw new Exception("Inserting into ? projection not supported."))

    /** Database column bewerberid SqlType(varchar), Length(255,true) */
    val bewerberid: Rep[String] = column[String]("bewerberid", O.Length(255, varying = true))
    /** Database column fachid SqlType(int2) */
    val fachid: Rep[Short] = column[Short]("fachid")
    /** Database column noteadcde SqlType(varchar), Length(254,true) */
    val noteadcde: Rep[Option[String]] = column[Option[String]]("noteadcde", O.Length(254, varying = true))
    /** Database column pktemin SqlType(int2), Default(None) */
    val pktemin: Rep[Option[Short]] = column[Option[Short]]("pktemin", O.Default(None))
    /** Database column pktemax SqlType(int2), Default(None) */
    val pktemax: Rep[Option[Short]] = column[Option[Short]]("pktemax", O.Default(None))
    /** Database column pkte SqlType(int2), Default(None) */
    val pkte: Rep[Option[Short]] = column[Option[Short]]("pkte", O.Default(None))
    /** Database column note1_6 SqlType(float8), Default(None) */
    val note16: Rep[Option[Double]] = column[Option[Double]]("note1_6", O.Default(None))
    /** Database column ergnormiert SqlType(numeric) */
    val ergnormiert: Rep[Option[scala.math.BigDecimal]] = column[Option[scala.math.BigDecimal]]("ergnormiert")

    /** Primary key of Fachbewertung (database name idx_17892_primary) */
    val pk = primaryKey("idx_17892_primary", (bewerberid, fachid))
  }

  /** Collection-like TableQuery object for table Fachbewertung */
  lazy val Fachbewertung = new TableQuery(tag => new Fachbewertung(tag))

  /** Entity class storing rows of table Fachzusatz
   *
   * @param bewerberid Database column bewerberid SqlType(varchar), Length(255,true)
   * @param zusatz     Database column zusatz SqlType(varchar), Length(80,true) */
  final case class FachzusatzRow(bewerberid: String, zusatz: Option[String])

  /** GetResult implicit for fetching FachzusatzRow objects using plain SQL queries */
  implicit def GetResultFachzusatzRow(implicit e0: GR[String], e1: GR[Option[String]]): GR[FachzusatzRow] = GR {
    prs =>
      import prs._
      FachzusatzRow.tupled((<<[String], <<?[String]))
  }

  /** Table description of table fachzusatz. Objects of this class serve as prototypes for rows in queries. */
  class Fachzusatz(_tableTag: Tag) extends profile.api.Table[FachzusatzRow](_tableTag, Some("stm_zulassung"), "fachzusatz") {
    def * = (bewerberid, zusatz) <> (FachzusatzRow.tupled, FachzusatzRow.unapply)

    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(bewerberid), zusatz).shaped.<>({ r => import r._; _1.map(_ => FachzusatzRow.tupled((_1.get, _2))) }, (_: Any) => throw new Exception("Inserting into ? projection not supported."))

    /** Database column bewerberid SqlType(varchar), Length(255,true) */
    val bewerberid: Rep[String] = column[String]("bewerberid", O.Length(255, varying = true))
    /** Database column zusatz SqlType(varchar), Length(80,true) */
    val zusatz: Rep[Option[String]] = column[Option[String]]("zusatz", O.Length(80, varying = true))
  }

  /** Collection-like TableQuery object for table Fachzusatz */
  lazy val Fachzusatz = new TableQuery(tag => new Fachzusatz(tag))

  /** Entity class storing rows of table Gutachter
   *
   * @param gutachterid Database column gutachterid SqlType(serial), AutoInc, PrimaryKey
   * @param gutachter   Database column gutachter SqlType(varchar), Length(30,true) */
  final case class GutachterRow(gutachterid: Int, gutachter: Option[String])

  /** GetResult implicit for fetching GutachterRow objects using plain SQL queries */
  implicit def GetResultGutachterRow(implicit e0: GR[Int], e1: GR[Option[String]]): GR[GutachterRow] = GR {
    prs =>
      import prs._
      GutachterRow.tupled((<<[Int], <<?[String]))
  }

  /** Table description of table gutachter. Objects of this class serve as prototypes for rows in queries. */
  class Gutachter(_tableTag: Tag) extends profile.api.Table[GutachterRow](_tableTag, Some("stm_zulassung"), "gutachter") {
    def * = (gutachterid, gutachter) <> (GutachterRow.tupled, GutachterRow.unapply)

    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(gutachterid), gutachter).shaped.<>({ r => import r._; _1.map(_ => GutachterRow.tupled((_1.get, _2))) }, (_: Any) => throw new Exception("Inserting into ? projection not supported."))

    /** Database column gutachterid SqlType(serial), AutoInc, PrimaryKey */
    val gutachterid: Rep[Int] = column[Int]("gutachterid", O.AutoInc, O.PrimaryKey)
    /** Database column gutachter SqlType(varchar), Length(30,true) */
    val gutachter: Rep[Option[String]] = column[Option[String]]("gutachter", O.Length(30, varying = true))
  }

  /** Collection-like TableQuery object for table Gutachter */
  lazy val Gutachter = new TableQuery(tag => new Gutachter(tag))

  /** Entity class storing rows of table GutachterBewerberid
   *
   * @param gutachterid Database column gutachterid SqlType(int2)
   * @param bewerberid  Database column bewerberid SqlType(varchar), Length(255,true) */
  final case class GutachterBewerberidRow(gutachterid: Short, bewerberid: String)

  /** GetResult implicit for fetching GutachterBewerberidRow objects using plain SQL queries */
  implicit def GetResultGutachterBewerberidRow(implicit e0: GR[Short], e1: GR[String]): GR[GutachterBewerberidRow] = GR {
    prs =>
      import prs._
      GutachterBewerberidRow.tupled((<<[Short], <<[String]))
  }

  /** Table description of table gutachter_bewerberid. Objects of this class serve as prototypes for rows in queries. */
  class GutachterBewerberid(_tableTag: Tag) extends profile.api.Table[GutachterBewerberidRow](_tableTag, Some("stm_zulassung"), "gutachter_bewerberid") {
    def * = (gutachterid, bewerberid) <> (GutachterBewerberidRow.tupled, GutachterBewerberidRow.unapply)

    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(gutachterid), Rep.Some(bewerberid)).shaped.<>({ r => import r._; _1.map(_ => GutachterBewerberidRow.tupled((_1.get, _2.get))) }, (_: Any) => throw new Exception("Inserting into ? projection not supported."))

    /** Database column gutachterid SqlType(int2) */
    val gutachterid: Rep[Short] = column[Short]("gutachterid")
    /** Database column bewerberid SqlType(varchar), Length(255,true) */
    val bewerberid: Rep[String] = column[String]("bewerberid", O.Length(255, varying = true))
  }

  /** Collection-like TableQuery object for table GutachterBewerberid */
  lazy val GutachterBewerberid = new TableQuery(tag => new GutachterBewerberid(tag))

  /** Entity class storing rows of table Immatriculation
   *
   * @param bemlang   Database column bemlang SqlType(varchar), PrimaryKey, Length(255,true)
   * @param matrikel  Database column matrikel SqlType(int8)
   * @param izkennung Database column izkennung SqlType(varchar), Length(10,true) */
  final case class ImmatriculationRow(bemlang: String, matrikel: Long, izkennung: Option[String])

  /** GetResult implicit for fetching ImmatriculationRow objects using plain SQL queries */
  implicit def GetResultImmatriculationRow(implicit e0: GR[String], e1: GR[Long], e2: GR[Option[String]]): GR[ImmatriculationRow] = GR {
    prs =>
      import prs._
      ImmatriculationRow.tupled((<<[String], <<[Long], <<?[String]))
  }

  /** Table description of table immatriculation. Objects of this class serve as prototypes for rows in queries. */
  class Immatriculation(_tableTag: Tag) extends profile.api.Table[ImmatriculationRow](_tableTag, Some("stm_zulassung"), "immatriculation") {
    def * = (bemlang, matrikel, izkennung) <> (ImmatriculationRow.tupled, ImmatriculationRow.unapply)

    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(bemlang), Rep.Some(matrikel), izkennung).shaped.<>({ r => import r._; _1.map(_ => ImmatriculationRow.tupled((_1.get, _2.get, _3))) }, (_: Any) => throw new Exception("Inserting into ? projection not supported."))

    /** Database column bemlang SqlType(varchar), PrimaryKey, Length(255,true) */
    val bemlang: Rep[String] = column[String]("bemlang", O.PrimaryKey, O.Length(255, varying = true))
    /** Database column matrikel SqlType(int8) */
    val matrikel: Rep[Long] = column[Long]("matrikel")
    /** Database column izkennung SqlType(varchar), Length(10,true) */
    val izkennung: Rep[Option[String]] = column[Option[String]]("izkennung", O.Length(10, varying = true))

    /** Uniqueness Index over (matrikel) (database name idx_17914_matrikel_unique) */
    val index1 = index("idx_17914_matrikel_unique", matrikel, unique = true)
  }

  /** Collection-like TableQuery object for table Immatriculation */
  lazy val Immatriculation = new TableQuery(tag => new Immatriculation(tag))

  /** Entity class storing rows of table Parameters
   *
   * @param parameter Database column parameter SqlType(varchar), Length(35,true)
   * @param value     Database column value SqlType(varchar), Length(35,true) */
  final case class ParametersRow(parameter: String, value: String)

  /** GetResult implicit for fetching ParametersRow objects using plain SQL queries */
  implicit def GetResultParametersRow(implicit e0: GR[String]): GR[ParametersRow] = GR {
    prs =>
      import prs._
      ParametersRow.tupled((<<[String], <<[String]))
  }

  /** Table description of table parameters. Objects of this class serve as prototypes for rows in queries. */
  class Parameters(_tableTag: Tag) extends profile.api.Table[ParametersRow](_tableTag, Some("stm_zulassung"), "parameters") {
    def * = (parameter, value) <> (ParametersRow.tupled, ParametersRow.unapply)

    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(parameter), Rep.Some(value)).shaped.<>({ r => import r._; _1.map(_ => ParametersRow.tupled((_1.get, _2.get))) }, (_: Any) => throw new Exception("Inserting into ? projection not supported."))

    /** Database column parameter SqlType(varchar), Length(35,true) */
    val parameter: Rep[String] = column[String]("parameter", O.Length(35, varying = true))
    /** Database column value SqlType(varchar), Length(35,true) */
    val value: Rep[String] = column[String]("value", O.Length(35, varying = true))
  }

  /** Collection-like TableQuery object for table Parameters */
  lazy val Parameters = new TableQuery(tag => new Parameters(tag))

  /** Entity class storing rows of table StudBemerkung
   *
   * @param bewerberid Database column bewerberid SqlType(varchar), PrimaryKey, Length(255,true)
   * @param bemerkung  Database column bemerkung SqlType(varchar), Length(254,true) */
  final case class StudBemerkungRow(bewerberid: String, bemerkung: String)

  /** GetResult implicit for fetching StudBemerkungRow objects using plain SQL queries */
  implicit def GetResultStudBemerkungRow(implicit e0: GR[String]): GR[StudBemerkungRow] = GR {
    prs =>
      import prs._
      StudBemerkungRow.tupled((<<[String], <<[String]))
  }

  /** Table description of table stud_bemerkung. Objects of this class serve as prototypes for rows in queries. */
  class StudBemerkung(_tableTag: Tag) extends profile.api.Table[StudBemerkungRow](_tableTag, Some("stm_zulassung"), "stud_bemerkung") {
    def * = (bewerberid, bemerkung) <> (StudBemerkungRow.tupled, StudBemerkungRow.unapply)

    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(bewerberid), Rep.Some(bemerkung)).shaped.<>({ r => import r._; _1.map(_ => StudBemerkungRow.tupled((_1.get, _2.get))) }, (_: Any) => throw new Exception("Inserting into ? projection not supported."))

    /** Database column bewerberid SqlType(varchar), PrimaryKey, Length(255,true) */
    val bewerberid: Rep[String] = column[String]("bewerberid", O.PrimaryKey, O.Length(255, varying = true))
    /** Database column bemerkung SqlType(varchar), Length(254,true) */
    val bemerkung: Rep[String] = column[String]("bemerkung", O.Length(254, varying = true))
  }

  /** Collection-like TableQuery object for table StudBemerkung */
  lazy val StudBemerkung = new TableQuery(tag => new StudBemerkung(tag))

  /** Entity class storing rows of table StudBewertung
   *
   * @param bewerberid     Database column bewerberid SqlType(varchar), PrimaryKey, Length(255,true)
   * @param anzahlprofil   Database column anzahlprofil SqlType(int2)
   * @param ergnorm        Database column ergnorm SqlType(float8)
   * @param bewertungszahl Database column bewertungszahl SqlType(int2)
   * @param zul            Database column zul SqlType(bpchar), Default(None) */
  final case class StudBewertungRow(bewerberid: String, anzahlprofil: Short, ergnorm: Double, bewertungszahl: Short, zul: Option[Char] = None)

  /** GetResult implicit for fetching StudBewertungRow objects using plain SQL queries */
  implicit def GetResultStudBewertungRow(implicit e0: GR[String], e1: GR[Short], e2: GR[Double], e3: GR[Option[Char]]): GR[StudBewertungRow] = GR {
    prs =>
      import prs._
      StudBewertungRow.tupled((<<[String], <<[Short], <<[Double], <<[Short], <<?[Char]))
  }

  /** Table description of table stud_bewertung. Objects of this class serve as prototypes for rows in queries. */
  class StudBewertung(_tableTag: Tag) extends profile.api.Table[StudBewertungRow](_tableTag, Some("stm_zulassung"), "stud_bewertung") {
    def * = (bewerberid, anzahlprofil, ergnorm, bewertungszahl, zul) <> (StudBewertungRow.tupled, StudBewertungRow.unapply)

    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(bewerberid), Rep.Some(anzahlprofil), Rep.Some(ergnorm), Rep.Some(bewertungszahl), zul).shaped.<>({ r => import r._; _1.map(_ => StudBewertungRow.tupled((_1.get, _2.get, _3.get, _4.get, _5))) }, (_: Any) => throw new Exception("Inserting into ? projection not supported."))

    /** Database column bewerberid SqlType(varchar), PrimaryKey, Length(255,true) */
    val bewerberid: Rep[String] = column[String]("bewerberid", O.PrimaryKey, O.Length(255, varying = true))
    /** Database column anzahlprofil SqlType(int2) */
    val anzahlprofil: Rep[Short] = column[Short]("anzahlprofil")
    /** Database column ergnorm SqlType(float8) */
    val ergnorm: Rep[Double] = column[Double]("ergnorm")
    /** Database column bewertungszahl SqlType(int2) */
    val bewertungszahl: Rep[Short] = column[Short]("bewertungszahl")
    /** Database column zul SqlType(bpchar), Default(None) */
    val zul: Rep[Option[Char]] = column[Option[Char]]("zul", O.Default(None))
  }

  /** Collection-like TableQuery object for table StudBewertung */
  lazy val StudBewertung = new TableQuery(tag => new StudBewertung(tag))

  /** Entity class storing rows of table Student
   *
   * @param matrikel   Database column matrikel SqlType(int8), Default(None)
   * @param name       Database column name SqlType(varchar), Length(100,true)
   * @param vorname    Database column vorname SqlType(varchar), Length(100,true)
   * @param bewerberid Database column bewerberid SqlType(varchar), PrimaryKey, Length(255,true) */
  final case class StudentRow(matrikel: Option[Long] = None, name: Option[String], vorname: Option[String], bewerberid: String)

  /** GetResult implicit for fetching StudentRow objects using plain SQL queries */
  implicit def GetResultStudentRow(implicit e0: GR[Option[Long]], e1: GR[Option[String]], e2: GR[String]): GR[StudentRow] = GR {
    prs =>
      import prs._
      StudentRow.tupled((<<?[Long], <<?[String], <<?[String], <<[String]))
  }

  /** Table description of table student. Objects of this class serve as prototypes for rows in queries. */
  class Student(_tableTag: Tag) extends profile.api.Table[StudentRow](_tableTag, Some("stm_zulassung"), "student") {
    def * = (matrikel, name, vorname, bewerberid) <> (StudentRow.tupled, StudentRow.unapply)

    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (matrikel, name, vorname, Rep.Some(bewerberid)).shaped.<>({ r => import r._; _4.map(_ => StudentRow.tupled((_1, _2, _3, _4.get))) }, (_: Any) => throw new Exception("Inserting into ? projection not supported."))

    /** Database column matrikel SqlType(int8), Default(None) */
    val matrikel: Rep[Option[Long]] = column[Option[Long]]("matrikel", O.Default(None))
    /** Database column name SqlType(varchar), Length(100,true) */
    val name: Rep[Option[String]] = column[Option[String]]("name", O.Length(100, varying = true))
    /** Database column vorname SqlType(varchar), Length(100,true) */
    val vorname: Rep[Option[String]] = column[Option[String]]("vorname", O.Length(100, varying = true))
    /** Database column bewerberid SqlType(varchar), PrimaryKey, Length(255,true) */
    val bewerberid: Rep[String] = column[String]("bewerberid", O.PrimaryKey, O.Length(255, varying = true))
  }

  /** Collection-like TableQuery object for table Student */
  lazy val Student = new TableQuery(tag => new Student(tag))

  /** Entity class storing rows of table Uni
   *
   * @param uniid   Database column uniid SqlType(bigserial), AutoInc, PrimaryKey
   * @param uni     Database column uni SqlType(varchar), Length(100,true)
   * @param faktor  Database column faktor SqlType(numeric)
   * @param country Database column country SqlType(varchar), Length(45,true)
   * @param town    Database column town SqlType(varchar), Length(45,true) */
  final case class UniRow(uniid: Long, uni: Option[String], faktor: Option[scala.math.BigDecimal], country: Option[String], town: Option[String])

  /** GetResult implicit for fetching UniRow objects using plain SQL queries */
  implicit def GetResultUniRow(implicit e0: GR[Long], e1: GR[Option[String]], e2: GR[Option[scala.math.BigDecimal]]): GR[UniRow] = GR {
    prs =>
      import prs._
      UniRow.tupled((<<[Long], <<?[String], <<?[scala.math.BigDecimal], <<?[String], <<?[String]))
  }

  /** Table description of table uni. Objects of this class serve as prototypes for rows in queries. */
  class Uni(_tableTag: Tag) extends profile.api.Table[UniRow](_tableTag, Some("stm_zulassung"), "uni") {
    def * = (uniid, uni, faktor, country, town) <> (UniRow.tupled, UniRow.unapply)

    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(uniid), uni, faktor, country, town).shaped.<>({ r => import r._; _1.map(_ => UniRow.tupled((_1.get, _2, _3, _4, _5))) }, (_: Any) => throw new Exception("Inserting into ? projection not supported."))

    /** Database column uniid SqlType(bigserial), AutoInc, PrimaryKey */
    val uniid: Rep[Long] = column[Long]("uniid", O.AutoInc, O.PrimaryKey)
    /** Database column uni SqlType(varchar), Length(100,true) */
    val uni: Rep[Option[String]] = column[Option[String]]("uni", O.Length(100, varying = true))
    /** Database column faktor SqlType(numeric) */
    val faktor: Rep[Option[scala.math.BigDecimal]] = column[Option[scala.math.BigDecimal]]("faktor")
    /** Database column country SqlType(varchar), Length(45,true) */
    val country: Rep[Option[String]] = column[Option[String]]("country", O.Length(45, varying = true))
    /** Database column town SqlType(varchar), Length(45,true) */
    val town: Rep[Option[String]] = column[Option[String]]("town", O.Length(45, varying = true))
  }

  /** Collection-like TableQuery object for table Uni */
  lazy val Uni = new TableQuery(tag => new Uni(tag))

  /** Entity class storing rows of table UniqueId
   *
   * @param stg       Database column stg SqlType(bpchar), Length(4,false), Default(STM)
   * @param sem       Database column sem SqlType(int2)
   * @param jahr      Database column jahr SqlType(int8)
   * @param maxUsedId Database column max_used_id SqlType(int8), Default(0) */
  final case class UniqueIdRow(stg: String = "STM", sem: Short, jahr: Long, maxUsedId: Long = 0L)

  /** GetResult implicit for fetching UniqueIdRow objects using plain SQL queries */
  implicit def GetResultUniqueIdRow(implicit e0: GR[String], e1: GR[Short], e2: GR[Long]): GR[UniqueIdRow] = GR {
    prs =>
      import prs._
      UniqueIdRow.tupled((<<[String], <<[Short], <<[Long], <<[Long]))
  }

  /** Table description of table unique_id. Objects of this class serve as prototypes for rows in queries. */
  class UniqueId(_tableTag: Tag) extends profile.api.Table[UniqueIdRow](_tableTag, Some("stm_zulassung"), "unique_id") {
    def * = (stg, sem, jahr, maxUsedId) <> (UniqueIdRow.tupled, UniqueIdRow.unapply)

    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(stg), Rep.Some(sem), Rep.Some(jahr), Rep.Some(maxUsedId)).shaped.<>({ r => import r._; _1.map(_ => UniqueIdRow.tupled((_1.get, _2.get, _3.get, _4.get))) }, (_: Any) => throw new Exception("Inserting into ? projection not supported."))

    /** Database column stg SqlType(bpchar), Length(4,false), Default(STM) */
    val stg: Rep[String] = column[String]("stg", O.Length(4, varying = false), O.Default("STM"))
    /** Database column sem SqlType(int2) */
    val sem: Rep[Short] = column[Short]("sem")
    /** Database column jahr SqlType(int8) */
    val jahr: Rep[Long] = column[Long]("jahr")
    /** Database column max_used_id SqlType(int8), Default(0) */
    val maxUsedId: Rep[Long] = column[Long]("max_used_id", O.Default(0L))

    /** Primary key of UniqueId (database name idx_17943_primary) */
    val pk = primaryKey("idx_17943_primary", (stg, sem, jahr))
  }

  /** Collection-like TableQuery object for table UniqueId */
  lazy val UniqueId = new TableQuery(tag => new UniqueId(tag))

  /** Entity class storing rows of table UniStud
   *
   * @param uniid      Database column uniid SqlType(int8), Default(None)
   * @param bewerberid Database column bewerberid SqlType(varchar), PrimaryKey, Length(255,true), Default(0) */
  final case class UniStudRow(uniid: Option[Long] = None, bewerberid: String = "0")

  /** GetResult implicit for fetching UniStudRow objects using plain SQL queries */
  implicit def GetResultUniStudRow(implicit e0: GR[Option[Long]], e1: GR[String]): GR[UniStudRow] = GR {
    prs =>
      import prs._
      UniStudRow.tupled((<<?[Long], <<[String]))
  }

  /** Table description of table uni_stud. Objects of this class serve as prototypes for rows in queries. */
  class UniStud(_tableTag: Tag) extends profile.api.Table[UniStudRow](_tableTag, Some("stm_zulassung"), "uni_stud") {
    def * = (uniid, bewerberid) <> (UniStudRow.tupled, UniStudRow.unapply)

    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (uniid, Rep.Some(bewerberid)).shaped.<>({ r => import r._; _2.map(_ => UniStudRow.tupled((_1, _2.get))) }, (_: Any) => throw new Exception("Inserting into ? projection not supported."))

    /** Database column uniid SqlType(int8), Default(None) */
    val uniid: Rep[Option[Long]] = column[Option[Long]]("uniid", O.Default(None))
    /** Database column bewerberid SqlType(varchar), PrimaryKey, Length(255,true), Default(0) */
    val bewerberid: Rep[String] = column[String]("bewerberid", O.PrimaryKey, O.Length(255, varying = true), O.Default("0"))
  }

  /** Collection-like TableQuery object for table UniStud */
  lazy val UniStud = new TableQuery(tag => new UniStud(tag))

  /** Entity class storing rows of table UserComm
   *
   * @param userName Database column user_name SqlType(varchar), PrimaryKey, Length(15,true)
   * @param commId   Database column comm_id SqlType(int2), Default(None) */
  final case class UserCommRow(userName: String, commId: Option[Short] = None)

  /** GetResult implicit for fetching UserCommRow objects using plain SQL queries */
  implicit def GetResultUserCommRow(implicit e0: GR[String], e1: GR[Option[Short]]): GR[UserCommRow] = GR {
    prs =>
      import prs._
      UserCommRow.tupled((<<[String], <<?[Short]))
  }

  /** Table description of table user_comm. Objects of this class serve as prototypes for rows in queries. */
  class UserComm(_tableTag: Tag) extends profile.api.Table[UserCommRow](_tableTag, Some("stm_zulassung"), "user_comm") {
    def * = (userName, commId) <> (UserCommRow.tupled, UserCommRow.unapply)

    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(userName), commId).shaped.<>({ r => import r._; _1.map(_ => UserCommRow.tupled((_1.get, _2))) }, (_: Any) => throw new Exception("Inserting into ? projection not supported."))

    /** Database column user_name SqlType(varchar), PrimaryKey, Length(15,true) */
    val userName: Rep[String] = column[String]("user_name", O.PrimaryKey, O.Length(15, varying = true))
    /** Database column comm_id SqlType(int2), Default(None) */
    val commId: Rep[Option[Short]] = column[Option[Short]]("comm_id", O.Default(None))

    /** Uniqueness Index over (commId) (database name idx_17956_comm_id_unique) */
    val index1 = index("idx_17956_comm_id_unique", commId, unique = true)
  }

  /** Collection-like TableQuery object for table UserComm */
  lazy val UserComm = new TableQuery(tag => new UserComm(tag))

  /** Entity class storing rows of table UserRoles
   *
   * @param userName Database column user_name SqlType(varchar), Length(15,true)
   * @param roleName Database column role_name SqlType(varchar), Length(15,true) */
  final case class UserRolesRow(userName: String, roleName: String)

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
    def ? = (Rep.Some(userName), Rep.Some(roleName)).shaped.<>({ r => import r._; _1.map(_ => UserRolesRow.tupled((_1.get, _2.get))) }, (_: Any) => throw new Exception("Inserting into ? projection not supported."))

    /** Database column user_name SqlType(varchar), Length(15,true) */
    val userName: Rep[String] = column[String]("user_name", O.Length(15, varying = true))
    /** Database column role_name SqlType(varchar), Length(15,true) */
    val roleName: Rep[String] = column[String]("role_name", O.Length(15, varying = true))

    /** Primary key of UserRoles (database name idx_17959_primary) */
    val pk = primaryKey("idx_17959_primary", (userName, roleName))
  }

  /** Collection-like TableQuery object for table UserRoles */
  lazy val UserRoles = new TableQuery(tag => new UserRoles(tag))

  /** Entity class storing rows of table UsersRow
   *
   * @param userName  Database column user_name SqlType(varchar), PrimaryKey, Length(35,true)
   * @param userPass  Database column user_pass SqlType(varchar), Length(35,true)
   * @param email     Database column email SqlType(varchar), Length(25,true), Default(dummy@nowhere.com)
   * @param created   Database column created SqlType(timestamptz), Default(None)
   * @param lastlogin Database column lastlogin SqlType(timestamptz), Default(None) */
  final case class UsersRow(userName: String, userPass: String, email: String = "dummy@nowhere.com",
                            created: Option[java.sql.Timestamp] = None, lastlogin: Option[java.sql.Timestamp] = None)

  /** GetResult implicit for fetching UsersRow objects using plain SQL queries */
  implicit def GetResultUsersRow(implicit e0: GR[String], e1: GR[Option[java.sql.Timestamp]]): GR[UsersRow] = GR {
    prs =>
      import prs._
      UsersRow.tupled((<<[String], <<[String], <<[String], <<?[java.sql.Timestamp], <<?[java.sql.Timestamp]))
  }

  /** Table description of table users. Objects of this class serve as prototypes for rows in queries. */
  class Users(_tableTag: Tag) extends profile.api.Table[UsersRow](_tableTag, Some("stm_zulassung"), "users") {
    def * = (userName, userPass, email, created, lastlogin) <> (UsersRow.tupled, UsersRow.unapply)

    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(userName), Rep.Some(userPass), Rep.Some(email), created, lastlogin).shaped.<>({ r => import r._; _1.map(_ => UsersRow.tupled((_1.get, _2.get, _3.get, _4, _5))) }, (_: Any) => throw new Exception("Inserting into ? projection not supported."))

    /** Database column user_name SqlType(varchar), PrimaryKey, Length(35,true) */
    val userName: Rep[String] = column[String]("user_name", O.PrimaryKey, O.Length(35, varying = true))
    /** Database column user_pass SqlType(varchar), Length(35,true) */
    val userPass: Rep[String] = column[String]("user_pass", O.Length(128, varying = true))
    /** Database column email SqlType(varchar), Length(25,true), Default(dummy@nowhere.com) */
    val email: Rep[String] = column[String]("email", O.Length(35, varying = true), O.Default("dummy@nowhere.com"))
    /** Database column created SqlType(timestamptz), Default(None) */
    val created: Rep[Option[java.sql.Timestamp]] = column[Option[java.sql.Timestamp]]("created", O.Default(None))
    /** Database column lastlogin SqlType(timestamptz), Default(None) */
    val lastlogin: Rep[Option[java.sql.Timestamp]] = column[Option[java.sql.Timestamp]]("lastlogin", O.Default(None))
  }

  /** Collection-like TableQuery object for table Users */
  lazy val Users = new TableQuery(tag => new Users(tag))
}
