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
	
	<div id = "login-container">
	
		<h1>Login</h1>
		
		<div>Email: </div>
		<div>
			<input type = "text"/>
			<span>@</span>
			<select name = "mail">
				<option value = "default">[Alege]</option>
				<option value = "yahoo">yahoo.com</option>
				<option value = "gmail">gmail.com</option>
			</select>
		</div>
		<br>
		
		<div>Parola: </div>
		<input type = "text"/>
		<br><br><br>
		
		<button id = "login-button">Login</button>
	</div>
	
</body>
</html>