package Deberes;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;


class Alumno {
    private String nombre;
    private String apellido;
    private int edad;

    public Alumno(String nombre, String apellido, int edad) {
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

public class Equipo {

    public static void main(String[] args) {
        // Crear una lista de 2 alumnos
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
        alumnos.add(new Alumno("Laia","", 23));
        alumnos.add(new Alumno("Ana maria","", 29));
        alumnos.add(new Alumno("Toni","", 20));

        
        System.out.println("Orden");
        for (Alumno alumno : alumnos) {
            System.out.println(alumno);
    }
}}