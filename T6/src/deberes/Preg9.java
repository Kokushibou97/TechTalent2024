package deberes;

import java.util.Scanner;
import java.util.Random;

public class Preg9 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println(" registra el tamaño del array ");
		int tamaño = sc.nextInt();
		int[] array = new int[tamaño];
		llenarArray(array, 0, 300);
		mostrarArray(array);
		sc.close();
	}

	public static void llenarArray(int[] array, int min, int maxi) {
		Random rand = new Random();
		for (int i = 0; i < array.length; i++) {
			array[i] = rand.nextInt(maxi - min+1)+min;
		}
	}

	public static void mostrarArray(int[] array) {
		int suma = 0;
		System.out.println("valor de cada posición");
		for (int i = 0; i < array.length; i++) {
			System.out.println("Posición " + i + " es " + array[i]);
			suma += array[i];
		}
		System.out.println(" La suma de todos los valores " + suma);
	}
}
