<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link href="styles/index.css" type="text/css" rel="stylesheet">
	<link href="styles/all.css" type="text/css" rel="stylesheet">
	<script src="js/index.js" type="text/javascript" ></script>
	<title>Spring Shop</title>
</head>
<body class="index-page">

	<jsp:include page="header.jsp" />
	
	<div id="top-div">
	    <div class="item">
	    	<a href="./" id="it"> IT </a>
	    </div>
	    <div class="item">
	    	<a href="./" id="electrocasnice"> Electrocasnice </a>
	    </div>
	    <div class="item">
	     	<a href="./" id="fashion"> Fashion </a>
	    </div>
	    <div class="item">
	    	<a href="./" id="sport"> Sport </a>
	    </div>
	    <div class="item">
	    	<a href="./" id="accesorii"> Accesorii </a>
	    </div>
	</div>
	
	<form id="left-div"> 
		<div> Categorie: </div> 
	    <select name="categorie">
		  <option>[Orice]</option>
		  <option value="it">IT</option>
		  <option value="electrocasnice">Electrocasnice</option>
		  <option value="fashion">Fashion</option>
		  <option value="sport">Sport</option>
		  <option value="accesorii">Accesorii</option>
		</select>
		<br><br>
		
		<div> Pret </div>
		<input id="pret" type="range" min="50" max="500" step="10" onclick="afiseazaPret(this.value)"/>
		<span id="valoare"> </span>
		<br><br>
	</form>
	
</body>
</html>