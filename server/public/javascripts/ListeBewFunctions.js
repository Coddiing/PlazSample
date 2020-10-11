BewerberListe
//function to get the bemlang id and to open a new window with the details about this bemlang
function getTaskId(button){

	 var id = button.id;

	 window.open('DetailedStudentInformation.jsp?bemlang='+id);

  }


/**
 * function to get the bemlang id and to open a new window with the documents of this this bemlang
 * @parameter bemlang
 *
 */
function getDocsId(button){

	 var id = button.id;

	 window.open('DocumentsUpload.jsp?bemlang='+id);

  }

/*
 * function to redirect to a new page
 * where a new application can be registered manually (from the secretary)
 *
 */
function newApp(){
	window.open('AppNewStudent.jsp');
}

/*
 * function to show all entries in the database.
 */
function showAll() {
	location.href = '?all=1';
}


/*
 * function to show all entries in the database.
 */
function logout() {
	location.href = 'logout.jsp';
}

/**
 * function to call an other servlet on pressing enter

function getBemerkung(text){
	var bemlang=text.id;
	var bemerkung=text.value;

	 window.open("http://localhost:8080/BewerberListeSekretariat/SmallWindow.jsp?bemlang="+bemlang+"&bemerkung=" +bemerkung, "width=600, height=600");
//	alert(bemlang+ "  " + bemerkung);
}

onkeypress="if (event.keyCode==13){ getBemerkung(this);return false;}"


*/
