    package Maven.C4;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Memorama extends JFrame implements ActionListener {
    private Memoria memorama[] = new Memoria[20];
    private boolean primera = false;
    private JButton jbtn[] = new JButton[2];
    private int intentos;
    private JFileChooser jfch = new JFileChooser();
    private JLabel jLabIntento = new JLabel();
    private JLabel jLabprueba = new JLabel();

    public Memorama() {
        initComponents();
        iniciar();
    }

    public void initComponents() {
        setLayout(null);
        jLabIntento.setBounds(30, 450, 100, 30);
        jLabprueba.setBounds(150, 450, 300, 30);
        add(jLabIntento);
        add(jLabprueba);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public int[] mezclar(int bar[]) {
        int m = bar.length - 1;
        for (int r = m; r > 1; r--) {
            int alea = (int) Math.floor(r * Math.random());
            int temp = bar[r];
            bar[r] = bar[alea];
            bar[alea] = temp;
        }
        return bar;
    }

    public void iniciar() {
        int x = 30, y = 50;
        int arre[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        mezclar(arre);

        for (int r = 0; r < memorama.length; r++) {
            memorama[r] = new Memoria(arre[r]);
            memorama[r].setLocation(x, y);
            x += 100;
            if ((r + 1) % 5 == 0) {
                y += 100;
                x = 30;
            }
            memorama[r].addActionListener(this);
            add(memorama[r]);
        }

        setSize(550, 550);
        intentos = 0;
        jLabIntento.setText(String.valueOf(intentos));
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Memoria btn = (Memoria) ae.getSource();

        if (!primera) {
            btn.mostrarNumero();
            jbtn[0] = btn;
            primera = true;
        } else {
            btn.mostrarNumero();
            jbtn[1] = btn;

            if ((() jbtn[0]).getNumero() == jbtn[1].getNumero() && jbtn[0] != jbtn[1]) {
                jbtn[0].setEnabled(false);
                jbtn[1].setEnabled(false);
            } else {
                jbtn[0].noMostrarNumero();
                jbtn[1].noMostrarNumero();
            }

            primera = false;
            intentos++;
            jLabIntento.setText(String.valueOf(intentos));
        }
    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> {
            new Memorama().setVisible(true);
        });
    }
}
