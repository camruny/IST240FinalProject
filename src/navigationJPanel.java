
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
    //====adds the buttons to the window====
    JButton newGame;
    JButton options;
    JButton instructions;
    JButton about;
   
    //====adds the JFrames to the window====
    instructionsJFrame injf = new instructionsJFrame();
    aboutJFrame ajf = new aboutJFrame();
    optionsJFrame ojf = new optionsJFrame();
    
    public navigationJPanel() {
        
    
    //====ActionListeners on navigation sub JFrames====
    injf.injp.close.addActionListener(this);
    ojf.ojp.close.addActionListener(this);
    ajf.ajp.close.addActionListener(this);
        
    //====Options for the Navigational Buttons====
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
        
        if(obj == instructions)
            {
            injf.setVisible(true);
            }
        if(obj == options)
            {
            ojf.setVisible(true);
            }
        if(obj == newGame) //not working
            {
            newGame.setText("Working");
            }
        if(obj == about)
            {
            ajf.setVisible(true);
            }
        if(obj == injf.injp.close)
        {
            //====Makes the INSTRUCTIONS JFrame invisible when the user clicks "Close"====
            injf.setVisible(false);
        }
        if(obj == ojf.ojp.close) {
            ojf.setVisible(false);
        }
        if(obj == ajf.ajp.close)    {
            ajf.setVisible(false);
        }
    }
    
}
