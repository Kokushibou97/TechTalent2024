import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DDBB {
    public static void main(String[] args) {
        
        Map<String, Double> stockDatabase = new HashMap<>();

        
        stockDatabase.put("Camiseta", 19.99);
        stockDatabase.put("Pantalones", 39.99);
        stockDatabase.put("Zapatos", 59.99);
        stockDatabase.put("Gorra", 14.99);
        stockDatabase.put("Calcetines", 9.99);
        stockDatabase.put("Vestido", 49.99);
        stockDatabase.put("Chaqueta", 79.99);
        stockDatabase.put("Bufanda", 24.99);
        stockDatabase.put("Bolso", 34.99);
        stockDatabase.put("Reloj", 99.99);

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Control de Stock ---");
            System.out.println("1. Añadir artículo");
            System.out.println("2. Consultar precio de un artículo");
            System.out.println("3. Listar todos los artículos");
            System.out.println("4. Salir");
            System.out.print("Elige una opción: ");
            int opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Introduce el nombre del artículo: ");
                    String articulo = sc.next();
                    System.out.print("Introduce el precio del artículo: ");
                    double precio = sc.nextDouble();
                    stockDatabase.put(articulo, precio);
                    System.out.println("Artículo añadido correctamente.");
                    break;
                case 2:
                    System.out.print("Introduce el nombre del artículo a consultar: ");
                    String articuloConsultar = sc.next();
                    if (stockDatabase.containsKey(articuloConsultar)) {
                        System.out.println("Precio de " + articuloConsultar + ": $" + stockDatabase.get(articuloConsultar));
                    } else {
                        System.out.println("El artículo no existe en la base de datos.");
                    }
                    break;
                case 3:
                    System.out.println("--- Lista de Artículos ---");
                    for (Map.Entry<String, Double> entry : stockDatabase.entrySet()) {
                        System.out.println(entry.getKey() + ": $" + entry.getValue());
                    }
                    break;
                case 4:
                    System.out.println("¡Hasta luego!");
                    System.exit(0);
                default:
                    System.out.println("Opción no válida. Inténtalo de nuevo.");
            }
        }
    }
}
