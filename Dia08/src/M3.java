import java.util.Scanner;
public class M3 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
        int suma = 0; 
        
        System.out.println("Introduce los números que desees sumar (introduce un número negativo para terminar):");
        
        while (true) {
            int numero = scanner.nextInt(); 
            
            if (numero < 0) {
                break; 
            }
            
            suma += numero; 
        }
        
 
        System.out.println("La suma total de los números ingresados es: " + suma);
        
        scanner.close();
    }
	}

