
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Timer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Cameron
 */
public class newGameJPanel extends JPanel implements ActionListener{
    JButton close;
    Timer tim;
    int delay = 0;
    int i = -1;
    JTextField timeMessage;
    optionsJPanel options;

    
    newGameJPanel() {
        options = new optionsJPanel();
 
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
                timeMessage.setBounds(25, 25, 200, 25);
                add(timeMessage);
                   tim.start();
    }
    



    public void actionPerformed(ActionEvent event) 
    {
       	Object obj = event.getSource();
 
        if (obj == tim)
		{
                    timeMessage.setBounds(25, 25, 200, 25);
                    i++;  
                      timeMessage.setText("Current Time: "+i + " seconds");
		}
}
}
