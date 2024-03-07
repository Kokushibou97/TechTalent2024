package Deberes;

import java.util.ArrayList;
import java.util.List;

//Creamos el primer objeto "Articulo"//
class Articulos {
	// Creamos los parametros que vamos a usar(importantes?)//
	public String código;
	public double precio;
	public int cantidad;

//usamos el constructor this para guardar/asignar info//
	public Articulos(String código, double precio, int cantidad) {
		this.código = código;
		this.precio = precio;
		this.cantidad = cantidad;
	}

//este método calcula el precio por cantidad del producto//
	public double getPrecioTotal() {
		return precio * cantidad;
	}
}

//Aquí hemos creado el 2ndo objeto carrito//
class Carrito {
	// mediante un hashtable creamos el atributo producto que es una lista de
	// objetos tipo producto//
	// usando el arraylist, la lista se irá llenando a medida que el usuario añada
	// productos//
	private List<Articulos> productos = new ArrayList<>();

//Aquí tenemos el método para añadir productos como parametros y los añadira a la lista//
	public void agregarArticulos(Articulos articulos) {
		productos.add(articulos);
	}

//Este metodo calculo el numero de los productos//
	public int getNumeroArticulos() {
		return productos.size();
	}

//Este método  calcula el precio bruto total, luego, recorre cada producto y//
	// a de cada producto añade su precio al total//
	public double getPrecioTotalBruto() {
		double total = 0;
		for (Articulos articulos : productos) {
			total += articulos.getPrecioTotal();
		}
		// Aquí se devuelve el precio total//
		return total;
	}
}

//Aquí tenemos el 3ra objeto//
class Cliente {
	// escribimos los paramteros importantes para la operación//
	public String identificador;
	public double cantidadPagada;

//se crea el constructor//
	public Cliente(String identificador, double cantidadPagada) {
		this.identificador = identificador;
		this.cantidadPagada = cantidadPagada;
	}

//Después se crea el método de cambio, que depende del precio total//
	public double getCambio(double precioTotal) {
		return cantidadPagada - precioTotal;
	}
}

public class CajaSupermercado {
	public static void main(String[] args) {

		Articulos manzanas = new Articulos("Huevos", 2.5, 3);
		Articulos leche = new Articulos("Harina", 1.0, 2);

		// Aquí se añaden los productos al carrito//
		Carrito carrito = new Carrito();
		carrito.agregarArticulos(manzanas);
		carrito.agregarArticulos(leche);

		// En este bloque calculamos totalbruto, luego con el IVA, después demostramos
		// el total//
		double precioTotalBruto = carrito.getPrecioTotalBruto();
		double iva = precioTotalBruto * 0.21;
		double precioTotalConIVA = precioTotalBruto + iva;

		// Creamos al cliente y calculamos su cambio//
		Cliente cliente = new Cliente("Juan", 10.0);
		double cambio = cliente.getCambio(precioTotalConIVA);

		// Finalmente, mostramos la información en la factura//
		System.out.println("IVA aplicado (21%): " + iva);
		System.out.println("Precio total bruto: " + precioTotalBruto);
		System.out.println("Precio total con IVA: " + precioTotalConIVA);
		System.out.println("Número de artículos comprados: " + carrito.getNumeroArticulos());
		System.out.println("Cantidad pagada: " + cliente.getCantidadPagada());
		System.out.println("Cambio a devolver al cliente: " + cambio);
	}
}
