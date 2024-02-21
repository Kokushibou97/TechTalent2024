
public class three {

	public static void main(String[] args) {
		int op1=-10; int op2=5;
		
		if (sumaNumeros(op1, op2)) {
			System.out.println("resultado es mayor o igual a 0");
		}else {
			System.out.println("El resultado es negativo");
		}
		
	}
public static boolean sumaNumeros(int num1, int num2) {
	int resultado=num1+num2;
	System.out.println("El resultado es "+resultado+" eso quiere decir que");
	if (resultado>=0) {
		return true;
	}else {
		return false;
	}
	
}
}
