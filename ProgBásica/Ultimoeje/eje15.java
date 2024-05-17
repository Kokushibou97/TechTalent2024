import java.util.Random;
import java.util.Scanner;

public class eje15 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //mediante syso pedimos el nombre//
        System.out.print("Porfavor, escribe el nombre y primer apellido: ");
        String nomApe = scanner.nextLine();

        //después intercalamos las letras//
        String contraseña = intercalarLetrass(nomApe);

        //generamos un aleatorio de 4 caracterers//
        Random rand = new Random();
        for (int i = 0; i < 4; i++) {
            int digito = rand.nextInt(10); //numeros random de 0 a 9//
            contraseña += digito;
        }

        // Mostra la contrasenya generada
        System.out.println("Contraseña generada: " + contraseña);
    }

    // Funció per intercalar les lletres del nom i cognom
    private static String intercalarLetrass(String nomApe) {
        StringBuilder result = new StringBuilder();
        String[] partes = nomApe.split(" ");
        String nom = partes[0];
        String ape = partes[1];

        for (int i = 0; i < 4; i++) {
            if (i < nom.length()) {
                result.append(nom.charAt(i));
            }
            if (i < ape.length()) {
                result.append(ape.charAt(i));
            }
        }

        return result.toString();
    }
}
