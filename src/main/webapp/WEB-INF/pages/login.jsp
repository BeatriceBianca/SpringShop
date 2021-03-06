<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link href="styles/login.css" type="text/css" rel="stylesheet">
	<link href="styles/all.css" type="text/css" rel="stylesheet">
	<script src="js/all.js" type="text/javascript" ></script>
	<title>Spring Shop</title>
</head>
<body class="login-page">

	<jsp:include page="header.jsp" />
	
	<jsp:include page="menu.jsp" />
 
   <div class="login-container">
   
	   <div id = "login-container">	
	   
	   		<h1>Login</h1>
     	    
     	    <form method="POST"
           action="${pageContext.request.contextPath}/j_spring_security_check">
	           <table>
	               <tr>
	                   <td>Email *</td>
	                   <td><input id="email" name="email" /></td>
	               </tr>
	 
	               <tr>
	                   <td>Password *</td>
	                   <td><input id="pass" type="password" name="password" /></td>
	               </tr>
	 
	               <tr>
	                   <td>&nbsp;</td>
	                   <td><input id="login" type="submit" value="Login" /> 
	                   <input id="reset" type="reset" value="Reset" /></td>
	               </tr>
	           </table>
      	   </form>
	 	</div>
 
       <c:if test="${param.error == 'true'}">
	           <div style="color: red; margin: 0px 25%;">
	 
	               Login Failed!!!<br /> Reason :
	               Wrong email or password!
	 
	           </div>
      </c:if>
 
   </div>
</body>
</html>