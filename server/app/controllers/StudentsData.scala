package controllers

import java.sql.Date
import java.util.Calendar

class StudentsData  {

  /**
   * Data Storage Class for the application data.
   */

  /**
   * Data used in application but not stored in bew table.
   */
  protected var authNo: String = "" // AuthNo for defining which Student is being looked at.

  protected var sem = 0 // which sem do we apply for.

  protected var year = 0 // which year do we apply for.


  /*
   * Define data stored in bew or antr tables.
   */ protected var bemlang: String = "1104edf"
  protected var anti: String = ""
  protected var nachname: String = "Uzochukwu"
  protected var vorname: String = "Victory"
  protected var gebname: String = ""
  protected var gebort: String = ""
  protected var gebdat: String = ""
  protected var geschl: String = ""
  protected var staat: String = "Nigeria"
  protected var pozusatz: String = ""
  protected var postrasse: String = ""
  protected var poplz: String = ""
  protected var poort: String = ""
  protected var pokfz: String = ""
  protected var potel: String = ""
  protected var bishsem = 0
  protected var hmkfzkz: String = ""
  protected var hmkfz: String = ""
  protected var fehlunt: String = ""
  protected var verarbkz: String = ""
  protected var staatkez: String = ""
  protected var berufab: String = ""
  protected var prakt1: String = ""
  protected var sonsttaet: String = ""
  protected var gesadauer = 0
  protected var erhskfz: String = ""
  protected var erhsart: String = ""
  protected var erhssembrd = 0
  protected var hssem = 0
  protected var urlsem = 0
  protected var praxsem = 0
  protected var email: String = ""
  protected var stg: String = ""
  protected var hzbart: String = ""
  protected var hzbdatum: String = ""
  protected var hzbkfzkz: String = ""
  protected var hzbort: String = ""
  protected var zusbew2 = 0
  protected var zusbew1 = 0
  protected var Zulassung: String = ""
  protected var hochschulname: String = ""
  protected var hochschulort: String = ""
  protected var studiengangname: String = ""
  protected var abschluss: String = ""
  protected var average: String = ""
  protected var bestmark: String = ""
  protected var passmark: String = ""
  protected var bachstartdate: String = ""
  protected var bachenddate: String = ""
  protected var brdcourse: String = ""
  protected var brddiploma: String = ""
  protected var brdstartdate: String = ""
  protected var brdenddate: String = ""
  protected var sitzungNr = 0
  protected var isChecked = 1
  protected var bemerkung: String = "99"
  protected var date_sul_sent: String = ""
  protected var bezeichnung: String = ""
  protected var bemlangextra: String = ""


  /*
   * Are the data defined?
   */ protected var isbemlangextra = false
  protected var isbemlang = false
  protected var isanti = false
  protected var isnachname = false
  protected var isvorname = false
  protected var isgebname = false
  protected var isgebort = false
  protected var isgebdat = false
  protected var isgeschl = false
  protected var isstaat = false
  protected var ispozusatz = false
  protected var ispostrasse = false
  protected var ispoplz = false
  protected var ispoort = false
  protected var ispokfz = false
  protected var ispotel = false
  protected var isbishsem = false
  protected var ishmkfzkz = false
  protected var ishmkfz = false
  protected var isfehlunt = false
  protected var isverarbkz = false
  protected var isstaatkez = false
  protected var isberufab = false
  protected var isprakt1 = false
  protected var issonsttaet = false
  protected var isgesadauer = false
  protected var iserhskfz = false
  protected var iserhsart = false
  protected var iserhssembrd = false
  protected var ishssem = false
  protected var isurlsem = false
  protected var ispraxsem = false
  protected var isemail = false
  protected var isstg = false
  protected var ishzbart = false
  protected var ishzbdatum = false
  protected var ishzbkfzkz = false
  protected var ishzbort = false
  protected var iszusbew2 = false
  protected var iszusbew1 = false
  protected var isZulassung = false
  protected var isHochschulname = false
  protected var isHochschulort = false
  protected var isStudiengangname = false
  protected var isAbschluss = false
  protected var isAverage = false
  protected var isBestmark = false
  protected var isPassmark = false
  protected var isbachstartdate = false
  protected var isbachenddate = false
  protected var isbrdcourse = false
  protected var isbrddiploma = false
  protected var isbrdstartdate = false
  protected var isbrdenddate = false
  protected var issitzungNr = false
  protected var isisChecked = false
  protected var isbemerkung = false
  protected var isdate_sul_sent = false
  protected var isbezeichnung = false


