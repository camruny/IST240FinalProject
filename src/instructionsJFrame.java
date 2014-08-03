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

public class instructionsJFrame extends javax.swing.JFrame
{
	instructionsJPanel injp;
	public instructionsJFrame ()
	{
		super ("Instructions");
//------------------------------------------------------
// Create components: JPanel, JButton
    	injp = new instructionsJPanel();
		getContentPane().setLayout(new BorderLayout());
                getContentPane().add(injp,"Center");
                injp.setVisible(true);

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize (640, 480);
                setVisible(false); 
	}

}
