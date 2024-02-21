import javax.swing.JOptionPane;

public class Preg3 {

    public static void main(String[] args) {
        String nombre = JOptionPane.showInputDialog(null, "Introduce el nombre ");
        if (nombre == null || nombre.isEmpty()) {
            nombre = "invitado";
        }
        String mensajeBienvenida = " Bienvenid@ " + nombre + " <3 ";
        imprimirMensajeEnChatBox(mensajeBienvenida);
    }

    public static void imprimirMensajeEnChatBox(String mensaje) {
        int longitudMensaje = mensaje.length();
        System.out.println("╔" + "═".repeat(longitudMensaje + 2) + "╗");
        System.out.println("║ " + mensaje + " ║");
        System.out.println("╚" + "═".repeat(longitudMensaje + 2) + "╝");
    }
}
