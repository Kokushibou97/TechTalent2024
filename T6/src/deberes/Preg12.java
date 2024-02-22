package deberes;

import java.util.Random;
import java.util.Scanner;

public class Preg12 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Introduce el tamaño del array:");
		int tamaño = sc.nextInt();

		int[] array1 = new int[tamaño];

		llenarArray(array1, 1, 300);

		System.out.println("Introduce el dígito final que deseas buscar:");
		int digito = sc.nextInt();

		while (digito < 0 || digito > 9) {
			System.out.println("Por favor, introduce un dígito válido (0-9):");
			digito = sc.nextInt();
		}

		int[] numerosConDigito = obtenerNumerosConDigito(array1, digito);

		System.out.println("Números en el array que terminan en " + digito + ":");
		mostrarArray(numerosConDigito);
	}

	public static void llenarArray(int[] array, int min, int max) {
		Random rand = new Random();
		for (int i = 0; i < array.length; i++) {
			array[i] = rand.nextInt(max - min + 1) + min;
		}
	}

	public static void mostrarArray(int[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}

	public static int[] obtenerNumerosConDigito(int[] array, int digito) {
		int contador = 0;
		for (int i = 0; i < array.length; i++) {
			if (array[i] % 10 == digito) {
				contador++;
			}
		}

		int[] numerosConDigito = new int[contador];
		contador = 0;

		for (int i = 0; i < array.length; i++) {
			if (array[i] % 10 == digito) {
				numerosConDigito[contador] = array[i];
				contador++;
			}
		}

		return numerosConDigito;
	}
}
