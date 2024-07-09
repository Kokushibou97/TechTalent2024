function determinarParImpar(numero) {
    if (numero % 2 === 0) {
        return "El número " + numero + " es par.";
    } else {
        return "El número " + numero + " es impar.";
    }
}

var numero = 23;
var resultado = determinarParImpar(numero);
console.log(resultado);
