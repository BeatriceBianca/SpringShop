<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link href="styles/profil.css" type="text/css" rel="stylesheet">
	<link href="styles/all.css" type="text/css" rel="stylesheet">
	<script src="js/criterii.js" type="text/javascript" ></script>
	<script src="js/all.js" type="text/javascript" ></script>
	<title>Spring Shop</title>
</head>

<body class="profile-page">

	<jsp:include page="header.jsp" />
	
	<jsp:include page="menu.jsp" />
	
	<div id = "profile-container">
			<h1>Profil</h1>
			<div>
				<div>
					<div>Nume: ${user.lastName} </div>
				
					<br><br>
					
					<div>Prenume: ${user.firstName}</div>
					
					<br><br>
					
					<div>Email: ${user.email}</div>
					<br><br>
				
					<div>Telefon: ${user.phone}</div>
					
					<br><br>
					
					<div>Adresa: ${user.address}</div>
			
				</div>
		</div>
		<br><br> 
		<a href="./editareProfil">
		     <button>Editeaza profil</button>
		</a>
		
	</div>
</body>
</html>