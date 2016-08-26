package testplane;

import java.awt.Graphics;
import java.awt.Image;

import util.*;

public class GamePlaneFrame extends MyFrame {
	Image bg = GameUtil.getImage("images/bg_01.jpg");
	Image plane = GameUtil.getImage("iamges/plane_01.jpg");
			
	public void paint(Graphics g){
		g.drawImage(bg, 0, 0, null);
		g.drawImage(plane, 50, 50, null);
	}
	
	public static void main(String[] args){
		new GamePlaneFrame().launchFrame();
	}
}
