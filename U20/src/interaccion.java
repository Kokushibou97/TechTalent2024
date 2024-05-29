import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class interaccion {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                createAndShowGUI();
            }
        });
    }

    private static void createAndShowGUI() {
        // Crear el marco principal//
        JFrame frame = new JFrame("Ventana con Interaccin");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // Crear la etiqueta//
        JLabel etiqueta = new JLabel("Pulsaste: ", JLabel.CENTER);
        frame.add(etiqueta, BorderLayout.NORTH);

        // Crear los botones//
        JButton boton1 = new JButton("Boton 1");
        JButton boton2 = new JButton("Boton 2");

        // Añadir ActionListeners a los botones//
        boton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                etiqueta.setText("Pulsaste: Boton 1");
            }
        });

        boton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                etiqueta.setText("Pulsaste: Boton 2");
            }
        });

        // Crear un panel para los botones//
        JPanel panelBotones = new JPanel();
        panelBotones.add(boton1);
        panelBotones.add(boton2);

        // Añadir el panel de botones al marco//
        frame.add(panelBotones, BorderLayout.CENTER);

        // Ajustar el tamaño y mostrar la ventana//
        frame.setSize(300, 200);
        frame.setLocationRelativeTo(null); // Centrar la ventana en la pantalla
        frame.setVisible(true);
    }
}
