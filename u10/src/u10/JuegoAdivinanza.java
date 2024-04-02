package u10;
import java.util.InputMismatchException;
import java.util.Scanner;

public class JuegoAdivinanza {
    private int numeroObjetivo;
    private int intentos;

    public JuegoAdivinanza() {
        numeroObjetivo = (int) (Math.random() * 500) + 1;
        intentos = 0;
    }

    public void jugar() {
        Scanner scanner = new Scanner(System.in);
        try {
            while (true) {
                System.out.print("Introduce un número entre 1 y 500: ");
                int intentoUsuario = scanner.nextInt();
                intentos++;

                if (intentoUsuario == numeroObjetivo) {
                    System.out.println("¡Felicidades! Has adivinado el número en " + intentos + " intentos.");
                    break;
                } else if (intentoUsuario < numeroObjetivo) {
                    System.out.println("El número a adivinar es mayor.");
                } else {
                    System.out.println("El número a adivinar es menor.");
                }
            }
        } catch (InputMismatchException e) {
            System.out.println("Entrada no válida. Debe ser un número.");
        }
    }

    public static void main(String[] args) {
        JuegoAdivinanza juego = new JuegoAdivinanza();
        juego.jugar();
    }
}


