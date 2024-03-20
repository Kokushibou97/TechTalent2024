public class Electro {

    private double precioBase;
    private String color;
    private int consumo;
    private int peso;

    public Electro() {
        this(100.0, 'F');
    }

    public Electro(double precioBase, int consumo) {
        this(precioBase, consumo, "blanco", 'F');
    }

    public Electro(double precioBase, int consumo, String color, char eficiencia) {
        if (precioBase < 0) {
            throw new IllegalArgumentException("Precio base no puede ser negativo");
        }
        if (consumo < 0 || consumo > 20) {
            throw new IllegalArgumentException("Consumo energético debe estar entre 0 y 20");
        }
        if (!color.equalsIgnoreCase("blanco") && !color.equalsIgnoreCase("negro")
                && !color.equalsIgnoreCase("rojo") && !color.equalsIgnoreCase("gris")) {
            throw new IllegalArgumentException("Color no válido");
        }
        if (eficiencia < 'A' || eficiencia > 'F') {
            throw new IllegalArgumentException("Eficiencia energética no válida");
        }
        this.precioBase = precioBase;
        this.color = color;
        this.consumo = consumo;
        this.peso = 5;
    }

    public double getPrecioBase() {
        return precioBase;
    }

    public void setPrecioBase(double precioBase) {
        if (precioBase < 0) {
            throw new IllegalArgumentException("Precio base no puede ser negativo");
        }
        this.precioBase = precioBase;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        if (!color.equalsIgnoreCase("blanco") && !color.equalsIgnoreCase("negro")
                && !color.equalsIgnoreCase("rojo") && !color.equalsIgnoreCase("gris")) {
            throw new IllegalArgumentException("Color no válido");
        }
        this.color = color;
    }

    public int getConsumo() {
        return consumo;
    }

    public void setConsumo(int consumo) {
        if (consumo < 0 || consumo > 20) {
            throw new IllegalArgumentException("Consumo energético debe estar entre 0 y 20");
        }
        this.consumo = consumo;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public double calcularPrecioFinal() {
        double precioFinal = precioBase;
        switch (consumo) {
            case 'A':
                precioFinal += 100;
                break;
            case 'B':
                precioFinal += 80;
                break;
            case 'C':
                precioFinal += 60;
                break;
            case 'D':
                precioFinal += 40;
                break;
            case 'E':
                precioFinal += 20;
                break;
        }
        if (peso >= 30) {
            precioFinal += 50;
        } else if (peso >= 20) {
            precioFinal += 30;
        } else if (peso >= 10) {
            precioFinal += 10;
        }
