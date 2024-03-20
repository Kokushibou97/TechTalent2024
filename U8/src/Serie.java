public class Serie {

    private String titulo;
    private int numeroTemporadas;
    private boolean entregado;
    private String genero;
    private String creador;

    // Constructor por defecto
    public Serie() {
        this.titulo = "";
        this.numeroTemporadas = 3;
        this.entregado = false;
        this.genero = "";
        this.creador = "";
    }

    // Constructor con título y creador
    public Serie(String titulo, String creador) {
        this.titulo = titulo;
        this.numeroTemporadas = 3;
        this.entregado = false;
        this.genero = "";
        this.creador = creador;
    }

    // Constructor con todos los atributos excepto 'entregado'
    public Serie(String titulo, int numeroTemporadas, String genero, String creador) {
        this.titulo = titulo;
        this.numeroTemporadas = numeroTemporadas;
        this.entregado = false;
        this.genero = genero;
        this.creador = creador;
    }

    // Métodos getter y setter
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getNumeroTemporadas() {
        return numeroTemporadas;
    }

    public void setNumeroTemporadas(int numeroTemporadas) {
        this.numeroTemporadas = numeroTemporadas;
    }

    public boolean isEntregado() {
        return entregado;
    }

    public void setEntregado(boolean entregado) {
        this.entregado = entregado;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getCreador() {
        return creador;
    }

    public void setCreador(String creador) {
        this.creador = creador;
    }

    // Método toString para imprimir la información de la serie
    @Override
    public String toString() {
        return "Serie{" +
                "titulo='" + titulo + '\'' +
                ", numeroTemporadas=" + numeroTemporadas +
                ", entregado=" + entregado +
                ", genero='" + genero + '\'' +
                ", creador='" + creador + '\'' +
                '}';
    }
}
