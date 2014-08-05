/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.awt.image.*;
import java.util.*;

//Primary class for the game
public class Asteroids extends Applet implements Runnable, KeyListener{
	
	Thread gameloop;
	BufferedImage backbuffer;
	Graphics2D g2d;
	boolean showBounds= false;
	optionsJPanel options;
	 int delay;
	int ASTEROIDS=20;
	asteroid[] ast= new asteroid[ASTEROIDS];
	
	
	int MISSILES=10;
	missile[] missiles= new missile[MISSILES];
	int currentMissiles=0;
	
	
	ship ship= new ship();
	
	
	AffineTransform identity= new AffineTransform();
	
	
	Random rand= new Random();
        int score=0;
	
	
	public void init(){
		
		backbuffer= new BufferedImage(640,480,BufferedImage.TYPE_INT_RGB);
		g2d= backbuffer.createGraphics();
		
		options = new optionsJPanel();
                
                switch (options.speedLevel){
            case 1:
                delay = 1;
            case 2:
                delay = 1;
            case 3:
                delay = 1;
            default:
                    delay = 1;
                                    }
		ship.setX(320);
		ship.setY(240);
		
		
		for(int n=0;n<MISSILES;n++){
			missiles[n]= new missile();
		}
		
		
		for(int n=0;n<ASTEROIDS;n++){
			ast[n]=new asteroid();
			ast[n].setRotationVelocity(rand.nextInt(3)+1);
			ast[n].setX((double)rand.nextInt(600)+20);
			ast[n].setY((double)rand.nextInt(440)+20);
			ast[n].setMoveAngle(rand.nextInt(360));
			double ang= ast[n].getMoveAngle()-90;
			ast[n].setVelX(calcAngleMoveX(ang) * delay);    //Not working but if I can get delay working we can adjust the speed of the game
			ast[n].setVelY(calcAngleMoveY(ang) * delay);
		}
		
		
		addKeyListener(this);
		
	}
	
	
	public void update(Graphics g){
		
		g2d.setTransform(identity);
		
		
		g2d.setPaint(Color.BLACK);
		g2d.fillRect(0, 0, getSize().width, getSize().height);
		
		
		g2d.setColor(Color.WHITE);
                g2d.drawString("Score : "+(20-score),5,55);
	
		
		drawShip();
		drawMissiless();
		drawAsteroids();
	
		
		paint(g);
	}
	
		
		public void drawShip(){
			g2d.setTransform(identity);
			g2d.translate(ship.getX(),ship.getY());
			g2d.rotate(Math.toRadians(ship.getFaceAngle()));
			g2d.setColor(Color.CYAN);
			g2d.fill(ship.getShape());
		}
		
		
		public void drawMissiless(){
			
			for(int n=0;n<MISSILES;n++){
				
				if(missiles[n].isAlive()){
					
					g2d.setTransform(identity);
					g2d.translate(missiles[n].getX(), missiles[n].getY());
					g2d.setColor(Color.RED);
					g2d.draw(missiles[n].getShape());
				}
			}
		}
		
		
		public void drawAsteroids(){
			
			for(int n=0;n<ASTEROIDS;n++){
				
				if(ast[n].isAlive()){
					
					g2d.setTransform(identity);
					g2d.translate(ast[n].getX(), ast[n].getY());
					g2d.rotate(Math.toRadians(ast[n].getMoveAngle()));
					g2d.setColor(Color.DARK_GRAY);
					g2d.fill(ast[n].getShape());
				}	
			}
		}
		
		
		public void paint(Graphics g){
			
			g.drawImage(backbuffer,0,0,this);
		}
		
		
		public void start(){
			
			gameloop= new Thread(this);
			gameloop.start();
		}
		
		
		public void run(){
			
			Thread t=Thread.currentThread();
			
			
			while(t==gameloop){
				try{
					
					gameUpdate();
					
					
					Thread.sleep(20);
				}
				catch(InterruptedException e){
					e.printStackTrace();
				}
				repaint();
			}	
		}
		
		
		public void stop(){
			
			gameloop=null;
		}
		
		
		
