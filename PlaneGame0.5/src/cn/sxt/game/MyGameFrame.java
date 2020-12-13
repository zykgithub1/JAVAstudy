package cn.sxt.game;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.*;
import javax.swing.JFrame;



public class MyGameFrame extends Frame {
	
	Image bg=GameUtil.getImage("images/bg.jpg");
	Image planeImg=GameUtil.getImage("images/plane.png");
	
	Plane plane=new Plane(planeImg,250,250);
	Shell[] shells=new Shell[40];
	
	
	@Override
	public void paint(Graphics g) {
		
		g.drawImage(bg,0,0,null);
		plane.drawSelf(g);
		for(int i=0;i<shells.length;i++) {
			shells[i].draw(g);
			boolean peng=shells[i].getRect().intersects(plane.getRect());
			if(peng) {
				plane.live=false;
			}
		}
		
	}
	class PaintThread extends Thread{
		@Override
		public void run() {
		
			while(true) {
				//System.out.println("窗口被重画ing");
				repaint();
				try {
					Thread.sleep(50);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
		}
	}
	class KeyMonitor extends KeyAdapter{

		@Override
		public void keyPressed(KeyEvent e) {
			plane.addDirection(e);;
			
		}

		@Override
		public void keyReleased(KeyEvent e) {
			plane.minusDirection(e);
		}
		
	}
	
	public void launchFrame() {
		this.setTitle("追梦航天的小飞机");
		this.setSize(Constant.GAME_WIDTH,Constant.GAME_HEIGHT);
		this.setLocation(110,100);
		this.setVisible(true);
		this.addWindowListener(new WindowAdapter() {
		
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		new PaintThread().start();
		addKeyListener(new KeyMonitor());
		
		for(int i=0;i<shells.length;i++) {
			shells[i]=new Shell();
		}
		
		
		
	}
	public static void main(String[]a) {
		MyGameFrame f=new MyGameFrame();
		f.launchFrame();
	}
	private Image offScreenImage=null;
	public void update(Graphics g) {
		if(offScreenImage==null)
			offScreenImage=this.createImage(Constant.GAME_HEIGHT,Constant.GAME_WIDTH);
		Graphics gOff=offScreenImage.getGraphics();
		paint(gOff);
		g.drawImage(offScreenImage,0,0,null);
	}
}