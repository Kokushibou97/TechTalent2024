package deberes;
import java.util.Random;
import javax.swing.JOptionPane;

public class Preg2 {
    public static void main(String[] args) {
        String input = JOptionPane.showInputDialog("Introduce la cantidad random");
        int cantRandoms = Integer.parseInt(input);
        int r1, r2;
        while (cantRandoms > 0) {
           r1=Integer.parseInt(JOptionPane.showInputDialog("Introduce el primer rango "));
           System.out.println();
            cantRandoms--;
        }
    }

    public static int NuEntRan(int rang1, int rang2) {
        int resultado = (int) (Math.random() * (rang2 - rang1 + 1)) + rang1;
        return resultado;
    }
}

