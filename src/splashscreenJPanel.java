
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
    
    public splashscreenJPanel() {
        setBackground(Color.white);
        
        placeHolder = new JTextField("Images will go here");
    }

    
}
