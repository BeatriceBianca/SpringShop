<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link href="styles/cosCurent.css" type="text/css" rel="stylesheet">
	<link href="styles/all.css" type="text/css" rel="stylesheet">
	<script src="js/criterii.js" type="text/javascript" ></script>
	<title>Spring Shop</title>
</head>
<body class="cosCurent-page">

	<jsp:include page="header.jsp" />
	
	<jsp:include page="menu.jsp" />
	
	<table>
       <tr>
           <th>Nume produs</th>
           <th>Pret</th>
           <th>Cantitate</th>
       </tr>
       <c:forEach items="${order}">
           <tr>
	           <td>${order.productId.getProductName()}</td>
	           <td>
	              <fmt:formatNumber value="${order.productId.getPrice()}" type="currency"/>
	           </td>
	           <td>${order.quanity}</td>
           </tr>
       </c:forEach>
   </table>
   
   <div id="total">
   		<div> Numar produse: </div>
   		<div> Pret total: </div>
   		<button> Comanda </button>
   </div>
   
</body>
</html>