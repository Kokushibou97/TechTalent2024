package Deberes;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

class Producto {
    public Producto(String nombre2, double precio2) {

	}
	public Producto() {
		// TODO Auto-generated constructor stub
	}
	int id;
    String nombre;
    double precio;
    int stock;

}

public class preg4 {
    public static void main(String[] args) {
        HashMap<Integer, Producto> stockProductos = new HashMap<>();
        ArrayList<Producto> ventasRealizadas = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

      

        Producto producto1 = new Producto();
        producto1.id = 1;
        producto1.nombre = "Camiseta";
        producto1.precio = 20.0;
        producto1.stock = 50;
        stockProductos.put(producto1.id, producto1);

    }
}

