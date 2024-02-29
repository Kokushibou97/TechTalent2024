public class E2NajemJ {

	public static void main(String[] args) {
		      //Primero asignamos los valores a sus varaibles correspondientes//
		//Ya que estamos hablando de numeros enteros, usamos el int//
		//Para la 1ra piscina//
		        int largoP1= 300;
		        int amplioP1= 150;
		        int profunP1= 20;
              //para la segunda//
		        int largoP2= 300;
		        int amplioP2= 80;
		        int profunP2= 35;

             //Hacemos el 1r cálculo que nos pide: area//
		        int area1 = largoP1 * amplioP2;
		        int area2 = largoP2 * amplioP2;

		      //Hacemos el calculo del otro calculo: volumen de otra forma//
		        int vol1 = area1 * 20;
		        int vol2 = area2 * 35;

		        //Calculamos la ampliada fusionada//
		        int amplioFus = 150 + 80;

		        //Calculamos la area compartida//
		        int areaCompartida = area1 + area2;

		        //Luego calculamos el volumen de ambas//
		        int volAmbas = vol1 + vol2;

		        //Hacemos un intercambio de valores con el método de regla de tres//
		        int profundAB = profunP1;
		        profunP1 = profunP2;
		        profunP2 = profundAB;

		        //Volvemos  a calcular//
		        int valorNuevop1 = area1 * profunP1;

		        //Hacemos lo mismo para la segunda piscina//
		        int valorNuevop2 = area2 * profunP2;

		        //Usamos syso para mostrar los resultados//
		        //Ponemos el texto concateado con el resultado de los calculos//
		        System.out.println("La area de la 1ra piscina es: " + area1);
		        System.out.println("la area de la segunda es: " + area2);
		        System.out.println("el volumen de la 1ra es : " + vol1);
		        System.out.println("el volumen de la segunda es : " + vol2);
		        System.out.println("la ampliada de ambas es : " + amplioFus);
		        System.out.println("la area combinada entre las dos es : " + areaCompartida);
		        System.out.println("el volumen del agua de las dos piscinas es : " + volAmbas);
		        System.out.println(" el nuevo volumen de la 1ra es : " + valorNuevop1);
		        System.out.println("el nuevo volumen de la segunda psicina es : " + valorNuevop2);
		

	}

}
