package Maven.C4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Juego extends JFrame {
    private final int NUM_CARTAS = 16;
    private JButton[] cartas;
    private int intentos = 0;
    private int cartasDesbloqueadas = 0;

    public Juego() {
        setTitle("Juego de Memoria");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(4, 4));

        cartas = new JButton[NUM_CARTAS];
        for (int i = 0; i < NUM_CARTAS; i++) {
            cartas[i] = new JButton();
            cartas[i].addActionListener(new CartaClickListener());
            add(cartas[i]);
        }

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private class CartaClickListener implements ActionListener {
        private boolean primeraCartaSeleccionada = false;
        private int indicePrimeraCarta;

        @Override
        public void actionPerformed(ActionEvent e) {
            JButton carta = (JButton) e.getSource();
            int indiceCarta = -1;

            for (int i = 0; i < NUM_CARTAS; i++) {
                if (cartas[i] == carta) {
                    indiceCarta = i;
                    break;
                }
            }

            if (!carta.isEnabled()) {
                return; // Carta ya desbloqueada
            }

            if (!primeraCartaSeleccionada) {
                primeraCartaSeleccionada = true;
                indicePrimeraCarta = indiceCarta;
                // Cambia el color o muestra la imagen de la carta
            } else {
                primeraCartaSeleccionada = false;
                // Verifica si las cartas son iguales
                if (sonIguales(indicePrimeraCarta, indiceCarta)) {
                    // Deshabilita las cartas
                    cartas[indicePrimeraCarta].setEnabled(false);
                    cartas[indiceCarta].setEnabled(false);
                    cartasDesbloqueadas += 2;
                    // Comprueba si todas las cartas están desbloqueadas
                    if (cartasDesbloqueadas == NUM_CARTAS) {
                        JOptionPane.showMessageDialog(null, "¡Enhorabuena! Has completado el juego en " + intentos + " intentos.");
                    }
                } else {
                    // Vuelve a su estado original
                    // Puedes cambiar el color o mostrar la imagen nuevamente
                }
                intentos++;
            }
        }

        private boolean sonIguales(int indice1, int indice2) {
            // Lógica para comparar las cartas (por ejemplo, usando etiquetas o imágenes)
            return true; // Cambia esto según tu implementación
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Juego());
    }
}

