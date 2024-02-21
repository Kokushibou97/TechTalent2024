
public class two {

	public static void main(String[] args) {
int op1=8;
int op2=10;
if(sumaNumeros(8, 10)) {
	System.out.println("El resultado es mayor que 0");
}else {
	System.out.println("El resultado es menor que 0");
}
	}
public static boolean sumaNumeros(int num1, int num2) {
	int resu =num1+num2;
	if(resu>=0) {
		return true;
	}else {
		return false;
	}
}
}
