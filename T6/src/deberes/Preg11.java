package deberes;
import java.util.random.*;
import java.util.Scanner;
import java.util.Arrays;

public class Preg11 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce la dimensión de los arrays:");
		int dimension = sc.nextInt();

		int[] array1 = new int[dimension];
		int[] array2 = new int[dimension];

		System.out.println("Contenido del primer array: " + Arrays.toString(array1));
		System.out.println("Contenido del segundo array: " + Arrays.toString(array2));

		int[] resultado = multiplicarArrays(array1, array2);

		System.out.println("Resultado de la multiplicación: " + Arrays.toString(resultado));
	}

	public static void llenarArray(int[] array) {
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < array.length; i++) {
			System.out.println("Introduce valor " + i + ":");
			array[i] = sc.nextInt();
		}
	}

	public static int[] multiplicarArrays(int[] array1, int[] array2) {
		int[] resultado = new int[array1.length];
		for (int i = 0; i < array1.length; i++) {
			resultado[i] = array1[i] * array2[i];
		}
		return resultado;
	}
}
