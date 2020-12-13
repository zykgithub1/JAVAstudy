package cn.sxt.game;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.*;
import javax.swing.JFrame;



public class MyGameFrame extends JFrame {
	
	Image ball=GameUtil.getImage("images/ball.png");
	
	@Override
	public void paint(Graphics g) {
		Color c=g.getColor();
		Font f=g.getFont();
		g.setColor(Color.BLUE);
		
		g.drawLine(100,100,300,300);
		g.drawRect(100, 100, 300, 300);
		g.drawLine(400,100,100,400);
		g.drawRect(200, 200, 100, 100);
		g.drawOval(100, 100, 300, 300);
		g.fillRect(100, 100, 40, 40);
		g.fillRect(360, 360, 40, 40);
		g.setFont(new Font("ËÎÌå",Font.BOLD,50));
		g.drawString("JAVAÅ£±Æ", 100, 250);
		g.drawImage(ball,250,250,null);
		
		
		g.setColor(c);
		g.setFont(f);
	}
	
	
	
	public void launchFrame() {
		this.setTitle("JAVAÐ¡»­°å");
		this.setSize(500,500);
		this.setLocation(110,100);
		this.setVisible(true);
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