  /**
   * This little helper just ignores a "" in result
   *
   * @param s
   * @return if s=="": an empty string, s otherwise.
   */
  def ignoreIfNull(s: String): String = {
    if (s == "") return ""
    s
  }

  /**
   * This little helper just ignores a "" in result
   *
   * @param s
   * @return if s=="": an empty string, s otherwise.
   */
  def ignoreNull(s: String): String = {
    if (s == "") return ""
    s
  }

  /**
   * This little helper just ignores a "" in result
   *
   * @param s
   * @return if s==0: an empty string, s otherwise.
   */
  def ignoreNullInt(s: Int): String = {
    var res = ""
    if (s != 0) res = "" + s
    res
  }

  /**
   * This little helper just ignores a "". And formats the dates according ISO format.
   *
   * @param d
   * @return
   */
  def ignoreNull(d: Date): String = {
    var res = ""
    if (d != "") { //SimpleDateFormat df = new SimpleDateFormat("yyyy-mm-dd");
      res = d.toString // df.format(d);

    }
    res
  }

  /**
   * Little helper to give the disabled attribute to a select element in html page.
   *
   * @param b call data.is...() to get this. gives, if the element is defined.
   * @return "disabled" (if element is defined) or empty string.
   */
  def getDisabled(b: Boolean): String = {
    if (b) return "disabled"
    ""
  }

  def getIsYear: Boolean = {
    if (year == 0) return false
    true
  }

  def getIsStg: Boolean = {
    if (stg == "" || stg.equalsIgnoreCase("")) return false
    true
  }

  /**
   * Helper function for the webpage in <option>
   * Print "selected" if the Strings match.
   *
   * @param Soll The string of the options.
   * @param Ist  The string of the database
   * @return "selected" if Soll equals Ist, empty String otherwise
   */
  def getSelected(Soll: String, Ist: String): String = {
    var res = ""
    if (Soll.equals(Ist)) res = "selected"
    res
  }


  /**
   * Helper function for the webpage in <option>
   * Print "checked" if the Strings match.
   *
   * @param Soll The string of the options.
   * @param Ist  The string of the database
   * @return "checked" if Soll equals Ist, empty String otherwise
   */
  def getChecked(Soll: String, Ist: String): String = {
    var res = ""
    if (Soll.equalsIgnoreCase(Ist)) res = "checked"
    res
  }


  /**
   * Helper function for the webpage in check box
   * Print "checked" if the Int match.
   *
   * @param Soll The int of the value of check box .
   * @param Ist  The int  of the database
   * @return "checked" if Soll equals Ist, empty String otherwise empty String
   */
  def getCheckedbox(Soll: Int, Ist: Int): String = {
    var res = "hidden"
    if (Soll == Ist) res = ""
    res
  }

  /**
   * Helper function for the webpage in <option>
   * Print "checked" if the Strings match.
   *
   * @param Soll "J" or "N"
   * @return "checked" if condition fullfilled, empty string otherwise.
   */
  def getCheckedBRDStudies(Soll: String): String = {
    val course = getBrdcourse
    val hs = getErhskfz
    var res = ""
    val defined = (course != "" && course.length > 0) || (hs != "" && hs.length > 0)
    if (((Soll eq "J") && defined) || ((Soll eq "N") && !defined)) res = "checked"
    else res = ""
    res
  }


