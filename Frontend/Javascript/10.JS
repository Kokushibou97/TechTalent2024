function esPalindromo(cadena) {
    var cadenaProcesada = cadena.toLowerCase().replace(/ /g, '');
    var cadenaInvertida = cadenaProcesada.split('').reverse().join('');
    
    return cadenaProcesada === cadenaInvertida;
}

console.log(esPalindromo("La ruta nos aportó otro paso natural"));  
console.log(esPalindromo("Anita lava la tina"));                      
console.log(esPalindromo("Hola mundo"));                             
console.log(esPalindromo("A mamá Roma le aviva el amor a mamá"));    
