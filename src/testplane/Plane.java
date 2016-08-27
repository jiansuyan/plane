package testplane;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;

import util.*;

public class Plane {
//	Image planeImg = GameUtil.getImage("images/plane_01.jpg");
	Image img;
	double x,y;
	
	boolean left, right, up, down;
	int speed = 10;
	
	public void draw(Graphics g){
		g.drawImage(img, (int)x, (int)y, null);
		move();
	}
	
	public void move(){
		if(left){
			x -= speed;
		}
		if(right){
			x +=speed;
		}
		if(up){
			y -= speed;
		}
		if(down){
			y += speed;
		}
	}
	
	public void addDirection(KeyEvent e){
		switch(e.getKeyCode()){
		case KeyEvent.VK_LEFT:
			left = true;
			break;
		case KeyEvent.VK_RIGHT:
			right = true;
			break;
		case KeyEvent.VK_UP:
			up = true;
			break;
		case KeyEvent.VK_DOWN:
			down = true;
			break;
		default:
			break;
		}
	}
	
	public void minusDirection(KeyEvent e){
		switch(e.getKeyCode()){
		case KeyEvent.VK_LEFT:
			left = false;
			break;
		case KeyEvent.VK_RIGHT:
			right = false;
			break;
		case KeyEvent.VK_UP:
			up = false;
			break;
		case KeyEvent.VK_DOWN:
			down = false;
			break;
		default:
			break;
		}
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