package deberes;
import javax.swing.JOptionPane;

public class Preg2 {
    public static void main(String[] args) {
        String input = JOptionPane.showInputDialog(" Introduce la cantidad random ");
        int cantRandoms = Integer.parseInt(input);
        while (cantRandoms > 0) {
        	   int r1=Integer.parseInt(JOptionPane.showInputDialog(" Introduce el 1r rango ")); 
        	   int r2=Integer.parseInt(JOptionPane.showInputDialog(" Introduce el segundo "));
        	int randomNum = NuEntRan(r1, r2);
           System.out.println(" El nº aleatorio es "+randomNum);
            cantRandoms--;
        }
    }
    public static int NuEntRan(int rang1, int rang2) {
        int resultado = (int) (Math.random() * (rang2 - rang1 + 1)) + rang1;
        return resultado;
    }
}

