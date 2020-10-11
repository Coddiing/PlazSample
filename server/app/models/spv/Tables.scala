package models.spv

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
  lazy val schema: profile.SchemaDescription = Array(KAbintweb.schema, KAbstgvweb.schema, KAkfz.schema, KHzbart.schema, KIkfz.schema, KIkfzha.schema).reduceLeft(_ ++ _)

  @deprecated("Use .schema instead of .ddl", "3.0")
  def ddl = schema

  /** Entity class storing rows of table KAbintweb
   *
   * @param abint     Database column abint SqlType(bpchar), Length(2,false), Default(None)
   * @param aikz      Database column aikz SqlType(bpchar), Default(None)
   * @param ktxt      Database column ktxt SqlType(bpchar), Length(10,false), Default(None)
   * @param dtxt      Database column dtxt SqlType(bpchar), Length(25,false), Default(None)
   * @param ltxt      Database column ltxt SqlType(bpchar), Length(100,false), Default(None)
   * @param astat     Database column astat SqlType(bpchar), Length(2,false), Default(None)
   * @param hrst      Database column hrst SqlType(bpchar), Length(10,false), Default(None)
   * @param part      Database column part SqlType(bpchar), Length(2,false), Default(None)
   * @param anzstg    Database column anzstg SqlType(int2), Default(None)
   * @param kzfaarray Database column kzfaarray SqlType(bpchar), Length(10,false), Default(None)
   * @param magLaa    Database column mag_laa SqlType(bpchar), Default(None)
   * @param sortkz1   Database column sortkz1 SqlType(bpchar), Length(2,false), Default(None)
   * @param anzstgmin Database column anzstgmin SqlType(int2), Default(None)
   * @param sprache   Database column sprache SqlType(bpchar), Length(3,false), Default(None)
   * @param refabint  Database column refabint SqlType(bpchar), Length(2,false), Default(None) */
  final case class KAbintwebRow(abint: Option[String] = None, aikz: Option[Char] = None, ktxt: Option[String] = None, dtxt: Option[String] = None, ltxt: Option[String] = None, astat: Option[String] = None, hrst: Option[String] = None, part: Option[String] = None, anzstg: Option[Short] = None, kzfaarray: Option[String] = None, magLaa: Option[Char] = None, sortkz1: Option[String] = None, anzstgmin: Option[Short] = None, sprache: Option[String] = None, refabint: Option[String] = None)

  /** GetResult implicit for fetching KAbintwebRow objects using plain SQL queries */
  implicit def GetResultKAbintwebRow(implicit e0: GR[Option[String]], e1: GR[Option[Char]], e2: GR[Option[Short]]): GR[KAbintwebRow] = GR {
    prs =>
      import prs._
      KAbintwebRow.tupled((<<?[String], <<?[Char], <<?[String], <<?[String], <<?[String], <<?[String], <<?[String], <<?[String], <<?[Short], <<?[String], <<?[Char], <<?[String], <<?[Short], <<?[String], <<?[String]))
  }

  /** Table description of table k_abintweb. Objects of this class serve as prototypes for rows in queries. */
  class KAbintweb(_tableTag: Tag) extends profile.api.Table[KAbintwebRow](_tableTag, Some("spv"), "k_abintweb") {
    def * = (abint, aikz, ktxt, dtxt, ltxt, astat, hrst, part, anzstg, kzfaarray, magLaa, sortkz1, anzstgmin, sprache, refabint) <> (KAbintwebRow.tupled, KAbintwebRow.unapply)

    /** Database column abint SqlType(bpchar), Length(2,false), Default(None) */
    val abint: Rep[Option[String]] = column[Option[String]]("abint", O.Length(2, varying = false), O.Default(None))
    /** Database column aikz SqlType(bpchar), Default(None) */
    val aikz: Rep[Option[Char]] = column[Option[Char]]("aikz", O.Default(None))
    /** Database column ktxt SqlType(bpchar), Length(10,false), Default(None) */
    val ktxt: Rep[Option[String]] = column[Option[String]]("ktxt", O.Length(10, varying = false), O.Default(None))
    /** Database column dtxt SqlType(bpchar), Length(25,false), Default(None) */
    val dtxt: Rep[Option[String]] = column[Option[String]]("dtxt", O.Length(25, varying = false), O.Default(None))
    /** Database column ltxt SqlType(bpchar), Length(100,false), Default(None) */
    val ltxt: Rep[Option[String]] = column[Option[String]]("ltxt", O.Length(100, varying = false), O.Default(None))
    /** Database column astat SqlType(bpchar), Length(2,false), Default(None) */
    val astat: Rep[Option[String]] = column[Option[String]]("astat", O.Length(2, varying = false), O.Default(None))
    /** Database column hrst SqlType(bpchar), Length(10,false), Default(None) */
    val hrst: Rep[Option[String]] = column[Option[String]]("hrst", O.Length(10, varying = false), O.Default(None))
    /** Database column part SqlType(bpchar), Length(2,false), Default(None) */
    val part: Rep[Option[String]] = column[Option[String]]("part", O.Length(2, varying = false), O.Default(None))
    /** Database column anzstg SqlType(int2), Default(None) */
    val anzstg: Rep[Option[Short]] = column[Option[Short]]("anzstg", O.Default(None))
    /** Database column kzfaarray SqlType(bpchar), Length(10,false), Default(None) */
    val kzfaarray: Rep[Option[String]] = column[Option[String]]("kzfaarray", O.Length(10, varying = false), O.Default(None))
    /** Database column mag_laa SqlType(bpchar), Default(None) */
    val magLaa: Rep[Option[Char]] = column[Option[Char]]("mag_laa", O.Default(None))
    /** Database column sortkz1 SqlType(bpchar), Length(2,false), Default(None) */
    val sortkz1: Rep[Option[String]] = column[Option[String]]("sortkz1", O.Length(2, varying = false), O.Default(None))
    /** Database column anzstgmin SqlType(int2), Default(None) */
    val anzstgmin: Rep[Option[Short]] = column[Option[Short]]("anzstgmin", O.Default(None))
    /** Database column sprache SqlType(bpchar), Length(3,false), Default(None) */
    val sprache: Rep[Option[String]] = column[Option[String]]("sprache", O.Length(3, varying = false), O.Default(None))
    /** Database column refabint SqlType(bpchar), Length(2,false), Default(None) */
    val refabint: Rep[Option[String]] = column[Option[String]]("refabint", O.Length(2, varying = false), O.Default(None))
  }

  /** Collection-like TableQuery object for table KAbintweb */
  lazy val KAbintweb = new TableQuery(tag => new KAbintweb(tag))

  /** Row type of table KAbstgvweb */
  type KAbstgvwebRow = HCons[Option[String], HCons[Option[Char], HCons[Option[String], HCons[Option[String], HCons[Option[String], HCons[Option[Short], HCons[Option[Short], HCons[Option[Short], HCons[Option[Short], HCons[Option[Short], HCons[Option[Short], HCons[Option[String], HCons[Option[String], HCons[Option[String], HCons[Option[String], HCons[Option[String], HCons[Option[String], HCons[Option[Char], HCons[Option[Char], HCons[Option[Char], HCons[Option[String], HCons[Option[Char], HCons[Option[String], HCons[Option[String], HCons[Option[String], HCons[Option[String], HCons[Option[Short], HCons[Option[Short], HCons[Option[String], HCons[Option[String], HCons[Option[String], HCons[Option[String], HCons[Option[Char], HCons[Option[Char], HCons[Option[String], HCons[Long, HCons[Option[Short], HCons[Option[Short], HNil]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]

  /** Constructor for KAbstgvwebRow providing default values if available in the database schema. */
  def KAbstgvwebRow(abstgv: Option[String] = None, aikz: Option[Char] = None, ktxt: Option[String] = None, dtxt: Option[String] = None, ltxt: Option[String] = None, pversion: Option[Short] = None, frist1: Option[Short] = None, frist2: Option[Short] = None, frist3: Option[Short] = None, frist3Alt: Option[Short] = None, frist4: Option[Short] = None, astat1: Option[String] = None, astat2: Option[String] = None, astgrp: Option[String] = None, prfgamt: Option[String] = None, vglgrp: Option[String] = None, fb: Option[String] = None, stutyp: Option[Char] = None, kzfa: Option[Char] = None, immsemkz: Option[Char] = None, kzfaarray: Option[String] = None, stort: Option[Char] = None, lehreinh: Option[String] = None, stkkurs1: Option[String] = None, stkkurs2: Option[String] = None, stkkurs3: Option[String] = None, prax1fsem: Option[Short] = None, prax2fsem: Option[Short] = None, abschl: Option[String] = None, stg: Option[String] = None, vert: Option[String] = None, schwp: Option[String] = None, stuart: Option[Char] = None, stufrm: Option[Char] = None, abstitel: Option[String] = None, abstgvnr: Long, semGueltigvon: Option[Short] = None, semGueltigbis: Option[Short] = None): KAbstgvwebRow = {
    abstgv :: aikz :: ktxt :: dtxt :: ltxt :: pversion :: frist1 :: frist2 :: frist3 :: frist3Alt :: frist4 :: astat1 :: astat2 :: astgrp :: prfgamt :: vglgrp :: fb :: stutyp :: kzfa :: immsemkz :: kzfaarray :: stort :: lehreinh :: stkkurs1 :: stkkurs2 :: stkkurs3 :: prax1fsem :: prax2fsem :: abschl :: stg :: vert :: schwp :: stuart :: stufrm :: abstitel :: abstgvnr :: semGueltigvon :: semGueltigbis :: HNil
  }

  /** GetResult implicit for fetching KAbstgvwebRow objects using plain SQL queries */
  implicit def GetResultKAbstgvwebRow(implicit e0: GR[Option[String]], e1: GR[Option[Char]], e2: GR[Option[Short]], e3: GR[Long]): GR[KAbstgvwebRow] = GR {
    prs =>
      import prs._
      <<?[String] :: <<?[Char] :: <<?[String] :: <<?[String] :: <<?[String] :: <<?[Short] :: <<?[Short] :: <<?[Short] :: <<?[Short] :: <<?[Short] :: <<?[Short] :: <<?[String] :: <<?[String] :: <<?[String] :: <<?[String] :: <<?[String] :: <<?[String] :: <<?[Char] :: <<?[Char] :: <<?[Char] :: <<?[String] :: <<?[Char] :: <<?[String] :: <<?[String] :: <<?[String] :: <<?[String] :: <<?[Short] :: <<?[Short] :: <<?[String] :: <<?[String] :: <<?[String] :: <<?[String] :: <<?[Char] :: <<?[Char] :: <<?[String] :: <<[Long] :: <<?[Short] :: <<?[Short] :: HNil
  }

  /** Table description of table k_abstgvweb. Objects of this class serve as prototypes for rows in queries. */
  class KAbstgvweb(_tableTag: Tag) extends profile.api.Table[KAbstgvwebRow](_tableTag, Some("spv"), "k_abstgvweb") {
    def * = abstgv :: aikz :: ktxt :: dtxt :: ltxt :: pversion :: frist1 :: frist2 :: frist3 :: frist3Alt :: frist4 :: astat1 :: astat2 :: astgrp :: prfgamt :: vglgrp :: fb :: stutyp :: kzfa :: immsemkz :: kzfaarray :: stort :: lehreinh :: stkkurs1 :: stkkurs2 :: stkkurs3 :: prax1fsem :: prax2fsem :: abschl :: stg :: vert :: schwp :: stuart :: stufrm :: abstitel :: abstgvnr :: semGueltigvon :: semGueltigbis :: HNil

    /** Database column abstgv SqlType(bpchar), Length(10,false), Default(None) */
    val abstgv: Rep[Option[String]] = column[Option[String]]("abstgv", O.Length(10, varying = false), O.Default(None))
    /** Database column aikz SqlType(bpchar), Default(None) */
    val aikz: Rep[Option[Char]] = column[Option[Char]]("aikz", O.Default(None))
    /** Database column ktxt SqlType(bpchar), Length(10,false), Default(None) */
    val ktxt: Rep[Option[String]] = column[Option[String]]("ktxt", O.Length(10, varying = false), O.Default(None))
    /** Database column dtxt SqlType(bpchar), Length(25,false), Default(None) */
    val dtxt: Rep[Option[String]] = column[Option[String]]("dtxt", O.Length(25, varying = false), O.Default(None))
    /** Database column ltxt SqlType(bpchar), Length(50,false), Default(None) */
    val ltxt: Rep[Option[String]] = column[Option[String]]("ltxt", O.Length(50, varying = false), O.Default(None))
    /** Database column pversion SqlType(int2), Default(None) */
    val pversion: Rep[Option[Short]] = column[Option[Short]]("pversion", O.Default(None))
    /** Database column frist1 SqlType(int2), Default(None) */
    val frist1: Rep[Option[Short]] = column[Option[Short]]("frist1", O.Default(None))
    /** Database column frist2 SqlType(int2), Default(None) */
    val frist2: Rep[Option[Short]] = column[Option[Short]]("frist2", O.Default(None))
    /** Database column frist3 SqlType(int2), Default(None) */
    val frist3: Rep[Option[Short]] = column[Option[Short]]("frist3", O.Default(None))
    /** Database column frist3_alt SqlType(int2), Default(None) */
    val frist3Alt: Rep[Option[Short]] = column[Option[Short]]("frist3_alt", O.Default(None))
    /** Database column frist4 SqlType(int2), Default(None) */
    val frist4: Rep[Option[Short]] = column[Option[Short]]("frist4", O.Default(None))
    /** Database column astat1 SqlType(bpchar), Length(2,false), Default(None) */
    val astat1: Rep[Option[String]] = column[Option[String]]("astat1", O.Length(2, varying = false), O.Default(None))
    /** Database column astat2 SqlType(bpchar), Length(4,false), Default(None) */
    val astat2: Rep[Option[String]] = column[Option[String]]("astat2", O.Length(4, varying = false), O.Default(None))
    /** Database column astgrp SqlType(bpchar), Length(3,false), Default(None) */
    val astgrp: Rep[Option[String]] = column[Option[String]]("astgrp", O.Length(3, varying = false), O.Default(None))
    /** Database column prfgamt SqlType(bpchar), Length(7,false), Default(None) */
    val prfgamt: Rep[Option[String]] = column[Option[String]]("prfgamt", O.Length(7, varying = false), O.Default(None))
    /** Database column vglgrp SqlType(bpchar), Length(4,false), Default(None) */
    val vglgrp: Rep[Option[String]] = column[Option[String]]("vglgrp", O.Length(4, varying = false), O.Default(None))
    /** Database column fb SqlType(bpchar), Length(2,false), Default(None) */
    val fb: Rep[Option[String]] = column[Option[String]]("fb", O.Length(2, varying = false), O.Default(None))
    /** Database column stutyp SqlType(bpchar), Default(None) */
    val stutyp: Rep[Option[Char]] = column[Option[Char]]("stutyp", O.Default(None))
    /** Database column kzfa SqlType(bpchar), Default(None) */
    val kzfa: Rep[Option[Char]] = column[Option[Char]]("kzfa", O.Default(None))
    /** Database column immsemkz SqlType(bpchar), Default(None) */
    val immsemkz: Rep[Option[Char]] = column[Option[Char]]("immsemkz", O.Default(None))
    /** Database column kzfaarray SqlType(bpchar), Length(10,false), Default(None) */
    val kzfaarray: Rep[Option[String]] = column[Option[String]]("kzfaarray", O.Length(10, varying = false), O.Default(None))
    /** Database column stort SqlType(bpchar), Default(None) */
    val stort: Rep[Option[Char]] = column[Option[Char]]("stort", O.Default(None))
    /** Database column lehreinh SqlType(bpchar), Length(4,false), Default(None) */
    val lehreinh: Rep[Option[String]] = column[Option[String]]("lehreinh", O.Length(4, varying = false), O.Default(None))
    /** Database column stkkurs1 SqlType(bpchar), Length(2,false), Default(None) */
    val stkkurs1: Rep[Option[String]] = column[Option[String]]("stkkurs1", O.Length(2, varying = false), O.Default(None))
    /** Database column stkkurs2 SqlType(bpchar), Length(2,false), Default(None) */
    val stkkurs2: Rep[Option[String]] = column[Option[String]]("stkkurs2", O.Length(2, varying = false), O.Default(None))
    /** Database column stkkurs3 SqlType(bpchar), Length(2,false), Default(None) */
    val stkkurs3: Rep[Option[String]] = column[Option[String]]("stkkurs3", O.Length(2, varying = false), O.Default(None))
    /** Database column prax1fsem SqlType(int2), Default(None) */
    val prax1fsem: Rep[Option[Short]] = column[Option[Short]]("prax1fsem", O.Default(None))
    /** Database column prax2fsem SqlType(int2), Default(None) */
    val prax2fsem: Rep[Option[Short]] = column[Option[Short]]("prax2fsem", O.Default(None))
    /** Database column abschl SqlType(bpchar), Length(2,false), Default(None) */
    val abschl: Rep[Option[String]] = column[Option[String]]("abschl", O.Length(2, varying = false), O.Default(None))
    /** Database column stg SqlType(bpchar), Length(3,false), Default(None) */
    val stg: Rep[Option[String]] = column[Option[String]]("stg", O.Length(3, varying = false), O.Default(None))
    /** Database column vert SqlType(bpchar), Length(3,false), Default(None) */
    val vert: Rep[Option[String]] = column[Option[String]]("vert", O.Length(3, varying = false), O.Default(None))
    /** Database column schwp SqlType(bpchar), Length(2,false), Default(None) */
    val schwp: Rep[Option[String]] = column[Option[String]]("schwp", O.Length(2, varying = false), O.Default(None))
    /** Database column stuart SqlType(bpchar), Default(None) */
    val stuart: Rep[Option[Char]] = column[Option[Char]]("stuart", O.Default(None))
    /** Database column stufrm SqlType(bpchar), Default(None) */
    val stufrm: Rep[Option[Char]] = column[Option[Char]]("stufrm", O.Default(None))
    /** Database column abstitel SqlType(bpchar), Length(2,false), Default(None) */
    val abstitel: Rep[Option[String]] = column[Option[String]]("abstitel", O.Length(2, varying = false), O.Default(None))
    /** Database column abstgvnr SqlType(bigserial), AutoInc */
    val abstgvnr: Rep[Long] = column[Long]("abstgvnr", O.AutoInc)
    /** Database column sem_gueltigvon SqlType(int2), Default(None) */
    val semGueltigvon: Rep[Option[Short]] = column[Option[Short]]("sem_gueltigvon", O.Default(None))
    /** Database column sem_gueltigbis SqlType(int2), Default(None) */
    val semGueltigbis: Rep[Option[Short]] = column[Option[Short]]("sem_gueltigbis", O.Default(None))

    /** Uniqueness Index over (abstgvnr) (database name idx_18038_abstgvnr) */
    val index1 = index("idx_18038_abstgvnr", abstgvnr :: HNil, unique = true)
  }

  /** Collection-like TableQuery object for table KAbstgvweb */
  lazy val KAbstgvweb = new TableQuery(tag => new KAbstgvweb(tag))

  /** Entity class storing rows of table KAkfz
   *
   * @param akfz                 Database column akfz SqlType(bpchar), Length(3,false)
   * @param aikz                 Database column aikz SqlType(bpchar)
   * @param ktxt                 Database column ktxt SqlType(bpchar), Length(10,false)
   * @param dtxt                 Database column dtxt SqlType(bpchar), Length(25,false)
   * @param ltxt                 Database column ltxt SqlType(bpchar), Length(255,false)
   * @param astat                Database column astat SqlType(bpchar), Length(3,false)
   * @param erdteil              Database column erdteil SqlType(bpchar), Length(4,false)
   * @param egmitgl              Database column egmitgl SqlType(bpchar)
   * @param isoCode              Database column iso_code SqlType(bpchar), Length(2,false)
   * @param sprache              Database column sprache SqlType(bpchar), Length(3,false)
   * @param refakfz              Database column refakfz SqlType(bpchar), Length(3,false)
   * @param oecd                 Database column oecd SqlType(bpchar)
   * @param staatsangehoerigkeit Database column staatsangehoerigkeit SqlType(bpchar), Length(50,false) */
  final case class KAkfzRow(akfz: String, aikz: Char, ktxt: String, dtxt: String, ltxt: String, astat: String, erdteil: String, egmitgl: Char, isoCode: String, sprache: String, refakfz: String, oecd: Char, staatsangehoerigkeit: String)

  /** GetResult implicit for fetching KAkfzRow objects using plain SQL queries */
  implicit def GetResultKAkfzRow(implicit e0: GR[String], e1: GR[Char]): GR[KAkfzRow] = GR {
    prs =>
      import prs._
      KAkfzRow.tupled((<<[String], <<[Char], <<[String], <<[String], <<[String], <<[String], <<[String], <<[Char], <<[String], <<[String], <<[String], <<[Char], <<[String]))
  }

  /** Table description of table k_akfz. Objects of this class serve as prototypes for rows in queries. */
  class KAkfz(_tableTag: Tag) extends profile.api.Table[KAkfzRow](_tableTag, Some("spv"), "k_akfz") {
    def * = (akfz, aikz, ktxt, dtxt, ltxt, astat, erdteil, egmitgl, isoCode, sprache, refakfz, oecd, staatsangehoerigkeit) <> (KAkfzRow.tupled, KAkfzRow.unapply)

    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(akfz), Rep.Some(aikz), Rep.Some(ktxt), Rep.Some(dtxt), Rep.Some(ltxt), Rep.Some(astat), Rep.Some(erdteil), Rep.Some(egmitgl), Rep.Some(isoCode), Rep.Some(sprache), Rep.Some(refakfz), Rep.Some(oecd), Rep.Some(staatsangehoerigkeit)).shaped.<>({ r => import r._; _1.map(_ => KAkfzRow.tupled((_1.get, _2.get, _3.get, _4.get, _5.get, _6.get, _7.get, _8.get, _9.get, _10.get, _11.get, _12.get, _13.get))) }, (_: Any) => throw new Exception("Inserting into ? projection not supported."))

    /** Database column akfz SqlType(bpchar), Length(3,false) */
    val akfz: Rep[String] = column[String]("akfz", O.Length(3, varying = false))
    /** Database column aikz SqlType(bpchar) */
    val aikz: Rep[Char] = column[Char]("aikz")
    /** Database column ktxt SqlType(bpchar), Length(10,false) */
    val ktxt: Rep[String] = column[String]("ktxt", O.Length(10, varying = false))
    /** Database column dtxt SqlType(bpchar), Length(25,false) */
    val dtxt: Rep[String] = column[String]("dtxt", O.Length(25, varying = false))
    /** Database column ltxt SqlType(bpchar), Length(255,false) */
    val ltxt: Rep[String] = column[String]("ltxt", O.Length(255, varying = false))
    /** Database column astat SqlType(bpchar), Length(3,false) */
    val astat: Rep[String] = column[String]("astat", O.Length(3, varying = false))
    /** Database column erdteil SqlType(bpchar), Length(4,false) */
    val erdteil: Rep[String] = column[String]("erdteil", O.Length(4, varying = false))
    /** Database column egmitgl SqlType(bpchar) */
    val egmitgl: Rep[Char] = column[Char]("egmitgl")
    /** Database column iso_code SqlType(bpchar), Length(2,false) */
    val isoCode: Rep[String] = column[String]("iso_code", O.Length(2, varying = false))
    /** Database column sprache SqlType(bpchar), Length(3,false) */
    val sprache: Rep[String] = column[String]("sprache", O.Length(3, varying = false))
    /** Database column refakfz SqlType(bpchar), Length(3,false) */
    val refakfz: Rep[String] = column[String]("refakfz", O.Length(3, varying = false))
    /** Database column oecd SqlType(bpchar) */
    val oecd: Rep[Char] = column[Char]("oecd")
    /** Database column staatsangehoerigkeit SqlType(bpchar), Length(50,false) */
    val staatsangehoerigkeit: Rep[String] = column[String]("staatsangehoerigkeit", O.Length(50, varying = false))
  }

  /** Collection-like TableQuery object for table KAkfz */
  lazy val KAkfz = new TableQuery(tag => new KAkfz(tag))

  /** Entity class storing rows of table KHzbart
   *
   * @param hzbart    Database column hzbart SqlType(bpchar), Length(2,false), Default(None)
   * @param aikz      Database column aikz SqlType(bpchar), Default(None)
   * @param ktxt      Database column ktxt SqlType(bpchar), Length(10,false), Default(None)
   * @param dtxt      Database column dtxt SqlType(bpchar), Length(25,false), Default(None)
   * @param ltxt      Database column ltxt SqlType(bpchar), Length(255,false), Default(None)
   * @param astat     Database column astat SqlType(bpchar), Length(2,false), Default(None)
   * @param bonussem  Database column bonussem SqlType(int2), Default(None)
   * @param autohzbwd Database column autohzbwd SqlType(bpchar), Default(None) */
  final case class KHzbartRow(hzbart: Option[String] = None, aikz: Option[Char] = None, ktxt: Option[String] = None, dtxt: Option[String] = None, ltxt: Option[String] = None, astat: Option[String] = None, bonussem: Option[Short] = None, autohzbwd: Option[Char] = None)

  /** GetResult implicit for fetching KHzbartRow objects using plain SQL queries */
  implicit def GetResultKHzbartRow(implicit e0: GR[Option[String]], e1: GR[Option[Char]], e2: GR[Option[Short]]): GR[KHzbartRow] = GR {
    prs =>
      import prs._
      KHzbartRow.tupled((<<?[String], <<?[Char], <<?[String], <<?[String], <<?[String], <<?[String], <<?[Short], <<?[Char]))
  }

  /** Table description of table k_hzbart. Objects of this class serve as prototypes for rows in queries. */
  class KHzbart(_tableTag: Tag) extends profile.api.Table[KHzbartRow](_tableTag, Some("spv"), "k_hzbart") {
    def * = (hzbart, aikz, ktxt, dtxt, ltxt, astat, bonussem, autohzbwd) <> (KHzbartRow.tupled, KHzbartRow.unapply)

    /** Database column hzbart SqlType(bpchar), Length(2,false), Default(None) */
    val hzbart: Rep[Option[String]] = column[Option[String]]("hzbart", O.Length(2, varying = false), O.Default(None))
    /** Database column aikz SqlType(bpchar), Default(None) */
    val aikz: Rep[Option[Char]] = column[Option[Char]]("aikz", O.Default(None))
    /** Database column ktxt SqlType(bpchar), Length(10,false), Default(None) */
    val ktxt: Rep[Option[String]] = column[Option[String]]("ktxt", O.Length(10, varying = false), O.Default(None))
    /** Database column dtxt SqlType(bpchar), Length(25,false), Default(None) */
    val dtxt: Rep[Option[String]] = column[Option[String]]("dtxt", O.Length(25, varying = false), O.Default(None))
    /** Database column ltxt SqlType(bpchar), Length(255,false), Default(None) */
    val ltxt: Rep[Option[String]] = column[Option[String]]("ltxt", O.Length(255, varying = false), O.Default(None))
    /** Database column astat SqlType(bpchar), Length(2,false), Default(None) */
    val astat: Rep[Option[String]] = column[Option[String]]("astat", O.Length(2, varying = false), O.Default(None))
    /** Database column bonussem SqlType(int2), Default(None) */
    val bonussem: Rep[Option[Short]] = column[Option[Short]]("bonussem", O.Default(None))
    /** Database column autohzbwd SqlType(bpchar), Default(None) */
    val autohzbwd: Rep[Option[Char]] = column[Option[Char]]("autohzbwd", O.Default(None))
  }

  /** Collection-like TableQuery object for table KHzbart */
  lazy val KHzbart = new TableQuery(tag => new KHzbart(tag))

  /** Entity class storing rows of table KIkfz
   *
   * @param ikfz  Database column ikfz SqlType(bpchar), Length(4,false), Default(None)
   * @param aikz  Database column aikz SqlType(bpchar), Default(None)
   * @param ktxt  Database column ktxt SqlType(bpchar), Length(10,false), Default(None)
   * @param dtxt  Database column dtxt SqlType(bpchar), Length(25,false), Default(None)
   * @param ltxt  Database column ltxt SqlType(bpchar), Length(255,false), Default(None)
   * @param astat Database column astat SqlType(bpchar), Length(5,false), Default(None)
   * @param bland Database column bland SqlType(bpchar), Length(2,false), Default(None) */
  final case class KIkfzRow(ikfz: Option[String] = None, aikz: Option[Char] = None, ktxt: Option[String] = None, dtxt: Option[String] = None, ltxt: Option[String] = None, astat: Option[String] = None, bland: Option[String] = None)

  /** GetResult implicit for fetching KIkfzRow objects using plain SQL queries */
  implicit def GetResultKIkfzRow(implicit e0: GR[Option[String]], e1: GR[Option[Char]]): GR[KIkfzRow] = GR {
    prs =>
      import prs._
      KIkfzRow.tupled((<<?[String], <<?[Char], <<?[String], <<?[String], <<?[String], <<?[String], <<?[String]))
  }

  /** Table description of table k_ikfz. Objects of this class serve as prototypes for rows in queries. */
  class KIkfz(_tableTag: Tag) extends profile.api.Table[KIkfzRow](_tableTag, Some("spv"), "k_ikfz") {
    def * = (ikfz, aikz, ktxt, dtxt, ltxt, astat, bland) <> (KIkfzRow.tupled, KIkfzRow.unapply)

    /** Database column ikfz SqlType(bpchar), Length(4,false), Default(None) */
    val ikfz: Rep[Option[String]] = column[Option[String]]("ikfz", O.Length(4, varying = false), O.Default(None))
    /** Database column aikz SqlType(bpchar), Default(None) */
    val aikz: Rep[Option[Char]] = column[Option[Char]]("aikz", O.Default(None))
    /** Database column ktxt SqlType(bpchar), Length(10,false), Default(None) */
    val ktxt: Rep[Option[String]] = column[Option[String]]("ktxt", O.Length(10, varying = false), O.Default(None))
    /** Database column dtxt SqlType(bpchar), Length(25,false), Default(None) */
    val dtxt: Rep[Option[String]] = column[Option[String]]("dtxt", O.Length(25, varying = false), O.Default(None))
    /** Database column ltxt SqlType(bpchar), Length(255,false), Default(None) */
    val ltxt: Rep[Option[String]] = column[Option[String]]("ltxt", O.Length(255, varying = false), O.Default(None))
    /** Database column astat SqlType(bpchar), Length(5,false), Default(None) */
    val astat: Rep[Option[String]] = column[Option[String]]("astat", O.Length(5, varying = false), O.Default(None))
    /** Database column bland SqlType(bpchar), Length(2,false), Default(None) */
    val bland: Rep[Option[String]] = column[Option[String]]("bland", O.Length(2, varying = false), O.Default(None))
  }

  /** Collection-like TableQuery object for table KIkfz */
  lazy val KIkfz = new TableQuery(tag => new KIkfz(tag))

  /** Entity class storing rows of table KIkfzha
   *
   * @param ikfzha   Database column ikfzha SqlType(bpchar), Length(6,false), Default(None)
   * @param aikz     Database column aikz SqlType(bpchar), Default(None)
   * @param ktxt     Database column ktxt SqlType(bpchar), Length(10,false), Default(None)
   * @param dtxt     Database column dtxt SqlType(bpchar), Length(25,false), Default(None)
   * @param ltxt     Database column ltxt SqlType(bpchar), Length(255,false), Default(None)
   * @param astat    Database column astat SqlType(bpchar), Length(4,false), Default(None)
   * @param hsbetrnr Database column hsbetrnr SqlType(bpchar), Length(20,false), Default(None) */
  final case class KIkfzhaRow(ikfzha: Option[String] = None, aikz: Option[Char] = None, ktxt: Option[String] = None, dtxt: Option[String] = None, ltxt: Option[String] = None, astat: Option[String] = None, hsbetrnr: Option[String] = None)

  /** GetResult implicit for fetching KIkfzhaRow objects using plain SQL queries */
  implicit def GetResultKIkfzhaRow(implicit e0: GR[Option[String]], e1: GR[Option[Char]]): GR[KIkfzhaRow] = GR {
    prs =>
      import prs._
      KIkfzhaRow.tupled((<<?[String], <<?[Char], <<?[String], <<?[String], <<?[String], <<?[String], <<?[String]))
  }

  /** Table description of table k_ikfzha. Objects of this class serve as prototypes for rows in queries. */
  class KIkfzha(_tableTag: Tag) extends profile.api.Table[KIkfzhaRow](_tableTag, Some("spv"), "k_ikfzha") {
    def * = (ikfzha, aikz, ktxt, dtxt, ltxt, astat, hsbetrnr) <> (KIkfzhaRow.tupled, KIkfzhaRow.unapply)

    /** Database column ikfzha SqlType(bpchar), Length(6,false), Default(None) */
    val ikfzha: Rep[Option[String]] = column[Option[String]]("ikfzha", O.Length(6, varying = false), O.Default(None))
    /** Database column aikz SqlType(bpchar), Default(None) */
    val aikz: Rep[Option[Char]] = column[Option[Char]]("aikz", O.Default(None))
    /** Database column ktxt SqlType(bpchar), Length(10,false), Default(None) */
    val ktxt: Rep[Option[String]] = column[Option[String]]("ktxt", O.Length(10, varying = false), O.Default(None))
    /** Database column dtxt SqlType(bpchar), Length(25,false), Default(None) */
    val dtxt: Rep[Option[String]] = column[Option[String]]("dtxt", O.Length(25, varying = false), O.Default(None))
    /** Database column ltxt SqlType(bpchar), Length(255,false), Default(None) */
    val ltxt: Rep[Option[String]] = column[Option[String]]("ltxt", O.Length(255, varying = false), O.Default(None))
    /** Database column astat SqlType(bpchar), Length(4,false), Default(None) */
    val astat: Rep[Option[String]] = column[Option[String]]("astat", O.Length(4, varying = false), O.Default(None))
    /** Database column hsbetrnr SqlType(bpchar), Length(20,false), Default(None) */
    val hsbetrnr: Rep[Option[String]] = column[Option[String]]("hsbetrnr", O.Length(20, varying = false), O.Default(None))
  }

  /** Collection-like TableQuery object for table KIkfzha */
  lazy val KIkfzha = new TableQuery(tag => new KIkfzha(tag))
}
