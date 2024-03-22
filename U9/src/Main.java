public class Main {
    public static void main(String[] args) {
        Electrodomestico[] electrodomesticos = new Electrodomestico[10];

        // Asigna objetos a cada posición con los valores deseados
        electrodomesticos[0] = new Electrodomestico(200, "negro", 'B', 10);
        electrodomesticos[1] = new Lavadora(8, 300, "blanco", 'A', 15);
        electrodomesticos[2] = new Television(32, true, 500, "gris", 'C', 20);
        // ... (similarly for other positions)

        // Recorre el array y ejecuta el método precioFinal()
        double totalElectrodomesticos = 0;
        double totalLavadoras = 0;
        double totalTelevisiones = 0;

        for (Electrodomestico electrodomestico : electrodomesticos) {
            if (electrodomestico instanceof Lavadora) {
                totalLavadoras += electrodomestico.precioFinal();
            } else if (electrodomestico instanceof Television) {
                totalTelevisiones += electrodomestico.precioFinal();
            }
            totalElectrodomesticos += electrodomestico.precioFinal();
        }

        // Muestra los resultados
        System.out.println("Total price for Electrodomesticos: " + totalElectrodomesticos + " €");
        System.out.println("Total price for Lavadoras: " + totalLavadoras + " €");
        System.out.println("Total price for Televisiones: " + totalTelevisiones + " €");
    }
}