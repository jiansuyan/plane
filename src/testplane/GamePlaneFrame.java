package testplane;

import java.awt.Graphics;
import java.awt.Image;

import util.*;

public class GamePlaneFrame extends MyFrame {
	Image bg = GameUtil.getImage("images/bg_01.jpg");
	Plane p = new Plane("images/plane_01.jpg", 50, 50);
			
	public void paint(Graphics g){
		g.drawImage(bg, 0, 0, null);
		p.draw(g);
	}
	
	public static void main(String[] args){
		new GamePlaneFrame().launchFrame();
	}
}
