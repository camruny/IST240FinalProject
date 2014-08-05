
import java.beans.XMLDecoder;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Cameron
 */
public class highScoreJPanel extends JPanel {
    JButton close;
    JTextField score1, score2, score3, name1, name2, name3;
    XMLDecoder de;
    
    //vaiable array for saving the scores and their player from the XML file
    int[] score;
    String[] scoreName;
    
    
    highScoreJPanel()   {
        close = new JButton("Close");
        add(close);
        
        score1 = new JTextField("S1");
        add(score1);
        score2 = new JTextField("S2");
        add(score2);
        score3 = new JTextField("S3");
        add(score3);
        
        name1 = new JTextField("N1");
        add(name1);
        name2 = new JTextField("N2");
        add(name2);
        name3 = new JTextField("N3");
        add(name3);  
        
        //allocates the memory for the arrays
        score = new int[10];
        scoreName = new String[10];  
        
        //runs the class to get the last 5 players
        readScores();
        
        //displays the top 5 scores in the program
        name1.setText(scoreName[1]);
        score1.setText(String.valueOf(score[1]));
    
    }
    public void readScores()    {
        try {
              de = new XMLDecoder(new BufferedInputStream(new FileInputStream("scores.xml")));
             }
          catch(Exception xx) {xx.printStackTrace();}
          try {
			 scoreName[1] = (String)de.readObject();
			 score[1] = (Integer)de.readObject();
			 
            }
          catch(Exception xx) {xx.printStackTrace();}
          try {
             de.close();
            }
          catch(Exception xx) {xx.printStackTrace();}
        }
    
    
}
