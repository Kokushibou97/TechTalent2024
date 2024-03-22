public class Lavadora extends Electrodomestico {
    // Atributo específico de Lavadora
    private double carga;

    // Constante para la carga por defecto
    private static final double CARGA_POR_DEFECTO = 5.0;

    // Constructores
    public Lavadora() {
        super(); // Llama al constructor por defecto de la clase padre
        this.carga = CARGA_POR_DEFECTO;
    }

    public Lavadora(double precioBase, double peso) {
        super(precioBase, peso); // Llama al constructor con precio y peso de la clase padre
        this.carga = CARGA_POR_DEFECTO;
    }

    public Lavadora(double carga, double precioBase, String color, char consumoEnergetico, double peso) {
        super(precioBase, color, consumoEnergetico, peso); // Llama al constructor con todos los atributos de la clase padre
        this.carga = carga;
    }

    // Método get para la carga
    public double getCarga() {
        return carga;
    }

    // Método para calcular el precio final (incluyendo las condiciones de la clase padre)
    @Override
    public double precioFinal() {
        double precio = super.precioFinal(); // Llama al método precioFinal() de la clase padre

        // Si la carga es mayor de 30 kg, aumenta el precio en 50 €
        if (carga > 30) {
            precio += 50;
        }

        return precio;
    }
}