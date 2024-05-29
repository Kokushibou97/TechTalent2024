import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class eje4 {

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
        JFrame frame = new JFrame("Ventana con Eventos");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // Crear la etiqueta
        JLabel etiqueta = new JLabel("Eventos", JLabel.CENTER);
        frame.add(etiqueta, BorderLayout.NORTH);

        // Crear el área de texto
        JTextArea areaTexto = new JTextArea();
        areaTexto.setEditable(false); // Hacer el área de texto no editable
        JScrollPane scrollPane = new JScrollPane(areaTexto); // Agregar barra de desplazamiento
        frame.add(scrollPane, BorderLayout.CENTER);

        // Añadir un WindowListener para capturar eventos de ventana
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowActivated(WindowEvent e) {
                areaTexto.append("Ventana activada\n");
            }

            @Override
            public void windowOpened(WindowEvent e) {
                areaTexto.append("Ventana abierta\n");
            }

            // Otros métodos de WindowListener se pueden sobrescribir según sea necesario
        });

        // Ajustar el tamaño y mostrar la ventana
        frame.setSize(300, 200);
        frame.setLocationRelativeTo(null); // Centrar la ventana en la pantalla
        frame.setVisible(true);
    }
}
