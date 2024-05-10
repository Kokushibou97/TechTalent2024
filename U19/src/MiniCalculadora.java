import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class MiniCalculadora extends JFrame implements ActionListener {
	private JTextField textField1, textField2, resultField;
	private JButton sumaButton, restaButton, multButton, divButton;                //se definen los componentes de la calculadora:campos de texto, botones y etiquetas, 
	private JLabel label1, label2, resultLabel;                                    //+lista para almacenar el historial de calculos.     
	private ArrayList<String> calculationHistory;                                   
	private JButton resetButton;
	private JButton porcentajeButton;

	public MiniCalculadora() {                                                           //constructor
		setTitle("Pascal's_Calculator.exe");
		setSize(300, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);                           //propiedades de la ventana
		setLayout(new GridLayout(6, 2));
		setResizable(false);

		// Menú
		JMenuBar menuBar = new JMenuBar();                                       //menu con las opc:History, About y Exit
		JMenu optionsMenu = new JMenu("Options");                                //+se agrega a la barra de menú de la ventana.

		JMenuItem historyMenuItem = new JMenuItem("History");
		historyMenuItem.addActionListener(this);
		optionsMenu.add(historyMenuItem);
		JMenuItem aboutMenuItem = new JMenuItem("About");
		aboutMenuItem.addActionListener(this);
		optionsMenu.add(aboutMenuItem);
		JMenuItem exitMenuItem = new JMenuItem("Exit");
		exitMenuItem.addActionListener(this);
		optionsMenu.add(exitMenuItem);

		menuBar.add(optionsMenu);
		setJMenuBar(menuBar);

		
		calculationHistory = new ArrayList<>();                         //inicialización de la lista para historial de cálculos

		// Labels
		label1 = new JLabel("Operando 1:");
		add(label1);                                                   //etiquetas, campos de texto y botones a la ventana principal.
		textField1 = new JTextField();                                    
		customizCampoText(textField1);                                 //para poder personalizar campo de texto
		add(textField1);

		label2 = new JLabel("Operando 2:");
		add(label2);
		textField2 = new JTextField();
		customizCampoText(textField2); 
		add(textField2);

		resultLabel = new JLabel("Resultado:");
		add(resultLabel);
		resultField = new JTextField();
		resultField.setEditable(false);
		customizCampoText(resultField); 
		add(resultField);

		// Buttons
		sumaButton = new JButton("+");
		sumaButton.addActionListener(this);
		customizButton(sumaButton, Color.GREEN.darker());
		add(sumaButton);

		restaButton = new JButton("-");
		restaButton.addActionListener(this);
		customizButton(restaButton, Color.RED.darker());
		add(restaButton);

		multButton = new JButton("x");
		multButton.addActionListener(this);
		customizButton(multButton, Color.BLUE.darker());
		add(multButton);

		divButton = new JButton("/");
		divButton.addActionListener(this);
		customizButton(divButton, Color.ORANGE.darker());
		add(divButton);

		resetButton = new JButton("c");
		resetButton.addActionListener(this);
		customizButton(resetButton, Color.GRAY);                       // personaliza el botón
		add(resetButton);

		porcentajeButton = new JButton("%");
		porcentajeButton.addActionListener(this);
		customizButton(porcentajeButton, Color.YELLOW.darker());       // personaliza el botón
		add(porcentajeButton);
		
		setVisible(true);
	}

	private void customizButton(JButton button, Color color) {                       //metodo para personalizar los botones 
		button.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		button.setFocusPainted(false);
		button.setBackground(color);
		button.setForeground(Color.WHITE);

		button.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				button.setBackground(button.getBackground().darker());                     // cambiar el color de fondo al entrar
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				button.setBackground(button.getBackground().brighter());                   // restaurar el color de fondo al salir
			}
		});
	}

	private void customizCampoText(JTextField textField) {                          // metodo para personalizar los campos de texto.
		textField.setBackground(Color.LIGHT_GRAY);                                  // color de fondo
		textField.setBorder(BorderFactory.createLineBorder(Color.GRAY));            // borde
		textField.setFont(new Font("Segoe UI", Font.PLAIN, 14));                    // fuente y tamaño de texto
	}
