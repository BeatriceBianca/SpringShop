<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link href="styles/istoric.css" type="text/css" rel="stylesheet">
	<link href="styles/all.css" type="text/css" rel="stylesheet">
	<script src="js/criterii.js" type="text/javascript" ></script>
	<title>Spring Shop</title>
</head>
<body class="istoric-page">

	<jsp:include page="header.jsp" />
	
	<jsp:include page="menu.jsp" />
	
	<security:authorize  access="hasAnyRole('BUYER')">
		<table>
			<tr>
				<th>Id</th>
				<th>Data</th>
				<th>Cantitate</th>
				<th></th>
			</tr>
			<c:forEach items="${user}">
	           <tr>
	           		<td>${user.orderId.getId()}</td>
	           		<td>
	           			<fmt:formatDate value="${user.orderId.getOrderDate()}"/>
	           		</td>
		            <td>${user.orderId.getQuantity()}</td>
		            <td>
		            	<a href="./detaliiComanda/${orders.id}">
		           			<button>Vezi produse</button>
		           		</a>
		           	</td>
	           </tr>
	       </c:forEach>
		</table>
	</security:authorize>
	
	<security:authorize  access="hasAnyRole('SUPPLIER')">
		<table>
       <tr>
           <th>Nume produs</th>
           <th>Pret</th>
       </tr>
       <c:forEach items="${order}">
           <tr>
	           <td>${order.productId.getProductName()}</td>
	           <td>
	              <fmt:formatNumber value="${order.productId.getPrice()}" type="currency"/>
	           </td>
           </tr>
       </c:forEach>
   </table>
	</security:authorize>
	
	
</body>
</html>