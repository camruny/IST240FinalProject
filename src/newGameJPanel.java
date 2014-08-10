
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
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
public class newGameJPanel extends JPanel implements ActionListener, KeyListener {
    
    Timer time = new Timer(5, this);
    Timer countDown = new Timer(1000, this);
    
    int shipX=320,shipY=220, velx=0, vely=0;
    int shipSpeed = 1;  //sets the speed that the ship will move
    int missleSpeed = 3;  //sets the speed that the missle will travel
    
    //sets up the blocks to be shot at
    JButton a1,a2,a3,a4;
    JButton b1,b2,b3,b4;
    JButton c1,c2,c3,c4;
    JButton d1,d2,d3,d4;
    JButton e1,e2,e3,e4;
    int blockSize = 30; //sets the size of the blocks
    
    //Components of the countdown timer
    JButton timeDisplay;
    int gameTime = 5;
    
    
    newGameJPanel() {
        countDown.start();
        time.start();
        addKeyListener(this);
        setFocusable(true);
        //prevents erratic behavior from various key entrys
        setFocusTraversalKeysEnabled(false);
        setLayout(null);
        
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
        
    }
    
    public void paintComponent(Graphics g)  {
        super.paintComponent(g);
        g.fillRect (shipX,shipY,20,20);
    }


    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        
        if(obj == time) {
        repaint();
        shipX += velx;
        shipY += vely;
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
            bullet b = new bullet(shipX, shipY, missleSpeed);
            
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
