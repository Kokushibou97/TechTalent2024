package View;

import java.awt.event.WindowAdapter;

import javax.swing.*;

import Controler.*;

import java.awt.event.*;

public class SelectTableView extends JFrame {

    private JPanel jp;

    public SelectTableView(final Conexiones c, final String db) {
        setTitle("Tablas");
        setSize(400, 220);
        setLocationRelativeTo(null);
        setVisible(true);

        // Panel
        jp = new JPanel();
        jp.setLayout(null);
        setContentPane(jp);

        // Label
        JLabel titulo = new JLabel("Selecciona una tabla de la base de datos",
                SwingConstants.CENTER);
        titulo.setBounds(0, 10, 400, 20);
        jp.add(titulo);

        // Combo Box
        final JComboBox<String> selectTabla = new JComboBox<String>();
        if (db.equals("clientes")) {
            selectTabla.addItem("Cliente");
            selectTabla.addItem("Videos");

        } else if (db.equals("cientificos")) {
            selectTabla.addItem("Cientificos");
            selectTabla.addItem("Proyecto");
            selectTabla.addItem("Asignado a");
        }
        
        selectTabla.setBounds(140, 40, 120, 20);
        jp.add(selectTabla);

        // Button
        JButton confirmar = new JButton("Confirmar");
        confirmar.setBounds(150, 110, 100, 30);
        jp.add(confirmar);

        // Action Listener
        ActionListener alConfirmar = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                Listeners.selectTabla(selectTabla, c, db);
            }

        };

        confirmar.addActionListener(alConfirmar);

        // Cerrar conexión al salir del aplicativo
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                SelectDbView sdv = new SelectDbView(c);
            }
        });
    }
}