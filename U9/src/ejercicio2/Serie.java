public class Serie {
    // Atributos de la clase
    private String titulo;
    private String creador;
    private String genero;
    private int numTemporadas;
    private boolean entregado;

    // Constructor por defecto
    public Serie() {
        this.titulo = "Sin título";
        this.creador = "Sin creador";
        this.genero = "Sin género";
        this.numTemporadas = 3;
        this.entregado = false;
    }

    // Constructor con título y creador (el resto por defecto)
    public Serie(String titulo, String creador) {
        this.titulo = titulo;
        this.creador = creador;
        this.genero = "Sin género";
        this.numTemporadas = 3;
        this.entregado = false;
    }

    // Constructor con todos los atributos excepto entregado
    public Serie(String titulo, String creador, String genero, int numTemporadas) {
        this.titulo = titulo;
        this.creador = creador;
        this.genero = genero;
        this.numTemporadas = numTemporadas;
        this.entregado = false;
    }

    // Métodos get para acceder a los atributos
    public String getTitulo() {
        return titulo;
    }

    public String getCreador() {
        return creador;
    }

    public String getGenero() {
        return genero;
    }

    public int getNumTemporadas() {
        return numTemporadas;
    }

    // Métodos set para modificar los atributos
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setCreador(String creador) {
        this.creador = creador;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public void setNumTemporadas(int numTemporadas) {
        this.numTemporadas = numTemporadas;
    }

    // Método toString (sobrescrito)
    @Override
    public String toString() {
        return "Título: " + titulo +
                "\nCreador: " + creador +
                "\nGénero: " + genero +
                "\nTemporadas: " + numTemporadas +
                "\nEntregado: " + (entregado ? "Sí" : "No");
    }

    public static void main(String[] args) {
        // Ejemplo de uso
        Serie miSerie = new Serie("Breaking Bad", "Vince Gilligan", "Drama", 5);
        System.out.println(miSerie);
    }
}
