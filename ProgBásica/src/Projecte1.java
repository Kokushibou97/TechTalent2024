import java.util.Scanner;

public class Projecte1 {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        // declaramos  las variables//
        int tis = preguntarTIS();
        int sintoma = obtenerSintoma();
        String exploracionInicial = obtenerExploracionInicial();
        int nivelPrioridad = obtenerNivelPrioridad();
        float temperaturaActual = obtenerTemperaturaActual();

        // validamos los datos escritos por el usuario//
        if (tis <= 0) {
            System.err.println("El TIS no puede ser menor o igual a 0.");
            return;
        }
        if (sintoma < 0 || sintoma > 3) {
            System.err.println("El síntoma no es válido.");
            return;
        }
        if (nivelPrioridad < 1 || nivelPrioridad > 5) {
            System.err.println("El nivel de prioridad no es válido.");
            return;
        }
        if (temperaturaActual < 35 || temperaturaActual > 42) {
            System.err.println("La temperatura actual no es válida.");
            return;
        }

        
        System.out.println("**Resumen de datos del paciente:**");
        System.out.println("TIS: " + tis);
        System.out.println("Síntoma: " + obtenerNombreSintoma(sintoma));
        System.out.println("Exploración inicial: " + exploracionInicial);
        System.out.println("Nivel de prioridad hospitalaria: " + nivelPrioridad);
        System.out.println("Temperatura actual: " + temperaturaActual);
    }

    //1.Función para preguntar el TIS al usuario//
    private static int preguntarTIS() {
        System.out.print("Introduce el TIS: ");
        return scanner.nextInt();
    }

    //2.Función para obtener el síntoma del paciente//
    private static int obtenerSintoma() {
        int sintoma;
        do {
           
            System.out.println("Selecciona una de las opciones:");
            System.out.println("0. Dolor");
            System.out.println("1. Lesión traumática");
            System.out.println("2. Fiebre alta");
            System.out.println("3. Confusión o desorientación");
            System.out.print("Opción seleccionada: ");
            sintoma = scanner.nextInt();
        } while (sintoma < 0 || sintoma > 3); // Validación de opción válida
        return sintoma;
    }

    //3.Función para obtener el nombre del sintoma segun la selección del usuario//
    private static String obtenerNombreSintoma(int sintoma) {
        // Utilizando expresiones switch para obtener el nombre del sintoma//
        return switch (sintoma) {
            case 0 -> "Dolor";
            case 1 -> "Lesión traumática";
            case 2 -> "Fiebre alta";
            case 3 -> "Confusión o desorientación";
            default -> "Síntoma desconocido";
        };
    }

    //4.Función para obtener los datos iniciales de exploración del paciente//
    private static String obtenerExploracionInicial() {
        scanner.nextLine();
        System.out.print("Introduzca datos iniciales de exploración del paciente: ");
        return scanner.nextLine();
    }

    //5.Función para obtener el nivel de prioridad del paciente//
    private static int obtenerNivelPrioridad() {
        System.out.print("Introduzca nivel de prioridad (1-5): ");
        return scanner.nextInt();
    }

    //6.Función para obtener la temperatura actual del paciente//
    private static float obtenerTemperaturaActual() {
        System.out.print("Introduzca la temperatura actual: ");
        return scanner.nextFloat();
    }
}

    
    