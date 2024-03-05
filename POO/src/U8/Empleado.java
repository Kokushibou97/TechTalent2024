package U8;

public class Empleado {
//atributos//
	private String nombre;
	private String apellido;
	private int edad;
	private double salario;
	
	//metodos//
	public boolean plus (double sueldoPlus) {
		boolean aumento=false;
		if (edad>40) {
			salario+=sueldoPlus;
			aumento= true;
		}
		return aumento;
	}
}
