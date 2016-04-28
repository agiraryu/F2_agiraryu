package F2_agiraryu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.Timer;


public class GameEngine {
	GamePanel gp;
	private ArrayList<Enemy> en = new ArrayList<Enemy>();		
	private SpaceShip v;	
	
	private Timer timer;
	
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
		Enemy e = new Enemy(100,50);
		gp.sprites.add(e);
		en.add(e);
	}
	public void start(){
		timer.start();
	}

	private void process(){
		
		generateEnemy();
		gp.updateGameUI();
		
		
	
	}
}