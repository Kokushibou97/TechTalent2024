package deberes;
import java.util.Scanner;
public class PR6 {

	public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);	
int num;
do {
	System.out.println("introduce un num sin comas ");
	num=sc.nextInt();
}while (num <=0);
int totalDigitos = totalDigitos(num);
System.out.println("El total de las cifras "+totalDigitos+" es ");
	sc.close();
	}
public static int totalDigitos(int num) {
	int digitos = 0;
	while (num !=0) {
		num/=10;
		digitos++;
	}
	return digitos;
}
}
