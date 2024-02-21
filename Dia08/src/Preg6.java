import java.util.Scanner;
public class Preg6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
final double IVA_Porcentaje=21;
Scanner scanner = new Scanner(System.in);
System.out.println(" Introduce el precio del producto ");
double precioProducto=scanner.nextDouble();
double precioFinal= precioProducto *(1+IVA_Porcentaje);
System.out.println(" El precio final del producto es " +precioFinal);
	}

}
