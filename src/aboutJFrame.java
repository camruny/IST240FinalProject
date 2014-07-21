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
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class aboutJFrame extends JFrame
{
	aboutJPanel ajp;
	public aboutJFrame ()
	{
		super ("About");
//------------------------------------------------------
// Create components: JPanel, JButton
    	ajp = new aboutJPanel();
		getContentPane().setLayout(new BorderLayout());
                //Adds the welcome screen
                getContentPane().add(ajp,"Center");
                ajp.setVisible(true);

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize (640, 480);
                setVisible(false); 
	}

}
