
//Abrir y cerrar {}//
//NO olvidar ;//
import java.util.Scanner;

public class Semana3 {

	static final double Largo = 300.3;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// partiendo de los datos siguientes//
		double divide = 20.0;
		double divisor = 6.0;
		double sumFinal = 3.0;
		double resultado = 0.0;
		resultado = divide / divisor;
		resultado = resultado + sumFinal;
		System.out.println(resultado);

		// Primero la 1ra piscina//
		System.out.println("Porfavor, introduce el amplio de la 1ra piscina.");
		double ampPi1 = sc.nextDouble(); // almacenamos el valor en amPi1 que es una variable double, ya que el numero
											// no es entero//
		System.out.println("el amplio de la 1ra pi es " + ampPi1);
		System.out.println("Porfavor, introduce la profundidad de la 1ra piscina.");
		double profunPi1 = sc.nextDouble();// el objetivo de sc.nextDouble es leer el valor de la variable//
		System.out.println("La profundidad de la 1ra pi es " + profunPi1);
		int areaPi1 = (int) (Largo * ampPi1);// Aquí hacemos los calculos sencillos//
		System.out.println("La area de la 1ra pi es" + areaPi1);
		int volPi1 = (int) (Largo * ampPi1 * profunPi1);// se usa un int, porque luego el resultado será entero//
		System.out.println("La area de la 1ra pi es" + volPi1);

//segunda pi//
		System.out.println("Porfavor, introduce el amplio de 2nda 1ra piscina.");
		double ampPi2 = sc.nextDouble();
		System.out.println("el amplio de la 2nda pi es " + ampPi2);
		System.out.println("Porfavor, introduce la profundidad de la 2nda piscina.");
		double profunPi2 = sc.nextDouble();
		System.out.println("La profundidad de la 2nda pi es " + profunPi2);
		int areaPi2 = (int) (Largo * ampPi2);
		System.out.println("La area de la 2nda pi es" + areaPi2);
		int volPi2 = (int) (Largo * ampPi2 * profunPi2);
		System.out.println("La area de la 2nda pi es" + volPi2);
	}
}
