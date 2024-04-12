//Se empieza desde 0 [0,1,2...//
import java.util.Scanner;

public class E12_1_NajemJ {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

// A: Lectura del código de usuario//
        int userCode = readUserCode(scanner); // Llamada a la función para leer un solo codigo del usuario//
        System.out.println(" Codigo de usuario escaneado: " + userCode);

// B: Lectura de una serie de cdigos y almacenameinto dentro del array//
        System.out.print("¿Cuántas personas quieres poner? ");
        int numUsers = scanner.nextInt();// aqui se lee la cantidad de codigos puestos//
        int[] userCodes = readUserCodes(scanner, numUsers);// Aqui tenemos la Llamada a la función, para leer la serie de códigos//

// C: Ordenar y mostrar los códigos guardados//
        bubbleSort(userCodes);// primero se ordenan los codigos//
        System.out.print("Lista de todos los códigos ingresados: ");
        printArray(userCodes);// Luego, se omprime la lista original de codigos//
        System.out.print("Lista ordenada de todos los códigos ingresados: ");
        printArray(userCodes);// Imprime la lista ordenada de códigos//
    }
 // 1ra función para leer un solo código de usuario//
    public static int readUserCode(Scanner scanner) {
        int code;
        do {
            System.out.print("Entra el código de usuario de (0-1000): ");
            code = scanner.nextInt();
        } while (code < 0 || code > 1000);// en esta parte, nos aseguramos de que el codigo está dentro del rango//
        return code;
    }
 //2nda función que sirve para leer una serie de códigos del usuario//
    public static int[] readUserCodes(Scanner scanner, int numUsers) {
        int[] userCodes = new int[numUsers];
        for (int i = 0; i < numUsers; i++) {
            userCodes[i] = readUserCode(scanner);// En esta linea se llama a la función para leer cada codigo de usuario//
        }
        return userCodes;
    }
// 3ra función: sirve para ordenar el array de códigos usando el algoritmo de ordenación de sorteo de burbuja//
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
//ultima función: sirve para imprimir los elementos de un array//
    public static void printArray(int[] arr) {
        for (int value : arr) {
            System.out.print(value + " ");// Imprime cada elemento del array//
        }
        System.out.println();
    }
}
