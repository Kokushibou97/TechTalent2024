function calcularFactorial(numero) {

    var factorial = 1;


    for (var i = 1; i <= numero; i++) {
        factorial *= i;
    }

    return factorial;
}

var numero = 5;
var resultado = calcularFactorial(numero);
console.log("El factorial de " + numero + " es: " + resultado);
