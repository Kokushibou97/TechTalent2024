import javax.swing.JOptionPane;
public class Day06 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int precioProducto = 300;
		final double IVA = 0.21;

		JOptionPane.showMessageDialog(null,
						"El precio del producto, incluido el IVA es " + 
						(precioProducto + (precioProducto * IVA)));
	}

}
