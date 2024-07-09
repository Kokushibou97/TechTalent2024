
var valores = [true, 5, false, "hola", "adios", 2];


var texto1 = valores[3]; 
var texto2 = valores[4]; 
var mayorTexto = (texto1 > texto2) ? texto1 : texto2;
console.log("El texto mayor es: " + mayorTexto);


var booleano1 = valores[0]; 
var booleano2 = valores[2]; 
var resultadoTrue = booleano1 || booleano2; 
var resultadoFalse = booleano1 && booleano2; 
console.log("Resultado true con operadores booleanos: " + resultadoTrue);
console.log("Resultado false con operadores booleanos: " + resultadoFalse);


var num1 = valores[1]; 
var num2 = valores[5]; 
var suma = num1 + num2;
var resta = num1 - num2;
var multiplicacion = num1 * num2;
var division = num1 / num2;
var modulo = num1 % num2;
console.log("Suma: " + suma);
console.log("Resta: " + resta);
console.log("Multiplicación: " + multiplicacion);
console.log("División: " + division);
console.log("Módulo: " + modulo);
