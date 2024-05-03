public class S14ArrayBidemensional {

    public static void main(String[] args) {
//aqui escribimos la variable int y asignamos valores en formato lista//
        int[][] datosCorredores = {
            {3457, 1, 51, 52},
            {3467, 1, 32, 41},
            {3568, 0, 14, 57},
            {3570, 0, 12, 63},
            {3571, 1, 45, 63},
            {3572, 0, 17, 46},
            {3573, 0, 12, 44},
            {3574, 0, 30, 42},
            {3575, 1, 24, 77},
            {3576, 0, 57, 48}
        };
//Después mostramos por consola que la lista de los corredores, con los nombres que le corresponde a cada columna de la lista//
        System.out.println("Listado de los corredores:");
        System.out.println("Dorsal / Sexo / Edad / Minutos");
        for (int i = 0; i < datosCorredores.length; i++) {
            System.out.printf("%6d / %4s / %4d / %7d%n",//aqui asignamos los valores a cada columna en horizontal de izquierda a derecha//
                    datosCorredores[i][0],//dorsal
                    (datosCorredores[i][1] == 1) ? "Mujer" : "Hombre",//sexo//
                    datosCorredores[i][2],//edad//
                    datosCorredores[i][3]);//minutos//
        }
//las siguientes variables con el maxvalue se busca el maximo valor dentro del array//
        int mejorTempMujer = Integer.MAX_VALUE;
        int mejorTempHombre = Integer.MAX_VALUE;
        int ganadoraDorsal = 0;
        int ganadorDorsal = 0;
//bucle para recorrer el array//
        for (int i = 0; i < datosCorredores.length; i++) {//con esta linea obtenemos el valor del tiempo (minutos)
            int tiempo = datosCorredores[i][3];
            if (datosCorredores[i][1] == 1 && tiempo < mejorTempMujer) {//está línea es para obtener del int tiempo, los minutos que corresponde a la mujer//
            	mejorTempMujer = tiempo;
            	ganadoraDorsal = datosCorredores[i][0];
            } else if (datosCorredores[i][1] == 0 && tiempo <  mejorTempHombre) {//y en caso contrario al anterior, se asigna al hombre//
            	 mejorTempHombre = tiempo;
            	 ganadorDorsal = datosCorredores[i][0];
            }
        }

        System.out.println("\nGanadora (Mujer): Dorsal " + ganadoraDorsal + " - Tiempo: " + mejorTempMujer + " minutos");//mostreo de los resultados por consola//
        System.out.println("Ganador (Hombre): Dorsal " + ganadorDorsal + " - Tiempo: " +  mejorTempHombre + " minutos");
    }
}
