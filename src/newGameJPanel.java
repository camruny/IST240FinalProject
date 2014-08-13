
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.beans.XMLDecoder;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Timer;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Cameron
 */
public final class newGameJPanel extends JPanel implements ActionListener, KeyListener {

    Timer time = new Timer(5, this);
    Timer countDown = new Timer(1000, this);
    Timer scoreUpdate = new Timer(100, this);
    
    XMLDecoder de;
    
    int shipX=320,shipY=220, velx=0, vely=0;
    int shipSpeed = 1;  //sets the speed that the ship will move
    int missleSpeed = 1;  //sets the speed that the missle will travel
    int difficultyLevel;
    
    
    //sets up the blocks to be shot at
    JButton a1,a2,a3,a4;
    JButton b1,b2,b3,b4;
    JButton c1,c2,c3,c4;
    JButton d1,d2,d3,d4;
    JButton e1,e2,e3,e4;
    //sets the size of the blocks
    int blockSize = 30;
    
    //Components of the countdown timer
    JButton timeDisplay;
    int gameTime = 5;
    
       
    //information for the bullet
    int x1=320;
    int y1=210;
    boolean isbullet;
    
    //Shows the players score
    int score = 0;
    JTextField scoreDisplay;
    
        
    newGameJPanel() {       
        //Starts the timer and adds actionListeners to them
        countDown.start();
        time.start();
        scoreUpdate.start();
        addKeyListener(this);
        setFocusable(true);
        
        //method that gets the saved options from the XML file
        getOptions();
        setDifficulty();
        
        //prevents erratic behavior from various key entrys
        setFocusTraversalKeysEnabled(false);
        setLayout(null);
        
        //Adds the timer button to the game
        timeDisplay = new JButton("Time Remaining: " + gameTime);
        add(timeDisplay);
        timeDisplay.setBounds(new Rectangle(135,10,300,30));
        
        //Resizes the football image based on how big the blocks are
        Image football = new ImageIcon("football.png").getImage().getScaledInstance(blockSize*2, blockSize, java.awt.Image.SCALE_SMOOTH);
        //Converts the image into an icon so that it can be used with the JButtons
        ImageIcon footballIcon = new ImageIcon(football);

        a1 = new JButton(footballIcon);
        a2 = new JButton(footballIcon);
        a3 = new JButton(footballIcon);
        a4 = new JButton(footballIcon);
        b1 = new JButton(footballIcon);
        b2 = new JButton(footballIcon);
        b3 = new JButton(footballIcon);
        b4 = new JButton(footballIcon);
        c1 = new JButton(footballIcon);
        c2 = new JButton(footballIcon);
        c3 = new JButton(footballIcon);
        c4 = new JButton(footballIcon);
        d1 = new JButton(footballIcon);
        d2 = new JButton(footballIcon);
        d3 = new JButton(footballIcon);
        d4 = new JButton(footballIcon);
        e1 = new JButton(footballIcon);
        e2 = new JButton(footballIcon);
        e3 = new JButton(footballIcon);
        e4 = new JButton(footballIcon);
        
        
        
        //x,y,lengh,height
        a1.setBounds(new Rectangle(50,50,blockSize*2,blockSize));
        a2.setBounds(new Rectangle(50,80,blockSize*2,blockSize));
        a3.setBounds(new Rectangle(50,110,blockSize*2,blockSize));
        a4.setBounds(new Rectangle(50,140,blockSize*2,blockSize));
        b1.setBounds(new Rectangle(150,50,blockSize*2,blockSize));
        b2.setBounds(new Rectangle(150,80,blockSize*2,blockSize));
        b3.setBounds(new Rectangle(150,110,blockSize*2,blockSize));
        b4.setBounds(new Rectangle(150,140,blockSize*2,blockSize));
        c1.setBounds(new Rectangle(250,50,blockSize*2,blockSize));
        c2.setBounds(new Rectangle(250,80,blockSize*2,blockSize));
        c3.setBounds(new Rectangle(250,110,blockSize*2,blockSize));
        c4.setBounds(new Rectangle(250,140,blockSize*2,blockSize));
        d1.setBounds(new Rectangle(350,50,blockSize*2,blockSize));
        d2.setBounds(new Rectangle(350,80,blockSize*2,blockSize));
        d3.setBounds(new Rectangle(350,110,blockSize*2,blockSize));
        d4.setBounds(new Rectangle(350,140,blockSize*2,blockSize));
        e1.setBounds(new Rectangle(450,50,blockSize*2,blockSize));
        e2.setBounds(new Rectangle(450,80,blockSize*2,blockSize));
        e3.setBounds(new Rectangle(450,110,blockSize*2,blockSize));
        e4.setBounds(new Rectangle(450,140,blockSize*2,blockSize));
        
        add(a1);    add(a2);    add(a3);    add(a4);
        add(b1);    add(b2);    add(b3);    add(b4); 
        add(c1);    add(c2);    add(c3);    add(c4); 
        add(d1);    add(d2);    add(d3);    add(d4); 
        add(e1);    add(e2);    add(e3);    add(e4); 
        
        //adds the score board to the game
        scoreDisplay = new JTextField();
        scoreDisplay.setBounds(new Rectangle(10,10,100,30));
        add(scoreDisplay);
    }
    
   
   

