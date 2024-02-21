import java.util.Scanner;

public class sorteo {

	    public static void main(String[] args) {

	        Scanner scanner = new Scanner(System.in);
	        String[] participantes = new String[3];

	        // Pedir los nombres de los participantes//
	        for (int i = 0; i < 3; i++) {
	            System.out.print("Ingrese el nombre del participante " + (i + 1) + ": ");
	            participantes[i] = scanner.nextLine();
	        }

	        // Mostrar los participantes//
	        System.out.println("\nLista de participantes:");
	        for (String participante : participantes) {
	            System.out.println("- " + participante);
	        }

	        // Realizar el sorteo//
	        int indiceGanador = (int) (Math.random() * participantes.length);
	        String ganador = participantes[indiceGanador];
	        System.out.println("\n¡El ganador del sorteo es: " + ganador + "!");
	    }
	}
