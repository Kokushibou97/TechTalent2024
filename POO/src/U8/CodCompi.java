package U8;

import java.util.Random;

import javax.swing.JOptionPane;

public class CodCompi {
    // ATRIBUTOS
    int longitud;
    final int LONG_PRED = 8;
    String pass;
    final String[] simbolos = { "!", "@",
            "#", "$", "%", "^", "&", "*", "-", "_",
            "+", "=", "~", "/", "<", ">" };

    // CONSTRUCTORES
    public CodCompi() {
        this.longitud = LONG_PRED;

        Random numAleatorio = new Random();
        StringBuilder pass = new StringBuilder();
        filtroGeneracion(simbolos, pass, longitud, numAleatorio);
        System.out.println(pass.toString()); // Mostrar en consola
        this.pass = pass.toString();
    }

    public CodCompi(int longitud) {
        this.longitud = longitud;

        Random numAleatorio = new Random();
        StringBuilder pass = new StringBuilder();
        filtroGeneracion(simbolos, pass, longitud, numAleatorio);
        System.out.println(pass.toString()); // Mostrar en consola
        this.pass = pass.toString();
    }

    // METODOS
    public void setLongitud(int longitud) {
        this.longitud = longitud;
    }

    public String getPass() {
        return pass;
    }

    //apllicar filtro para un porcentaje minimo ;)
    public static void main(String[] args) {
        boolean mal = false;
        boolean pred = false;
        String contra = "";
        do {
            String input = JOptionPane.showInputDialog("Ingrese la longitud de la contraseña que se generará");
            if (input.isEmpty()) {
                CodCompi password = new CodCompi();
                contra = password.getPass();
                pred = true;
                mal = false;
            } else {
                try {
                    int longitud = Integer.parseInt(input);
                    CodCompi password = new CodCompi(longitud);
                    contra = password.getPass();
                    pred = false;
                    mal = false;
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "INGRESE UN VALOR ENTERO", "Error 404",
                            JOptionPane.ERROR_MESSAGE);
                    mal = true;
                }
            }
        } while (mal);
        if (pred) {
            JOptionPane.showMessageDialog(null, "Tu contraseña será:\n" + contra + "\n\nOPCIÓN PREDETERMINADA.",
                    "Password", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null,
                    "Tu contraseña será:\n" + contra + "\n\nGENERADA ALEATORIAMENTE.",
                    "Password", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public static void filtroGeneracion(String[] simbolos, StringBuilder pass, int longitud, Random numAleatorio) {
        for (int i = 1; i <= longitud; i++) {
            int indiceLetra = numAleatorio.nextInt(10000);
            if (indiceLetra % 13 == 0) {
                indiceLetra = numAleatorio.nextInt(simbolos.length);
                pass.append(simbolos[indiceLetra]);
            } else if (indiceLetra % 7 == 0) {
                indiceLetra = numAleatorio.nextInt(10) + 48;
                char character = (char) indiceLetra;
                pass.append(character);
            } else if (indiceLetra % 2 == 0) {
                indiceLetra = numAleatorio.nextInt(26) + 65;
                char character = (char) indiceLetra;
                pass.append(character);
            } else {
                indiceLetra = numAleatorio.nextInt(26) + 97;
                char character = (char) indiceLetra;
                pass.append(character);
            }
        }
    }
}