public class four {

    public static void main(String[] args) {
        int op1 = 4; 
        int op2 = 5;
        int resultado = sumaNumeros(op1, op2); 
        System.out.println("El resultado de la suma es " + resultado);
     
        if (positivo(resultado)) {
            System.out.println("El resultado es mayor o igual a 0");
        } else {
            System.out.println("El resultado es negativo");
        }
    }

    public static int sumaNumeros(int num1, int num2) {
        return num1 + num2;
    }

    public static boolean positivo(int num) {
        return num >= 0;
    }
}
