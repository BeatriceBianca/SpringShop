<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
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
<body class="">

	<jsp:include page="header.jsp" />
	
	<jsp:include page="menu.jsp" />
	
	<form:form modelAttribute="ofertaForm" method="POST">
	<div id = "">
			<h1>Propune Oferta</h1>
			<div>
				<div>
					<div>Produs: </div>
					<form:input path="name" />
					<br>
					<div>Stoc: </div>
					<form:input path="productsLeftInStock" />
					<br>
					<div>Pret: </div>
					<form:input path="price" />
					<br>
					<div>Categorie </div>
					<form:input path="category" />
					<br>
					<div>Descriere: </div>
					<form:input path="description" />
					<br>
				</div>
		</div>
		<br>
		<input type="submit" value="Submit" /> 
		<input type="reset" value="Reset" />
	</div>
	</form:form>
</body>
</html>