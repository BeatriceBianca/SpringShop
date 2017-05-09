<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link href="styles/editareProfil.css" type="text/css" rel="stylesheet">
	<link href="styles/all.css" type="text/css" rel="stylesheet">
	<script src="js/criterii.js" type="text/javascript" ></script>
	<script src="js/all.js" type="text/javascript" ></script>
	<title>Spring Shop</title>
</head>

<body class="editProfile-page">

	<jsp:include page="header.jsp" />
	
	<jsp:include page="menu.jsp" />
	
	<!--<form:form modelAttribute="registrationForm" method="POST">-->
	<div id = "editProfile-container">
			<h1>Editare Profil</h1>
			<div>
				<div>
					<div>Nume: 
					<input path = "lastName" value  = ${user.lastName} />
					</div>
				
					<br><br>
					
					<div>Prenume: 
					<input path = "firstName" value = ${user.firstName} />
					</div>
					
					<br><br>
						
					<div>Parola: 
					<input path = "password" type = "password" value = ${user.password} />
					</div>
					<br><br>
				
					<div>Telefon: 
					<input path = "phone" value = ${user.phone} />
					</div>
					
					<br><br>
					
					<div>Adresa: 
					<input path = "address" value = ${user.address} />
					</div>
					
			
				</div>
		</div>
		<br><br>
		<input type="submit" value="Submit" /> 
	</div>
	<!--</form:form>-->
</body>
</html>