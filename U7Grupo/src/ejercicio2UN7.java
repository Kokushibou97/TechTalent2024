import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Iterator;//se importa la iterfaz para recorrer el hashmap//


public class ejercicio2UN7 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
//Aquí se pide al usuario que registre datos//
		System.out.print("Ingrese la cantidad de productos: ");
		int cantidadProductos = scanner.nextInt();
		
//Este Hashmap sirve para guardar los nombres de los productos como claves//
		//Luego los precios como valores//
Map<String, Double> PrecioProducto = new HashMap<>();
		
		
		//Después, se crea un bucle para leer los datos de los productos//
		for (int i = 1; i <= cantidadProductos; i++) {
			System.out.print("Ingrese el nombre del producto " + i + ": ");
			String nombreProducto = scanner.next();

			
		System.out.print("Ingrese precio producto: ");
		double precioProductoBruto = scanner.nextDouble();
		
		System.out.print("Es producto de primera necesidad: ");
		String necesidadIVA =  scanner.next();
		
		necesidadIVA = necesidadIVA.toLowerCase();

		double precioProductoNeto;
//Luego se crea un condicional para asignar un tipo de IVA, según respuesta si/no//
		if ( necesidadIVA.equals("si")) {
			precioProductoNeto = (precioProductoBruto*0.04)+precioProductoBruto;
            System.out.println("el IVA sera del 4%: "  + precioProductoBruto*0.04 +
            		"\nEl precio neto es de: " + precioProductoNeto);
            
        } else {
        	precioProductoNeto = (precioProductoBruto*0.21)+precioProductoBruto;
            System.out.println("El IVA sera del 21%: " + precioProductoBruto*0.21 +
            		"\nEl precio neto es de: " + precioProductoNeto);
        }
            PrecioProducto.put(nombreProducto, precioProductoNeto);
		}
		double sumaCompra = 0;//Después de todo lo anterior se calcula el precio total//
    	for (double m : PrecioProducto.values()) {
			sumaCompra += m;//guardará el valor de los values//
		}
    	//mostreo del total//
		double totalCompra = sumaCompra;
	
			System.out.println( "El precio total de la compra sera de: "+ totalCompra);
			//Aquí se pide el pago al cliente//
			System.out.print("El pago del cliente sera ");
			double pagoCliente =  scanner.nextDouble();
//			
			double cambioCliente = pagoCliente - totalCompra;
			System.out.println("El cliente pago " + pagoCliente + " y el cambio sera de " + cambioCliente);
			//Aquí se informa de la diferencia entre la factura y el lo que paga el cliente (devolución)//
		}
}
