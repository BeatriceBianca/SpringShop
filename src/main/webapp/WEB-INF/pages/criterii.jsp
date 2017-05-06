    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<form:form modelAttribute="categoryForm" method="POST" id="left-div"> 
		<div> Categorie: </div> 
			<form:select path="category" id = "categorie">
				<form:option value="5">&nbsp;</form:option>
		   	    <form:option value="6">IT</form:option>
				<form:option value="7">Electrocasnice</form:option>
			    <form:option value="8">Fashion</form:option>
			    <form:option value="9">Sport</form:option>
			    <form:option value="10">Accesorii</form:option>
			</form:select>
		<br><br>
			
		<div> Pret </div>
			<div id = "pret">
				<form:input id="pret-min" path="minPrice"/>
				<span> - </span>
				<form:input id="pret-max" path="maxPrice"/>
			</div>
		<br>
			
		<div> Disponibilitate </div>
			<form:radiobutton path="productsLeftInStock"  value="0" /> Toate<br>
			<form:radiobutton path="productsLeftInStock"  value="1"/> In stoc 
		<br><br>
			
		<button id="criterii"> Submit </button>	
	</form:form>

	