  def getSelected(Soll: String, Ist: Int): String = {
    var res = ""
    val ist = String.valueOf(Ist)
    if (Soll.equalsIgnoreCase(ist)) res = "selected"
    res
  }

  /**
   * Little helper that gives year String as result
   *
   * @return String of current year (+1, if we are after deadline).
   */
  def checkDeadLineDate1: String = {
    val thisyear = Calendar.getInstance.get(Calendar.YEAR)
    val thismonth = Calendar.getInstance.get(Calendar.MONTH)
    if (thismonth > 8) return String.valueOf(thisyear + 1)
    String.valueOf(thisyear)
  }

  /**
   * Little helper that gives year String as result
   *
   * @return String of current year +1 (+2, if we are after deadline).
   */
  def checkDeadLineDate2: String = {
    val thisyear = Calendar.getInstance.get(Calendar.YEAR)
    val thismonth = Calendar.getInstance.get(Calendar.MONTH)
    if (thismonth > 8) return String.valueOf(thisyear + 2)
    String.valueOf(thisyear + 1)
  }


  /**
   * Little helper that gives year String as result
   *
   * @return String of current year +2 (+3, if we are after deadline).
   */
  def checkDeadLineDate3: String = {
    val thisyear = Calendar.getInstance.get(Calendar.YEAR)
    val thismonth = Calendar.getInstance.get(Calendar.MONTH)
    if (thismonth > 8) return String.valueOf(thisyear + 3)
    String.valueOf(thisyear + 2)
  }


  def getBemlangextra: String = bemlangextra


  def setBemlangextra(bemlangextra: String): Unit = {
    this.bemlangextra = bemlangextra
    isbemlangextra = true
  }

  def getBemlang: String = bemlang


  def setBemlang(bemlang: String): Unit = {
    this.bemlang = bemlang
    isbemlang = true
  }

  def getAnti: String = {
    ignoreNull(anti)
  }

  def setAnti(anti: String): Unit = {
    this.anti = anti
    isanti = true
  }

  var shortNachName = ""
  def getShortNachname: String = {
    ignoreNull(shortNachName)
  }

  def setShortNachname(nachname: String): Unit = {
    this.shortNachName = nachname
    isnachname = true
  }

  def getNachname: String = {
    ignoreNull(nachname)
  }

  def setNachname(nachname: String): Unit = {
    this.nachname = nachname
    isnachname = true
  }

  var shortVorName = ""
  def getShortVorname: String = {
    ignoreNull(shortVorName)
  }

  def setShortVorname(vorname: String): Unit = {
    this.shortVorName = vorname
    isvorname = true
  }

  def getVorname: String = {
    ignoreNull(vorname)
  }

  def setVorname(vorname: String): Unit = {
    this.vorname = vorname
    isvorname = true
  }

  def getGebname: String = {
    ignoreNull(gebname)
  }

  def setGebname(gebname: String): Unit = {
    this.gebname = gebname
    isgebname = true
  }

  def getGebort: String = ignoreNull(gebort)

  def setGebort(gebort: String): Unit = {
    this.gebort = gebort
    isgebort = true
  }

  def getGebdat: String = gebdat

  def getGebdatS: String = ignoreNull(gebdat)

  def setGebdat(gebdat: String): Unit = {
    this.gebdat = gebdat
    isgebdat = true
  }

  def getGeschl: String = ignoreNull(geschl)

  def setGeschl(geschl: String): Unit = {
    this.geschl = geschl
    isgeschl = true
  }

  def getStaat: String = ignoreNull(staat)

  def setStaat(staat: String): Unit = {
    this.staat = staat
    isstaat = true
  }

  def getPozusatz: String = ignoreNull(pozusatz)

  def setPozusatz(pozusatz: String): Unit = {
    this.pozusatz = pozusatz
    ispozusatz = true
  }

