import java.util.Scanner;
public class Més {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//primero definimos el tipo de la variable y asignamos un valor//
		int tablaMulti=5;
		//indicamos el enunciado//
		System.out.println("Las tablas de multiplicar es "+tablaMulti+":");
		//usamos el bucle for y asignamos i para el encremento y la multiplicación//
		for(int i=1; i<=10;i++){
		int resultado=tablaMulti*i;
		System.out.println(tablaMulti+"x"+i+"="+resultado);
		}
	}

}
