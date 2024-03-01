package Deberes;
import java.util.Scanner;

public class due {

	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

  
        double preB = 0;
        double Iva = 0.21;
        int numArti = 0;

        System.out.println("Hello! soy el sistema de gestión de ventas del supermercado ¿Cómo te puedo ayudar? ");

        while (true) {
            System.out.print("escribe el precio del artículo ");
            double precioArticulo = Double.parseDouble(sc.nextLine());

            if (precioArticulo == 0) {
                break;
            }

            preB += precioArticulo;
            numArti++;
        }


        double precioConIVA = preB * (1 + Iva);

        System.out.print("¿Cuánto pagó el cliente? ");
        double cantidadPagada = Double.parseDouble(sc.nextLine());

 
        double cambio = cantidadPagada - precioConIVA;

        System.out.println("\nconclusión ");
        System.out.println("Número de cosas comprados: " + numArti);
        System.out.println("Precio bruto: " +preB);
        System.out.println("IVA (" + (Iva * 100) + "%): " + (precioConIVA - preB));
        System.out.println("Precio con IVA: " + precioConIVA);
        System.out.println("pagado por el cliente " + cantidadPagada);
        System.out.println("Cambio " + cambio);

        sc.close();
	}
}
