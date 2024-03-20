import java.util.Arrays;

//creación del objeto Electrodoméstico//
public class Electrodoméstico {
	// Luegoo, se crean los constantes para dar valores por defecto//
	private static final String DEFAULT_COLOR = "blanco";// los valores son privados para ser accesibles únicamente
															// aquí//
	private static final String DEFAULT_CONSUMO = "F";
	private static final double DEFAULT_PRECIO_BASE = 100;
	private static final double DEFAULT_PESO = 5;

	// Creamos otro constante para escribir colores predeterminados//
	private static final String[] AVAILABLE_COLORES = { "blanco", "negro", "rojo", "azul", "gris" };

	// Aquí definimos los atributos//
	private double precioBase;
	private String color;
	private String consumo;
	private double peso;

	// Aquí tenemos el primer constructor por defecto//
	public Electrodoméstico() {
		this(DEFAULT_PRECIO_BASE, DEFAULT_PESO, DEFAULT_COLOR, DEFAULT_CONSUMO);
	}

	// Después,el segundo constructor con precio y peso//
	public Electrodoméstico(double precioBase, double peso) {
		this(precioBase, peso, DEFAULT_COLOR, DEFAULT_CONSUMO);
	}

	// Luego, otro constructor con todos los atributos//
	public Electrodoméstico(double precioBase, double peso, String color, String consumo) {

		this.color = Arrays.stream(AVAILABLE_COLORES).filter(c -> c.equalsIgnoreCase(color)).findFirst()
				.orElse(DEFAULT_COLOR);

		// Aquí validamos el consumo//
		this.consumo = Arrays.asList("A", "B", "C", "D", "E", "F").contains(consumo.toUpperCase())
				? consumo.toUpperCase()
				: DEFAULT_CONSUMO;

		this.precioBase = precioBase;
		this.peso = peso;
	}

	public static void main(String[] args) {
		Electrodoméstico electrodomestico1 = new Electrodoméstico();
		System.out.println("Electrodomestico 1: Precio base = " + electrodomestico1.precioBase + ", Color = "
				+ electrodomestico1.color + ", Consumo = " + electrodomestico1.consumo + ", Peso = "
				+ electrodomestico1.peso);

		Electrodoméstico electrodomestico2 = new Electrodoméstico(200, 10);
		System.out.println("Electrodomestico 2: Precio base = " + electrodomestico2.precioBase + ", Color = "
				+ electrodomestico2.color + ", Consumo = " + electrodomestico2.consumo + ", Peso = "
				+ electrodomestico2.peso);

		Electrodoméstico electrodomestico3 = new Electrodoméstico(300, 15, "rojo", "A");
		System.out.println("Electrodomestico 3: Precio base = " + electrodomestico3.precioBase + ", Color = "
				+ electrodomestico3.color + ", Consumo = " + electrodomestico3.consumo + ", Peso = "
				+ electrodomestico3.peso);
	}
}
