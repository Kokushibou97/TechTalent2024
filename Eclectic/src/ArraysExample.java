import java.util.Arrays;

public class ArraysExample {
    public static void main(String[] args) {
        // Ejemplo de Arrays.fill()
        int[] array1 = new int[5];
        Arrays.fill(array1, 10); // Rellena el array con el valor 10
        System.out.println("Array rellenado: " + Arrays.toString(array1));

        // Ejemplo de Arrays.copyOf()
        int[] originalArray = {1, 2, 3, 4, 5};
        int[] copiedArray = Arrays.copyOf(originalArray, 7); // Copia el array con longitud 7
        System.out.println("Array original: " + Arrays.toString(originalArray));
        System.out.println("Array copiado: " + Arrays.toString(copiedArray));
    }
}