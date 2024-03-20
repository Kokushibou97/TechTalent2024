import java.awt.Component;
import java.awt.GridLayout;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

import javax.swing.*;

public class Ej4modificado {
    
    public static void main(String[] args) {
		  Tienda tienda = new Tienda();
	        tienda.iniciarVentas();
	    }
	}

	class Tienda {

	    private Map<String, Double> productos;

	    public Tienda() {
	        productos = new HashMap<>();
	    }

	    public void iniciarVentas() {
	        pedirDatos();
	        int respuesta = masProductos();
	        do {
	            pedirMasProductos(respuesta);
	            respuesta = masProductos();
	        } while (respuesta == JOptionPane.YES_OPTION);
	        gestionarVentas();
	    }

	    private int masProductos() {
	        return JOptionPane.showConfirmDialog(null, "¿Deseas introducir otro producto?", "Pregunta",
	                JOptionPane.YES_NO_OPTION);
	    }

	    private void pedirMasProductos(int respuesta) {
	        int numero = productos.size();
	        if (respuesta == JOptionPane.YES_OPTION) {
	            JPanel panel = new JPanel();
	            JTextField articuloField = new JTextField(10);
	            JTextField precioField = new JTextField(4);
	            JTextField cantidadField = new JTextField(4);
	            JComboBox<String> ivaComboBox = new JComboBox<>(new String[]{"4%", "21%"});

	            panel.add(new JLabel("Artículo " + (numero + 1) + ":"));
	            panel.add(articuloField);
	            panel.add(new JLabel("Precio: "));
	            panel.add(precioField);
	            panel.add(new JLabel("Cantidad: "));
	            panel.add(cantidadField);
	            panel.add(new JLabel("IVA: "));
	            panel.add(ivaComboBox);

	            int result = JOptionPane.showConfirmDialog(null, panel,
	                    "Introduce los datos para el artículo " + (numero + 1), JOptionPane.OK_CANCEL_OPTION);

	            if (result == JOptionPane.OK_OPTION) {
	                String articulo = articuloField.getText();
	                double precio;
	                int cantidad;
	                try {
	                    precio = Double.parseDouble(precioField.getText());
	                    cantidad = Integer.parseInt(cantidadField.getText());
	                    double iva = 0.21;
	                    if (ivaComboBox.getSelectedItem().equals("4%")) {
	                        iva = 0.04;
	                    }
	                    productos.put(articulo, precio * cantidad * (1 + iva));
	                } catch (NumberFormatException e) {
	                    JOptionPane.showMessageDialog(null, "Error, ingresa un número válido para el precio o la cantidad", "Error",
	                            JOptionPane.ERROR_MESSAGE);
	                }
	            }
	        }
	    }

	    private void pedirDatos() {
	        int cantidadProd = Integer.parseInt(JOptionPane.showInputDialog(null,
	                "Introduce la cantidad de artículos en stock: "));

	        for (int i = 0; i < cantidadProd; i++) {
	            JPanel panel = new JPanel();
	            JTextField articuloField = new JTextField(10);
	            JTextField precioField = new JTextField(4);
	            JTextField cantidadField = new JTextField(4);
	            JComboBox<String> ivaComboBox = new JComboBox<>(new String[]{"4%", "21%"});

	            panel.add(new JLabel("Artículo " + (i + 1) + ":"));
	            panel.add(articuloField);
	            panel.add(new JLabel("Precio: "));
	            panel.add(precioField);
	            panel.add(new JLabel("Cantidad: "));
	            panel.add(cantidadField);
	            panel.add(new JLabel("IVA: "));
	            panel.add(ivaComboBox);

	            int result = JOptionPane.showConfirmDialog(null, panel,
	                    "Introduce los datos para el artículo " + (i + 1), JOptionPane.OK_CANCEL_OPTION);

	            if (result == JOptionPane.OK_OPTION) {
	                String articulo = articuloField.getText();
	                double precio;
	                int cantidad;
	                try {
	                    precio = Double.parseDouble(precioField.getText());
	                    cantidad = Integer.parseInt(cantidadField.getText());
	                    double iva = 0.21;
	                    if (ivaComboBox.getSelectedItem().equals("4%")) {
	                        iva = 0.04;
	                    }
	                    productos.put(articulo, precio * cantidad * (1 + iva));
	                } catch (NumberFormatException e) {
	                    JOptionPane.showMessageDialog(null, "Error, ingresa un número válido para el precio o la cantidad", "Error",
	                            JOptionPane.ERROR_MESSAGE);
	                    i--;
	                }
	            } else {
	                break;
	            }
	        }
	    }

	    public void gestionarVentas() {
	        JFrame frame = new JFrame("Tienda");
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        frame.setSize(400, 300);
	        frame.setLayout(new GridLayout(3, 1));

	        JButton agregarProductoBtn = new JButton("Agregar Producto a la Base de Datos");
	        JButton agregarCarritoBtn = new JButton("Agregar Producto al Carrito");

	        agregarProductoBtn.addActionListener(e -> agregarProducto());
	        agregarCarritoBtn.addActionListener(e -> agregarCarrito());

	        frame.add(agregarProductoBtn);
	        frame.add(agregarCarritoBtn);

	        frame.setVisible(true);
	    }

	    private void agregarProducto() {
	        String nombre = JOptionPane.showInputDialog("Nombre del producto:");
	        double precio = Double.parseDouble(JOptionPane.showInputDialog("Precio del producto:"));
	        double cantidad = Double.parseDouble(JOptionPane.showInputDialog("Cantidad: "));
	        productos.put(nombre, (precio+cantidad));
	    }

	    private void agregarCarrito() {
	        JFrame frame = new JFrame("Agregar al Carrito");
	        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	        frame.setSize(400, 300);
	        frame.setLayout(new GridLayout(productos.size() + 1, 1));

	        JLabel titleLabel = new JLabel("Selecciona los productos:");
	        frame.add(titleLabel);

	        for (String producto : productos.keySet()) {
	            JCheckBox checkBox = new JCheckBox(producto);
	            frame.add(checkBox);
	        }

	        JButton comprarBtn = new JButton("Comprar");
	        comprarBtn.addActionListener(e -> comprarProductos(frame));
	        frame.add(comprarBtn);

	        frame.setVisible(true);
	    }

	    private void comprarProductos(JFrame frame) {
	        double totalPagar = 0;

	        for (Component component : frame.getContentPane().getComponents()) {
	            if (component instanceof JCheckBox) {
	                JCheckBox checkBox = (JCheckBox) component;
	                if (checkBox.isSelected()) {
	                    String producto = checkBox.getText();
	                    double precio = productos.get(producto);
	                    totalPagar += precio;
	                }
	            }
	        }

	        DecimalFormat df = new DecimalFormat("#.##");
	        JOptionPane.showMessageDialog(null, "Total a pagar: €" + df.format(totalPagar));

	        frame.dispose();
	    }
	}
