import java.util.Scanner;
public class Preg5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
Scanner scanner = new Scanner (System.in);
System.out.println("Introduce un numero intero ");
int numero = scanner.nextInt();

if (numero % 2 == 0) {
	System.out.println(" El numero "+numero+" es divisible entre 2 ");
}else {
System.out.println("El numero "+numero+" NO es divisible entre 2 ");
}
scanner.close();
	}

}
