
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.XMLDecoder;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Cameron
 */
public class aboutJPanel extends JPanel implements ActionListener {
    JButton close;
    JTextArea instructions;
    String instructionText = "ERROR";   //Shows an error if the program does not read from the XML file
    XMLDecoder de;
    
    aboutJPanel()
    {
        close = new JButton("Close");
        add(close,"South");
        close.addActionListener(this);
        
        getAbout();
        
        instructions = new JTextArea(10,40);
        instructions.setText(instructionText);
        instructions.setLineWrap(true);
        instructions.setWrapStyleWord(true);
        instructions.setEditable(false);
        add(instructions, "Center");
        
        
        
    }
    
    //gets the instructions from the instruction.xml document and sets it as a string
    public void getAbout()   {
    try {
              de = new XMLDecoder(new BufferedInputStream(new FileInputStream("about.xml")));
             }
          catch(Exception xx) {xx.printStackTrace();}
          try {
			 instructionText = (String)de.readObject();
			 
            }
          catch(Exception xx) {xx.printStackTrace();}
          try {
             de.close();
            }
          catch(Exception xx) {xx.printStackTrace();}
        }


    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        
        
    }
    
}
