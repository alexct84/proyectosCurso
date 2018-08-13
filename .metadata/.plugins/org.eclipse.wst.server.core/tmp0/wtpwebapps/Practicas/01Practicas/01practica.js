var modulo = {
	nombre: "Pepito",
	apellido: "Perez",
	obtenerEdad: function(){
		return 100;
	}
};

console.log(modulo.nombre + " "+ modulo.apellido);
console.log("Edad = "+ modulo.obtenerEdad());



var modulo2 = (function(){
	var miNombre = "Alejandro";
	var miApellido = "Carretero";
	
	return{
		nombre: miNombre,
		apellido: miApellido
	}
})();

