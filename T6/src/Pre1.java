import java.util.Scanner;

import javax.swing.JSpinner;
public class Pre1 {
	public static void main(String[] args) {
Scanner sc=new Scanner (System.in);
System.out.println("¿Cuál calculo quiere hacer? ");
String figuraGeométrica = sc.nextLine();

double area=0.0;//luego lo usaremos para los metodos//
switch (figuraGeométrica) {
case "Circulo":
	area=calcularAreaCirculo();
	break;
case "Triangulo":
	area=calcularAreaTriangulo();
break;
case "Cuadrado":
	area=calcularAreaCuadrado();
break;
default:
	System.out.println("Figura geometrica non válida. Introduce otra ");
	return;
}
System.out.println("El area de "+figuraGeométrica+" es: "+area);
	}
public static double calcularAreaCirculo() {
	Scanner sc=new Scanner (System.in);
	 System.out.println("pon la radio ");
	double radio = sc.nextDouble();
	return Math.PI*Math.pow(radio, 2);
}
public static double calcularAreaTriangulo(){
	Scanner sc=new Scanner (System.in);
	System.out.println("pon el numero de la base ");
	double base = sc.nextDouble();
	System.out.println("pon el numero de la altura ");
	double altura =sc.nextDouble();
	return (base*altura)/2;
}
public static double calcularAreaCuadrado() {
	Scanner sc=new Scanner (System.in);
	System.out.println("pon el numero del lado ");
	double lado = sc.nextDouble();
	return lado*lado;
}
}
