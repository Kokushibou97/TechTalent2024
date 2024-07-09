function esPalindromo(cadena) {
    // Convertir la cadena a minúsculas y eliminar espacios
    var cadenaProcesada = cadena.toLowerCase().replace(/ /g, '');
    
    // Comparar la cadena original con la cadena invertida
    var cadenaInvertida = cadenaProcesada.split('').reverse().join('');
    
    return cadenaProcesada === cadenaInvertida;
}

// Ejemplos de uso:
console.log(esPalindromo("La ruta nos aportó otro paso natural"));  // true
console.log(esPalindromo("Anita lava la tina"));                      // true
console.log(esPalindromo("Hola mundo"));                             // false
console.log(esPalindromo("A mamá Roma le aviva el amor a mamá"));    // true
