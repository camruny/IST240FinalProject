
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JSlider;
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
public class optionsJPanel extends JPanel implements ActionListener, ChangeListener {
    JButton close;
    
    JSlider difficulty;
    
    int difficultyLevel;

    
    public optionsJPanel()  {
        //DIFFICULTY SLIDER
        difficulty = new JSlider(JSlider.HORIZONTAL,1,3,1);
        difficulty.setBorder(BorderFactory.createTitledBorder("Set Difficulty"));
        difficulty.setMajorTickSpacing(1);
        difficulty.setPaintTicks(true);
        difficulty.addChangeListener(this);
        add(difficulty);
        
        close = new JButton("Close");
        add(close);
        
    }


    public void actionPerformed(ActionEvent e) {
        
    }


    public void stateChanged(ChangeEvent e) {
        JSlider obj = (JSlider)e.getSource();
        //number between 1-3 that dictates the dificulty level, 1:Easy-2:Regular-3:Expert
        difficultyLevel = obj.getValue();
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
    
}
