public class Television extends Electrodomestico {
    // Atributos específicos de Television
    private int resolucion; // en pulgadas
    private boolean sintonizadorTDT;

    // Constantes por defecto
    private static final int RESOLUCION_POR_DEFECTO = 20;
    private static final boolean SINTONIZADOR_TDT_POR_DEFECTO = false;

    // Constructores
    public Television() {
        super(); // Llama al constructor por defecto de la clase padre
        this.resolucion = RESOLUCION_POR_DEFECTO;
        this.sintonizadorTDT = SINTONIZADOR_TDT_POR_DEFECTO;
    }

    public Television(double precioBase, double peso) {
        super(precioBase, peso); // Llama al constructor con precio y peso de la clase padre
        this.resolucion = RESOLUCION_POR_DEFECTO;
        this.sintonizadorTDT = SINTONIZADOR_TDT_POR_DEFECTO;
    }

    public Television(int resolucion, boolean sintonizadorTDT, double precioBase, String color, char consumoEnergetico, double peso) {
        super(precioBase, color, consumoEnergetico, peso); // Llama al constructor con todos los atributos de la clase padre
        this.resolucion = resolucion;
        this.sintonizadorTDT = sintonizadorTDT;
    }

    // Métodos get para resolución y sintonizador TDT
    public int getResolucion() {
        return resolucion;
    }

    public boolean hasSintonizadorTDT() {
        return sintonizadorTDT;
    }

    // Método para calcular el precio final (incluyendo las condiciones de la clase padre)
    @Override
    public double precioFinal() {
        double precio = super.precioFinal(); // Llama al método precioFinal() de la clase padre

        // Si la resolución es mayor de 40 pulgadas, aumenta el precio en un 30%
        if (resolucion > 40) {
            precio *= 1.30;
        }

        // Si tiene sintonizador TDT incorporado, aumenta 50 € al precio
        if (sintonizadorTDT) {
            precio += 50;
        }

        return precio;
    }
}