  def getPostrasse: String = ignoreNull(postrasse)

  def setPostrasse(postrasse: String): Unit = {
    this.postrasse = postrasse
    ispostrasse = true
  }

  def getPoplz: String = ignoreNull(poplz)

  def setPoplz(poplz: String): Unit = {
    this.poplz = poplz
    ispoplz = true
  }

  def getPoort: String = ignoreNull(poort)

  def setPoort(poort: String): Unit = {
    this.poort = poort
    ispoort = true
  }

  def getPokfz: String = ignoreNull(pokfz)

  def setPokfz(pokfz: String): Unit = {
    this.pokfz = pokfz
    ispokfz = true
  }

  def getPotel: String = ignoreNull(potel)

  def setPotel(potel: String): Unit = {
    this.potel = potel
    ispotel = true
  }

  def getBishsem: Int = bishsem

  def setBishsem(bishsem: Int): Unit = {
    this.bishsem = bishsem
    isbishsem = true
  }

  def getHmkfzkz: String = ignoreNull(hmkfzkz)

  def setHmkfzkz(hmkfzkz: String): Unit = {
    this.hmkfzkz = hmkfzkz
    ishmkfzkz = true
  }

  def getHmkfz: String = ignoreNull(hmkfz)

  def setHmkfz(hmkfz: String): Unit = {
    this.hmkfz = hmkfz
    ishmkfz = true
  }

  def getFehlunt: String = ignoreNull(fehlunt)

  def setFehlunt(fehlunt: String): Unit = {
    this.fehlunt = fehlunt
    isfehlunt = true
  }

  def getVerarbkz: String = verarbkz

  def setVerarbkz(verarbkz: String): Unit = {
    this.verarbkz = verarbkz
    isverarbkz = true
  }

  def getStaatkez: String = ignoreNull(staatkez)

  def setStaatkez(staatkez: String): Unit = {
    this.staatkez = staatkez
    isstaatkez = true
  }

  def getBerufab: String = ignoreNull(berufab)

  def setBerufab(berufab: String): Unit = {
    this.berufab = berufab
    isberufab = true
  }

  def getPrakt1: String = ignoreNull(prakt1)

  def setPrakt1(prakt1: String): Unit = {
    this.prakt1 = prakt1
    isprakt1 = true
  }

  def getSonsttaet: String = ignoreNull(sonsttaet)

  def setSonsttaet(sonsttaet: String): Unit = {
    this.sonsttaet = sonsttaet
    issonsttaet = true
  }

  def getGesadauer: Int = gesadauer

  def setGesadauer(gesadauer: Int): Unit = {
    this.gesadauer = gesadauer
    isgesadauer = true
  }

  /**
   * The select element and the entries in the database combine the values.
   *
   * @return
   */
  def getErhskfz_combined: String = ignoreNull(erhskfz) + " " + ignoreNull(erhsart)

  def getErhskfz: String = ignoreNull(erhskfz)

  def setErhskfz(erhskfz: String): Unit = {
    this.erhskfz = erhskfz
    iserhskfz = true
  }

  def getErhsart: String = ignoreNull(erhsart)

  def setErhsart(erhsart: String): Unit = {
    this.erhsart = erhsart
    iserhsart = true
  }

  def getErhssembrd: Int = erhssembrd

  def setErhssembrd(erhssembrd: Int): Unit = {
    this.erhssembrd = erhssembrd
    iserhssembrd = true
  }

  def getHssem: Int = hssem

  def setHssem(hssem: Int): Unit = {
    this.hssem = hssem
    ishssem = true
  }

  def getUrlsem: Int = urlsem

  def setUrlsem(urlsem: Int): Unit = {
    this.urlsem = urlsem
    isurlsem = true
  }

  def getPraxsem: Int = praxsem

  def setPraxsem(praxsem: Int): Unit = {
    this.praxsem = praxsem
    ispraxsem = true
  }

