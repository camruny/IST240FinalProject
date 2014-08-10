
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.JFrame;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Cameron
 */
public class OLDnewGameJPanel extends JPanel implements ActionListener, KeyListener{
    JButton close;
    Timer tim;
    int delay = 0;
    int i = -1;
    JTextField timeMessage, keyPressed;
    optionsJPanel options;
    
    OLDnewGameJPanel() {
        //Gets the speed option from the Options JPanel
        options = new optionsJPanel();
 
        //Sets the speed of the game using the timer
        switch (options.speedLevel){
            case 1:
                delay = 3000;
            case 2:
                delay = 2000;
            case 3:
                delay = 1000;
            }
        
            close = new JButton("Close");
            tim = new Timer(delay, this);
            timeMessage = new JTextField();
            timeMessage.setBounds(25, 5, 200, 25);
            //add(timeMessage);
            tim.start();
            
            setFocusable(true);
            addKeyListener(this);
            requestFocusInWindow();
            keyPressed = new JTextField("Key Pressed");
            //add(keyPressed);
            
        }
    



    public void actionPerformed(ActionEvent event) 
    {
       	Object obj = event.getSource();
 
        if (obj == tim)
        {
            timeMessage.setBounds(25, 5, 200, 25);
            i++;  
              timeMessage.setText("Current Time: "+i + " seconds");
        }
}

    
    public void keyTyped(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
    public void keyPressed(KeyEvent e) {
        int k = e.getKeyCode();
        if(k == KeyEvent.VK_LEFT)  {keyPressed.setText("L Pressed");}
        if(k == KeyEvent.VK_RIGHT)  {keyPressed.setText("R Pressed");}
    }

 
    public void keyReleased(KeyEvent e) {
        int k = e.getKeyCode();
        if(k == KeyEvent.VK_LEFT)  {keyPressed.setText("L Released");}
        if(k == KeyEvent.VK_RIGHT)  {keyPressed.setText("R Released");}
    }
}
