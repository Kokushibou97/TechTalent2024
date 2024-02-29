package deberes;
import java.util.Scanner;

public class Pr5 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(" Pon un número decimal para convertirlo en binario:");
        int numDeci = sc.nextInt();
        String binario = ABinario(numDeci);
        System.out.println("El número binario es: " + binario);
        sc.close();
    }

    public static String ABinario(int numDeci) {
        if (numDeci == 0) {
            return "0";
        }
        StringBuilder resultado = new StringBuilder();
        while (numDeci > 0) {
            int nobi = numDeci % 2;
            resultado.insert(0, nobi);
            numDeci /= 2;
        }
        return resultado.toString();
    }
}
