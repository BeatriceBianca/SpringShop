<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link href="styles/newAccount.css" type="text/css" rel="stylesheet">
	<link href="styles/all.css" type="text/css" rel="stylesheet">
	<script src="js/criterii.js" type="text/javascript" ></script>
	<script src="js/all.js" type="text/javascript" ></script>
	<title>Spring Shop</title>
</head>
<body class="newAccount-page">

	<jsp:include page="header.jsp" />
	
	<jsp:include page="menu.jsp" />
	
	<form:form modelAttribute="registrationForm" method="GET">
	<div id = "creare-cont-container">
			<h1>Creare cont</h1>
			<div>
				<div>
					<div>Nume: </div>
					<form:input path="lastName" />
               		<form:errors path="lastName"/>
					<br>
					
					<div>Prenume: </div>
					<c:if test="${not empty registrationForm.firstName}">
                       <form:hidden path="firstName"/>
                       ${registrationForm.firstName}
                 	</c:if>
                 	<c:if test="${empty registrationForm.firstName}">
                       <form:input path="firstName" />
                       <form:hidden path="newUser" />
                 	</c:if>
                 	<form:errors path="firstName" />
					<br>
					
					<div>Email: </div>
					<form:input path="email" />
              	    <form:errors path="email" />
						
					<div>Parola: </div>
					<form:input path="password" />
              	    <form:errors path="password" />
					<br>
				</div>
			
				<div>
					<div>Telefon: </div>
					<form:input path="phone" />
	              	<form:errors path="phone" />
					<br>
					
					<div>Adresa: </div>
					<form:input path="address" />
              	    <form:errors path="address" />
					<br>
					
					<div>Tip cont: </div>
					<form:select path="role">
						<form:option value="MANAGER">Manager</form:option>
						<form:option value="EMPLOYEE">Employee</form:option>
					</form:select>
              	    <form:errors path="role" />
			
				</div>
		</div>
		<br>
		<input type="submit" value="Submit" /> 
		<input type="reset" value="Reset" />
	</div>
	</form:form>
</body>
</html>