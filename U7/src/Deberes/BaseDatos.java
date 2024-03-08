package Deberes;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BaseDatos {
    public static void main(String[] args) {
        // Crear un diccionario para almacenar los artículos y sus precios
        Map<String, Double> stockDatabase = new HashMap<>();

        // Agregar 10 artículos iniciales (puedes modificarlos según tus necesidades)
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

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Control de Stock ---");
            System.out.println("1. Añadir artículo");
            System.out.println("2. Consultar precio de un artículo");
            System.out.println("3. Listar todos los artículos");
            System.out.println("4. Salir");
            System.out.print("Elige una opción: ");
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Introduce el nombre del artículo: ");
                    String articulo = scanner.next();
                    System.out.print("Introduce el precio del artículo: ");
                    double precio = scanner.nextDouble();
                    stockDatabase.put(articulo, precio);
                    System.out.println("Artículo añadido correctamente.");
                    break;
                case 2:
                    System.out.print("Introduce el nombre del artículo a consultar: ");
                    String articuloConsultar = scanner.next();
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

