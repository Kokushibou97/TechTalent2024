import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;

public class Grupal extends JFrame {
    private JButton[] buttons = new JButton[16];
    private ArrayList<Color> colors = new ArrayList<>();
    private JButton firstButton = null;
    private JButton secondButton = null;
    private Color firstColor;
    private Color secondColor;
    private boolean isComparing = false; // Variable para controlar el estado de comparación
    private int pairsFound = 0; // Contador de parejas encontradas

    public Grupal() {
        // Configuración de la ventana
        setTitle("Memorama de Colores");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(4, 4)); // 4x4 GridLayout

        // Inicializar colores de los botones
        Color[] colorArray = {
            Color.RED, Color.BLUE, Color.GREEN, Color.YELLOW,
            Color.ORANGE, Color.CYAN, Color.MAGENTA, Color.PINK
        };

        for (Color color : colorArray) {
            colors.add(color);
            colors.add(color);
        }
        Collections.shuffle(colors);

        // Crear y añadir botones
        for (int i = 0; i < 16; i++) {
            buttons[i] = new JButton();
            buttons[i].setBackground(Color.GRAY);
            buttons[i].addActionListener(new ButtonClickListener());
            add(buttons[i]);
        }
    }
}
