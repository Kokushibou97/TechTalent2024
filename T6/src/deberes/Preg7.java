package deberes;
import java.util.Scanner;
public class Preg7 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println(" pon cuantos euros  ");
		double euros= sc.nextDouble();
		System.out.println("Pone la divisia a la que desea cambiar ");
		String divisa= sc.next();
CambioDivisa(euros, divisa);
	}
public static void CambioDivisa(double euros, String divisa) {
	double resultado=0;
	switch(divisa.toLowerCase()) {
	case "dólar":
		resultado = euros*1.28611;
		System.out.println(euros+" los euros en dolares serán "+resultado);
		break;
	case "yenes":
		resultado = euros*129.852;
		System.out.println(euros+" los euros en yenes serán "+resultado);
		break;
	case"libras":
		resultado = euros* 0.86;
		System.out.println(euros+" los euros en libras serán "+resultado);
		break;
		default:
		System.out.println("divisa inéxistente");
	}
}
}
