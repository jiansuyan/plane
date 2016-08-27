package testplane;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import util.*;

public class GamePlaneFrame extends MyFrame {
	Image bg = GameUtil.getImage("images/bg_01.jpg");
	Plane p = new Plane("images/plane_01.jpg", 50, 50);
	
	ArrayList bulletlist = new ArrayList(); //泛型
			
	public void paint(Graphics g){
		g.drawImage(bg, 0, 0, null);
		p.draw(g);
		for(int i = 0; i < bulletlist.size(); i++){
			Bullet b = (Bullet) bulletlist.get(i);
			b.draw(g);
			
			//检测与 飞机的碰撞
			boolean peng = b.getRect().intersects(p.getRect());
			System.out.println("pengpeng");
		}
	}
	
	public static void main(String[] args){
		new GamePlaneFrame().launchFrame();
	}
	
	public void launchFrame(){
		super.launchFrame();
		//增加键盘的监听
		addKeyListener(new KeyMonitor());
		
		//生成子弹
		for(int i = 0; i <=50; i++){
			Bullet b = new Bullet();
			bulletlist.add(b);
		}
	}
	
	
	// 定义为内部类，可以方便的使用外部类的普通属性
	class KeyMonitor extends KeyAdapter{

		@Override
		public void keyPressed(KeyEvent e) {
		//	System.out.println("Press: " + e.getKeyCode());
			p.addDirection(e);
		}

		@Override
		public void keyReleased(KeyEvent e) {
		//	System.out.println("Release: " + e.getKeyCode());
			p.minusDirection(e);
		}
	}
	
/*	private Image offScreenImage = null; //利用双缓冲技术解决屏幕闪烁
	public void update(Graphics g){
		if(offScreenImage == null)
			offScreenImage = this.createImage(Constant.GAME_WIDTH, Constant.GAME_HEIGHT);
		
		Graphics gOff = offScreenImage.getGraphics();
		
		paint(gOff);
		g.drawImage(offScreenImage, 0, 0, null);   
	}  */
}
