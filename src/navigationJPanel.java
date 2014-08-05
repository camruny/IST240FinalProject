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
    newGameJFrame ngjf = new newGameJFrame();
    highScoreJFrame hsjf = new highScoreJFrame();
    
    public navigationJPanel() {
        
    
    //====ActionListeners on navigation sub JFrames====
    injf.injp.close.addActionListener(this);
    ojf.ojp.close.addActionListener(this);
    ajf.ajp.close.addActionListener(this);
    ngjf.ngjp.close.addActionListener(this);
    hsjf.hsjp.close.addActionListener(this);
        
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
        if(obj == highScores)       {hsjf.setVisible(true);}
        if(obj == newGame)          
        {
             // Create a frame
		//newGameJFrame frame = new newGameJFrame();

		// Create an instance of the applet
		Asteroids applet = new Asteroids();

		// Add the applet instance to the frame
		ngjf.getContentPane().add(applet,"Center");

		// Invoke init() and start()
		applet.init();
		applet.start();

		// Display the frame
		//ngjf.setSize(700,300);

		//frame.pack();
		ngjf.setVisible(true);
		ngjf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                 /**/
            //ngjf.setVisible(true);
        }
        if(obj == about)            {ajf.setVisible(true);}
        
        //====Closes the JFrames when the user clicks "Close"====
        if(obj == injf.injp.close)  {injf.setVisible(false);}
        if(obj == ojf.ojp.close)    {ojf.setVisible(false);}
        if(obj == ajf.ajp.close)    {ajf.setVisible(false);}
        if(obj == ngjf.ngjp.close)  {ngjf.setVisible(false);}
        if(obj == hsjf.hsjp.close)  {hsjf.setVisible(false);}
    }
    
}