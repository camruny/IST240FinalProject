
import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
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
    private final ImageIcon asteroidPic;
    private final JLabel asteroidLabel;
    
    public splashscreenJPanel() {
        setBackground(Color.blue);
        
      
   
        setLayout(new FlowLayout());
        
        asteroidPic = new ImageIcon(getClass().getResource("Asteroid-002.jpg"));
        asteroidLabel = new JLabel(asteroidPic);
        add(asteroidLabel);
    }
    
}
