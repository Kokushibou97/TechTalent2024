
public class Més2 {

	public static void main(String[] args) {
		for (int numero =1; numero <=9; numero++) {
			System.out.println("La tabla de multiplicar " +numero+" es: ");
			for(int i=1; i<=10; i++) {
				int resultado =numero*i;
				System.out.println(numero+"x"+i+"="+resultado);
			}
			System.out.println();
		}

	}

}
