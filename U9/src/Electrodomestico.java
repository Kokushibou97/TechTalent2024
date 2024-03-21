public class Electrodomestico {
    //Atributos//
    private double precioBase;
    private String color;
    private char consumoEnergetico;
    private double peso;

    // Constantes
    private static final String COLOR_POR_DEFECTO = "blanco";
    private static final char CONSUMO_ENERGETICO_POR_DEFECTO = 'F';
    private static final double PRECIO_BASE_POR_DEFECTO = 100.0;
    private static final double PESO_POR_DEFECTO = 5.0;

    // Constructores
    public Electrodomestico() {
        this.precioBase = PRECIO_BASE_POR_DEFECTO;
        this.color = COLOR_POR_DEFECTO;
        this.consumoEnergetico = CONSUMO_ENERGETICO_POR_DEFECTO;
        this.peso = PESO_POR_DEFECTO;
    }

    public Electrodomestico(double precioBase, double peso) {
        this();
        this.precioBase = precioBase;
        this.peso = peso;
    }

    public Electrodomestico(double precioBase, String color, char consumoEnergetico, double peso) {
        this.precioBase = precioBase;
        this.color = comprobarColor(color);
        this.consumoEnergetico = comprobarConsumoEnergetico(consumoEnergetico);
        this.peso = peso;
    }

    // Métodos get
    public double getPrecioBase() {
        return precioBase;
    }

    public String getColor() {
        return color;
    }

    public char getConsumoEnergetico() {
        return consumoEnergetico;
    }

    public double getPeso() {
        return peso;
    }

    // Métodos privados para comprobar color y consumo energético
    private String comprobarColor(String color) {
        String colorNormalizado = color.toLowerCase();
        if (colorNormalizado.equals("blanco") || colorNormalizado.equals("negro") ||
                colorNormalizado.equals("rojo") || colorNormalizado.equals("azul") ||
                colorNormalizado.equals("gris")) {
            return colorNormalizado;
        } else {
            return COLOR_POR_DEFECTO;
        }
    }

    private char comprobarConsumoEnergetico(char letra) {
        if (letra >= 'A' && letra <= 'F') {
            return letra;
        } else {
            return CONSUMO_ENERGETICO_POR_DEFECTO;
        }
    }

    // Método para calcular el precio final
    public double precioFinal() {
        double precio = precioBase;

        switch (consumoEnergetico) {
            case 'A':
                precio += 100;
                break;
            case 'B':
                precio += 80;
                break;
            case 'C':
                precio += 60;
                break;
            case 'D':
                precio += 50;
                break;
            case 'E':
                precio += 30;
                break;
            case 'F':
                precio += 10;
                break;
        }

        if (peso >= 0 && peso < 20) {
            precio += 10;
        } else if (peso >= 20 && peso < 50) {
            precio += 50;
        } else if (peso >= 50 && peso < 80) {
            precio += 80;
        } else {
            precio += 100;
        }

        return precio;
    }
}
