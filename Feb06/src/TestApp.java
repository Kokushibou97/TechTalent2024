import javax.swing.JOptionPane;
public class TestApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
final double IVA= 0.21;
String texto_num=JOptionPane.
showInputDialog("introduce el precio ");

int precio=Integer.parseInt(texto_num);
JOptionPane.
showMessageDialog(null, " El producto tiene un precio de " +precio+ " y su precio final es " +(precio+(precio*IVA)));
	}

}
