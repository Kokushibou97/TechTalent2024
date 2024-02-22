package deberes;

import java.lang.reflect.Array;
import java.util.Scanner;

public class Preg8 {

	public static void main(String[] args) {
		int[] array = new int[10];
		llenarValores(array);
		mostrarArray(array);
	}

	public static void llenarValores(int[] array) {
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < array.length; i++) {
			System.out.println("Pon el valor para la intro " + i);
			array[i] = sc.nextInt();
		}
	}

	public static void mostrarArray(int[] array) {
		System.out.println("Índice\tValor");
		for (int i = 0; i < array.length; i++) {
			System.out.println(i + "\t" + array[i]);
		}
	}
}
