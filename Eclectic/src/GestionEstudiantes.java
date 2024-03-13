import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class GestionEstudiantes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, ArrayList<Integer>> estudiantes = registrarEstudiantes(scanner);
        Map<String, Double> promedios = calcularPromedios(estudiantes);
        ArrayList<String> aprobados = identificarAprobados(promedios);
        mostrarResultados(estudiantes, promedios, aprobados);
    }

public static void mostrarResultados(Map<String, ArrayList<Integer>> estudiantes, Map<String, Double> promedios, ArrayList<String> aprobados) {
    System.out.println("Lista de estudiantes:");
    for (Map.Entry<String, ArrayList<Integer>> estudiante : estudiantes.entrySet()) {
        String nombre = estudiante.getKey();
        ArrayList<Integer> calificaciones = estudiante.getValue();
        System.out.print(nombre + ": ");
        for (int calificacion : calificaciones) {
            System.out.print(calificacion + " ");
        }
        System.out.print("- Promedio: " + promedios.get(nombre));
        if (aprobados.contains(nombre)) {
            System.out.println(" - Aprobado");
        } else {
            System.out.println(" - Reprobado");
        }
    }
} public static ArrayList<String> identificarAprobados(Map<String, Double> promedios) {
    ArrayList<String> aprobados = new ArrayList<>();
    for (Map.Entry<String, Double> entrada : promedios.entrySet()) {
        String nombre = entrada.getKey();
        double promedio = entrada.getValue();
        if (promedio >= 60) {
            aprobados.add(nombre);
        }
    }
    return aprobados;
} public static Map<String, Double> calcularPromedios(Map<String, ArrayList<Integer>> estudiantes) {
    Map<String, Double> promedios = new HashMap<>();
    for (Map.Entry<String, ArrayList<Integer>> estudiante : estudiantes.entrySet()) {
        String nombre = estudiante.getKey();
        ArrayList<Integer> calificaciones = estudiante.getValue();
        double suma = 0;
        for (int calificacion : calificaciones) {
            suma += calificacion;
        }
        double promedio = suma / calificaciones.size();
        promedios.put(nombre, promedio);
    }
    return promedios;
} public static Map<String, ArrayList<Integer>> registrarEstudiantes(Scanner scanner) {
    Map<String, ArrayList<Integer>> estudiantes = new HashMap<>();
    System.out.println("Ingrese el nombre del estudiante y sus calificaciones separadas por comas (ejemplo: Juan,80,75,90):");
    while (true) {
        String entrada = scanner.nextLine();
        if (entrada.equals("fin")) {
            break;
        }
        String[] partes = entrada.split(",");
        String nombre = partes[0];
        ArrayList<Integer> calificaciones = new ArrayList<>();
        for (int i = 1; i < partes.length; i++) {
            calificaciones.add(Integer.parseInt(partes[i]));
        }
        estudiantes.put(nombre, calificaciones);
    }
    return estudiantes;
}}