package u10; 

import java.util.InputMismatchException; // Importación de la clase InputMismatchException
import java.util.Scanner; // Importación de la clase Scanner

// Definición de la clase Calculadora
class Calculadora {
    // Método para sumar dos números
    public double suma(double a, double b) {
        return a + b;
    }

    // Método para restar dos números
    public double resta(double a, double b) {
        return a - b;
    }

    // Método para multiplicar dos números
    public double multiplicacion(double a, double b) {
        return a * b;
    }

    // Método para dividir dos números
    public double division(double a, double b) throws ArithmeticException {
        // Verifica si el divisor es cero, en cuyo caso lanza una excepción
        if (b == 0) {
            throw new ArithmeticException("Error: No se puede dividir entre cero.");
        }
        return a / b;
    }

    // Método para calcular la potencia de un número
    public double potencia(double base, double exponente) {
        return Math.pow(base, exponente);
    }

    // Método para calcular la raíz cuadrada de un número
    public double raizCuadrada(double a) throws IllegalArgumentException {
        // Verifica si el número es negativo, en cuyo caso lanza una excepción
        if (a < 0) {
            throw new IllegalArgumentException("Error: No se puede calcular la raíz cuadrada de un número negativo.");
        }
        return Math.sqrt(a);
    }

    // Método para calcular la raíz cúbica de un número
    public double raizCubica(double a) {
        return Math.cbrt(a);
    }
}

public class Main { // Clase principal
    public static void main(String[] args) { // Método principal
        Scanner scanner = new Scanner(System.in); // Creación de un objeto Scanner para leer la entrada del usuario
        Calculadora calculadora = new Calculadora(); // Creación de un objeto Calculadora

        try { // Inicio del bloque try para manejar excepciones
            System.out.print("Introduce el primer número: "); // Solicita al usuario que ingrese el primer número
            double num1 = scanner.nextDouble(); // Lee el primer número ingresado por el usuario

            System.out.print("Introduce el segundo número: "); // Solicita al usuario que ingrese el segundo número
            double num2 = scanner.nextDouble(); // Lee el segundo número ingresado por el usuario

            // Muestra los resultados de diferentes operaciones matemáticas utilizando el objeto Calculadora
            System.out.println("Suma: " + calculadora.suma(num1, num2));
            System.out.println("Resta: " + calculadora.resta(num1, num2));
            System.out.println("Multiplicación: " + calculadora.multiplicacion(num1, num2));
            System.out.println("División: " + calculadora.division(num1, num2));
            System.out.println("Potencia: " + calculadora.potencia(num1, num2));
            System.out.println("Raíz cuadrada del primer número: " + calculadora.raizCuadrada(num1));
            System.out.println("Raíz cúbica del segundo número: " + calculadora.raizCubica(num2));
        } catch (InputMismatchException e) { // Captura la excepción InputMismatchException si el usuario ingresa un valor no válido
            System.out.println("Entrada no válida. Debe ser un número."); // Imprime un mensaje de error
        } catch (ArithmeticException | IllegalArgumentException e) { // Captura excepciones ArithmeticException e IllegalArgumentException
            System.out.println(e.getMessage()); // Imprime el mensaje de la excepción capturada
        }
    }
}

