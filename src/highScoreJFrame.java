

import java.awt.BorderLayout;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Cameron
 */
public class highScoreJFrame extends JFrame {
    highScoreJPanel hsjp;
    highScoreJFrame() {
        super ("High Scores");
//------------------------------------------------------
// Create components: JPanel, JButton
    	hsjp = new highScoreJPanel();
	getContentPane().setLayout(new BorderLayout());
        getContentPane().add(hsjp);        
        hsjp.setVisible(true);
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize (680, 560);
        setVisible(false); 
        
    }

}








