package Deberes;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DDBB {
    public static void main(String[] args) {
        
        Map<String, Double> stockDatabase = new HashMap<>();

        
        stockDatabase.put("Leche", 5.99);
        stockDatabase.put("Huevos", 7.45);
        stockDatabase.put("Harina", 10.85);
        stockDatabase.put("Agua", 8.00);
        stockDatabase.put("Pan", 3.99);
        stockDatabase.put("Patatas", 12.99);
        stockDatabase.put("Tomate", 3.99);
        stockDatabase.put("Platanos", 2.99);
        stockDatabase.put("Naranjas", 5.99);
        stockDatabase.put("Pepinos", 2.99);

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("Stock de articulos en el almacén");
            System.out.println("1. Añadir artículo");
            System.out.println("2. Consultar precio de un artículo");
            System.out.println("3. Listar todos los artículos");
            System.out.println("4. Salir");
            System.out.print("Elige una opción de la anteriores: ");
            int opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Introduce el nombre del artículo: ");
                    String articulo = sc.next();
                    System.out.print("Introduce el precio: ");
                    double precio = sc.nextDouble();
                    stockDatabase.put(articulo, precio);
                    System.out.println("Artículo añadido correctamente.");
                    break;
                case 2:
                    System.out.print("Introduce el nombre del artículo a consultar: ");
                    String articuloConsultar = sc.next();
                    if (stockDatabase.containsKey(articuloConsultar)) {
                        System.out.println("Precio de " + articuloConsultar + stockDatabase.get(articuloConsultar));
                    } else {
                        System.out.println("El artículo no existe el almacén");
                    }
                    break;
                case 3:
                    System.out.println("Lista de Artículos");
                    for (Map.Entry<String, Double> entry : stockDatabase.entrySet()) {
                        System.out.println(entry.getKey()+ entry.getValue());
                    }
                    break;
                case 4:
                    System.out.println("Bye");
                    System.exit(0);
                default:
                    System.out.println("Opción no válida. Inténtalo de nuevo.");
            }
        }
    }
}
