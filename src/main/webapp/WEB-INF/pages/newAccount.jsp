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
	
	<div id = "creare-cont-container">
		
		
		<form:form modelAttribute="registrationForm" method="POST">
			 <table style="text-align:left;">
           <tr>
               <td>First Name *</td>
               <td style="color:red;">
                  <c:if test="${not empty registrationForm.firstName}">
                       <form:hidden path="firstName"/>
                       ${registrationForm.firstName}
                  </c:if>
                  <c:if test="${empty registrationForm.firstName}">
                       <form:input path="firstName" />
                       <form:hidden path="newUser" />
                  </c:if>
               </td>
               <td><form:errors path="firstName" /></td>
           </tr>
 
           <tr>
               <td>Last Name *</td>
               <td><form:input path="lastName" /></td>
               <td><form:errors path="lastName"/></td>
           </tr>
 
           <tr>
               <td>Email *</td>
               <td><form:input path="email" /></td>
               <td><form:errors path="email" /></td>
           </tr>
           <tr>
               <td>Password *</td>
               <td><form:input path="password" type="password"/></td>
               <td><form:errors path="password" /></td>
           </tr>
           <tr>
               <td>Phone *</td>
               <td><form:input path="phone" /></td>
               <td><form:errors path="phone" /></td>
           </tr>
 		   <tr>
               <td>Address *</td>
               <td><form:input path="address" /></td>
               <td><form:errors path="address" /></td>
           </tr>
 			<tr>
               <td>Id *</td>
               <td><form:input path="user_id" /></td>
               <td><form:errors path="user_id" /></td>
           </tr>
           <tr>
               <td>Role *</td>
               <td><form:input path="role" /></td>
               <td><form:errors path="role" /></td>
           </tr>
           <tr>
               <td>&nbsp;</td>
               <td><input type="submit" value="Submit" /> <input type="reset"
                   value="Reset" /></td>
           </tr>
       </table>
   </form:form>
		
		
	</div>
</body>
</html>