<form id="left-div"> 
		<div> Categorie: </div> 
	    <select name="categorie">
		  <option>[Orice]</option>
		  <option value="it">IT</option>
		  <option value="electrocasnice">Electrocasnice</option>
		  <option value="fashion">Fashion</option>
		  <option value="sport">Sport</option>
		  <option value="accesorii">Accesorii</option>
		</select>
		<br><br>
		
		<div> Pret </div>
		<input id="pret" type="range" min="50" max="500" step="10" onchange="afiseazaPret(this.value)"/>
		<span id="valoare"> </span>
		<br><br>
		
		<div> Disponibilitate </div>
		<input type="radio" name="disp" value="all" checked> Toate<br>
		<input type="radio" name="disp" value="disp"> In stoc 
		<br><br>
		
		<button id="criterii"> Submit </button>
		
</form>