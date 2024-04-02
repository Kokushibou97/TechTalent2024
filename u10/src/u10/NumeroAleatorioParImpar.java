package u10;
import java.util.Random;

class ParImparException extends Exception {
    public ParImparException(String mensaje) {
        super(mensaje);
    }
}

public class NumeroAleatorioParImpar {
    public static void main(String[] args) {
        try {
            int numeroAleatorio = generarNumeroAleatorio();
            verificarParidad(numeroAleatorio);
        } catch (ParImparException e) {
            System.out.println(e.getMessage());
        }
    }

    public static int generarNumeroAleatorio() {
        Random random = new Random();
        return random.nextInt(1000); // Genera un número aleatorio entre 0 y 999
    }

    public static void verificarParidad(int numero) throws ParImparException {
        if (numero % 2 == 0) {
            throw new ParImparException("El número " + numero + " es par.");
        } else {
            throw new ParImparException("El número " + numero + " es impar.");
        }
    }
}

