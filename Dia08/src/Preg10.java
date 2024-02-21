import java.util.Scanner;

public class Preg10 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce el número de ventas: ");
        int numeroVentas = scanner.nextInt();
        double sumVentas = 0;
        scanner.nextLine();
        
        for (int i = 1; i <= numeroVentas; i++) {
            System.out.println("Introduce la venta " + i);
            double ventas = scanner.nextDouble();
            sumVentas += ventas;
            scanner.nextLine();
        }
        
        System.out.println("La suma de todas las ventas es " + sumVentas);
        scanner.close();
    }
}

