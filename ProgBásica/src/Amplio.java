import javax.swing.JOptionPane;

public class Amplio {

	//Primero escribimos varaibles//
	//Estas variables tendran valor que no se puede cambiar//
	private static final int PUNTOS_HERMANOS = 40;
	private static final int PUNTOS_MISMA_POBLACION = 30;
	private static final int PUNTOS_TRABAJO_MISMA_POBLACION = 20;
	private static final int PUNTOS_DISCAPACIDAD = 10;
	private static final int PUNTOS_FAMILIA_NUMEROSA = 15;
	private static final int PUNTOS_ALUMNI = 5;

	public static void main(String[] args) {
		//creamos una variable que pida al usuario registrar el nº//
		int nRegi = numRegi();

		//Pedimos al usuario contestar con si o no, si tiene hermanos, asignamos puntos//
		int puntos = 0;
		puntos += regiResp("¿Tiene hermanos cursando en el insti? (0: no / 1: sí)", PUNTOS_HERMANOS);

		//Hacemos lo mismo para la otra pregunta//
		puntos += regiResp("¿Vive en el pueblo del insti? (0: no / 1: sí)", PUNTOS_MISMA_POBLACION);

		//Volvemos a formular la pregunta para los padres trabajando en el insti//
		puntos += regiResp("¿Alguno de los padres trabaja en el pueblo del insti? (0: no / 1: sí)",
				PUNTOS_TRABAJO_MISMA_POBLACION);

		//preguntamos sobre las descapacidad y enfermedades crónicas//
		puntos += regiResp(
				"¿Tiene discapacidad igual o superior a 33% o enfermedad crónica? (0: no / 1: sí)",
				PUNTOS_DISCAPACIDAD);

		//Re-preguntamos sobre el estado de la familia//
		puntos += regiResp("¿Forma parte de una familia numerosa, o monoparental? (0: no / 1: sí)",
				PUNTOS_FAMILIA_NUMEROSA);

		//Por último pregiuntamos sobre si agún familiar ha sido alumni//
		puntos += regiResp("¿Algun familiar es alumni? (0: no / 1: sí)",
				PUNTOS_ALUMNI);

		//finalmente mostramos los resultados//
		JOptionPane.showInputDialog(null,
				"El/la alumn@ con número de registro " + nRegi + " tiene un total de " + puntos +
				" Resultado ", JOptionPane.INFORMATION_MESSAGE);
	}

	//Aquí creamos una función para crear el intervalo de nº de resgistro válido entre 1 y 499//
	public static int numRegi() {
		int nRegi = 0;
		boolean numeroValido = false;
		while (!numeroValido) {
			String regiStr = JOptionPane.showInputDialog(null, "Nº de regi de alumn@ ", "Inscripción",
					JOptionPane.QUESTION_MESSAGE);
			try {
				nRegi = Integer.parseInt(regiStr);
				if (nRegi >= 1 && nRegi <= 499) {
					numeroValido = true;
				} else {
					JOptionPane.showMessageDialog(null,
							"El nº de registro tiene que estar entre 1 y 499. Intentalo de nuevo porfa.", "Error",
							JOptionPane.ERROR_MESSAGE);
				}
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "tiene que introducir un nº entero válido.", "Error",
						JOptionPane.ERROR_MESSAGE);
			}
		}
		return nRegi;
	}

	//Esta función es para asignar puntos dependiendo de la anterior función//
	public static int regiResp(String pregunta, int puntos) {
		int respuesta = -1;
		while (respuesta != 0 && respuesta != 1) {
			String respuestaStr = JOptionPane.showInputDialog(null, pregunta, "Inscripción",
					JOptionPane.QUESTION_MESSAGE);
			try {
				respuesta = Integer.parseInt(respuestaStr);
				if (respuesta != 0 && respuesta != 1) {
					JOptionPane.showMessageDialog(null, "¡Ojo! responda con 0 (no) o 1 (sí).", "Error",
							JOptionPane.ERROR_MESSAGE);
				}
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "¡Ojo! responda con 0 (no) o 1 (sí).", "Error",
						JOptionPane.ERROR_MESSAGE);
			}
		}
		return respuesta == 1 ? puntos : 0;
	}
}
