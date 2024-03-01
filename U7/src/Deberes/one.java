package Deberes;
import java.util.Scanner;
import java.util.HashMap;
public class one {
	
	public static void main(String[] args) {

		        Scanner sc = new Scanner(System.in);
		        HashMap<String, Double> notAlum = new HashMap<>();

		        System.out.println(" Bonjour! somos su calculadora de notas de toda la vida  ");

		        while (true) {
		            System.out.print(" pon el nombre del alumno ");
		            String nomAlum = sc.nextLine();

		            if (nomAlum.equalsIgnoreCase(" salir ")) {
		                break;
		            }

		            System.out.print("Escribe la nota media del alumno ");
		            double notaMedia = Double.parseDouble(sc.nextLine());

		            notAlum.put(nomAlum, notaMedia);
		        }

		        double sumaNotas = 0;
		        for (double nota : notAlum.values()) {
		            sumaNotas += nota;
		        }
		        double notaMediaGlobal = sumaNotas / notAlum.size();

		        System.out.println("\nEstadísticas generales:");
		        System.out.println("Cantidad de alumnos: " + notAlum.size());
		        System.out.println("Nota media general: " + notaMediaGlobal);

		      
		        System.out.println("\nNotas individuales de los alumnos:");
		        for (String alumno : notAlum.keySet()) {
		            System.out.println(alumno + ": " + notAlum.get(alumno));
		        }

		        sc.close();
		    }

}
