    public static void checkArray (int array2check[], String num2check) {
        System.out.print("Los numeros cuyo ultimo digito es " +num2check+ " son:");
        for (int i = 0; i < array2check.length; i++) {
            String checkPosition = String.valueOf(array2check[i]);
            char lastDigit = checkPosition.charAt(checkPosition.length() -1);
            
            if (String.valueOf(lastDigit).equals(num2check)) {
                System.out.print("\n" +checkPosition);
            }

        }
    }
    public static int[] newArraySelectedDigit(int[] array2check, String num2check) {
        /* Voy a copiar el array y lo voy a chequear igual que en el metodo checkArray.
         * En vez de devolver los numeros, lo que voy a hacer es guardarlos en el array copiado.
         * A la vez, cada vez que encuentre un valor y lo copie al nuevo array, aumento el contador creado.
         * Este array copiado es TEMPORAL, ya que mantiene la longitud del array original.
         * Usamos el contador para dar la longitud del array final; se copia el array tempy se eliminan
         * los espacios vacíos que contenga con el comando System.arraycopy
         */
        int[] numerosGuardadosTEMP = new int[array2check.length];
        int coincidencias = 0; //contador generado

        for (int i = 0; i < array2check.length; i++) {
            String checkPosition = String.valueOf(array2check[i]);
            char lastDigit = checkPosition.charAt(checkPosition.length() - 1);

            if (String.valueOf(lastDigit).equals(num2check)) {
                numerosGuardadosTEMP[coincidencias] = array2check[i];
                coincidencias++;
            }
        }

//        Elimino las posiciones que no tienen valor copiado y doy como length del nuevo array
//        el valor del contador, que aumenta por cada valor copiado.
        int[] arrayFinal = new int[coincidencias];
        

    }