public class Serie {

    private String titulo;
    private int numTemporadas;
    private boolean completado;
    private String genero;
    private String autor;

    // Constructor por defecto//
    public Serie() {
        this.titulo = "";
        this.numTemporadas = 3;
        this.completado= false;
        this.genero = "";
        this.autor = "";
    }

    // Constructor con título y el autor//
    public Serie(String titulo, String autor) {
        this.titulo = titulo;
        this.numTemporadas = 3;
        this.completado = false;
        this.genero = "";
        this.autor = autor;
    }

    // Constructor con todos los atributos excepto 'completado'//
    public Serie(String titulo, int numTemporadas, String genero, String autor) {
        this.titulo = titulo;
        this.numTemporadas = numTemporadas;
        this.completado = false;
        this.genero = genero;
        this.autor = autor;
    }

    // Métodos getter y setter
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getNumTemporadas() {
        return numTemporadas;
    }

    public void setNumeroTemporadas(int numTemporadas) {
        this.numTemporadas = numTemporadas;
    }

    public boolean isEntregado() {
        return completado;
    }

    public void setEntregado(boolean entregado) {
        this.completado = entregado;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getCreador() {
        return autor;
    }

    public void setCreador(String creador) {
        this.autor = creador;
    }

    // Método toString para imprimir la información de la serie
    @Override
    public String toString() {
        return "Serie{" +
                "titulo='" + titulo + '\'' +
                ", numeroTemporadas=" + numTemporadas +
                ", entregado=" + completado +
                ", genero='" + genero + '\'' +
                ", creador='" + autor + '\'' +
                '}';
    }
}
