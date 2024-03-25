package Cinco;
import java.util.Random;

class Persona {
    private String nombre;
    private int edad;
    private String sexo;

    public Persona(String nombre, int edad, String sexo) {
        this.nombre = nombre;
        this.edad = edad;
        this.sexo = sexo;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public String getSexo() {
        return sexo;
    }
}

class Estudiante extends Persona {
    private double calificacion;

    public Estudiante(String nombre, int edad, String sexo, double calificacion) {
        super(nombre, edad, sexo);
        this.calificacion = calificacion;
    }

    public double getCalificacion() {
        return calificacion;
    }

    public boolean haceNovillos() {
        return new Random().nextDouble() < 0.5;
    }
}

class Profesor extends Persona {
    private String materia;

    public Profesor(String nombre, int edad, String sexo, String materia) {
        super(nombre, edad, sexo);
        this.materia = materia;
    }

    public String getMateria() {
        return materia;
    }

    public boolean estaDisponible() {
        return new Random().nextDouble() >= 0.2;
    }
}

class Aula {
    private int id;
    private int maxEstudiantes;
    private String materia;
    private Profesor profesor;
    private Estudiante[] estudiantes;

    public Aula(int id, int maxEstudiantes, String materia, Profesor profesor, Estudiante[] estudiantes) {
        this.id = id;
        this.maxEstudiantes = maxEstudiantes;
        this.materia = materia;
        this.profesor = profesor;
        this.estudiantes = estudiantes;
    }

    public boolean puedeDarClase() {
        if (!profesor.estaDisponible()) {
            return false;
        }

        if (!profesor.getMateria().equals(materia)) {
            return false;
        }

        int aprobadosHombres = 0;
        int aprobadosMujeres = 0;

        for (Estudiante estudiante : estudiantes) {
            if (estudiante.getCalificacion() >= 5) {
                if (estudiante.getSexo().equals("Hombre")) {
                    aprobadosHombres++;
                } else {
                    aprobadosMujeres++;
                }
            }
        }

        return aprobadosHombres + aprobadosMujeres > estudiantes.length / 2;
    }

    public static void main(String[] args) {
        Profesor profesor = new Profesor("Juan", 40, "Hombre", "Matemáticas");

        Estudiante[] estudiantes = new Estudiante[10];
        for (int i = 0; i < estudiantes.length; i++) {
            estudiantes[i] = new Estudiante("Estudiante " + (i + 1), 18 + i, i % 2 == 0 ? "Hombre" : "Mujer", Math.random() * 11);
        }

        Aula aula = new Aula(1, 10, "Matemáticas", profesor, estudiantes);

        if (aula.puedeDarClase()) {
            System.out.println("Se puede dar clase en el aula " + aula.id);
        } else {
            System.out.println("No se puede dar clase en el aula " + aula.id);
        }
    }
}
