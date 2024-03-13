public class Ej12ArrayCheckDigit {
    /*Crea un array de números de un tamaño pasado por teclado. 
      El array contendrá números aleatorios entre 1 y 300.
      Mostrará aquellos números que acaben en un dígito que nosotros le indiquemos por teclado.
      Debes controlar que se introduce un numero correcto. Estos deben guardarse en un nuevo array.
     */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingresa la longitud del array a crear:");
            int lengthIntro = Integer.parseInt(sc.nextLine());
        
        int[]arrayCreado= crearYrellenarArrayRANDOM(lengthIntro);
        
        System.out.println("El array creado es:");
        imprimirArray(arrayCreado);
        System.out.println("\n¿Que ultimo digito quieres chequear?");
        String num2checkIntro = sc.nextLine();
        checkArray(arrayCreado, num2checkIntro);
        System.out.println("\nSe ha generado el array cuyo digito escogido coincide con los valores"
                + " del array generado anteriormente:");
        imprimirArray(newArraySelectedDigit(arrayCreado, num2checkIntro));
        sc.close();
    }
    
    
    
    public static int[] crearYrellenarArrayRANDOM(int lengthArray) {
        Scanner sc = new Scanner(System.in);
        
        int array[] = new int[lengthArray];
        
        for (int i = 0; i <lengthArray; i++) {
                int randomNum = (int)(Math.random()* (300 - 1 +1)) +1;
                array[i] = randomNum;
        }
    
    return array;
    }
    
    public static void imprimirArray (int lista[]) {
        for (int i = 0; i < lista.length; i++) {
            System.out.print(lista[i]);
            if (i < lista.length -1) {
                System.out.print(", ");
            }
        }
    }
    
}