  def getEmail: String = ignoreNull(email)

  def setEmail(email: String): Unit = {
    this.email = email
    isemail = true
  }

  def getStg: String = ignoreNull(stg)

  def setStg(stg: String): Unit = {
    this.stg = stg
    isstg = true
  }

  def getHzbart: String = ignoreNull(hzbart)

  def setHzbart(hzbart: String): Unit = {
    this.hzbart = hzbart
    ishzbart = true
  }

  def getHzbdatum: String = hzbdatum

  def setHzbdatum(hzbdatum: String): Unit = {
    this.hzbdatum = hzbdatum
    ishzbdatum = true
  }

  def getHzbkfzkz: String = ignoreNull(hzbkfzkz)

  def setHzbkfzkz(hzbkfzkz: String): Unit = {
    this.hzbkfzkz = hzbkfzkz
    ishzbkfzkz = true
  }

  def getHzbort: String = ignoreNull(hzbort)

  def setHzbort(hzbort: String): Unit = {
    this.hzbort = hzbort
    ishzbort = true
  }

  def getZusbew2: Int = zusbew2

  def setZusbew2(zusbew2: Int): Unit = {
    this.zusbew2 = zusbew2
    iszusbew2 = true
  }

  def getZusbew1: Int = zusbew1

  def setZusbew1(zusbew1: Int): Unit = {
    this.zusbew1 = zusbew1
    iszusbew1 = true
  }

  def getZulassung: String = ignoreNull(Zulassung)

  def setZulassung(zulassung: String): Unit = {
    this.Zulassung = zulassung
    isZulassung = true
  }

  def isIsbemlang: Boolean = isbemlang

  def setIsbemlang(isbemlang: Boolean): Unit = {
    this.isbemlang = isbemlang
  }

  def isIsanti: Boolean = isanti

  def setIsanti(isanti: Boolean): Unit = {
    this.isanti = isanti
  }

  def isIsnachname: Boolean = isnachname

  def setIsnachname(isnachname: Boolean): Unit = {
    this.isnachname = isnachname
  }

  def isIsvorname: Boolean = isvorname

  def setIsvorname(isvorname: Boolean): Unit = {
    this.isvorname = isvorname
  }

  def isIsgebname: Boolean = isgebname

  def setIsgebname(isgebname: Boolean): Unit = {
    this.isgebname = isgebname
  }

  def isIsgebort: Boolean = isgebort

  def setIsgebort(isgebort: Boolean): Unit = {
    this.isgebort = isgebort
  }

  def isIsgebdat: Boolean = isgebdat

  def setIsgebdat(isgebdat: Boolean): Unit = {
    this.isgebdat = isgebdat
  }

  def isIsgeschl: Boolean = isgeschl

  def setIsgeschl(isgeschl: Boolean): Unit = {
    this.isgeschl = isgeschl
  }

  def isIsstaat: Boolean = isstaat

  def setIsstaat(isstaat: Boolean): Unit = {
    this.isstaat = isstaat
  }

  def isIspozusatz: Boolean = ispozusatz

  def setIspozusatz(ispozusatz: Boolean): Unit = {
    this.ispozusatz = ispozusatz
  }

  def isIspostrasse: Boolean = ispostrasse

  def setIspostrasse(ispostrasse: Boolean): Unit = {
    this.ispostrasse = ispostrasse
  }

  def isIspoplz: Boolean = ispoplz

  def setIspoplz(ispoplz: Boolean): Unit = {
    this.ispoplz = ispoplz
  }

  def isIspoort: Boolean = ispoort

  def setIspoort(ispoort: Boolean): Unit = {
    this.ispoort = ispoort
  }

  def isIspokfz: Boolean = ispokfz

  def setIspokfz(ispokfz: Boolean): Unit = {
    this.ispokfz = ispokfz
  }

  def isIspotel: Boolean = ispotel

