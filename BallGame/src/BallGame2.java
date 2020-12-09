import java.awt.*;
import javax.swing.*;


public class BallGame2 extends JFrame{
	
	Image ball=Toolkit.getDefaultToolkit().getImage("images/ball.png");
	Image desk=Toolkit.getDefaultToolkit().getImage("images/desk.jpg");
	
	double x=100;
	double y=100;
	double degree=3.14/3;
	
	
	public void paint(Graphics g) {
		System.out.println("good good study,day day up");
		
		g.drawImage(desk,0,0,null);
		g.drawImage(ball,(int)x,(int)y,null);
		
		x=x+10*Math.cos(degree);
		y=y+10*Math.sin(degree);
		
		if(y>500-70||y<40+40) {
			degree=-degree;
		}
		if(x<0||x>856-70) {
			degree=3.14-degree;
		}
		
		
		
	}
	
	void launchFrame() {
		setSize(856,500);
		setLocation(50,50);
		setVisible(true);
		while(true) {
			repaint();
			try {
				Thread.sleep(30);
			}catch(Exception e) {
				e.printStackTrace();
			}
			
			
		}
		
		
	}
	
	
	public static void main(String[]args) {
		System.out.println("我是曾驿凯，JAVA虽然很难，但是我不怕！！");
		BallGame2 game=new BallGame2();
		game.launchFrame();
		
	}

}
