package u10;

import java.util.InputMismatchException; // Importación de la clase InputMismatchException
import java.util.Scanner; // Importación de la clase Scanner

public class JuegoAdivinanza { // Declaración de la clase

    private int numeroObjetivo; // Declaración de la variable entera privada numeroObjetivo
    private int intentos; // Declaración de la variable entera privada intentos

    public JuegoAdivinanza() { // Método constructor
        numeroObjetivo = (int) (Math.random() * 500) + 1; // Generación de un número aleatorio entre 1 y 500 y asignación a numeroObjetivo
        intentos = 0; // Inicialización de intentos en 0
    }

    public void jugar() { // Método para jugar el juego
        Scanner scanner = new Scanner(System.in); // Creación de un objeto Scanner para leer la entrada del usuario
        try { // Inicio del bloque try para manejar posibles excepciones
            while (true) { // Bucle para mantener el juego en funcionamiento hasta que el usuario adivine el número correcto
                System.out.print("Introduce un número entre 1 y 500: "); // Solicitando al usuario que ingrese un número
                int intentoUsuario = scanner.nextInt(); // Leyendo la entrada del usuario como un entero
                intentos++; // Incrementando el número de intentos realizados por el usuario

                if (intentoUsuario == numeroObjetivo) { // Comprobando si el intento del usuario coincide con el número generado aleatoriamente
                    System.out.println("¡Felicidades! Has adivinado el número en " + intentos + " intentos."); // Imprimiendo un mensaje de felicitación
                    break; // Saliendo del bucle ya que se ha ganado el juego
                } else if (intentoUsuario < numeroObjetivo) { // Comprobando si el intento del usuario es menor que el número objetivo
                    System.out.println("El número a adivinar es mayor."); // Indicando al usuario que intente con un número más grande
                } else { // Si el intento del usuario es mayor que el número objetivo
                    System.out.println("El número a adivinar es menor."); // Indicando al usuario que intente con un número más pequeño
                }
            }
        } catch (InputMismatchException e) { // Capturando InputMismatchException si el usuario ingresa un valor que no es un entero
            System.out.println("Entrada no válida. Debe ser un número."); // Imprimiendo un mensaje de error
        }
    }

    public static void main(String[] args) { // Método principal para ejecutar el programa
        JuegoAdivinanza juego = new JuegoAdivinanza(); // Creando una instancia de la clase JuegoAdivinanza
        juego.jugar(); // Llamando al método jugar() para iniciar el juego
    }
}
