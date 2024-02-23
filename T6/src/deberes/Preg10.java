package deberes;

import java.util.Random;
import java.util.Scanner;

public class Preg10 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Introduce el tamaño del array:");
		int tamaño = sc.nextInt();

		int[] array = generarNumerosPrimos(tamaño);

		System.out.println("El array generado con números primos es:");
		mostrarArray(array);

		int maximo = encontrarMaximo(array);
		System.out.println("El número primo máximo en el array es: " + maximo);
	}

	public static int[] generarNumerosPrimos(int tamaño) {
		int[] array = new int[tamaño];
		Random rand = new Random();

		int contador = 0;
		while (contador < tamaño) {
			int num = rand.nextInt(1000) + 1; 
			if (esPrimo(num)) {
				array[contador] = num;
				contador++;
			}
		}

		return array;
	}

	public static boolean esPrimo(int num) {
		if (num <= 1) {
			return false;
		}
		for (int i = 2; i <= Math.sqrt(num); i++) {
			if (num % i == 0) {
				return false;
			}
		}
		return true;
	}

	public static void mostrarArray(int[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}

	public static int encontrarMaximo(int[] array) {
		int maximo = Integer.MIN_VALUE;
		for (int i = 0; i < array.length; i++) {
			if (array[i] > maximo) {
				maximo = array[i];
			}
		}
		return maximo;
	}
}
