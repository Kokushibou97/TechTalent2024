package Deberes;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

class Alumnos {
    private String nombre;
    private String apellido;
    private int edad;

    public Alumnos(String nombre, String apellido, int edad) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public int getEdad() {
        return edad;
    }

    @Override
    public String toString() {
        return "Alumno{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", edad=" + edad +
                '}';
    }
}

public class Equip {

    public static void main(String[] args) {
        List<Alumno> alumnos = new ArrayList<>();
        alumnos.add(new Alumno("Abde", "Rachedi", 22));
        alumnos.add(new Alumno("Jessi", "Najem", 26));
        alumnos.add(new Alumno("Joel", "", 17));
        alumnos.add(new Alumno("Sebas", "", 29));
        alumnos.add(new Alumno("Santos", "", 24));
        alumnos.add(new Alumno("Manel", "", 23));
        alumnos.add(new Alumno("Diego", "", 22));
        alumnos.add(new Alumno("Alejandro", "", 25));
        alumnos.add(new Alumno("Jose", "", 28));
        alumnos.add(new Alumno("Alex", "", 30));
        alumnos.add(new Alumno("Aurora", "Sanchez", 30));
        alumnos.add(new Alumno("Laia", "", 23));
        alumnos.add(new Alumno("Ana maria", "", 29));
        alumnos.add(new Alumno("Toni", "", 20));

        // Ordenar la lista de alumnos por nombre
        List<Alumno> alumnosOrdenadosPorNombre = alumnos.stream()
                .sorted(Comparator.comparing(Alumno::getNombre))
                .collect(Collectors.toList());

        // Imprimir los grupos de alumnos por orden alfabético
        System.out.println("Grupos por orden alfabético:");
        imprimirGrupos(crearGrupos(alumnosOrdenadosPorNombre));

        // Ordenar la lista de alumnos por edad
        List<Alumno> alumnosOrdenadosPorEdad = alumnos.stream()
                .sorted(Comparator.comparingInt(Alumno::getEdad))
                .collect(Collectors.toList());

        // Imprimir los grupos de alumnos por edad
        System.out.println("\nGrupos por edad:");
        imprimirGrupos(crearGrupos(alumnosOrdenadosPorEdad));
    }

    // Método para crear grupos de 3 personas aleatorias
    private static List<List<Alumno>> crearGrupos(List<Alumno> alumnos) {
        List<List<Alumno>> grupos = new ArrayList<>();
        Random random = new Random();
        List<Alumno> copiaAlumnos = new ArrayList<>(alumnos); // Hacemos una copia para no modificar la lista original

        while (!copiaAlumnos.isEmpty()) {
            List<Alumno> grupo = new ArrayList<>();
            for (int i = 0; i < 3 && !copiaAlumnos.isEmpty(); i++) {
                int indice = random.nextInt(copiaAlumnos.size());
                grupo.add(copiaAlumnos.remove(indice));
            }
            grupos.add(grupo);
        }

        return grupos;
    }

    // Método para imprimir los grupos de alumnos
    private static void imprimirGrupos(List<List<Alumno>> grupos) {
        for (int i = 0; i < grupos.size(); i++) {
            System.out.println("Grupo " + (i + 1) + ":");
            for (Alumno alumno : grupos.get(i)) {
                System.out.println(alumno);
            }
            System.out.println();
        }
    }
}
