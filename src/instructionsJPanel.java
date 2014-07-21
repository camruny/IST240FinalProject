
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
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
public class instructionsJPanel extends JPanel implements ActionListener {
    JButton close;
    JTextField instructions;
    
    instructionsJPanel()
    {
        close = new JButton("Close");
        add(close,"South");
        close.addActionListener(this);
        
        instructions = new JTextField("The instructions will go here.");
        add(instructions, "North");
    }


    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        
        
    }
    
}
