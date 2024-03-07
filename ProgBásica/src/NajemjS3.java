//Nos piden crear un programa que le pida al usuario cierta información//
//Plantear preguntas sencillas que se contestan con si o no//
//Si o no condiciona a dar un resultado al final//

import javax.swing.JOptionPane;

public class NajemjS3 {

	public static void main(String[] args) {
		// Primero tenemos que pedir el nº de registro//
		// Se ha usado la caja de dialogo para que le usuario introduzca la
		// información//
		String regiStr = JOptionPane.showInputDialog(null, "Num. de registro del niño ", "Inscripción",
				JOptionPane.QUESTION_MESSAGE);
		int nRegi = Integer.parseInt(regiStr);// la función del parseint es guardar la info, luego convertirla en int//

		// Hermanos?//
		String hermanoStr = JOptionPane.showInputDialog(null, "¿Tiene algún hermano en el centro? (0: no / 1: sí)",
				"Inscripción", JOptionPane.QUESTION_MESSAGE);
		int tieneHerm = Integer.parseInt(hermanoStr);

		int puntos = 0;

		// el bucle, en el caso de si pues asignamos puntos//
		//Como la respuesta del usuario condiciona el resultado usaremos el bucle if/else//
		//dentro del bucle ponemos que si la condicion es igual a 1, entonces asignamos puntos//
		if (tieneHerm == 1) {
			puntos += 40;
		} else {//si el valor puesto por el usuario es 0, no se asignan puntos//
			// vive en el pueblo?//
			String mismoPobStr = JOptionPane.showInputDialog(null,
					"¿Vive en la misma población del insti? (0: no / 1: sí)", "Inscripción",
					JOptionPane.QUESTION_MESSAGE);
			int mismoPob = Integer.parseInt(mismoPobStr);

			// Si, sí pues asiganmos puntos//
			if (mismoPob == 1) {
				puntos += 30;
			} else {
				// Trabjan los padres en el pueblo?//
				String trabajaMismaPoblacionStr = JOptionPane.showInputDialog(null,
						"¿El padre o la madre trabaja en la misma población del insti? (0: no / 1: sí)",
						"Inscripción", JOptionPane.QUESTION_MESSAGE);
				int trabMismoPob = Integer.parseInt(mismoPobStr);

				// En el caso de si, asignamos puntos//
				if (trabMismoPob == 1) {
					puntos += 20;
				}
			}
		}

		// Tiene problemas?//
		String discStr = JOptionPane.showInputDialog(null,
				"¿Tiene alguna discapacidad igual o superior a 33% o una enfermedad crónica? (0: no / 1: sí)",
				"Inscripción", JOptionPane.QUESTION_MESSAGE);
		int discap = Integer.parseInt(discStr);

		// En el caso de si, asignamos puntos//
		if (discap == 1) {
			puntos += 10;
		}

		// Preguntamos si tiene familia numerosa o monoparental//
		String famNumStr = JOptionPane.showInputDialog(null,
				"¿Forma parte de una familia numerosa, o monoparental? (0: no / 1: sí)", "Inscripción",
				JOptionPane.QUESTION_MESSAGE);
		int famNum = Integer.parseInt(famNumStr);

		// En el caso de si, asignamos puntos//
		if (famNum == 1) {
			puntos += 15;
		}

		// Algún familiar ha sido alumni?//
		String alumniInstiStr = JOptionPane.showInputDialog(null,
				"¿Alguien de su familia ha sido escolarizado en la misma escuela? (0: no / 1: sí)", "Inscripción",
				JOptionPane.QUESTION_MESSAGE);
		int alumniInsti = Integer.parseInt(alumniInstiStr);

		// en el caso de respuesta afirmativa, asignamos puntos//
		if (alumniInsti == 1) {
			puntos += 5;
		}

		// Le mostramos el resultado al usuario//
		JOptionPane.showMessageDialog(null,
				"El/la alumn@ con número de registro " + nRegi + " tiene un total de " + puntos + " puntos ",
				" Resultado ", JOptionPane.INFORMATION_MESSAGE);
	}

}
