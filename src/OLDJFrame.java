/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author rspatz
 */
import java.awt.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class OLDJFrame extends javax.swing.JFrame
{
introJPanel ijp;
public OLDJFrame ()
{
super ("PSU Asteroids");
//------------------------------------------------------
// Create components: JPanel, JButton
     ijp = new introJPanel();
getContentPane().setLayout(new BorderLayout());
getContentPane().add(ijp,"Center");
setDefaultCloseOperation(EXIT_ON_CLOSE);
setSize (640, 480);
                setVisible(true);
}

}
