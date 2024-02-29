package deberes;

import java.util.Random;
import java.util.Scanner;

public class Preg12 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("introduce numero ");
		int tamany = sc.nextInt();
		int[] array1 = new int[tamany];

		llenarArray(array1, 1, 300);
//		mostrarArray(array1);		
		System.out.println("introduce un digito ");
		int digito = sc.nextInt();

		while (digito < 0 || digito > 9) {
			System.out.println(" numero invalido, debe de ser un digito ");
			digito = sc.nextInt();
		}

		int[] conDigito = conDigito(array1, digito);

		System.out.println("" + digito);
		mostrarArray(conDigito(array1, digito));
	}

	

	public static void llenarArray(int[] array, int min, int max) {
		Random rand = new Random();
		for (int i = 0; i < array.length; i++) {
			array[i] = rand.nextInt(max - min + 1) + min;
		}
	}

	public static void mostrarArray(int[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i]+" ");
		}
		System.out.println();
	}

	public static int[]  conDigito(int[] array, int digito) {
		int contador = 0;
		for (int i = 0; i < array.length; i++) {
			if (array[i] % 10 == digito) {
				contador++;
			}
		}

		int[]  conDigito = new int[contador];
		contador = 0;

		for (int i = 0; i < array.length; i++) {
			if (array[i] % 10 == digito) {
				 conDigito[contador] = array[i];
				contador++;
			}
		}

		return  conDigito;
	}
}
