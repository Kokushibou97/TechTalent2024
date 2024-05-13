import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EJE2 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Lista de Películas");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);

        //componentes//
        JLabel label = new JLabel("Película:");
        JTextField textField = new JTextField(20);
        JButton addButton = new JButton("Añadir");
        JComboBox<String> peliculasComboBox = new JComboBox<>();

        //Establecer colores y bordes//
        addButton.setBackground(Color.GREEN);
        addButton.setForeground(Color.WHITE);
        addButton.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));

        //añadir acción al botón//
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nuevaPelicula = textField.getText();
                peliculasComboBox.addItem(nuevaPelicula);
                textField.setText(""); // Limpiar el campo de texto//
            }
        });

        //Crear panel y agregar componentes//
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        panel.add(label);
        panel.add(textField);
        panel.add(addButton);
        panel.add(peliculasComboBox);

        //Agregar panel al frame//
        frame.add(panel);
        frame.setVisible(true);
    }
}
