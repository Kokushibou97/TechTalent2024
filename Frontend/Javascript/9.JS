function analizarCadena(cadena) {
    var esSoloMayusculas = true;
    var esSoloMinusculas = true;

    for (var i = 0; i < cadena.length; i++) {
        var char = cadena.charAt(i);
        if (char >= 'A' && char <= 'Z') {
            esSoloMinusculas = false;
        } else if (char >= 'a' && char <= 'z') {
            esSoloMayusculas = false;
        }
        if (!esSoloMayusculas && !esSoloMinusculas) {
            break;
        }
    }

    if (esSoloMayusculas) {
        console.log("La cadena '" + cadena + "' está formada solo por mayúsculas.");
    } else if (esSoloMinusculas) {
        console.log("La cadena '" + cadena + "' está formada solo por minúsculas.");
    } else {
        console.log("La cadena '" + cadena + "' está formada por una mezcla de mayúsculas y minúsculas.");
    }
}
analizarCadena("HOLA");       
analizarCadena("hola");        
analizarCadena("Hola Mundo");  
analizarCadena("12345");       
