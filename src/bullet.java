
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

public class bullet extends JPanel implements ActionListener {
    int shipX;
    int shipY;
    int missleSpeed;
    int vely;
    int velx;
    int missleX;
    int missleY;
    
    Timer time = new Timer(5, this);

    bullet(int x, int y, int speed) {
        System.out.println("tt");
        time.start();
        shipX = x;
        shipY = y;
        missleSpeed = speed;
    }
    
    public void up()    {
        vely = missleSpeed * -1;
        velx = 0;
    }
    
    public void paintComponent(Graphics g)  {
        super.paintComponent(g);
        System.out.println("Test");
        g.fillRect (shipX,shipY,40,40);
    }


    public void actionPerformed(ActionEvent e) {
       
        missleX += velx;
        missleY += vely;
        up();
         repaint();
    }
}
