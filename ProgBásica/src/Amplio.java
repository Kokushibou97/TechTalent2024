import javax.swing.JOptionPane;

public class NajJs3 {

    // Constantes para las puntuaciones
    private static final int PUNTOS_HERMANOS = 40;
    private static final int PUNTOS_MISMA_POBLACION = 30;
    private static final int PUNTOS_TRABAJO_MISMA_POBLACION = 20;
    private static final int PUNTOS_DISCAPACIDAD = 10;
    private static final int PUNTOS_FAMILIA_NUMEROSA = 15;
    private static final int PUNTOS_ALUMNI = 5;

    public static void main(String[] args) {
        // Pedimos al usuario que introduzca el número de registro
        int nRegi = obtenerNumeroRegistro();

        // Verificamos si tiene hermanos en el centro
        int puntos = 0;
        puntos += obtenerRespuesta("¿Tiene algún hermano en el centro? (0: no / 1: sí)", PUNTOS_HERMANOS);

        // Verificamos si vive en la misma población del instituto
        puntos += obtenerRespuesta("¿Vive en la misma población del insti? (0: no / 1: sí)", PUNTOS_MISMA_POBLACION);

        // Verificamos si el padre o la madre trabaja en la misma población del instituto
        puntos += obtenerRespuesta("¿El padre o la madre trabaja en la misma población del insti? (0: no / 1: sí)", PUNTOS_TRABAJO_MISMA_POBLACION);

        // Verificamos si tiene alguna discapacidad o enfermedad crónica
        puntos += obtenerRespuesta("¿Tiene alguna discapacidad igual o superior a 33% o una enfermedad crónica? (0: no / 1: sí)", PUNTOS_DISCAPACIDAD);

        // Verificamos si forma parte de una familia numerosa o monoparental
        puntos += obtenerRespuesta("¿Forma parte de una familia numerosa, o monoparental? (0: no / 1: sí)", PUNTOS_FAMILIA_NUMEROSA);

        // Verificamos si algún familiar ha sido escolarizado en la misma escuela
        puntos += obtenerRespuesta("¿Alguien de su familia ha sido escolarizado en la misma escuela? (0: no / 1: sí)", PUNTOS_ALUMNI);

        // Mostramos el resultado al usuario
        JOptionPane.showMessageDialog(null,
                "El/la alumn@ con número de registro " + nRegi + " tiene un total de " + puntos + " puntos ",
                " Resultado ", JOptionPane.INFORMATION_MESSAGE);
    }

    // Función para obtener el número de registro validado
    public static int obtenerNumeroRegistro() {
        int nRegi = 0;
        boolean numeroValido = false;
        while (!numeroValido) {
            String regiStr = JOptionPane.showInputDialog(null, "Num. de registro del niño ", "Inscripción",
                    JOptionPane.QUESTION_MESSAGE);
            try {
                nRegi = Integer.parseInt(regiStr);
                if (nRegi >= 1 && nRegi <= 499) {
                    numeroValido = true;
                } else {
                    JOptionPane.showMessageDialog(null, "El número de registro debe estar entre 1 y 499. Inténtelo de nuevo.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Por favor, introduzca un número entero válido.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        return nRegi;
    }

    // Función para obtener la respuesta (0 o 1) validada y asignar puntos
    public static int obtenerRespuesta(String pregunta, int puntos) {
        int respuesta = -1;
        while (respuesta != 0 && respuesta != 1) {
            String respuestaStr = JOptionPane.showInputDialog(null, pregunta, "Inscripción",
                    JOptionPane.QUESTION_MESSAGE);
            try {
                respuesta = Integer.parseInt(respuestaStr);
                if (respuesta != 0 && respuesta != 1) {
                    JOptionPane.showMessageDialog(null, "Por favor, responda con 0 (no) o 1 (sí).", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Por favor, responda con 0 (no) o 1 (sí).", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        return respuesta == 1 ? puntos : 0;
    }
}
