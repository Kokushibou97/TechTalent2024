package u10;
import java.util.Random;
import java.util.Scanner;

class Password {
    private int longitud;
    private String contrasena;

    public Password() {
        this.longitud = 8;
        generarPassword();
    }

    public Password(int longitud) {
        this.longitud = longitud;
        generarPassword();
    }

    public boolean esFuerte() {
        int mayusculas = 0;
        int minusculas = 0;
        int numeros = 0;

        for (char c : contrasena.toCharArray()) {
            if (Character.isUpperCase(c)) {
                mayusculas++;
            } else if (Character.isLowerCase(c)) {
                minusculas++;
            } else if (Character.isDigit(c)) {
                numeros++;
            }
        }

        return mayusculas > 2 && minusculas > 1 && numeros > 5;
    }

    private void generarPassword() {
        String caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder sb = new StringBuilder();

        Random random = new Random();
        for (int i = 0; i < longitud; i++) {
            int index = random.nextInt(caracteres.length());
            sb.append(caracteres.charAt(index));
        }

        contrasena = sb.toString();
    }

    public String getContrasena() {
        return contrasena;
    }

    public int getLongitud() {
        return longitud;
    }

    public void setLongitud(int longitud) {
        this.longitud = longitud;
        generarPassword();
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Introduce la longitud de las contraseñas: ");
        int longitud = scanner.nextInt();

        System.out.print("Introduce el número de contraseñas a generar: ");
        int numContraseñas = scanner.nextInt();

        Password[] contraseñas = new Password[numContraseñas];
        boolean[] esFuerte = new boolean[numContraseñas];

        for (int i = 0; i < numContraseñas; i++) {
            contraseñas[i] = new Password(longitud);
            esFuerte[i] = contraseñas[i].esFuerte();
        }

        System.out.println("Contraseñas generadas:");
        for (int i = 0; i < numContraseñas; i++) {
            System.out.println(contraseñas[i].getContrasena() + " " + esFuerte[i]);
        }
    }
}
