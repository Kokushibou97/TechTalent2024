package Maven.C4;

import java.awt.Font;
import javax.swing.JButton;

class Memoria extends JButton {
    private int numero;

    public Memoria(int num) {
        numero = num;
        setSize(80, 80);
        setFont(new Font("Arial", Font.BOLD, 34));
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void mostrarNumero() {
        setText(String.valueOf(numero));
    }

    public void noMostrarNumero() {
        setText("");
    }
}
