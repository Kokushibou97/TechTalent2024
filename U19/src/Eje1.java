import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Eje1 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Saludador Personalizable");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 150);

        // Crear componentes
        JLabel label = new JLabel("Escribe tu nombre:");
        JTextField textField = new JTextField(20);
        JButton button = new JButton("Saludar");

        // Cambiar colores de los componentes
        button.setBackground(Color.BLUE);
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false); // Evita que se muestre un borde al hacer clic

        // Agregar acción al botón
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = textField.getText();
                JOptionPane.showMessageDialog(frame, "¡Hola " + nombre + "!", "Saludo Personalizado", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        // Crear panel y agregar componentes
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout()); // Alineación horizontal
        panel.add(label);
        panel.add(textField);
        panel.add(button);

        // Agregar panel al frame
        frame.add(panel);
        frame.setVisible(true);
    }
}
