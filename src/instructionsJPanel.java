
import static com.sun.javafx.fxml.expression.Expression.add;
import javax.swing.JButton;
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
public class instructionsJPanel {
    JButton close;
    JTextField instructions;
    
    instructionsJPanel()
    {
        close = new JButton("Close");
        add(close,"South");
        
        instructions = new JTextField("The instructions will go here.");
        add(instructions, "North");
    }
    
}
