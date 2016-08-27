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
	
	ArrayList bulletlist = new ArrayList(); //����
			
	public void paint(Graphics g){
		g.drawImage(bg, 0, 0, null);
		p.draw(g);
		for(int i = 0; i < bulletlist.size(); i++){
			Bullet b = (Bullet) bulletlist.get(i);
			b.draw(g);
			
			//����� �ɻ�����ײ
			boolean peng = b.getRect().intersects(p.getRect());
			System.out.println("pengpeng");
		}
	}
	
	public static void main(String[] args){
		new GamePlaneFrame().launchFrame();
	}
	
	public void launchFrame(){
		super.launchFrame();
		//���Ӽ��̵ļ���
		addKeyListener(new KeyMonitor());
		
		//�����ӵ�
		for(int i = 0; i <=50; i++){
			Bullet b = new Bullet();
			bulletlist.add(b);
		}
	}
	
	
	// ����Ϊ�ڲ��࣬���Է����ʹ���ⲿ�����ͨ����
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
	
/*	private Image offScreenImage = null; //����˫���弼�������Ļ��˸
	public void update(Graphics g){
		if(offScreenImage == null)
			offScreenImage = this.createImage(Constant.GAME_WIDTH, Constant.GAME_HEIGHT);
		
		Graphics gOff = offScreenImage.getGraphics();
		
		paint(gOff);
		g.drawImage(offScreenImage, 0, 0, null);   
	}  */
}
