package deberes;
import java.util.Scanner;
import javax.swing.JOptionPane;
public class PR6 {

	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String numero = "";
        int num = 0;
        boolean isValid = false;
        
 
        if (args.length > 0 && args[0].equalsIgnoreCase("console")) {

            System.out.println("Introduce un número para saber su número de cifras:");
            num = sc.nextInt();
            isValid = (num > 0);
        } else {
  
            numero = JOptionPane.showInputDialog("Ingrese un numero para saber su numero de cifras:");
            String sinletras = numero.replaceAll("[\\D]", "");
            isValid = hayNumero(sinletras);
            num = Integer.parseInt(sinletras);
        }
        
 
        while (!isValid) {
            if (args.length > 0 && args[0].equalsIgnoreCase("console")) {
                System.out.println("Ingrese un número válido (mayor que 0):");
                num = sc.nextInt();
                isValid = (num > 0);
            } else {
                numero = JOptionPane.showInputDialog(null, "Ingrese un número válido (diferente de 0):");
                String sinletras = numero.replaceAll("[\\D]", "");
                isValid = hayNumero(sinletras);
                num = Integer.parseInt(sinletras);
            }
        }
        
    
        int totalDigitos = contarDigitos(num);
        
    
        if (args.length > 0 && args[0].equalsIgnoreCase("console")) {
            System.out.println("El número de cifras de " + num + " es: " + totalDigitos);
        } else {
            JOptionPane.showMessageDialog(null, "El número de cifras de " + num + " es: " + totalDigitos);
        }
        
        sc.close();
    }

    public static int contarDigitos(int num) {
        int digitos = 0;
        while (num != 0) {
            num /= 10;
            digitos++;
        }
        return digitos;
    }

    public static boolean hayNumero(String num) {
        int numero = Integer.parseInt(num);
        return (numero != 0);
    }
}