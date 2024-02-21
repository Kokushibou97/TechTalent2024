import javax.swing.JOptionPane;
public class Preg4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        String inputRadio = JOptionPane.showInputDialog(null, "Por favor, introduce el radio del círculo:");

        double radio = Double.parseDouble(inputRadio);

        double area = Math.PI * Math.pow(radio, 2);


        JOptionPane.showMessageDialog(null, "El área del círculo con radio " + radio + " es: " + area);
	}

}
