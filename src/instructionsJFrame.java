
import java.awt.BorderLayout;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Cameron
 */
public class instructionsJFrame extends JFrame {
    instructionsJPanel instruct;
	public instructionsJFrame ()
	{
		super ("PSU Asteroids - Instructions");
//------------------------------------------------------
// Create components: JPanel, JButton
    	instruct = new instructionsJPanel();
		getContentPane().setLayout(new BorderLayout());
		//getContentPane().add(instruct,"Center");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize (640, 480);
                setVisible(false);
	}
    
}
