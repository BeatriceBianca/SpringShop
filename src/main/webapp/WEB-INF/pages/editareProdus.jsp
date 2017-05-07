<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link href="styles/detaliiProdus.css" type="text/css" rel="stylesheet">
	<link href="styles/all.css" type="text/css" rel="stylesheet">
	<script src="js/editare.js" type="text/javascript" ></script>
	<title>Spring Shop</title>
</head>

<body class="productDetails-page">

	<jsp:include page="header.jsp" />
	
	<jsp:include page="menu.jsp" />
	
	<div id = "productDetails-container">
	<form:form modelAttribute="saveProductForm" method="GET">
		<div>
				<div id="detalii">
					
					<!--  MANAGER  -->
					
					<security:authorize  access="hasAnyRole('MANAGER')">
						<div class="m-name"> ${product.name} </div>
						<form:input path="name" class="m-name" id="m-m-name" />
		
						<c:if test="${product.productsLeftInStock == 0}">
							<div id="stoc"> [ Stoc epuizat ] </div>
						</c:if>
						
						<c:if test="${product.productsLeftInStock > 0}">
							<div id="stoc"> [ In stoc ] </div>
						</c:if>
	
						<br><br>
						
						<span class="m-descriere"> Descriere </span><form:textarea path="description" id="m-m-descriere" class="m-descriere" />
						
						<br><br><br>
						
						<div class="m-pret"> Pret: ${product.price} lei </div>
						<form:input path="price" class="m-pret" id="m-m-pret"/>
					</security:authorize>
				</div>
				
				<div id="butoane">
					<security:authorize  access="hasAnyRole('MANAGER')">
						<input id="submit" type="submit" value="Submit" /> 
					</security:authorize>
				</div>
		</div>
	</form:form>
	</div>
</body>
</html>