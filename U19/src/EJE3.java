import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EJE3 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Mini Encuesta");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        // Crear componentes
        JLabel sistemaLabel = new JLabel("Elige un sistema operativo:");
        JRadioButton windowsRadioButton = new JRadioButton("Windows");
        JRadioButton linuxRadioButton = new JRadioButton("Linux");
        JRadioButton macRadioButton = new JRadioButton("Mac");

        JLabel especialidadLabel = new JLabel("Elige tu especialidad:");
        JCheckBox programacionCheckBox = new JCheckBox("Programación");
        JCheckBox disenoGraficoCheckBox = new JCheckBox("Diseño gráfico");
        JCheckBox administracionCheckBox = new JCheckBox("Administración");

        JLabel horasLabel = new JLabel("Horas dedicadas en el ordenador:");
        JSlider horasSlider = new JSlider(0, 10);

        JButton mostrarButton = new JButton("Mostrar datos");

        // Agrupar los radio buttons
        ButtonGroup sistemaGroup = new ButtonGroup();
        sistemaGroup.add(windowsRadioButton);
        sistemaGroup.add(linuxRadioButton);
        sistemaGroup.add(macRadioButton);

        // Agregar acción al botón "Mostrar datos"
        mostrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String sistemaSeleccionado = "";
                if (windowsRadioButton.isSelected()) {
                    sistemaSeleccionado = "Windows";
                } else if (linuxRadioButton.isSelected()) {
                    sistemaSeleccionado = "Linux";
                } else if (macRadioButton.isSelected()) {
                    sistemaSeleccionado = "Mac";
                }

                StringBuilder especialidadesSeleccionadas = new StringBuilder();
                if (programacionCheckBox.isSelected()) {
                    especialidadesSeleccionadas.append("Programación, ");
                }
                if (disenoGraficoCheckBox.isSelected()) {
                    especialidadesSeleccionadas.append("Diseño gráfico, ");
                }
                if (administracionCheckBox.isSelected()) {
                    especialidadesSeleccionadas.append("Administración, ");
                }

                int horasDedicadas = horasSlider.getValue();

                // Mostrar los datos en un mensaje emergente
                JOptionPane.showMessageDialog(frame,
                        "Sistema operativo elegido: " + sistemaSeleccionado + "\n" +
                        "Especialidades seleccionadas: " + especialidadesSeleccionadas.toString() + "\n" +
                        "Horas dedicadas en el ordenador: " + horasDedicadas,
                        "Resultados de la Encuesta",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        });

        // Crear panel y agregar componentes
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(0, 1));
        panel.add(sistemaLabel);
        panel.add(windowsRadioButton);
        panel.add(linuxRadioButton);
        panel.add(macRadioButton);
        panel.add(especialidadLabel);
        panel.add(programacionCheckBox);
        panel.add(disenoGraficoCheckBox);
        panel.add(administracionCheckBox);
        panel.add(horasLabel);
        panel.add(horasSlider);
        panel.add(mostrarButton);

        // Agregar panel al frame
        frame.add(panel);
        frame.setVisible(true);
    }
}