    public void paintComponent(Graphics g)  {
        super.paintComponent(g);
        g.fillRect (shipX,shipY,20,20);
        if(isbullet) {
            g.fillRect (x1,y1--,3,3);
        } else {
        }
        if(y1<0)
            isbullet=false;
    }
    
    public void bullet(Graphics b)  {
        if(isbullet) {
            b.fillRect (x1,y1--,3,3);
        } else {
        }
        if(y1<0)
            isbullet=false;
   
        
    }
    //gets the options from the XML file that were saved in the options JPanel
    public void getOptions()    {
        try {
              de = new XMLDecoder(new BufferedInputStream(new FileInputStream("options.xml")));
             }
          catch(FileNotFoundException xx) {}
          try {
			 difficultyLevel = (Integer)de.readObject();
			 shipSpeed = (Integer)de.readObject();
                         blockSize = (Integer)de.readObject();
			 
            }
          catch(Exception xx) {}
          try {
             de.close();
            }
          catch(Exception xx) {}
    }
    
    //sets the time of the game based on the difficulty level
    public void setDifficulty() {
        switch (difficultyLevel)    {
            case 1:
                gameTime = 60;
                break;
            case 2:
                gameTime = 30;
                break;
            case 3:
                gameTime = 10;
                break;
                }
    }


    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        
        if(obj == time) {
        repaint();
        shipX += velx;
        shipY += vely;
        
        
        
        //impact sensing for Column 1 of blocks
        if(x1 > 50 && x1 < (50+(blockSize*2)))   {  
            if(y1 == 50)    {if(a1.isVisible()==true)    {a1.setVisible(false); score++; isbullet = false;}} 
            if(y1 == 80)    {if(a2.isVisible()==true)    {a2.setVisible(false); score++; isbullet = false;}}
            if(y1 == 110)   {if(a3.isVisible()==true)    {a3.setVisible(false); score++; isbullet = false;}}
            if(y1 == 140)   {if(a4.isVisible()==true)    {a4.setVisible(false); score++; isbullet = false;}}
        }
        //impact sensing for Column 2 of blocks
        if(x1 > 150 && x1 < (150+(blockSize*2)))   {  
            if(y1 == 50)    {if(b1.isVisible()==true)    {b1.setVisible(false); score++; isbullet = false;}} 
            if(y1 == 80)    {if(b2.isVisible()==true)    {b2.setVisible(false); score++; isbullet = false;}}
            if(y1 == 110)   {if(b3.isVisible()==true)    {b3.setVisible(false); score++; isbullet = false;}}
            if(y1 == 140)   {if(b4.isVisible()==true)    {b4.setVisible(false); score++; isbullet = false;}}
        }
        //impact sensing for Column 3 of blocks
        if(x1 > 250 && x1 < (250+(blockSize*2)))   {  
            if(y1 == 50)    {if(c1.isVisible()==true)    {c1.setVisible(false); score++; isbullet = false;}} 
            if(y1 == 80)    {if(c2.isVisible()==true)    {c2.setVisible(false); score++; isbullet = false;}}
            if(y1 == 110)   {if(c3.isVisible()==true)    {c3.setVisible(false); score++; isbullet = false;}}
            if(y1 == 140)   {if(c4.isVisible()==true)    {c4.setVisible(false); score++; isbullet = false;}}
        }
        //impact sensing for Column 4 of blocks
        if(x1 > 350 && x1 < (350+(blockSize*2)))   {  
            if(y1 == 50)    {if(d1.isVisible()==true)    {d1.setVisible(false); score++; isbullet = false;}} 
            if(y1 == 80)    {if(d2.isVisible()==true)    {d2.setVisible(false); score++; isbullet = false;}}
            if(y1 == 110)   {if(d3.isVisible()==true)    {d3.setVisible(false); score++; isbullet = false;}}
            if(y1 == 140)   {if(d4.isVisible()==true)    {d4.setVisible(false); score++; isbullet = false;}}
        }
        //impact sensing for Column 5 of blocks
        if(x1 > 450 && x1 < (450+(blockSize*2)))   {  
            if(y1 == 50)    {if(e1.isVisible()==true)    {e1.setVisible(false); score++; isbullet = false;}} 
            if(y1 == 80)    {if(e2.isVisible()==true)    {e2.setVisible(false); score++; isbullet = false;}}
            if(y1 == 110)   {if(e3.isVisible()==true)    {e3.setVisible(false); score++; isbullet = false;}}
            if(y1 == 140)   {if(e4.isVisible()==true)    {e4.setVisible(false); score++; isbullet = false;}}
        }
        
        


        }
        
        
        