  def setIspotel(ispotel: Boolean): Unit = {
    this.ispotel = ispotel
  }

  def isIsbishsem: Boolean = isbishsem

  def setIsbishsem(isbishsem: Boolean): Unit = {
    this.isbishsem = isbishsem
  }

  def isIshmkfzkz: Boolean = ishmkfzkz

  def setIshmkfzkz(ishmkfzkz: Boolean): Unit = {
    this.ishmkfzkz = ishmkfzkz
  }

  def isIshmkfz: Boolean = ishmkfz

  def setIshmkfz(ishmkfz: Boolean): Unit = {
    this.ishmkfz = ishmkfz
  }

  def isIsfehlunt: Boolean = isfehlunt

  def setIsfehlunt(isfehlunt: Boolean): Unit = {
    this.isfehlunt = isfehlunt
  }

  def isIsverarbkz: Boolean = isverarbkz

  def setIsverarbkz(isverarbkz: Boolean): Unit = {
    this.isverarbkz = isverarbkz
  }

  def isIsstaatkez: Boolean = isstaatkez

  def setIsstaatkez(isstaatkez: Boolean): Unit = {
    this.isstaatkez = isstaatkez
  }

  def isIsberufab: Boolean = isberufab

  def setIsberufab(isberufab: Boolean): Unit = {
    this.isberufab = isberufab
  }

  def isIsprakt1: Boolean = isprakt1

  def setIsprakt1(isprakt1: Boolean): Unit = {
    this.isprakt1 = isprakt1
  }

  def isIssonsttaet: Boolean = issonsttaet

  def setIssonsttaet(issonsttaet: Boolean): Unit = {
    this.issonsttaet = issonsttaet
  }

  def isIsgesadauer: Boolean = isgesadauer

  def setIsgesadauer(isgesadauer: Boolean): Unit = {
    this.isgesadauer = isgesadauer
  }

  def isIserhskfz: Boolean = iserhskfz

  def setIserhskfz(iserhskfz: Boolean): Unit = {
    this.iserhskfz = iserhskfz
  }

  def isIserhsart: Boolean = iserhsart

  def setIserhsart(iserhsart: Boolean): Unit = {
    this.iserhsart = iserhsart
  }

  def isIserhssembrd: Boolean = iserhssembrd

  def setIserhssembrd(iserhssembrd: Boolean): Unit = {
    this.iserhssembrd = iserhssembrd
  }

  def isIshssem: Boolean = ishssem

  def setIshssem(ishssem: Boolean): Unit = {
    this.ishssem = ishssem
  }

  def isIsurlsem: Boolean = isurlsem

  def setIsurlsem(isurlsem: Boolean): Unit = {
    this.isurlsem = isurlsem
  }

  def isIspraxsem: Boolean = ispraxsem

  def setIspraxsem(ispraxsem: Boolean): Unit = {
    this.ispraxsem = ispraxsem
  }

  def isIsemail: Boolean = isemail

  def setIsemail(isemail: Boolean): Unit = {
    this.isemail = isemail
  }

  def isIsstg: Boolean = isstg

  def setIsstg(isstg: Boolean): Unit = {
    this.isstg = isstg
  }

  def isIshzbart: Boolean = ishzbart

  def setIshzbart(ishzbart: Boolean): Unit = {
    this.ishzbart = ishzbart
  }

  def isIshzbdatum: Boolean = ishzbdatum

  def setIshzbdatum(ishzbdatum: Boolean): Unit = {
    this.ishzbdatum = ishzbdatum
  }

  def isIshzbkfzkz: Boolean = ishzbkfzkz

  def setIshzbkfzkz(ishzbkfzkz: Boolean): Unit = {
    this.ishzbkfzkz = ishzbkfzkz
  }

  def isIshzbort: Boolean = ishzbort

  def setIshzbort(ishzbort: Boolean): Unit = {
    this.ishzbort = ishzbort
  }

