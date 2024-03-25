package Cuatro;
public class Raices {
    private double a;
    private double b;
    private double c;

    // Constructor
    public Raices(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    // Método para calcular el discriminante
    public double getDiscriminante() {
        return Math.pow(b, 2) - 4 * a * c;
    }

    // Método para verificar si tiene dos soluciones
    public boolean tieneRaices() {
        return getDiscriminante() >= 0;
    }

    // Método para verificar si tiene una única solución
    public boolean tieneRaiz() {
        return getDiscriminante() == 0;
    }

    // Método para calcular y mostrar las soluciones
    public void calcular() {
        double discriminante = getDiscriminante();
        if (discriminante > 0) {
            double raiz1 = (-b + Math.sqrt(discriminante)) / (2 * a);
            double raiz2 = (-b - Math.sqrt(discriminante)) / (2 * a);
            System.out.println("Las soluciones son: " + raiz1 + " y " + raiz2);
        } else if (discriminante == 0) {
            double raiz = -b / (2 * a);
            System.out.println("La única solución es: " + raiz);
        } else {
            System.out.println("No existen soluciones reales.");
        }
    }

    // Método para imprimir las posibles soluciones
    public void obtenerRaices() {
        double discriminante = getDiscriminante();
        if (discriminante >= 0) {
            double raiz1 = (-b + Math.sqrt(discriminante)) / (2 * a);
            double raiz2 = (-b - Math.sqrt(discriminante)) / (2 * a);
            System.out.println("Las posibles soluciones son: " + raiz1 + " y " + raiz2);
        } else {
            System.out.println("No existen soluciones reales.");
        }
    }

    // Método para imprimir la única raíz
    public void obtenerRaiz() {
        double discriminante = getDiscriminante();
        if (discriminante == 0) {
            double raiz = -b / (2 * a);
            System.out.println("La única raíz es: " + raiz);
        } else {
            System.out.println("No existe una única raíz.");
        }
    }

    public static void main(String[] args) {
        Raices ecuacion1 = new Raices(1, -3, 2);
        ecuacion1.calcular();
        ecuacion1.obtenerRaices();
        ecuacion1.obtenerRaiz();
    }
}