        if(obj == countDown)    {
            gameTime = gameTime - 1;    //subtracts one every second to countdown the game
            timeDisplay.setText("Time Remaining: " + gameTime);
            if(gameTime == 0)    {
                time.stop();
                countDown.stop();
                timeDisplay.setText("GAME OVER!");
            } 
        } 
        
        if(obj == scoreUpdate)  {
            //updates the score display
            scoreDisplay.setText("Score: " + String.valueOf(score));
        }
    }
    
    public void up()    {
        vely = shipSpeed * -1;
        velx = 0;
    }
    
    public void down()  {
        vely = shipSpeed;
        velx = 0;
    }
    
    public void left()  {
        velx = shipSpeed * -1;
        vely = 0;
    }
    
    public void right() {
        velx = shipSpeed;
        vely = 0;
    }
    
    public void stop()  {
        //stops the ship from moving
        velx = 0;
        vely = 0;
    }


    public void keyTyped(KeyEvent e) {
        
    }


    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_UP) {
            //up();
        }
        if (code == KeyEvent.VK_DOWN) {
            //down();
        }
        if (code == KeyEvent.VK_LEFT) {
            left();
        }
        if (code == KeyEvent.VK_RIGHT) {
            right();
        }
        if (code == KeyEvent.VK_SPACE) {
            
            isbullet=true;
            x1=shipX;
            y1=shipY;
        }
    }


    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        //stops the ship from moving when the arrow key is released
        if (code == KeyEvent.VK_UP) {
            stop();
        }
        if (code == KeyEvent.VK_DOWN) {
            stop();
        }
        if (code == KeyEvent.VK_LEFT) {
            stop();
        }
        if (code == KeyEvent.VK_RIGHT) {
            stop();
        }
    }
}
