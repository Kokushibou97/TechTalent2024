import javax.swing.*;
import java.awt.*;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

public class Tienda {
    private JFrame frame;
    private Map<String, Producto> stockProductos;

    public Tienda() {
        this.frame = new JFrame("Tienda");
        this.stockProductos = new HashMap<>();
        inicializarBaseDeDatos();
        configurarInterfaz();
    }

    private void configurarInterfaz() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new GridLayout(4, 1));

        JButton agregarProductoBtn = new JButton("Agregar Producto a la Base de Datos");
        JButton agregarCarritoBtn = new JButton("Agregar Producto al Carrito");
        JButton modificarProductoBtn = new JButton("Modificar Producto");
        JButton verStockBtn = new JButton("Ver Stock de Productos");

        agregarProductoBtn.addActionListener(e -> agregarProducto());
        agregarCarritoBtn.addActionListener(e -> agregarCarrito());
        modificarProductoBtn.addActionListener(e -> modificarProducto());
        verStockBtn.addActionListener(e -> verStock());

        frame.add(agregarProductoBtn);
        frame.add(agregarCarritoBtn);
        frame.add(modificarProductoBtn);
        frame.add(verStockBtn);

        frame.setVisible(true);
    }

    public void iniciarVentas() {
        // Lógica para iniciar las ventas
    }

    private void agregarProducto() {
        String nombre = JOptionPane.showInputDialog("Nombre del producto:");
        double precio = Double.parseDouble(JOptionPane.showInputDialog("Precio del producto:"));
        int cantidad = Integer.parseInt(JOptionPane.showInputDialog("Cantidad: "));
        agregarProductoAlStock(nombre, precio, cantidad);
        JOptionPane.showMessageDialog(null, "Producto agregado a la base de datos.");
    }

    private void agregarProductoAlStock(String nombre, double precio, int cantidad) {
        stockProductos.put(nombre, new Producto(nombre, precio, cantidad));
    }

    private void agregarCarrito() {
        comprarProductos();
    }

    private void comprarProductos() {
        JPanel panel = new JPanel(new GridLayout(0, 2));
        Map<String, Integer> productosComprados = new HashMap<>();

        for (Producto producto : stockProductos.values()) {
            String cantidadStr = JOptionPane.showInputDialog("Cantidad a comprar de " + producto.getNombre() + ":");
            if (cantidadStr != null && !cantidadStr.isEmpty()) {
                try {
                    int cantidad = Integer.parseInt(cantidadStr);
                    if (cantidad > 0 && cantidad <= producto.getCantidad()) {
                        productosComprados.put(producto.getNombre(), cantidad);
                    } else {
                        JOptionPane.showMessageDialog(null, "Cantidad no válida para " + producto.getNombre());
                    }
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Cantidad no válida para " + producto.getNombre());
                }
            }
        }

        double totalPagar = 0;
        for (Map.Entry<String, Integer> entry : productosComprados.entrySet()) {
            String nombre = entry.getKey();
            int cantidad = entry.getValue();
            Producto producto = stockProductos.get(nombre);
            totalPagar += producto.getPrecio() * cantidad;
        }

        DecimalFormat df = new DecimalFormat("#.##");
        JOptionPane.showMessageDialog(null, "Total a pagar: €" + df.format(totalPagar));
    }

    private void modificarProducto() {
        String nombre = JOptionPane.showInputDialog("Ingrese el nombre del producto a modificar:");
        if (stockProductos.containsKey(nombre)) {
            double nuevoPrecio = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el nuevo precio para " + nombre + ":"));
            int nuevaCantidad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la nueva cantidad para " + nombre + ":"));
            modificarProductoEnStock(nombre, nuevoPrecio, nuevaCantidad);
            JOptionPane.showMessageDialog(null, "Producto modificado correctamente.");
        } else {
            JOptionPane.showMessageDialog(null, "El producto no existe.");
        }
    }

    private void modificarProductoEnStock(String nombre, double precio, int cantidad) {
        if (stockProductos.containsKey(nombre)) {
            Producto producto = stockProductos.get(nombre);
            producto.setPrecio(precio);
            producto.setCantidad(cantidad);
        }
    }

    private void verStock() {
        StringBuilder listaProductos = new StringBuilder();
        listaProductos.append("--- Stock de Productos ---\n");
        for (Producto producto : stockProductos.values()) {
            listaProductos.append(producto.getNombre()).append(" - Cantidad: ").append(producto.getCantidad())
                    .append(", Precio: €").append(producto.getPrecio()).append("\n");
        }
        JOptionPane.showMessageDialog(null, listaProductos.toString());
    }

    private void inicializarBaseDeDatos() {
        stockProductos.put("Manzanas", new Producto("Manzanas", 2.5, 20));
        stockProductos.put("Plátanos", new Producto("Plátanos", 1.8, 15));
        stockProductos.put("Leche", new Producto("Leche", 1.2, 30));
        stockProductos.put("Pan", new Producto("Pan", 0.9, 25));
        stockProductos.put("Huevos", new Producto("Huevos", 3.0, 40));
        stockProductos.put("Arroz", new Producto("Arroz", 1.5, 50));
        stockProductos.put("Aceite", new Producto("Aceite", 2.8, 35));
        stockProductos.put("Azúcar", new Producto("Azúcar", 1.0, 45));
        stockProductos.put("Sal", new Producto("Sal", 0.8, 40));
        stockProductos.put("Café", new Producto("Café", 4.0, 20));
    }

    public static void main(String[] args) {
        Tienda tienda = new Tienda();
        tienda.iniciarVentas();
    }
}