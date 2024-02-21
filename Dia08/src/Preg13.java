import javax.swing.JOptionPane;
public class Preg13 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
int op1 = Integer.parseInt(JOptionPane.showInputDialog("Introduzca el 1r op"));
int op2 = Integer.parseInt(JOptionPane.showInputDialog("Introduzca el 2n op"));
String signo = JOptionPane.showInputDialog("elija una operación aritmética");

double resultado=0;

switch (signo) {
case "+":
resultado = op1+op2;
break;
case "-":
	resultado= (double)op1-op2;
	break;
case "/":
	resultado=op1/op2;
	break;
case "*":
	resultado=op1*op2;
	break;
case "%":
	resultado=op1%op2;
	break;
case "^":
	resultado=op1^op2;
	break;
default:
    JOptionPane.showInputDialog(null,"signo no valido, intenta de nuevo");
    return;
}
JOptionPane.showMessageDialog(null, "El resultado es " + resultado);
}

}
