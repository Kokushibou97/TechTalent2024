package Memo;

public class bleh1 {


	import javax.swing.JToggleButton;

	public class Memoria extends JToggleButton {
	    private int numero;
	    private boolean descubierto = false;

	    public Memoria(int numero) {
	        this.numero = numero;
	        noMostrarNumero();
	    }

	    public int getNumero() {
	        return numero;
	    }

	    public void mostrarNumero() {
	        setText(String.valueOf(numero));
	        setSelected(true);
	        descubierto = true;
	    }

	    public void noMostrarNumero() {
	        setText("");
	        setSelected(false);
	        descubierto = false;
	    }

	    public boolean estaDescubierto() {
	        return descubierto;
	    }
	}

}
