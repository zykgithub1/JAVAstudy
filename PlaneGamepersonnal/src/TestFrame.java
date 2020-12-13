import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;



public class TestFrame extends Frame{
	Image bg=GameUtil.getImage("images/bg.jpg");
	Image planeImg=GameUtil.getImage("images/plane.png");
	
	Plane plane=new Plane(planeImg,250,250);
	Shell[] shells=new Shell[40];
	
	public void paint(Graphics g) {
				g.drawImage(bg,0,0,null);
				plane.drawSelf(g);
				for(int i=0;i<shells.length;i++){
					shells[i].draw(g);
				}
	
	}
	class PaintThread extends Thread{
		@Override
		public void run() {
			while(true) {
				System.out.println("重画");
				repaint();
				try {
					Thread.sleep(40);
				}  catch(InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
	
	public void launchFrame() {
		this.setTitle("自己独立敲");
		this.setVisible(true);
		this.setSize(500,500);
		this.setLocation(100,100);
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		new PaintThread().start();
	}
	
	public static void main(String[]a) {
		TestFrame f=new TestFrame();
		f.launchFrame();
	}
}


