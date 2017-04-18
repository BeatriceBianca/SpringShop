<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link href="styles/login.css" type="text/css" rel="stylesheet">
	<link href="styles/all.css" type="text/css" rel="stylesheet">
	<script src="js/criterii.js" type="text/javascript" ></script>
	<script src="js/all.js" type="text/javascript" ></script>
	<title>Spring Shop</title>
</head>
<body class="login-page">

	<jsp:include page="header.jsp" />
	
	<jsp:include page="menu.jsp" />
 
   <div class="login-container">
   
	   <div id = "login-container">	
	   
	   		<h1>Login</h1>
	   		
	 	    <c:if test="${param.error == 'true'}">
	           <div style="color: red; margin: 10px 0px;">
	 
	               Login Failed!!!<br /> Reason :
	               ${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}
	 
	           </div>
     	    </c:if>
     	    
     	    <form method="POST"
           action="${pageContext.request.contextPath}/j_spring_security_check">
	           <table>
	               <tr>
	                   <td>Email *</td>
	                   <td><input name="email" /></td>
	               </tr>
	 
	               <tr>
	                   <td>Password *</td>
	                   <td><input type="password" name="password" /></td>
	               </tr>
	 
	               <tr>
	                   <td>&nbsp;</td>
	                   <td><input type="submit" value="Login" /> <input type="reset"
	                       value="Reset" /></td>
	               </tr>
	           </table>
      	   </form>
	 	</div>
 
       <span class="error-message">${error }</span>
 
   </div>
 
 
   
 
</body>
</html>