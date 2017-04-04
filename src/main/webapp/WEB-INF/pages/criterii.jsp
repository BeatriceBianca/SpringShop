<form id="left-div"> 
	<div> Categorie: </div> 
		<select name="categorie" id = "categorie">
			<option>[Orice]</option>
	   	    <option value="it">IT</option>
			<option value="electrocasnice">Electrocasnice</option>
		    <option value="fashion">Fashion</option>
		    <option value="sport">Sport</option>
		    <option value="accesorii">Accesorii</option>
		</select>
	<br><br>
		
	<div> Pret </div>
		<div id = "pret">
			<input id="pret-min" type="text"/>
			<span> - </span>
			<input id="pret-max" type="text"/>
		</div>
	<br>
		
	<div> Disponibilitate </div>
		<input type="radio" name="disp" value="all" checked> Toate<br>
		<input type="radio" name="disp" value="disp"> In stoc 
	<br><br>
		
	<button id="criterii"> Submit </button>	
</form>