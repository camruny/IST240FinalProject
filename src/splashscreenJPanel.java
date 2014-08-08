import java.awt.*;
import javax.swing.*;

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
        setBackground(Color.black);
        
      
   
        setLayout(new FlowLayout());
        
        image1 = new ImageIcon(getClass().getResource("nav_logo.jpg"));
        label1 = new JLabel(image1);
        add(label1);
    }
    
}