package Deberes;
import java.util.Scanner;
import java.util.HashMap;

public class one {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        HashMap<String, Double> notAlum = new HashMap<>();

        //creamos un Array-string con nombres elegidos y asignador por nosotros//
        String[] names = {"Abde", "Alejandro", "Isabelle", "Jose", "Aurora",
                           "Jessica", "Joel", "Manel", "Laia", "Sebas",
                           "Santos", "Diego", "Toni", "Alex", "Anna"};

        System.out.println(" Bonjour! somos su calculadora de notas de toda la vida ");

        //Creamos un bucle para asignar notas a los nombres//
        for (String name : names) {
            System.out.println("Ingrese la nota para " + name);
            double notaMedia = Double.parseDouble(sc.nextLine());
            notAlum.put(name, notaMedia);
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
