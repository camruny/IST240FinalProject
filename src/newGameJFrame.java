import java.awt.*;
import javax.swing.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class newGameJFrame extends JFrame
{
	newGameJPanel ngjp;
	public newGameJFrame ()
	{
		super ("New Game");
//------------------------------------------------------
// Create components       
    	ngjp = new newGameJPanel();
//------------------------------------------------------
// Choose a Layout for JFrame and 
// add Jpanel to JFrame according to layout    	
		getContentPane().setLayout(new BorderLayout());
		getContentPane().add(ngjp,"Center");
                getContentPane().add(new ScoreBoard(), BorderLayout.EAST);
//------------------------------------------------------
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize (640, 480);
		setVisible(false);
	}
}
