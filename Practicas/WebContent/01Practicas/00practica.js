window.addEventListener("load", function(){

	document.getElementById("principal").innerHTML=
	'<input type="button" id="miBoton" value="Hazme click">';
	document.getElementById("miBoton").addEventListener("click", clickeame);
});

function clickeame()
{
	alert ("Hola caracola");
}