package deberes;
import java.util.Scanner;
public class pREG4 {

	public static void main(String[] args) {
Scanner sc= new Scanner(System.in);
try {
	System.out.println("Introduce un numero para calcular el nº factorial ");
	int num = sc.nextInt();
	if(num <0) {
		System.out.println("Factorial incorrecto ");
	}else {
		long resultado = calcuFactorial(num);
		System.out.println("El factorial de "+num+" es "+resultado);
	}
}catch(Exception e){
	System.out.println(" introduzca un num válido ");
}finally {
	sc.close();
	}
}
	public static long calcuFactorial(int num) {
		long factorial =1;
for (int i=1; i<= num; i++) {
	factorial*=i;
}
return factorial;
	}
}

//Sin array//
//import java.util.Scanner;
//
//public class pREG4 {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//
//        System.out.print("Introduce un num para calcular su factorial : ");
//        int number = sc.nextInt();
//        sc.close();
//
//        long factorial = 1;
//        for (int i = 2; i <= number; i++) {
//            factorial *= i;
//        }
//
//        System.out.println("El factorial de " + number + " es: " + factorial);
//    }
//}