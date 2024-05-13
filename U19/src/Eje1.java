import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Eje1 {
    public static void main(String[] args) {
        //Historial de registro de la conversación//
        ArrayList<String> conversationHistory = new ArrayList<>();

        JFrame frame = new JFrame("Saludador Personalizable");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);

        //componentes//
        JLabel label = new JLabel("Escribe tu nombre:");
        JTextField textField = new JTextField(30);
        JButton button = new JButton("Saludar");

        // Crear panel y agregar componentes//
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout()); // Alineación horizontal
        panel.add(label);
        panel.add(textField);
        panel.add(button);

       
        frame.add(panel);

        //caja de texto//
        JTextArea conversationText = new JTextArea(10, 30);
        conversationText.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(conversationText);
        frame.add(scrollPane, BorderLayout.SOUTH);

        //event/buton//
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = textField.getText();
                String mensajeSalida = "¡Hola " + nombre + "!";
                JOptionPane.showMessageDialog(frame, mensajeSalida, "Saludo Personalizado", JOptionPane.INFORMATION_MESSAGE);

                // Añadir mensaje al historial de conversación//
                String mensajeEntrada = "Usuario: " + nombre;
                conversationHistory.add(mensajeEntrada);
                conversationHistory.add("Sistema: " + mensajeSalida);

                // Actualizar texto de conversación//
                actualizarConversacion(conversationText, conversationHistory);

                // Limpieza//
                textField.setText("");
            }
        });

    
        frame.setVisible(true);
    }

    // Actualizar la caja(texto)//
    private static void actualizarConversacion(JTextArea conversationText, ArrayList<String> conversationHistory) {
        conversationText.setText(""); 
        for (String mensaje : conversationHistory) {
            conversationText.append(mensaje + "\n");
        }
    }
}

