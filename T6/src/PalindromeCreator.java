import java.util.Scanner;

public class PalindromeCreator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese una cadena para crear un palíndromo: ");
        String input = scanner.nextLine();
        scanner.close();

        String palindrome = createPalindrome(input);
        System.out.println("El palíndromo creado es: " + palindrome);
    }

    public static String createPalindrome(String input) {
        StringBuilder palindromeBuilder = new StringBuilder(input);

        // Agregar el reverso de la cadena excepto el primer carácter
        for (int i = input.length() - 2; i >= 0; i--) {
            palindromeBuilder.append(input.charAt(i));
        }

        return palindromeBuilder.toString();
    }
}
