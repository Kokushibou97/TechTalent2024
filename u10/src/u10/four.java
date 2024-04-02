package u10;
import java.util.InputMismatchException;
import java.util.Scanner;

class Calculadora {
    public double suma(double a, double b) {
        return a + b;
    }

    public double resta(double a, double b) {
        return a - b;
    }

    public double multiplicacion(double a, double b) {
        return a * b;
    }

    public double division(double a, double b) throws ArithmeticException {
        if (b == 0) {
            throw new ArithmeticException("Error: No se puede dividir entre cero.");
        }
        return a / b;
    }

    public double potencia(double base, double exponente) {
        return Math.pow(base, exponente);
    }

    public double raizCuadrada(double a) throws IllegalArgumentException {
        if (a < 0) {
            throw new IllegalArgumentException("Error: No se puede calcular la raíz cuadrada de un número negativo.");
        }
        return Math.sqrt(a);
    }

    public double raizCubica(double a) {
        return Math.cbrt(a);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Calculadora calculadora = new Calculadora();

        try {
            System.out.print("Introduce el primer número: ");
            double num1 = scanner.nextDouble();

            System.out.print("Introduce el segundo número: ");
            double num2 = scanner.nextDouble();

            System.out.println("Suma: " + calculadora.suma(num1, num2));
            System.out.println("Resta: " + calculadora.resta(num1, num2));
            System.out.println("Multiplicación: " + calculadora.multiplicacion(num1, num2));
            System.out.println("División: " + calculadora.division(num1, num2));
            System.out.println("Potencia: " + calculadora.potencia(num1, num2));
            System.out.println("Raíz cuadrada del primer número: " + calculadora.raizCuadrada(num1));
            System.out.println("Raíz cúbica del segundo número: " + calculadora.raizCubica(num2));
        } catch (InputMismatchException e) {
            System.out.println("Entrada no válida. Debe ser un número.");
        } catch (ArithmeticException | IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
