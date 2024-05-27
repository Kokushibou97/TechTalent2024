package Memo;

public class bleh {
	package Maven.C4;

	import javax.swing.*;
	import java.awt.*;
	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;
	import java.util.Random;

	public class Memorama extends JFrame implements ActionListener {
	    private Memoria memorama[] = new Memoria[16];
	    private boolean primera = false;
	    private Memoria jbtn[] = new Memoria[2];
	    private int intentos;
	    private JLabel jLabIntento = new JLabel("Intentos: 0");
	    private int parejasEncontradas = 0;

	    public Memorama() {
	        initComponents();
	        iniciar();
	    }

	    public void initComponents() {
	        setLayout(new BorderLayout());
	        JPanel panelJuego = new JPanel(new GridLayout(4, 4));
	        add(panelJuego, BorderLayout.CENTER);

	        JPanel panelInfo = new JPanel();
	        panelInfo.add(jLabIntento);
	        add(panelInfo, BorderLayout.SOUTH);

	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    }

	    public int[] mezclar(int[] bar) {
	        Random random = new Random();
	        for (int i = 0; i < bar.length; i++) {
	            int j = random.nextInt(bar.length);
	            int temp = bar[i];
	            bar[i] = bar[j];
	            bar[j] = temp;
	        }
	        return bar;
	    }

	    public void iniciar() {
	        int[] numeros = {1, 2, 3, 4, 5, 6, 7, 8, 1, 2, 3, 4, 5, 6, 7, 8};
	        mezclar(numeros);

	        for (int i = 0; i < memorama.length; i++) {
	            memorama[i] = new Memoria(numeros[i]);
	            memorama[i].addActionListener(this);
	            add(memorama[i]);
	        }

	        setSize(400, 450);
	        intentos = 0;
	        parejasEncontradas = 0;
	        jLabIntento.setText("Intentos: " + intentos);
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

	            Timer timer = new Timer(1000, new ActionListener() {
	                @Override
	                public void actionPerformed(ActionEvent e) {
	                    if (jbtn[0].getNumero() == jbtn[1].getNumero() && jbtn[0] != jbtn[1]) {
	                        jbtn[0].setEnabled(false);
	                        jbtn[1].setEnabled(false);
	                        parejasEncontradas++;
	                        if (parejasEncontradas == 8) {
	                            JOptionPane.showMessageDialog(null, "¡Enhorabuena! Has encontrado todas las parejas.");
	                        }
	                    } else {
	                        jbtn[0].noMostrarNumero();
	                        jbtn[1].noMostrarNumero();
	                    }
	                    primera = false;
	                    intentos++;
	                    jLabIntento.setText("Intentos: " + intentos);
	                }
	            });
	            timer.setRepeats(false);
	            timer.start();
	        }
	    }

	    public static void main(String[] args) {
	        java.awt.EventQueue.invokeLater(() -> {
	            new Memorama().setVisible(true);
	        });
	    }
	}

}
