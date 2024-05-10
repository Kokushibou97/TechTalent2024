import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
//Definición de los componentes: campos de texto, botones y etiquetas//
public class MiniCalculadora extends JFrame implements ActionListener {
	private JTextField textField1, textField2, resultField;
	private JButton sumaButton, restaButton, multButton, divButton;    
	private JLabel label1, label2, resultLabel;  
	//lista de arrays para almacenar el historial de calculos//
	private ArrayList<String> calculationHistory;                                   
	private JButton resetButton;
	private JButton porcentajeButton;
//constructor//
	public MiniCalculadora() { 
		//propiedades de la ventana//
		setTitle("Pascal's_Calculator.exe");
		setSize(300, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);                     
		setLayout(new GridLayout(6, 2));
		setResizable(false);

		//menu con las opciones: historial, about, exit//
		JMenuBar menuBar = new JMenuBar();                                     
		JMenu optionsMenu = new JMenu("Options");                              
//Añadir los componentes al menu//
		JMenuItem historyMenuItem = new JMenuItem("History");
		historyMenuItem.addActionListener(this);
		optionsMenu.add(historyMenuItem);
		JMenuItem aboutMenuItem = new JMenuItem("About");
		aboutMenuItem.addActionListener(this);
		optionsMenu.add(aboutMenuItem);
		JMenuItem exitMenuItem = new JMenuItem("Exit");
		exitMenuItem.addActionListener(this);
		optionsMenu.add(exitMenuItem);

		menuBar.add(optionsMenu);//esta linea añade las opciones del menu al menu//
		setJMenuBar(menuBar);//Establece la barra del menu en el JFrame//

		//inicialización de la lista para historial de calculos//
		calculationHistory = new ArrayList<>();                       

		 //etiquetas, campos de texto y botones a la ventana principal//
		label1 = new JLabel("Operando 1:");
		add(label1);                                                  
		textField1 = new JTextField();                                    
		customizCampoText(textField1); //para poder personalizar campo de texto//                                
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

		//butones//
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
		customizButton(resetButton, Color.GRAY);// personaliza el botón//                       
		add(resetButton);

		porcentajeButton = new JButton("%");
		porcentajeButton.addActionListener(this);
		customizButton(porcentajeButton, Color.YELLOW.darker());       
		add(porcentajeButton);
		
		setVisible(true);
	}
	//metodo para personalizar los botones//
	private void customizButton(JButton button, Color color) {                       
		button.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		button.setFocusPainted(false);
		button.setBackground(color);
		button.setForeground(Color.WHITE);

		button.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				button.setBackground(button.getBackground().darker());// cambiar el color de fondo al entrar//                     
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				button.setBackground(button.getBackground().brighter()); // restaurar el color de fondo al salir//                  
			}
		});
	}
	// metodo para personalizar los campos de texto//
	private void customizCampoText(JTextField textField) {                          
		textField.setBackground(Color.LIGHT_GRAY);  // color de fondo                                
		textField.setBorder(BorderFactory.createLineBorder(Color.GRAY));// borde            
		textField.setFont(new Font("Segoe UI", Font.PLAIN, 14));  // fuente y tamaño de texto//                  
	}
//tenemos el metodo action, que se activa con los clics (evento), cuyo parametro es el action event, que contine info de los clics o acciones occuridas //
	public void actionPerformed(ActionEvent e) {   
		//verificación//
		if (e.getActionCommand().equals("About")) {//about se ejecuta con el if//
			String aboutMensaje = "Pascal's_Calculator\nVersión 1.0\n\nDesarrollado por:\n" + "LAJ TechTigresas";//mensaje informativo//
			JOptionPane.showMessageDialog(this, aboutMensaje, "About", JOptionPane.INFORMATION_MESSAGE);
		} else if (e.getActionCommand().equals("Exit")) {//si la acción es exit, se sale//
			System.exit(0);
		} else if (e.getActionCommand().equals("History")) {    //historial//                     
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
			 //limpiar campos de texto//
			textField1.setText("");
			textField2.setText("");                               
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
				result = num1 + num2;   //calcula la suma//                                                 
			} else if (e.getSource() == restaButton) {
				result = num1 - num2;     // calcula la resta//                                               
			} else if (e.getSource() == multButton) {
				result = num1 * num2;  //calcula la multiplicacion//                                                  
			} else if (e.getSource() == divButton) {
				if (num2 != 0) {                                       
					result = num1 / num2;   //calcula la division//                                                   
				} else {
					JOptionPane.showMessageDialog(this, "Error: División por cero", "Error", JOptionPane.ERROR_MESSAGE);
					return;
				}
            } else if (e.getSource() == porcentajeButton) {
                result = (num1 * num2) / 100;   //calcula el porcentaje//                                          
            }

			resultField.setText(String.valueOf(result));
			// metodo: agregar el cálculo al historial//
			String calculo = num1 + " " + e.getActionCommand() + " " + num2 + " = " + result;          
			agregarAlHistorial(calculo);
		}
	}
	//met. para agregar un calculo al historial//
	private void agregarAlHistorial(String calculo) {                        
		calculationHistory.add(calculo);
	}

	//met. para mostrar el historial de calculos//
	private void mostrHistorial() {                                          
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
//main que ejecuta//
	public static void main(String[] args) {
		new MiniCalculadora();
	}
}
