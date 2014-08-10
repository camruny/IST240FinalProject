
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
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
    int shipSpeed = 8;  //sets the speed that the ship will move
    int missleSpeed = 3;  //sets the speed that the missle will travel
    
    //sets up the blocks to be shot at
    JButton a1,a2,a3,a4;
    JButton b1,b2,b3,b4;
    JButton c1,c2,c3,c4;
    JButton d1,d2,d3,d4;
    JButton e1,e2,e3,e4;
    int blockSize = 35; //sets the size of the blocks
    
    //Components of the countdown timer
    JButton timeDisplay;
    int gameTime = 60;  //sets the time for the game
    
    
    
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
        timeDisplay.setBounds(new Rectangle(10,10,300,30));
        
        a1 = new JButton();
        a2 = new JButton();
        a3 = new JButton();
        a4 = new JButton();
        b1 = new JButton();
        b2 = new JButton();
        b3 = new JButton();
        b4 = new JButton();
        c1 = new JButton();
        c2 = new JButton();
        c3 = new JButton();
        c4 = new JButton();
        d1 = new JButton();
        d2 = new JButton();
        d3 = new JButton();
        d4 = new JButton();
        e1 = new JButton();
        e2 = new JButton();
        e3 = new JButton();
        e4 = new JButton();
        
        
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
