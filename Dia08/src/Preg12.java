import java.util.Scanner;

public class Preg12 {

    public static void main(String[] args) {
        String pass = "@Blah?568";
        Scanner scanner = new Scanner(System.in);
        int intentos = 3;

        while (intentos > 0) {
            System.out.println("Introduce la contraseña (" + intentos + " intentos restantes):");
            String intento = scanner.next();

            if (intento.equals(pass)) {
                System.out.println("¡Felicitaciones! Tienes buena memoria.");
                break;
            } else {
                intentos--;
                if (intentos > 0) {
                    System.out.println("Contraseña incorrecta. Por favor, inténtalo de nuevo.");
                } else {
                    System.out.println("Has agotado todos los intentos. Acceso denegado.");
                }
            }
        }
        scanner.close();
    }
}