  def isIszusbew2: Boolean = iszusbew2

  def setIszusbew2(iszusbew2: Boolean): Unit = {
    this.iszusbew2 = iszusbew2
  }

  def isIszusbew1: Boolean = iszusbew1

  def setIszusbew1(iszusbew1: Boolean): Unit = {
    this.iszusbew1 = iszusbew1
  }

  def getisZulassung: Boolean = isZulassung

  def setisZulassung(isZulassung: Boolean): Unit = {
    this.isZulassung = isZulassung
  }

  def getAuthNo: String = ignoreNull(authNo)

  def setAuthNo(authNo: String): Unit = {
    this.authNo = authNo
  }

  def getSem: Int =  sem

  def getYear: Int = year

  def getHochschulname: String = ignoreNull(hochschulname)

  def setHochschulname(hochschulname: String): Unit = {
    this.hochschulname = hochschulname
    isHochschulname = true
  }

  def getHochschulort: String = ignoreNull(hochschulort)

  def setHochschulort(hochschulort: String): Unit = {
    this.hochschulort = hochschulort
    isHochschulort = true
  }

  def getStudiengangname: String = ignoreNull(studiengangname)

  def setStudiengangname(studiengangname: String): Unit = {
    this.studiengangname = studiengangname
    isStudiengangname = true
  }

  def getAbschluss: String = ignoreNull(abschluss)

  def setAbschluss(abschluss: String): Unit = {
    this.abschluss = abschluss
    isAbschluss = true
  }

  def getIsHochschulname: Boolean = isHochschulname

  def setHochschulname(isHochschulname: Boolean): Unit = {
    this.isHochschulname = isHochschulname
  }

  def getIsHochschulort: Boolean = isHochschulort

  def setHochschulort(isHochschulort: Boolean): Unit = {
    this.isHochschulort = isHochschulort
  }

  def getIsStudiengangname: Boolean = isStudiengangname

  def setStudiengangname(isStudiengangname: Boolean): Unit = {
    this.isStudiengangname = isStudiengangname
  }

  def getIsAbschluss: Boolean = isAbschluss

  def setAbschluss(isAbschluss: Boolean): Unit = {
    this.isAbschluss = isAbschluss
  }

  def getAverage: String = ignoreNull(average)

  def setAverage(average: String): Unit = {
    this.average = average
    isAverage = true
  }

  def getBestmark: String = ignoreNull(bestmark)

  def setBestmark(bestmark: String): Unit = {
    this.bestmark = bestmark
    isBestmark = true
  }

  def getPassmark: String = ignoreNull(passmark)

  def setPassmark(passmark: String): Unit = {
    this.passmark = passmark
    isPassmark = true
  }

  def getisAverage: Boolean = isAverage

  def setAverage(isAverage: Boolean): Unit = {
    this.isAverage = isAverage
  }

  def getisBestmark: Boolean = isBestmark

  def setBestmark(isBestmark: Boolean): Unit = {
    this.isBestmark = isBestmark
  }

  def getisPassmark: Boolean = isPassmark

  def setPassmark(isPassmark: Boolean): Unit = {
    this.isPassmark = isPassmark
  }

  def getBachstartdate: String = bachstartdate

  def getBachstartdateS: String = ignoreNull(bachstartdate)

  def setBachstartdate(bachstartdate: String): Unit = {
    this.bachstartdate = bachstartdate
    isbachstartdate = true
  }

  def getBachenddate: String = bachenddate

  def getBachenddateS: String = ignoreNull(bachenddate)

  def setBachenddate(bachenddate: String): Unit = {
    this.bachenddate = bachenddate
    isbachenddate = true
  }

  def isIsbachstartdate: Boolean = isbachstartdate

  def setIsbachstartdate(isbachstartdate: Boolean): Unit = {
    this.isbachstartdate = isbachstartdate
  }

