package deberes;
import java.util.Scanner;
public class Preg3 {
public static boolean primo(int num) {
	if (num <=1) {
		return false;
	}
	for (int i=2; i<=Math.sqrt(num);i++) {
		if ( num % i==0) {
			return false;
		}
	}
	return true;
}
	public static void main(String[] args) {
Scanner sc= new Scanner(System.in);
System.out.println("Introduce un numero ");
int numero = sc.nextInt();
sc.close();
if (primo(numero)) {
	System.out.println(numero+" correcto, es un num primo ");
}else {
	System.out.println(numero+" nope, no es primo ");
	}
}
}
