import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class tresconwhile {

    public static void main(String[] args) {
        Map<String, Integer> stockProducto = new HashMap<>();
        stockProducto.put("platano", 2);
        stockProducto.put("manzana", 5);
        stockProducto.put("pato", 2);
        stockProducto.put("kebab", 9);
        stockProducto.put("zanahoria", 99);
        stockProducto.put("zatano", 39);
        stockProducto.put("aranadno", 2);
        stockProducto.put("pera", 7);

        Scanner scanner = new Scanner(System.in);
        
        String respuesta;
        do {
            System.out.print("Quiere ver los articulos disponibles en stock? (si/no): ");
            respuesta = scanner.next();

            if (respuesta.equalsIgnoreCase("si")) {
                System.out.println(stockProducto);
            } else if (!respuesta.equalsIgnoreCase("no")) {
                System.out.println("Por favor, responda 'si' o 'no'.");
            }
        } while (!respuesta.equalsIgnoreCase("si") && !respuesta.equalsIgnoreCase("no"));

        if (respuesta.equalsIgnoreCase("no")) {
            System.out.println("\nProcede a añadir los productos y las cantidades de forma manual");
        } else {
            System.out.println("\nEscriba la cantidad de productos que quiere añadir: ");
            int cantidadProductos = scanner.nextInt();

            for (int i = 1; i <= cantidadProductos; i++) {
                System.out.println("\nEscriba el nombre del articulo: ");
                String nombreProducto = scanner.next();

                System.out.println("\nEscriba la cantidad del articulo que desea añadir: ");
                int cantidadArticulos = scanner.nextInt();
                
                stockProducto.put(nombreProducto, cantidadArticulos);
                System.out.println("Añadimos al stock " + cantidadArticulos + " unidades de " + nombreProducto);
            }
        }
    }
}
