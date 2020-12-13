package cn.sxt.game;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.*;
import javax.swing.JFrame;

//设计窗体

public class MyGameFrame extends Frame {
	public void Paint(Graphics g) {
		g.drawLine(500,500,300,300);
	}
	
	
	
	public void launchFrame() {
		this.setTitle("追梦航天的小飞机");
		this.setVisible(true);
		this.setSize(500,500);
		this.setLocation(110,100);
		
		this.addWindowListener(new WindowAdapter() {
		
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
	}
	public static void main(String[]a) {
		MyGameFrame f=new MyGameFrame();
		f.launchFrame();
	}

}