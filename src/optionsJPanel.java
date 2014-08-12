
import java.awt.Color;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.XMLEncoder;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Cameron
 */
 
 //Jonathan Cesari - Changed the code a bit to use if statements for our ChangeListeners
 //Added an additional option for a speed slider
public class optionsJPanel extends JPanel implements ActionListener, ChangeListener {
    JButton close, save;
    
    JSlider difficulty, speed, blocksize;
    
    int difficultyLevel = 2, speedLevel = 4, blocksizeLevel = 24, blocksizeAdj;
    
    XMLEncoder xe;

    
    public optionsJPanel()  {
        //DIFFICULTY SLIDER
        difficulty = new JSlider(JSlider.HORIZONTAL,1,3,1);
        difficulty.setBorder(BorderFactory.createTitledBorder("Set Difficulty (Game Time)"));
        difficulty.setMajorTickSpacing(1);
        difficulty.setPaintTicks(true);
        difficulty.addChangeListener(this);
        add(difficulty);
        
        //Speed Slider
        speed = new JSlider(JSlider.HORIZONTAL, 1, 8, 1);
        speed.setBorder(BorderFactory.createTitledBorder("Set Ship Move Speed"));
        speed.setMajorTickSpacing(1);
        speed.setPaintTicks(true);
        speed.addChangeListener(this);
        add(speed);
      
        //Blocksize Slider
        blocksize = new JSlider(JSlider.HORIZONTAL,1, 35, 1);
        blocksize.setBorder(BorderFactory.createTitledBorder("Size of Enemies"));
        blocksize.setMajorTickSpacing(1);
        blocksize.setPaintTicks(true);
        blocksize.addChangeListener(this);
        add(blocksize);
        
        //close button    
        close = new JButton("Close");
        add(close);
        
        //save button
        save = new JButton("Save Options & Start ");
        save.addActionListener(this);
        add(save);
    }


    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        
        if(obj == save) {
    
            //writes the options to the "options.xml" file
            try {
              xe = new XMLEncoder(new BufferedOutputStream(new FileOutputStream("options.xml")));
             }
            catch(Exception xx) {xx.printStackTrace();}

            try {
			 xe.writeObject(difficultyLevel);
			 xe.writeObject(speedLevel);
                         xe.writeObject(blocksizeAdj);
            }
            catch(Exception xx) {xx.printStackTrace();}

            try {
             xe.close();
            }
            catch(Exception xx) {xx.printStackTrace();}
           
            newGameJFrame ngf = new newGameJFrame();
            ngf.setVisible(true);
     	 }
        }
        
   


    public void stateChanged(ChangeEvent e) {
         Object obj = e.getSource();
        //number between 1-3 that dictates the difficulty level, 1:Easy-2:Regular-3:Expert
       if(obj == difficulty)
       {
           difficultyLevel = difficulty.getValue();
       
        //displays the difficulty level in the title of the slider
        switch(difficultyLevel){
            case 1:
                difficulty.setBorder(BorderFactory.createTitledBorder("Set Difficulty - Beginner"));
                break;
            case 2:
                difficulty.setBorder(BorderFactory.createTitledBorder("Set Difficulty - Regular"));
                break;
            case 3:
                difficulty.setBorder(BorderFactory.createTitledBorder("Set Difficulty - Expert"));
                break;
        }
       }
       
    
      if(obj == speed)
       {
           speedLevel = speed.getValue();
    switch(speedLevel){
            case 1:
                speed.setBorder(BorderFactory.createTitledBorder("Set Speed - Extremely Slow"));
                break;
            case 2:
                speed.setBorder(BorderFactory.createTitledBorder("Set Speed - Very Slow"));
                break;
            case 3:
                speed.setBorder(BorderFactory.createTitledBorder("Set Speed - Slow"));
                break;
            case 4:
                speed.setBorder(BorderFactory.createTitledBorder("Set Speed - Average"));
                break;
            case 5:
                speed.setBorder(BorderFactory.createTitledBorder("Set Speed - Moderate"));
                break;
            case 6:
                speed.setBorder(BorderFactory.createTitledBorder("Set Speed - Fast"));
                break;
            case 7:
                speed.setBorder(BorderFactory.createTitledBorder("Set Speed - Very Fast"));
                break;
            case 8:
                speed.setBorder(BorderFactory.createTitledBorder("Set Speed - Extremely Fast"));
                break;
    }
       }
      if(obj == blocksize)
      {
    	  
    	  //7 TO 35, 6 is added to the value in the other panel to start the value at 7
    	  //!!!! PLEASE MAKE SURE 6 IS ADDED TO THE VALUE WITH WHATEVER METHOD WE USE OR IT WILL BE WRONG!!
    	  blocksizeLevel = blocksize.getValue();
          blocksizeAdj = (blocksize.getValue() + 6);
          blocksize.setBorder(BorderFactory.createTitledBorder("Blocksize: " + String.valueOf(blocksizeAdj)));
          
    }
    }
}
