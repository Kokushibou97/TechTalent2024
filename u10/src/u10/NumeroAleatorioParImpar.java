package u10;

import java.util.Random; // Importación de la clase Random

// Definición de una nueva excepción ParImparException que extiende de la clase Exception
class ParImparException extends Exception {
    public ParImparException(String mensaje) {
        super(mensaje);
    }
}

public class NumeroAleatorioParImpar { // Declaración de la clase principal

    public static void main(String[] args) { // Método principal
        try { // Inicio del bloque try para manejar excepciones
            int numeroAleatorio = generarNumeroAleatorio(); // Llamada al método para generar un número aleatorio
            verificarParidad(numeroAleatorio); // Llamada al método para verificar la paridad del número
        } catch (ParImparException e) { // Captura de la excepción ParImparException
            System.out.println(e.getMessage()); // Impresión del mensaje de la excepción
        }
    }

    public static int generarNumeroAleatorio() { // Método para generar un número aleatorio
        Random random = new Random(); // Creación de un objeto de la clase Random
        return random.nextInt(1000); // Generación de un número aleatorio entre 0 y 999
    }

    // Método para verificar la paridad del número y lanzar una excepción ParImparException en caso de que sea par o impar
    public static void verificarParidad(int numero) throws ParImparException {
        if (numero % 2 == 0) { // Verificación de si el número es par
            throw new ParImparException("El número " + numero + " es par."); // Lanzamiento de la excepción si es par
        } else { // Si no es par, entonces es impar
            throw new ParImparException("El número " + numero + " es impar."); // Lanzamiento de la excepción si es impar
        }
    }
}
