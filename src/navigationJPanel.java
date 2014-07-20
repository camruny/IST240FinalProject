
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
    newGame.addActionListener(this);
    
    options = new JButton("Options");
    add(options);
    options.addActionListener(this);
    
    instructions = new JButton("Instructions");
    instructions.addActionListener(this);
    add(instructions);
    
    about = new JButton("About");
    add(about);
    about.addActionListener(this);
    
}

    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        
        if(obj == instructions) //not working
        {
            removeAll();
            instructions.setText("Working");
          
          
        }
           if(obj == options) //not working
        {
            options.setText("Working");
        }
              if(obj == newGame) //not working
        {
            newGame.setText("Working");
        }
                 if(obj == about) //not working
        {

            about.setText("Working");
        }
 
    }
    
}
