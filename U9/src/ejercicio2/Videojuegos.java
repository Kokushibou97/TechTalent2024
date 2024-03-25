package ejercicio2;
public class Videojuego {
    // Atributos de la clase
    private String titulo;
    private int horasEstimadas;
    private boolean entregado;
    private String genero;
    private String compania;

    // Constructor por defecto
    public Videojuego() {
        this.titulo = "Sin título";
        this.horasEstimadas = 10;
        this.entregado = false;
        this.genero = "Sin género";
        this.compania = "Sin compañía";
    }

    // Constructor con título y horas estimadas (el resto por defecto)
    public Videojuego(String titulo, int horasEstimadas) {
        this.titulo = titulo;
        this.horasEstimadas = horasEstimadas;
        this.entregado = false;
        this.genero = "Sin género";
        this.compania = "Sin compañía";
    }

    // Constructor con todos los atributos excepto entregado
    public Videojuego(String titulo, int horasEstimadas, String genero, String compania) {
        this.titulo = titulo;
        this.horasEstimadas = horasEstimadas;
        this.entregado = false;
        this.genero = genero;
        this.compania = compania;
    }

    // Métodos get para acceder a los atributos
    public String getTitulo() {
        return titulo;
    }

    public int getHorasEstimadas() {
        return horasEstimadas;
    }

    public String getGenero() {
        return genero;
    }

    public String getCompania() {
        return compania;
    }

    // Métodos set para modificar los atributos
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setHorasEstimadas(int horasEstimadas) {
        this.horasEstimadas = horasEstimadas;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public void setCompania(String compania) {
        this.compania = compania;
    }

    // Método toString (sobrescrito)
    @Override
    public String toString() {
        return "Título: " + titulo +
                "\nHoras estimadas: " + horasEstimadas +
                "\nGénero: " + genero +
                "\nCompañía: " + compania +
                "\nEntregado: " + (entregado ? "Sí" : "No");
    }

    public static void main(String[] args) {
        // Ejemplo de uso
        Videojuego miVideojuego = new Videojuego("The Legend of Zelda", 40, "Aventura", "Nintendo");
        System.out.println(miVideojuego);
    }
}