//tenemos el metodo action, que se activa con los clics (evento), cuyo parametro es el action event, que contine info de los clics o acciones occuridas //
	public void actionPerformed(ActionEvent e) {                                    //logica + los eventos de accion: clics en botones o seleccion de opciones de menu.
		//verificación//
		if (e.getActionCommand().equals("About")) {//about se ejecuta con el if//
			String aboutMensaje = "Pascal's_Calculator\nVersión 1.0\n\nDesarrollado por:\n" + "LAJ TechTigresas";//mensaje informativo//
			JOptionPane.showMessageDialog(this, aboutMensaje, "About", JOptionPane.INFORMATION_MESSAGE);
		} else if (e.getActionCommand().equals("Exit")) {//si la acción es exit, se sale//
			System.exit(0);
		} else if (e.getActionCommand().equals("History")) {    //historial//                     //barraMenu
			JTextArea historyArea = new JTextArea();//este se usa para demostrar el historial 
			historyArea.setEditable(false);//y desactiva el modo edición//
			historyArea.setRows(10);
			historyArea.setColumns(30);

			StringBuilder historyText = new StringBuilder();//este bucle recorre el historial y muestra la cadena de cada calculo//
			for (String calculation : calculationHistory) {//el historial se muestra dentro de JTextArea//
				historyText.append(calculation).append("\n");//salto de linea, para que sea legible//
			}
			historyArea.setText(historyText.toString());

			JScrollPane scrollPane = new JScrollPane(historyArea);//Es para desplazar si el texto es demasiado grande//
			JOptionPane.showMessageDialog(this, scrollPane, "Calculation History", JOptionPane.PLAIN_MESSAGE);   //este es el que muestra la caja del dialogo, sin botones//
		} else if (e.getSource() == resetButton) {//resetea//verifica la limpieza//
			
			textField1.setText("");
			textField2.setText("");                                //limpiar campos de texto
			resultField.setText("");
		} else {
			double num1, num2;
			try {//aqui se declaran dos variables y se guardan sus valores//
				num1 = Double.parseDouble(textField1.getText());
				num2 = Double.parseDouble(textField2.getText());
			} catch (NumberFormatException ex) {//aqui se hace el intento de convertir los valores introducidos a nº, si falla muestra mensaje de error//
				JOptionPane.showMessageDialog(this, "Por favor, introduce números válidos.", "Error",
						JOptionPane.ERROR_MESSAGE);
				return;
			}

			double result = 0.0;

			if (e.getSource() == sumaButton) { 
				result = num1 + num2;                                                    //calcula la suma
			} else if (e.getSource() == restaButton) {
				result = num1 - num2;                                                    // calcula la resta
			} else if (e.getSource() == multButton) {
				result = num1 * num2;                                                    //calcula la multiplicacion 
			} else if (e.getSource() == divButton) {
				if (num2 != 0) {                                       
					result = num1 / num2;                                                //calcula la division      
				} else {
					JOptionPane.showMessageDialog(this, "Error: División por cero", "Error", JOptionPane.ERROR_MESSAGE);
					return;
				}
            } else if (e.getSource() == porcentajeButton) {
                result = (num1 * num2) / 100;                                             //calcula el porcentaje
            }

			resultField.setText(String.valueOf(result));
			
			String calculo = num1 + " " + e.getActionCommand() + " " + num2 + " = " + result;          // metodo: agregar el cálculo al historial
			agregarAlHistorial(calculo);
		}
	}///hasta aqui

	private void agregarAlHistorial(String calculo) {                        //met. para agregar un calculo al historial
		calculationHistory.add(calculo);
	}

	
	private void mostrHistorial() {                                          //met. para mostrar el historial de calculos
		JTextArea historialArea = new JTextArea();
		historialArea.setEditable(false);
		historialArea.setRows(10);
		historialArea.setColumns(30);

		StringBuilder historialText = new StringBuilder();
		for (String calculo : calculationHistory) {
			historialText.append(calculo).append("\n");
		}
		historialArea.setText(historialText.toString());

		JScrollPane scrollPane = new JScrollPane(historialArea);
		JOptionPane.showMessageDialog(this, scrollPane, "Calculation History", JOptionPane.PLAIN_MESSAGE);
	}

	public static void main(String[] args) {
		new MiniCalculadora();
	}
}
