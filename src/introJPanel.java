/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.awt.BorderLayout;
import java.awt.Color;
import java.beans.XMLEncoder;
import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import javax.swing.JPanel;
/**
 *
 * @author rspatz
 */

public class introJPanel extends JPanel {
    XMLEncoder xe;

    public introJPanel() {
        super();
        
        XMLSetup();
        
        setBackground(Color.black);

        setLayout(new BorderLayout());

        //Navigation panel that will contain the navigational JButtons
        navigationJPanel nav = new navigationJPanel();
        //Panel to contain artwork for the introduction page
        splashscreenJPanel splashscreen = new splashscreenJPanel();
                
        add(nav, "South");
        add(splashscreen, "North");
}
    
     public void XMLSetup()   {
     //prevents the options in the XML file from being set to 0 on launch and causing a crash
        try {
            xe = new XMLEncoder(new BufferedOutputStream(new FileOutputStream("options.xml")));
            }
            catch(FileNotFoundException xx) {}

            try {
			 xe.writeObject(1);
			 xe.writeObject(1);
                         xe.writeObject(20);
            }
            catch(Exception xx) {xx.printStackTrace();}

            try {
             xe.close();
            }
            catch(Exception xx) {xx.printStackTrace();}
     	 }
}