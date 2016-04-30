package F2_agiraryu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.Timer;


public class GameEngine implements KeyListener{ 
	GamePanel gp;
	private ArrayList<Enemy> en = new ArrayList<Enemy>();		
	private SpaceShip v;	
	
	private Timer timer;
	private double diff = 0.1;
	
	public GameEngine(GamePanel gp, SpaceShip v) {
		this.gp = gp;
		this.v = v;		
		
		gp.sprites.add(v);
		
		timer = new Timer(50, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				process();
			}
		});
		timer.setRepeats(true);
		
	}
	
	private void generateEnemy(){
		Enemy e = new Enemy((int)(Math.random()*390),50);
		gp.sprites.add(e);
		en.add(e);
	}

	public void start(){
		timer.start();
	}

	private void process(){
		
 		if(Math.random() < diff){
 			generateEnemy();	
 		}
 		Iterator<Enemy> e_iter = en.iterator();
		while(e_iter.hasNext()){
			Enemy e = e_iter.next();
			e.proceed();
			
			if(!e.isAlive()){
				e_iter.remove();
				gp.sprites.remove(e);
			}
		}
		
		gp.updateGameUI();
		
	}
	void controlVehicle(KeyEvent e) {
 		switch (e.getKeyCode()) {
 		case KeyEvent.VK_LEFT:
 			v.move(-1);
 			break;
 		case KeyEvent.VK_RIGHT:
 			v.move(1);
 			break;
 		case KeyEvent.VK_D:
 			diff += 0.1;
 			break;
 		}
 	}
 
 	
 	
 	@Override
 	public void keyPressed(KeyEvent e) {
 		controlVehicle(e);
	}
 
 	@Override
 	public void keyReleased(KeyEvent e) {
 		//do nothing
 	}
 
 	@Override
 	public void keyTyped(KeyEvent e) {
 		//do nothing		
 	}
 
}