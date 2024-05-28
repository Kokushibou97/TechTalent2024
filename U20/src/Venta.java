import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.BorderLayout;

public class Venta {

    public static void main(String[] args) {
       
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
             
                JFrame frame = new JFrame("Ventana con Etiqueta");
                
              
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                
             
                JLabel etiqueta = new JLabel("Etiqueta de ejemplo", JLabel.CENTER);
                
               
                frame.getContentPane().add(etiqueta, BorderLayout.CENTER);
                
          
                frame.setResizable(true);
                
             
                frame.pack();
                
            
                frame.setLocationRelativeTo(null);
                
               
                frame.setVisible(true);
            }
        });
    }
}
