
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
public class navigationJPanel extends JPanel {
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
    
}
