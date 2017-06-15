<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link href="styles/all.css" type="text/css" rel="stylesheet">
	<link href="styles/index.css" type="text/css" rel="stylesheet">
	<link href="styles/cosCurent.css" type="text/css" rel="stylesheet">
	<title>Spring Shop</title>
</head>
<body class="cosCurent-page">

	<jsp:include page="header.jsp" />
	
	<jsp:include page="menu.jsp" />
	<c:set var="TotalValue" value="${0}" />
	<table>
       <tr>
           <th>Nume produs</th>
           <th>Pret</th>
           <th>Cantitate</th>
           <th></th>
           <th></th>
       </tr>
       <c:forEach items="${cartProducts.list}" var="products">
       		<c:choose>
				<c:when test="${products.cantitate>1}">
  					<c:set var="TotalValue" value="${TotalValue+products.cantitate*products.pretProd}" />
  				</c:when>
  				<c:otherwise>
  					<c:set var="TotalValue" value="${TotalValue+products.pretProd}" />
  				</c:otherwise>
  			</c:choose>
  		<tr>
	        <td>${products.denumireProd}</td>
	        <td>${products.pretProd}</td>
	        <td>${products.cantitate}</td>
		    <td><form action="UpdateCart" method="get">
				<br>Cantitate: <input type="number" name="quantity">
				<input type="hidden" name="idProd" value="${products.idProd}">
				<br><input type="submit" value="Actualizeaza">
			</form></td>
	        <td>
	        	<a href="${pageContext.request.contextPath}/Delete?idProd=${products.idProd}">Sterge</a>
	        </td>
	   </tr>
       </c:forEach>
   </table>
   
   <c:if test="${cartProducts.totalPages > 1}">
       <div class="page-navigator">
          <c:forEach items="${cartProducts.navigationPages}" var = "page">
              <c:if test="${page != -1 }">
                <a href="Cos?page=${page}" class="nav-item">${page}</a>
              </c:if>
              <c:if test="${page == -1 }">
                <span class="nav-item"> ... </span>
              </c:if>
          </c:forEach>
       </div>
   </c:if>
   
   <div id="total">
   		<div><c:if test="${not empty cartMessage}">
				<c:out value="${cartMessage}"></c:out>
		</c:if>
		</div>
   		<div> Numar produse:${fn:length(cartProducts.list)}</div>
   		<div> Pret total: ${TotalValue } lei</div>
   		<a href="${pageContext.request.contextPath}/CartFinalization">
			<button> Comanda </button>
		</a>
   </div>
   
</body>
</html>