package Deberes;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class trois {
    public static void main(String[] args) {
        
        Map<String, Double> stockDatabase = new HashMap<>();

        // añadir//
        stockDatabase.put("Camiseta", 19.99);
        stockDatabase.put("Pantalones", 39.99);
        stockDatabase.put("Zapatos", 59.99);
        

        //para poner más//
        Scanner scanner = new Scanner(System.in);
        System.out.println("¿Nuevo artículo? Introduce el nombre:");
        String nuevoArticulo = scanner.nextLine();
        System.out.println("¿Precio del artículo?");
        double precio = scanner.nextDouble();
        stockDatabase.put(nuevoArticulo, precio);

        //mostrar//
        System.out.println("¿Qué artículo deseas consultar?");
        String articuloConsultado = scanner.next();
        if (stockDatabase.containsKey(articuloConsultado)) {
            double precioArticulo = stockDatabase.get(articuloConsultado);
            System.out.println("Precio de " + articuloConsultado + ": $" + precioArticulo);
        } else {
            System.out.println("El artículo no existe en la base de datos.");
        }

        //poner en lista//
        System.out.println("Inventario completo:");
        for (Map.Entry<String, Double> entry : stockDatabase.entrySet()) {
            System.out.println(entry.getKey() + ": $" + entry.getValue());
        }
    }
}
