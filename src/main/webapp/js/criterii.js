window.onload = function(){
	document.getElementById("criterii").onclick = function() {
		if(document.getElementById("pret-max").value != ""){
			if(document.getElementById("pret-min").value > document.getElementById("pret-max").value)
				alert("Ai completat gresit pretul maxim!");
		}
	};
	
	document.getElementById("pret-min").onkeyup = function(e) {
		if(e.keyCode < 48 || e.keyCode > 57) {
			if(e.keyCode != 13) {
				document.getElementById("pret-min").value="";
			}
		}
	};
	
	document.getElementById("pret-max").onkeyup = function(e) {
		if(e.keyCode < 48 || e.keyCode > 57) {
			if(e.keyCode != 13) {
				document.getElementById("pret-max").value="";
			}
		}
	};
};


