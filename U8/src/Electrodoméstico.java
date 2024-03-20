public class  Electrodoméstico {

    private final double precioBase;
    private final String color;
    private final ConsumoEnergetico consumoEnergetico;
    private final double peso;

    public static final double PRECIO_BASE_DEFECTO = 100;
    public static final double PESO_DEFECTO = 5;
    public static final String COLOR_DEFECTO = "blanco";
    public static final ConsumoEnergetico CONSUMO_ENERGETICO_DEFECTO = ConsumoEnergetico.F;

    public static final String[] COLORES_DISPONIBLES = {"blanco", "negro", "rojo", "azul", "gris"};

    public enum ConsumoEnergetico {
        A, B, C, D, E, F
    }

    public Three() {
        this(PRECIO_BASE_DEFECTO, PESO_DEFECTO, COLOR_DEFECTO, CONSUMO_ENERGETICO_DEFECTO);
    }

    public Three(double precioBase, double peso) {
        this(precioBase, peso, COLOR_DEFECTO, CONSUMO_ENERGETICO_DEFECTO);
    }

    public Three(double precioBase, double peso, String color, ConsumoEnergetico consumoEnergetico) {
        this.precioBase = precioBase;
        this.peso = peso;
        this.color = comprobarColor(color.toLowerCase());
        this.consumoEnergetico = comprobarConsumoEnergetico(consumoEnergetico);
    }

    private String comprobarColor(String color) {
        for (String colorDisponible : COLORES_DISPONIBLES) {
            if (colorDisponible.equals(color)) {
                return color;
            }
        }
        return COLOR_DEFECTO;
    }

    private ConsumoEnergetico comprobarConsumoEnergetico(ConsumoEnergetico letra) {
        return letra; // Enums already handle valid values
    }

    // Getters
    public double getPrecioBase() {
        return precioBase;
    }

    public String getColor() {
        return color;
    }

    public ConsumoEnergetico getConsumoEnergetico() {
        return consumoEnergetico;
    }

    public double getPeso() {
        return peso;
    }

    public static void main(String[] args) {
        Three electrodomestico1 = new Three();
        System.out.println("Electrodomestico 1:");
        System.out.println("Precio base: " + electrodomestico1.getPrecioBase());
        System.out.println("Color: " + electrodomestico1.getColor());
        System.out.println("Consumo energético: " + electrodomestico1.getConsumoEnergetico());
        System.out.println("Peso: " + electrodomestico1.getPeso());

        Three electrodomestico2 = new Three(200, 10);
        System.out.println("\nElectrodomestico 2:");
        System.out.println("Precio base: " + electrodomestico2.getPrecioBase());
        System.out.println("Color: " + electrodomestico2.getColor());
        System.out.println("Consumo energético: " + electrodomestico2.getConsumoEnergetico());
        System.out.println("Peso: " + electrodomestico2.getPeso());

        Three electrodomestico3 = new Three(300, 15);
        System.out.println("\nElectrodomestico 3:");
        System.out.println("Precio base: " + electrodomestico3.getPrecioBase());
        System.out.println("Color: " + electrodomestico3.getColor());
        System.out.println("Consumo energético: " + electrodomestico3.getConsumoEnergetico());
        System.out.println("Peso: " + electrodomestico3.getPeso());
    }
}
