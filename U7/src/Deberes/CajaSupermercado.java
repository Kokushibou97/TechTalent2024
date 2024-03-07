package Deberes;

import java.util.ArrayList;
import java.util.Scanner;

public class CajaSupermercado {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		//
		ArrayList<Producto> carrito = new ArrayList<>();
		double totalBruto = 0.0;
		double iva = 0.0;
		int numArticulos = 0;

		System.out.println("Bienvenido al Supermercado App");
		System.out.println("Ingrese los nombres y precios de los productos (0 para finalizar):");

		// Leer productos hasta que se ingrese 0
		String nombre;
		double precio;
		do {
			System.out.print("Nombre del producto (0 para finalizar): ");
			nombre = scanner.nextLine();
			if (!nombre.equals("0")) {
				System.out.print("Precio del producto: ");
				precio = scanner.nextDouble();
				scanner.nextLine(); // Consume the newline character
				if (precio > 0) {
					carrito.add(new Producto(nombre, precio));
					totalBruto += precio;
					numArticulos++;
				}
			}
		} while (!nombre.equals("0"));

		// Calcular IVA
		System.out.print("Ingrese el tipo de IVA (21 o 4): ");
		int tipoIVA = scanner.nextInt();
		if (tipoIVA == 21 || tipoIVA == 4) {
			iva = totalBruto * (tipoIVA / 100.0);
		} else {
			System.out.println("Tipo de IVA no válido. Se aplicará el 21% por defecto.");
			iva = totalBruto * 0.21;
		}

		// Calcular precio total con IVA
		double precioConIVA = totalBruto + iva;

		// Pedir cantidad pagada
		System.out.print("Ingrese la cantidad pagada: ");
		double cantidadPagada = scanner.nextDouble();

		// Calcular cambio
		double cambio = cantidadPagada - precioConIVA;

		// Mostrar información
		System.out.println("\nResumen de la compra:");
		System.out.println("Número de artículos comprados: " + numArticulos);
		for (Producto producto : carrito) {
			System.out.println(producto);
		}
		System.out.println("Precio total bruto: " + totalBruto);
		System.out.println("IVA aplicado (" + tipoIVA + "%): " + iva);
		System.out.println("Precio total con IVA: " + precioConIVA);
		System.out.println("Cantidad pagada: " + cantidadPagada);
		System.out.println("Cambio a devolver al cliente: " + cambio);

		scanner.close();
	}
}
