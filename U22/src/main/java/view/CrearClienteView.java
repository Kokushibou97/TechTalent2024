package view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Date;

public class CrearClienteView extends JFrame {
    private JTextField nombreField;
    private JTextField apellidoField;
    private JTextField direccionField;
    private JTextField dniField;
    private JButton btnCrear;

    public CrearClienteView() {
        // Configuración de la vista

        btnCrear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    String nombre = nombreField.getText();
                    String apellido = apellidoField.getText();
                    String direccion = direccionField.getText();
                    int dni = Integer.parseInt(dniField.getText());
                    Date fecha = new Date(); // Supongamos que la fecha es la actual
                    Cliente cliente = new Cliente(nombre, apellido, direccion, dni, fecha);
                    ClienteDAO clienteDAO = new ClienteDAO();
                    clienteDAO.crearCliente(cliente);
                    JOptionPane.showMessageDialog(null, "Cliente creado correctamente.");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "El DNI debe ser un número válido.");
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Error al crear el cliente: " + ex.getMessage());
                }
            }
        });
    }
}

