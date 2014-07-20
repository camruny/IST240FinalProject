
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Cameron
 */
public class navigationJPanel extends JPanel implements ActionListener {
    JButton newGame;
    JButton options;
    JButton instructions;
    JButton about;
    
    
    public navigationJPanel() {
    
    newGame = new JButton("New Game");  
    add(newGame);
    options = new JButton("Options");
    add(options);
    instructions = new JButton("Instructions");
    add(instructions);
    about = new JButton("About");
    add(about);
}

    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        
        if(obj == instructions) //not working
        {
            //insert code here to make the InstructionsJFrame visible
            //test to see if the JButton is working
            instructions.setText("Working");
        }
    }
    
}
