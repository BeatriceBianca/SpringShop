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
	<link href="styles/index.css" type="text/css" rel="stylesheet">
	<title>Spring Shop</title>
</head>
<body class="">

	<jsp:include page="header.jsp" />
	
	<jsp:include page="menu.jsp" />
	<table>
	<c:forEach items="${offerProducts.list}" var="products">
           	<tr>
	           <td>${products.name}</td>
	           <td>${products.price} lei</td>
	           <td><a href="${pageContext.request.contextPath}/oferte?prodIdAccept=${products.id}"><button>Accepta Oferta</button></a></td>
	           <td><a href="${pageContext.request.contextPath}/oferte?prodIdRemove=${products.id}"><button>Respinge Oferta</button></a></td>
	      	</tr>
	</c:forEach>
   	</table>
	<c:if test="${offerProducts.totalPages > 1}">
       <div class="page-navigator">
          <c:forEach items="${offerProducts.navigationPages}" var = "page">
              <c:if test="${page != -1 }">
                <a href="oferte?page=${page}" class="nav-item">${page}</a>
              </c:if>
              <c:if test="${page == -1 }">
                <span class="nav-item"> ... </span>
              </c:if>
          </c:forEach>
          
       </div>
   </c:if>
</body>
</html>