  def isIsbachenddate: Boolean = isbachenddate

  def setIsbachenddate(isbachenddate: Boolean): Unit = {
    this.isbachenddate = isbachenddate
  }

  def getBrdcourse: String = ignoreNull(brdcourse)

  def setBrdcourse(brdcourse: String): Unit = {
    this.brdcourse = brdcourse
    isbrdcourse = true
  }

  def getBrddiploma: String = ignoreNull(brddiploma)

  def setBrddiploma(brddiploma: String): Unit = {
    this.brddiploma = brddiploma
    isbrddiploma = true
  }

  def getBrdstartdate: String = brdstartdate

  def getBrdstartdateS: String = ignoreNull(brdstartdate)


  def setBrdstartdate(brdstartdate: String): Unit = {
    this.brdstartdate = brdstartdate
    isbrdstartdate = true
  }

  def getBrdenddate: String = brdenddate

  def getBrdenddateS: String = ignoreNull(brdenddate)

  def setBrdenddate(brdenddate: String): Unit = {
    this.brdenddate = brdenddate
    isbrdenddate = true
  }

  def isIsbrdcourse: Boolean = isbrdcourse

  def setIsbrdcourse(isbrdcourse: Boolean): Unit = {
    this.isbrdcourse = isbrdcourse
  }

  def isIsbrddiploma: Boolean = isbrddiploma

  def setIsbrddiploma(isbrddiploma: Boolean): Unit = {
    this.isbrddiploma = isbrddiploma
  }

  def isIsbrdstartdate: Boolean = isbrdstartdate

  def setIsbrdstartdate(isbrdstartdate: Boolean): Unit = {
    this.isbrdstartdate = isbrdstartdate
  }

  def isIsbrdenddate: Boolean = isbrdenddate

  def setIsbrdenddate(isbrdenddate: Boolean): Unit = {
    this.isbrdenddate = isbrdenddate
  }

  def setSem(sem: Byte): Unit = {
    this.sem = sem
  }

  def setYear(year: Int): Unit = {
    this.year = year
  }


  def getSitzungNr: Int = sitzungNr

  def setSitzungNr(sitzungNr: Int): Unit = {
    this.sitzungNr = sitzungNr
    issitzungNr = true
  }

  def getIsChecked: Int = isChecked

  def setisChecked(isChecked: Int): Unit = {
    this.isChecked = isChecked
    isisChecked = true
  }

  def getBemerkung: String = ignoreNull(bemerkung)

  def setBemerkung(bemerkung: String): Unit = {
    this.bemerkung = bemerkung
    isbemerkung = true
  }

  def setZulassung: String = date_sul_sent

  def getDate_Zul_Sent: String = {
      date_sul_sent
  }
  def setDate_Zul_Sent(date_zul_sent: String): Unit = {
    this.date_sul_sent = date_zul_sent
    isdate_sul_sent = true
  }

  def getBezeichnung: String = ignoreNull(bezeichnung)

  def setBezeichnung(Bezeichnung: String): Unit = {
    bezeichnung = Bezeichnung
    isbezeichnung = true
  }

  //++++++++++++++++++++++++++++++++++++
  def isSitzungNr: Boolean = isSitzungNr

  def setissitzungNr(issitzungNr: Boolean): Unit = {
    this.issitzungNr = issitzungNr
  }

  def getisChecked: Boolean = isisChecked

  def setisisChecked(isisChecked: Boolean): Unit = {
    this.isisChecked = isisChecked
  }

  def isBemarkung: Boolean = isbemerkung

  def setisBemerkung(isbemerkung: Boolean): Unit = {
    this.isbemerkung = isbemerkung
  }

  def getIsDate_Zul_Sent: Boolean = isdate_sul_sent

  def setisDate_Zul_Sent(isdate_zul_sent: Boolean): Unit = {
    this.isdate_sul_sent = isdate_zul_sent
  }


}