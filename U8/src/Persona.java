//primero se crea el objeto publico//
public class Persona {
	private String nombre;// después se definen con las variables privadas para la clase Uno//
	private int edad;// Estos variables representan los atributos de la persona//
	private String dni;// con el método privado solamente Uno puede acceder a ellos//
	private char sexo;
	private double peso;
	private double altura;
//A continuación se decalara dos variables constantes de sexo hombre y otro para la mujer//
	public static final char SEXO_HOMBRE = 'H';// el static y el final se usa para fijarlos y usarlos por los
												// instantes//
	public static final char SEXO_MUJER = 'M';

//Luego se definen tres constructores//
	public Persona() {// el primer constructor se da por defecto//
		this("", 0, "", SEXO_HOMBRE, 0, 0);
	}

//este constructor llama al tercero con valores del primero para otros atributos//
	public Persona(String nombre, int edad, char sexo) {
		this(nombre, edad, "", sexo, 0, 0);
	}

//Este constructor usa todos los parametros//
	// Luego, inicializa el objeto con los valores declarados//
	public Persona(String nombre, int edad, String dni, char sexo, double peso, double altura) {
		this.nombre = nombre;
		this.edad = edad;
		this.dni = dni;
		this.sexo = sexo;
		this.peso = peso;
		this.altura = altura;
	}

	// Getters and setters//

	@Override
	public String toString() {// Este método anula el método toString()//
		// para proporcionar una representación en forma de cadena del objeto Uno//
		return "Nombre: " + nombre + ", Edad: " + edad + ", DNI: " + dni + ", Sexo: " + sexo + ", Peso: " + peso
				+ ", Altura: " + altura;
	}

	public static void main(String[] args) {
		Persona persona1 = new Persona();
		System.out.println(persona1);

		Persona persona2 = new Persona("Mamon", 18, SEXO_HOMBRE);
		System.out.println(persona2);

		Persona persona3 = new Persona("Bonbon", 18, "98765432B", SEXO_MUJER, 50, 1.60);
		System.out.println(persona3);
	}
}
