function analizarCadena(cadena) {
    var esSoloMayusculas = true;
    var esSoloMinusculas = true;

    for (var i = 0; i < cadena.length; i++) {
        var char = cadena.charAt(i);
        
        // Verificar si el carácter actual es una letra y si es mayúscula o minúscula
        if (char >= 'A' && char <= 'Z') {
            esSoloMinusculas = false;
        } else if (char >= 'a' && char <= 'z') {
            esSoloMayusculas = false;
        }
        
        // Si encontramos un carácter que no es letra, ya sabemos que no es solo mayúsculas ni solo minúsculas
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

// Ejemplos de uso:
analizarCadena("HOLA");        // Salida esperada: La cadena 'HOLA' está formada solo por mayúsculas.
analizarCadena("hola");        // Salida esperada: La cadena 'hola' está formada solo por minúsculas.
analizarCadena("Hola Mundo");  // Salida esperada: La cadena 'Hola Mundo' está formada por una mezcla de mayúsculas y minúsculas.
analizarCadena("12345");       // Salida esperada: La cadena '12345' está formada por una mezcla de mayúsculas y minúsculas.
