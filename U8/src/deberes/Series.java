package deberes;
public class Series {

    private String titulo;
    private int numTemporadas;
    private boolean completado;
    private String genero;
    private String autor;

    // Constructor por defecto
    public Series() {
        this("", 3, false, "", "");
    }

    // Constructor con título y autor
    public Series(String titulo, String autor) {
        this(titulo, 3, false, "", autor);
    }

    // Constructor con todos los atributos excepto 'completado'
    public Series(String titulo, int numTemporadas, String genero, String autor) {
        this(titulo, numTemporadas, false, genero, autor);
    }

    // Constructor con todos los atributos
    public Series(String titulo, int numTemporadas, boolean completado, String genero, String autor) {
        this.titulo = titulo;
        this.numTemporadas = numTemporadas;
        this.completado = completado;
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

    public void setNumTemporadas(int numTemporadas) {
        this.numTemporadas = numTemporadas;
    }

    public boolean isCompletado() {
        return completado;
    }

    public void setCompletado(boolean completado) {
        this.completado = completado;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    // Método toString para imprimir la información de la serie
    @Override
    public String toString() {
        return "Serie{" +
                "titulo='" + titulo + '\'' +
                ", numTemporadas=" + numTemporadas +
                ", completado=" + completado +
                ", genero='" + genero + '\'' +
                ", autor='" + autor + '\'' +
                '}';
    }
}

