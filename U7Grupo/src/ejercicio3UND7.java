import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

//definición de la clase//
public class ejercicio3UND7 {

	public static void main(String[] args) {

		// Se crea un objeto HashMap llamado stockProducto que mapea nombres de
		// productos (String) a cantidades disponibles (Integer)//
		Map<String, Integer> stockProducto = new HashMap<>();

		stockProducto.put("platano", 2);
		stockProducto.put("manzana ", 5);
		stockProducto.put("pato ", 2);
		stockProducto.put("kebab ", 9);
		stockProducto.put("zanahoria ", 99);
		stockProducto.put("zatano ", 39);
		stockProducto.put("aranadno ", 2);
		stockProducto.put("pera", 7);

//			System.out.println("Escriba la cantidad de Articulos que quiere añadir ");
//			int cantidadCesta =  sc.nextInt();
//			idea antigua

		Scanner scanner = new Scanner(System.in);

		System.out.print("Quiere ver los articulos disponibles en stock? ");
		String articulosDisponibles = scanner.next();
		// Si el usuario ingresa "si", se imprime el stock de productos. Si no, se
		// muestra un mensaje indicando que el usuario debe agregar productos
		// manualmente//
		if (articulosDisponibles.equals("si")) {
			System.out.println(stockProducto);

		} else {
			System.out.println("\nProcede a añadir los productos y las cantidades de forma manual");

		}

		System.out.println("\nEscriba la cantidad de productos que quiere añadir ");
		int cantidadProductos = scanner.nextInt();

		// Se pide al usuario que ingrese la cantidad de productos que desea agregar//
		for (int i = 1; i <= cantidadProductos; i++) {
			System.out.println("\nEscriba el nombre del articulo: ");
			String nombreProducto = scanner.next();

			System.out.println("\nEscriba la cantidad del articulo que desea añadir: ");
			int cantidadArticulos = scanner.nextInt();
			// Se solicita al usuario que ingrese la cantidad del producto que desea
			// agregar//
			System.out.println("\nAñadimos al stock " + cantidadArticulos + " unidades de " + nombreProducto);

		}

	}

}
