
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
public class newGameJFrame extends JFrame {
    newGameJPanel ngjp;
    newGameJFrame() {
        super ("New Game");
//------------------------------------------------------
// Create components: JPanel, JButton
    	ngjp = new newGameJPanel();
	getContentPane().setLayout(new BorderLayout());
        getContentPane().add(ngjp,"North");        
        ngjp.setVisible(true);
        
        Asteroids applet = new Asteroids();
        
        getContentPane().add(applet,"Center");
       
        applet.init();
        applet.start();


        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize (680, 560);
        setVisible(false); 
        
    }

}
