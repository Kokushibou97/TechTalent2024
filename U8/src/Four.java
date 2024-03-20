public class Four {
    private String titulo;
    private int numeroTemporadas;
    private boolean entregado;
    private String genero;
    private String creador;

    public static final int TEMPORADAS_POR_DEFECTO = 3;
    public static final boolean ENTREGADO_POR_DEFECTO = false;
    public static final String TITULO_POR_DEFECTO = "";
    public static final String GENERO_POR_DEFECTO = "";
    public static final String CREADOR_POR_DEFECTO = "";

    public Four() {
        this(TITULO_POR_DEFECTO, TEMPORADAS_POR_DEFECTO, ENTREGADO_POR_DEFECTO, GENERO_POR_DEFECTO, CREADOR_POR_DEFECTO);
    }

    public Four(String titulo, String creador) {
        this(titulo, TEMPORADAS_POR_DEFECTO, ENTREGADO_POR_DEFECTO, GENERO_POR_DEFECTO, creador);
    }

    public Four(String titulo, int numeroTemporadas, String genero, String creador) {
        this(titulo, numeroTemporadas, ENTREGADO_POR_DEFECTO, genero, creador);
    }

    public Four(String titulo, int numeroTemporadas, boolean entregado, String genero, String creador) {
        this.titulo = titulo;
        this.numeroTemporadas = numeroTemporadas;
        this.entregado = entregado;
        this.genero = genero;
        this.creador = creador;
    }

    public String getTitulo() {
        return titulo;
    }

    public int getNumeroTemporadas() {
        return numeroTemporadas;
    }

    public boolean isEntregado() {
        return entregado;
    }

    public String getGenero() {
        return genero;
    }

    public String getCreador() {
        return creador;
    }

    public static void main(String[] args) {
        Four serie1 = new Four();
        System.out.println("Serie 1:");
        System.out.println("Título: " + serie1.getTitulo());
        System.out.println("Número de temporadas: " + serie1.getNumeroTemporadas());
        System.out.println("Entregado: " + serie1.isEntregado());
        System.out.println("Género: " + serie1.getGenero());
        System.out.println("Creador: " + serie1.getCreador());

        Four serie2 = new Four("Breaking Bad", "Vince Gilligan");
        System.out.println("\nSerie 2:");
        System.out.println("Título: " + serie2.getTitulo());
        System.out.println("Número de temporadas: " + serie2.getNumeroTemporadas());
        System.out.println("Entregado: " + serie2.isEntregado());
        System.out.println("Género: " + serie2.getGenero());
        System.out.println("Creador: " + serie2.getCreador());

        Four serie3 = new Four("Friends", 10, "Comedia", "David Crane");
        System.out.println("\nSerie 3:");
        System.out.println("Título: " + serie3.getTitulo());
        System.out.println("Número de temporadas: " + serie3.getNumeroTemporadas());
        System.out.println("Entregado: " + serie3.isEntregado());
        System.out.println("Género: " + serie3.getGenero());
        System.out.println("Creador: " + serie3.getCreador());
    }
}