		private void gameUpdate(){
			updateShip();
			updateMissiless();
			updateAsteroids();
			checkCollisions();
		}
		
		
		public void updateShip(){
			
			ship.incX(ship.getVelX());
			
			
			if(ship.getX()<-10)
				ship.setX(getSize().width+10);
			else if(ship.getX()>getSize().width + 10)
				ship.setX(-10);
			
			
			ship.incY(ship.getVelY());
			
			
			if(ship.getY()<-10)
				ship.setY(getSize().height+10);
			else if(ship.getY()>getSize().height + 10)
				ship.setY(-10);
				
		}
		
		
		public void updateMissiless(){
                        
			
			for(int n=0;n<MISSILES;n++){
				
				
				if(missiles[n].isAlive()){
					
					
					missiles[n].incX(missiles[n].getVelX());
					
					
					if(missiles[n].getX() <0 || missiles[n].getX()>getSize().width){
						missiles[n].setAlive(false);
					}
					
					
					missiles[n].incY(missiles[n].getVelY());
					
					
					if(missiles[n].getY() <0 || missiles[n].getY()>getSize().height){
						missiles[n].setAlive(false);
					}
					
				}
			}
		}
		
		
		public void updateAsteroids(){
                        score=0;
			
			for(int n=0;n<ASTEROIDS;n++){
				
				
				if(ast[n].isAlive()){
					score++;
					
					ast[n].incX(ast[n].getVelX());
					
					
					if(ast[n].getX()<-20)
						ast[n].setX(getSize().width+20);
					else if (ast[n].getX()>getSize().width+20)
						ast[n].setX(-20);
					
					
					ast[n].incY(ast[n].getVelY());
					
					
					if(ast[n].getY()<-20)
						ast[n].setY(getSize().height+20);
					else if (ast[n].getY()>getSize().height+20)
						ast[n].setY(-20);
					
					
					ast[n].incMoveAngle(ast[n].getRotationVelocity());
					
					
					if(ast[n].getMoveAngle()<0)
						ast[n].setMoveAngle(360-ast[n].getRotationVelocity());
					else if(ast[n].getMoveAngle()<360)
						ast[n].setMoveAngle(ast[n].getRotationVelocity());
				}
			}
		}
		
		
		public void checkCollisions(){
			
			
			for(int m=0;m<ASTEROIDS;m++){
				
				if(ast[m].isAlive()){
					
					
					for(int n=0;n<MISSILES;n++){
						
						
						if(missiles[n].isAlive()){
							
							
							if(ast[m].getBounds().contains(missiles[n].getX()+1,missiles[n].getY()+1)){
								missiles[n].setAlive(false);
								ast[m].setAlive(false);
								continue;
							}
						}
					}
					
					
					if(ast[m].getBounds().intersects(ship.getBounds())){
						ast[m].setAlive(true);
						ship.setX(320);
						ship.setY(240);
						ship.setFaceAngle(0);
						ship.setVelX(0);
						ship.setVelY(0);
						continue;
					}	
				}	
			}
		}
		
		
		
		
		public void keyReleased(KeyEvent k) {}
		public void keyTyped(KeyEvent k) {}
		public void keyPressed(KeyEvent k){
			int keyCode=k.getKeyCode();
			switch(keyCode){
			case KeyEvent.VK_LEFT:
				
				ship.incFaceAngle(-5);
				if(ship.getFaceAngle()<0) ship.setFaceAngle(360-5);
				break;
			case KeyEvent.VK_RIGHT:
				
				ship.incFaceAngle(5);
				if(ship.getFaceAngle()>360) ship.setFaceAngle(5);
				break;
			case KeyEvent.VK_UP:
				ship.setMoveAngle(ship.getFaceAngle()-90);
				ship.incVelX(calcAngleMoveX(ship.getMoveAngle())*0.10);
				ship.incVelY(calcAngleMoveY(ship.getMoveAngle())*0.10);
				break;
                        case KeyEvent.VK_DOWN:
                            ship.setMoveAngle(ship.getFaceAngle()-270);
				ship.incVelX(calcAngleMoveX(ship.getMoveAngle())*0.10);
				ship.incVelY(calcAngleMoveY(ship.getMoveAngle())*0.10);
				break;
			case KeyEvent.VK_CONTROL:
			case KeyEvent.VK_ENTER:
			case KeyEvent.VK_SPACE:
				
				currentMissiles++;
				if(currentMissiles > MISSILES -1) currentMissiles=0;
				missiles[currentMissiles].setAlive(true);
				
				
				missiles[currentMissiles].setX(ship.getX());
				missiles[currentMissiles].setY(ship.getY());
				missiles[currentMissiles].setMoveAngle(ship.getFaceAngle()-90);
				
				
				double angle=missiles[currentMissiles].getMoveAngle();
				double svx=ship.getVelX();
				double svy=ship.getVelY();
				missiles[currentMissiles].setVelX(svx+calcAngleMoveX(angle)*2);
				missiles[currentMissiles].setVelY(svy+calcAngleMoveY(angle)*2);
			}
		}
		
		
		
		
		
		
		public double calcAngleMoveX(double angle){
			return (double)(Math.cos(angle* Math.PI /180));
		}
		
		
		public double calcAngleMoveY(double angle){
			return (double)(Math.sin(angle* Math.PI /180));
		}
		
		
}
