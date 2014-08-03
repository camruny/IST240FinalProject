/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Cameron
 */
import java.awt.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class WelcomeJFrame extends javax.swing.JFrame
{
	introJPanel ijp;
	public WelcomeJFrame ()
	{
		super ("PSU Asteroids");
//------------------------------------------------------
// Create components: JPanel, JButton
    	ijp = new introJPanel();
		getContentPane().setLayout(new BorderLayout());
                //Adds the welcome screen
                getContentPane().add(ijp,"Center");
                ijp.setVisible(true);

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize (640, 480);
                setVisible(true); 
	}

}
