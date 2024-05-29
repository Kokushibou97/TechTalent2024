import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class eje {

    private static int contadorBoton1 = 0;
    private static int contadorBoton2 = 0;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                createAndShowGUI();
            }
        });
    }

    private static void createAndShowGUI() {
        // Crear el marco principal
        JFrame frame = new JFrame("Ventana con Más Interacción");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(3, 1));

        // Crear las etiquetas
        JLabel etiquetaBoton1 = new JLabel("Boton 1: 0 veces", JLabel.CENTER);
        JLabel etiquetaBoton2 = new JLabel("Boton 2: 0 veces", JLabel.CENTER);

        // Crear los botones
        JButton boton1 = new JButton("Botón 1");
        JButton boton2 = new JButton("Botón 2");

        // Añadir ActionListeners a los botones
        boton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                contadorBoton1++;
                etiquetaBoton1.setText("Boton 1: " + contadorBoton1 + " veces");
            }
        });

        boton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                contadorBoton2++;
                etiquetaBoton2.setText("Boton 2: " + contadorBoton2 + " veces");
            }
        });

        // Añadir las etiquetas y los botones al marco
        frame.add(etiquetaBoton1);
        frame.add(etiquetaBoton2);
        frame.add(boton1);
        frame.add(boton2);

        // Ajustar el tamaño y mostrar la ventana
        frame.setSize(300, 200);
        frame.setLocationRelativeTo(null); // Centrar la ventana en la pantalla
        frame.setVisible(true);
    }
}
