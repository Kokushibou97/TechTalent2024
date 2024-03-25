package Seis;

import java.util.Random;

class Pelicula {
    private String titulo;
    private int duracion;
    private int edadMinima;
    private String director;

    public Pelicula(String titulo, int duracion, int edadMinima, String director) {
        this.titulo = titulo;
        this.duracion = duracion;
        this.edadMinima = edadMinima;
        this.director = director;
    }

    public String getTitulo() {
        return titulo;
    }

    public int getDuracion() {
        return duracion;
    }

    public int getEdadMinima() {
        return edadMinima;
    }

    public String getDirector() {
        return director;
    }
}

class Espectador {
    private String nombre;
    private int edad;
    private double dinero;

    public Espectador(String nombre, int edad, double dinero) {
        this.nombre = nombre;
        this.edad = edad;
        this.dinero = dinero;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public double getDinero() {
        return dinero;
    }
}

class Asiento {
    private char fila;
    private int columna;
    private boolean ocupado;

    public Asiento(char fila, int columna) {
        this.fila = fila;
        this.columna = columna;
        this.ocupado = false;
    }

    public boolean estaOcupado() {
        return ocupado;
    }

    public void ocupar() {
        ocupado = true;
    }
}

class Cine {
    private Pelicula pelicula;
    private double precioEntrada;
    private Asiento[][] asientos;

    public Cine(Pelicula pelicula, double precioEntrada) {
        this.pelicula = pelicula;
        this.precioEntrada = precioEntrada;
        this.asientos = new Asiento[8][9];
        for (int fila = 0; fila < 8; fila++) {
            for (int columna = 0; columna < 9; columna++) {
                asientos[fila][columna] = new Asiento((char) ('1' + fila), columna + 1);
            }
        }
    }

    public boolean sentarEspectador(Espectador espectador) {
        for (int fila = 7; fila >= 0; fila--) {
            for (int columna = 0; columna < 9; columna++) {
                Asiento asiento = asientos[fila][columna];
                if (!asiento.estaOcupado() && espectador.getEdad() >= pelicula.getEdadMinima() && espectador.getDinero() >= precioEntrada) {
                    asiento.ocupar();
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Pelicula pelicula = new Pelicula("Inception", 150, 13, "Christopher Nolan");
        Cine cine = new Cine(pelicula, 12);

        Random random = new Random();
        for (int i = 0; i < 50; i++) {
            Espectador espectador = new Espectador("Espectador " + (i + 1), 10 + random.nextInt(60), 5 + random.nextDouble() * 20);
            cine.sentarEspectador(espectador);
        }

        System.out.println("Película: " + pelicula.getTitulo());
        System.out.println("Precio de entrada: " + cine.precioEntrada);
        System.out.println("Asientos ocupados: " + (72 - cine.asientosLibres()));
    }

    private int asientosLibres() {
        int libres = 0;
        for (int fila = 0; fila < 8; fila++) {
            for (int columna = 0; columna < 9; columna++) {
                if (!asientos[fila][columna].estaOcupado()) {
                    libres++;
                }
            }
        }
        return libres;
    }
}
