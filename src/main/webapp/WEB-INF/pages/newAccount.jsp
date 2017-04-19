<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
			<h1>Creare cont</h1>
			<div>
				<div>
					<div>Nume: </div>
					<input type = "text"/>
					<br>
					
					<div>Prenume: </div>
					<input type = "text"/>
					<br>
					
					<div>Email: </div>
					<div>
						<input type = "text"/>
					</div>
						
					<div>Parola: </div>
					<input type = "text"/>
					<br>
				</div>
			
			<div>
				<div>Telefon: </div>
				<input type = "text"/>
				<br>
				
				<div>Adresa: </div>
				<input type = "text"/>
				<br>
				
				<div>Tip cont: </div>
				<select>
					<option>Cumparator</option>
					<option>Furnizor</option>
				</select>
			
			</div>
		</div>
		<br>
		<button id = "creare-cont-button">Creare cont</button>
	</div>
</body>
</html>