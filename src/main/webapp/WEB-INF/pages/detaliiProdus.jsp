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
	<title>Spring Shop</title>
</head>

<body class="productDetails-page">

	<jsp:include page="header.jsp" />
	
	<jsp:include page="menu.jsp" />
	
	<div id = "productDetails-container">
		<div>
				<div id="detalii">
					<h1 id="name">${product.name} </h1>
	
					<c:if test="${product.productsLeftInStock == 0}">
						<div id="stoc"> [ Stoc epuizat ] </div>
					</c:if>
					
					<c:if test="${product.productsLeftInStock > 0}">
						<div id="stoc"> [ In stoc ] </div>
					</c:if>

					<br><br>
				
					<div id="descriere"> ${product.description}</div>
					
					<div id="pret"> Pret: ${product.price} lei </div>
				</div>
				
				<div id="butoane">
					<button> Adauga in cos </button>
					<button> Adauga la favorite </button>
				</div>
		</div>
	</div>
</body>
</html>