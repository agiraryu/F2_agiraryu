package F2_agiraryu;

import javax.swing.*;
import java.awt.*;
import java.awt.image.*;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import java.io.*;
import java.io.File;

import javax.swing.JPanel;

public class GamePanel extends JPanel {
	private Image image01;
	private BufferedImage bi;	
	Graphics2D big;
	ArrayList<Sprite> sprites = new ArrayList<Sprite>();

	public GamePanel() {
		//image01 = new ImageIcon(getClass().getResource("star_twinkle.jpg"));
		bi = new BufferedImage(400, 600, BufferedImage.TYPE_INT_ARGB);
		big = (Graphics2D) bi.getGraphics();
		try{
 			File file = new File ("star_twinkle.jpg");
 			image01 = ImageIO.read(file);
 		}
		catch(IOException e){
 			e.printStackTrace();
 		}
	}

public void updateGameUI(GameReporter reporter){
		big.clearRect(0, 0, 400, 600);
		big.drawImage(image01, 0, 0, null);
		big.setColor(Color.WHITE);
		big.drawString(String.format("%08d", reporter.getScore()), 300, 20);
		for(Sprite s : sprites){
			s.draw(big);
		}
		repaint();
	}
	

	@Override
	public void paint(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.drawImage(bi, null, 0, 0);
	}

}
