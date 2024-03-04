package Deberes;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Finalf {

  public static void main(String[] args) {
    int edades[] = {22, 23, 26, 18, 19, 28, 24, 22, 22, 26, 29, 27, 23, 23, 30};
    String nombres[] = {"Abde", "Laia", "Jess", "Isabel", "Joel", "Alex", "Santos", "Alejandro", "Diego", "Jose", "Sebas", "Ana Maria", "Toni", "Manel", "Aurora"};
    Person[] personas = new Person[nombres.length];
    for (int i = 0; i < nombres.length; i++) {
      personas[i] = new Person(nombres[i], edades[i]);
    }

    // Generar e imprimir 5 grupos aleatorios
    System.out.println("Grupos Aleatorios:");
    for (int i = 0; i < 5; i++) {
      Person[] grupoAleatorio = generarGrupoAleatorio(Arrays.copyOf(personas, personas.length));
      imprimirGrupo(grupoAleatorio);
    }

    // Ordenar las personas por edades de menor a mayor
    Arrays.sort(personas, Comparator.comparing(Person::getEdad));

    // Generar e imprimir 5 grupos ordenados por edades
    System.out.println("\nGrupos Ordenados por Edades:");
    for (int i = 0; i < 5; i++) {
      Person[] grupoOrdenado = Arrays.copyOfRange(personas, i * 3, (i + 1) * 3);
      imprimirGrupo(grupoOrdenado);
    }

    // Ordenar las personas alfabéticamente
    Arrays.sort(personas, Comparator.comparing(Person::getNombre));

    // Generar e imprimir 5 grupos ordenados alfabéticamente
    System.out.println("\nGrupos Ordenados Alfabéticamente:");
    for (int i = 0; i < 5; i++) {
      Person[] grupoAlfabetico = Arrays.copyOfRange(personas, i * 3, (i + 1) * 3);
      imprimirGrupo(grupoAlfabetico);
    }
  }

  // Método para generar un grupo aleatorio
  private static Person[] generarGrupoAleatorio(Person[] personas) {
	    Person[] grupo = new Person[3];
	    Random rand = new Random();
	    int[] indices = new int[personas.length];

	    // Generar array de indices
	    for (int i = 0; i < indices.length; i++) {
	        indices[i] = i;
	    }

	    // Barajar array de indices
	    for (int i = indices.length - 1; i > 0; i--) {
	        int j = rand.nextInt(i + 1);
	        int temp = indices[i];
	        indices[i] = indices[j];
	        indices[j] = temp;
	    }

	    // Seleccionar personas según indices aleatorios
	    for (int i = 0; i < 3; i++) {
	    	int j = rand.nextInt(i + 1);
	    	int k = rand.nextInt(Math.min(i + 1, personas.length - 1));
	    }

	    return grupo;
	}

  // Método para imprimir un grupo de personas
  private static void imprimirGrupo(Person[] grupo) {
    for (Person persona : grupo) {
      System.out.println(persona.getNombre() + ": " + persona.getEdad());
    }
    System.out.println();
  }

  // Método para eliminar un elemento de un array de personas
  private static Person[] removeElement(Person[] arr, int index) {
    if (arr == null || index < 0 || index >= arr.length) {
      return arr;
    }

    Person[] result = new Person[arr.length - 1];

    for (int i = 0, j = 0; i < arr.length; i++) {
      if (i != index) {
        result[j++] = arr[i];
      }
    }

    return result;
  }
}

// Clase para representar a una persona con nombre y edad
class Person {
  private String nombre;
  private int edad;

  public Person(String nombre, int edad) {
    this.nombre = nombre;
    this.edad = edad;
  }

  public String getNombre() {
    return nombre;
  }

  public int getEdad() {
    return edad;
  }
}