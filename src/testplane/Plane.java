package testplane;

import java.awt.Graphics;
import java.awt.Image;

import util.*;

public class Plane {
//	Image planeImg = GameUtil.getImage("images/plane_01.jpg");
	Image img;
	double x,y;
	
	public void draw(Graphics g){
		g.drawImage(img, 50, 50, null);
	}
	
	public Plane(String imgpath, double x, double y) {
		super();
		this.img = GameUtil.getImage(imgpath);
		this.x = x;
		this.y = y;
	}
	
	public Plane(){
		
	}
	
	
}
