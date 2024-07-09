function calcularLetraDNI(numeroDNI) {
    var letras = ['T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E', 'T'];
    var resto = numeroDNI % 23;
    return letras[resto];
}

var numeroDNI = prompt("Introduce el número de DNI (sin letra):");
var letraUsuario = prompt("Introduce la letra del DNI (mayúscula):");


if (numeroDNI < 0 || numeroDNI > 99999999) {
    console.log("El número proporcionado no es válido.");
} else {
    
    var letraCalculada = calcularLetraDNI(numeroDNI);

    if (letraCalculada !== letraUsuario) {
        console.log("La letra indicada no es correcta.");
    } else {
        console.log("El número y la letra del DNI son correctos.");
    }
}
