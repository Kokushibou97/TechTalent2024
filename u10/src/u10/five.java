package u10;

import java.util.Random; 
import java.util.Scanner; 

// Definición de la clase Password
class Password {
    private int longitud; // Declaración de variable privada para la longitud de la contraseña
    private String contrasena; // Declaración de variable privada para almacenar la contraseña

    // Constructor sin parámetros que genera una contraseña de longitud predeterminada (8 caracteres)
    public Password() {
        this.longitud = 8;
        generarPassword(); // Llamada al método para generar una contraseña
    }

    // Constructor con parámetro de longitud para generar una contraseña con la longitud especificada
    public Password(int longitud) {
        this.longitud = longitud;
        generarPassword(); // Llamada al método para generar una contraseña
    }

    // Método para verificar si la contraseña es fuerte
    public boolean esFuerte() {
        int mayusculas = 0;
        int minusculas = 0;
        int numeros = 0;

        // Recorre cada carácter de la contraseña y cuenta las mayúsculas, minúsculas y números
        for (char c : contrasena.toCharArray()) {
            if (Character.isUpperCase(c)) {
                mayusculas++;
            } else if (Character.isLowerCase(c)) {
                minusculas++;
            } else if (Character.isDigit(c)) {
                numeros++;
            }
        }

        // Verifica si la contraseña cumple con los criterios para ser considerada fuerte
        return mayusculas > 2 && minusculas > 1 && numeros > 5;
    }

    // Método privado para generar una contraseña aleatoria
    private void generarPassword() {
        String caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789"; // Definición de caracteres permitidos
        StringBuilder sb = new StringBuilder(); // Creación de un StringBuilder para construir la contraseña

        Random random = new Random(); // Creación de un objeto Random
        for (int i = 0; i < longitud; i++) { // Generación de caracteres aleatorios hasta alcanzar la longitud especificada
            int index = random.nextInt(caracteres.length());
            sb.append(caracteres.charAt(index));
        }

        contrasena = sb.toString(); // Asignación de la contraseña generada
    }

    // Método getter para obtener la contraseña
    public String getContrasena() {
        return contrasena;
    }

    // Método getter para obtener la longitud de la contraseña
    public int getLongitud() {
        return longitud;
    }

    // Método setter para establecer la longitud de la contraseña y generar una nueva contraseña
    public void setLongitud(int longitud) {
        this.longitud = longitud;
        generarPassword(); // Llamada al método para generar una nueva contraseña
    }
}

public class Main { // Clase principal
    public static void main(String[] args) { // Método principal
        Scanner scanner = new Scanner(System.in); // Creación de un objeto Scanner para leer la entrada del usuario

        // Solicita al usuario la longitud de las contraseñas y el número de contraseñas a generar
        System.out.print("Introduce la longitud de las contraseñas: ");
        int longitud = scanner.nextInt();

        System.out.print("Introduce el número de contraseñas a generar: ");
        int numContraseñas = scanner.nextInt();

        Password[] contraseñas = new Password[numContraseñas]; // Arreglo para almacenar las contraseñas generadas
        boolean[] esFuerte = new boolean[numContraseñas]; // Arreglo para almacenar el resultado de la verificación de fortaleza de cada contraseña

        // Genera las contraseñas y verifica su fortaleza
        for (int i = 0; i < numContraseñas; i++) {
            contraseñas[i] = new Password(longitud); // Genera una nueva contraseña con la longitud especificada
            esFuerte[i] = contraseñas[i].esFuerte(); // Verifica si la contraseña generada es fuerte
        }

        // Imprime las contraseñas generadas junto con su fortaleza
        System.out.println("Contraseñas generadas:");
        for (int i = 0; i < numContraseñas; i++) {
            System.out.println(contraseñas[i].getContrasena() + " " + esFuerte[i]);
        }
    }
}
