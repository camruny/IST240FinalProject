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

public class optionsJFrame extends javax.swing.JFrame
{
	optionsJPanel ojp;
	public optionsJFrame ()
	{
		super ("Options");
//------------------------------------------------------
// Create components: JPanel, JButton
    	ojp = new optionsJPanel();
		getContentPane().setLayout(new BorderLayout());
                //Adds the welcome screen
                getContentPane().add(ojp,"Center");
                ojp.setVisible(true);

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize (640, 480);
                setVisible(false); 
	}

}
