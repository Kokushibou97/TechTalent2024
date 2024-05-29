import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Venta {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                createAndShowGUI();
            }
        });
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Ventana");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Añadir una etiqueta centrada
        JLabel etiqueta = new JLabel("Ejemplo ", JLabel.CENTER);
        frame.getContentPane().add(etiqueta, BorderLayout.CENTER);

        // Añadir un botón de cierre
        JButton closeButton = new JButton("Cerrar");
        closeButton.addActionListener(e -> frame.dispose());
        frame.getContentPane().add(closeButton, BorderLayout.SOUTH);

        // Añadir un icono a la ventana
        ImageIcon icon = new ImageIcon("path/to/icon.png");
        frame.setIconImage(icon.getImage());

        // Configurar el tamaño y la posición de la ventana
        frame.setResizable(true);
        frame.setSize(400, 300); // Ajustar el tamaño inicial de la ventana
        frame.setLocationRelativeTo(null); // Centrar la ventana en la pantalla

        // Manejar eventos de ventana
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowOpened(WindowEvent e) {
                System.out.println("Ventana abierta");
            }

            @Override
            public void windowClosing(WindowEvent e) {
                System.out.println("Ventana cerrándose");
            }

            @Override
            public void windowClosed(WindowEvent e) {
                System.out.println("Ventana cerrada");
            }
        });

        // Aplicar un LookAndFeel
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            SwingUtilities.updateComponentTreeUI(frame);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Mostrar la ventana
        frame.setVisible(true);
    }
}

