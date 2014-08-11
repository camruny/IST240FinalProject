import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Cameron
 */
public class navigationJPanel extends JPanel implements ActionListener {
    //====adds the buttons to the window====
    JButton newGame;
    JButton options;
    JButton instructions;
    JButton about;
    JButton highScores;

    //====adds the JFrames to the window====
    instructionsJFrame injf = new instructionsJFrame();
    aboutJFrame ajf = new aboutJFrame();
    optionsJFrame ojf = new optionsJFrame();
    OLDnewGameJFrame ngjf = new OLDnewGameJFrame();
    newGameJFrame ngf = new newGameJFrame();

    
    public navigationJPanel() {
        setBackground(Color.black);
        
    
    //====ActionListeners on navigation sub JFrames====
    injf.injp.close.addActionListener(this);
    ojf.ojp.close.addActionListener(this);
    ajf.ajp.close.addActionListener(this);
    ngjf.ngjp.close.addActionListener(this);
        
    //====Options for the Navigational Buttons====
    newGame = new JButton("New Game");  
    add(newGame);
    newGame.addActionListener(this);
    
    
    options = new JButton("Options");
    add(options);
    options.addActionListener(this);
    
    instructions = new JButton("Instructions");
    instructions.addActionListener(this);
    add(instructions);

    about = new JButton("About");
    add(about);
    about.addActionListener(this);
    
    highScores = new JButton("High Scores");
    add(highScores);
    highScores.addActionListener(this);
}

    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        
        //====Opens the JFrames when the navigation buttons are clicked====
        if(obj == instructions)     {injf.setVisible(true);}
        if(obj == options)          {ojf.setVisible(true);}

        if(obj == newGame)          
        {
             // Create a frame
		//OLDnewGameJFrame frame = new OLDnewGameJFrame();

		// Create an instance of the applet
		OLDAsteroids applet = new OLDAsteroids();

		// Add the applet instance to the frame
		//ngjf.getContentPane().add(applet,"Center");

		// Invoke init() and start()
		//applet.init();
		//applet.start();
                //applet.setSize(680,560);

		//ngjf.setVisible(true);
		//ngjf.setDefaultCloseOperation(OLDJFrame.EXIT_ON_CLOSE);
                ngf.setVisible(true);
         
        }
        if(obj == about)            {ajf.setVisible(true);}
        
        //====Closes the JFrames when the user clicks "Close"====
        if(obj == injf.injp.close)  {injf.setVisible(false);}
        if(obj == ojf.ojp.close)    {ojf.setVisible(false);}
        if(obj == ajf.ajp.close)    {ajf.setVisible(false);}
        if(obj == ngjf.ngjp.close)  {ngjf.setVisible(false);}
    }
    
}