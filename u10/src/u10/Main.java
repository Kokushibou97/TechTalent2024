package u10;
class MiExcepcion extends Exception {
    public MiExcepcion(String mensaje) {
        super(mensaje);
    }
}

public class Main {
    public static void main(String[] args) {
        try {

            throw new MiExcepcion("¡Esto es una excepción personalizada!");
        } catch (MiExcepcion e) {
            System.out.println("Se ha capturado la excepción: " + e.getMessage());
        }
    }
}
