package cn.sxt.game;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.*;
import javax.swing.JFrame;



public class MyGameFrame extends JFrame {
	
	Image bg=GameUtil.getImage("images/bg.jpg");
	Image plane=GameUtil.getImage("images/plane.png");
	
	int planeX=250,planeY=250;
	
	@Override
	public void paint(Graphics g) {
		
		g.drawImage(bg,0,0,null);
		g.drawImage(plane,planeX,planeY,null);
		planeX++;planeY++;
	}
	class PaintThread extends Thread{
		@Override
		public void run() {
		
			while(true) {
				System.out.println("窗口被重画ing");
				repaint();
				try {
					Thread.sleep(50);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
		}
	}
	
	
	public void launchFrame() {
		this.setTitle("追梦航天的小飞机");
		this.setSize(500,500);
		this.setLocation(110,100);
		this.setVisible(true);
		this.addWindowListener(new WindowAdapter() {
		
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		new PaintThread().start();
		
	}
	public static void main(String[]a) {
		MyGameFrame f=new MyGameFrame();
		f.launchFrame();
	}
}