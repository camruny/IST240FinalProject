/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JPanel;
/**
 *
 * @author rspatz
 */
public class introJPanel extends JPanel {

    public introJPanel() {
        super();
setBackground(Color.blue);

setLayout(new BorderLayout());

//Navigation panel that will contain the navigational JButtons
                navigationJPanel nav = new navigationJPanel();
                //Panel to contain artwork for the introduction page
splashscreenJPanel splashscreen = new splashscreenJPanel();
                
                add(nav, "South");
                add(splashscreen, "North");

    }
    
}