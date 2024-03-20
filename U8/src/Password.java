import java.security.SecureRandom; // Esta clase utiliza un algoritmo más seguro para generar aleatorios//

// Primero se crea la clase llamada Password//
public class Password {
	private int longitud; // Se definen las variables en privado//
	private String password;

	// Mediante las variables constantes se definen los caracteres admisibles para
	// generar la contraseña//
	private static final String CARACTERES_VALIDOS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()_+{}[]|;:,.<>?";
	private static final SecureRandom RANDOM_GENERATOR = new SecureRandom();
	// Aquí se hace lo mismo para la longitud del password//
	private static final int LONGITUD_PREDETERMINADA = 8;
//Empezamos a crear los constructores//
	// Este es el constructor por defecto//
	public Password() {
        this(LONGITUD_PREDETERMINADA);
    }

	// El segundo constructor se usa para la longitud del password//
	public Password(int longitud) {
        if (longitud <= 0) {
            throw new IllegalArgumentException("La longitud debe ser un número entero y superior a 0");
        }
        this.longitud = longitud;
        generPasswordAlea();
    }

	// Este método genera la contraseña con la longitud deseada//
	private void generPasswordAlea() {//esta función privada se encarga en generar el passwor aleatoriamente//
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < longitud; i++) {//mediante este bucle se decide cuantos carácteres tendrá una contraseña//
			int index = RANDOM_GENERATOR.nextInt(CARACTERES_VALIDOS.length());
			sb.append(CARACTERES_VALIDOS.charAt(index));
		}
		password = sb.toString();
	}

	// Getters
	public String getPassword() {
		return password;
	}

	// Setters
	public void setLongitud(int longitud) {
		if (longitud <= 0) {
			throw new IllegalArgumentException("La longitud debe ser un número positivo ");
		}
		this.longitud = longitud;
		generPasswordAlea(); // Generación del password
	}

	public static void main(String[] args) {

		Password passwordPredeterminado = new Password();
		System.out.println("El password por defecto es  " + passwordPredeterminado.getPassword());

		Password passwordPersonalizado = new Password(12);
		System.out.println("El password personalizado es " + passwordPersonalizado.getPassword());
	}
}
