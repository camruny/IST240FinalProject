
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JTextField;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Cameron
 */
public class splashscreenJPanel extends JPanel {
    
    JTextField placeHolder;
    private ImageIcon image1;
    private JLabel label1;
    
    public splashscreenJPanel() {
        setBackground(Color.white);
        
      
   
        setLayout(new FlowLayout());
        
        image1 = new ImageIcon(getClass().getResource("Asteroid-002.jpg"));
        label1 = new JLabel(image1);
        add(label1);
    }
    
}
