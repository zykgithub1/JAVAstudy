package cn.sxt.game;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.*;
import java.util.Date;

import javax.swing.JFrame;



public class MyGameFrame extends Frame {
	//导入背景和飞机图片
	Image bg=GameUtil.getImage("images/bg.jpg");
	Image planeImg=GameUtil.getImage("images/plane.png");
	//新建飞机定义炸弹数组；
	Plane plane=new Plane(planeImg,350,250);
	Shell[] shells=new Shell[40];
	//定义爆炸
	Explode bao;
	Date starTime=new Date();
	Date endTime;
	int period;
	@Override//重载paint方法
	public void paint(Graphics g) {
		Color c=g.getColor();
		g.drawImage(bg,0,0,null);
		plane.drawSelf(g);
		//炸弹类，for循环画出炸弹
		for(int i=0;i<shells.length;i++) {
			shells[i].draw(g);
			//矩形碰撞检测
			boolean peng=shells[i].getRect().intersects(plane.getRect());
			if(peng) {
				plane.live=false;
				if(bao==null) {
					bao=new Explode(plane.x,plane.y);
					endTime=new Date();
					period=(int)((endTime.getTime()-starTime.getTime())/1000);
				}
			
				bao.draw(g);
			}//飞机爆炸显示秒数
			if(!plane.live) {
				
				g.setColor(Color.BLUE);
				Font f=new Font("宋体",Font.BOLD,50);
				g.setFont(f);
				g.drawString("时间:"+period+"秒",250,350);
			}
		}
		g.setColor(c);
		
	}//多线程绘画
	class PaintThread extends Thread{
		@Override
		public void run() {
		
			while(true) {
				//System.out.println("窗口被重画ing");
				repaint();
				try {
					Thread.sleep(30);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
		}
	}
	//键盘监听
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
	//主窗口
	public void launchFrame() {
		this.setTitle("追梦航天的小飞机");
		this.setSize(Constant.GAME_WIDTH,Constant.GAME_HEIGHT);
		this.setLocation(110,100);
		this.setVisible(true);
		//关闭窗口
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
	//双缓存
	private Image offScreenImage=null;
	public void update(Graphics g) {
		if(offScreenImage==null)
			offScreenImage=this.createImage(Constant.GAME_HEIGHT,Constant.GAME_WIDTH);
		Graphics gOff=offScreenImage.getGraphics();
		paint(gOff);
		g.drawImage(offScreenImage,0,0,null);
	}
}