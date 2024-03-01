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
        alumnos.add(new Alumno("Laura", "Sanchez", 27));
        alumnos.add(new Alumno("Maria", "Gutierrez", 23));

        // Imprimir los datos de los alumnos
        System.out.println("Lista de alumnos:");
        for (Alumno alumno : alumnos) {
            System.out.println(alumno);
        }
    }
}