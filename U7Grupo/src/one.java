
import java.util.Scanner;
import java.util.HashMap;

public class one {

    public static void main(String[] args) {
//Declaración de variables, mediante hashtable//
        Scanner sc = new Scanner(System.in);
        HashMap<String, Double> notAlum = new HashMap<>();

        //creamos un Array-string con nombres elegidos//
        String[] names = {"Abde", "Alejandro", "Isabelle", "Jose", "Aurora",
                           "Jessica", "Joel", "Manel", "Laia", "Sebas",
                           "Santos", "Diego", "Toni", "Alex", "Anna"};

        System.out.println(" Bonjour! somos su calculadora de notas de toda la vida ");

        //Creamos un bucle para pedir notas//
        for (String name : names) {
            System.out.println("Ingrese la nota para " + name);
            double notaMedia = Double.parseDouble(sc.nextLine());
            notAlum.put(name, notaMedia);
        }
     // Cálculo de la media//
        double sumaNotas = 0;
        for (double nota : notAlum.values()) {
            sumaNotas += nota;
        }
        double notaMediaGlobal = sumaNotas / notAlum.size();

        // Mostreo global//
        System.out.println("\nEstadísticas generales:");
        System.out.printf("Número de alumnos: %d\n", notAlum.size());
        System.out.printf("Nota media general: %.2f\n", notaMediaGlobal);

        // Mostreo individual//
        System.out.println("\nNotas individuales de los alumnos:");
        for (String nombre : notAlum.keySet()) {
            System.out.printf("%s: %.2f\n", nombre, notAlum.get(nombre));
        }

        sc.close();
    }
}
