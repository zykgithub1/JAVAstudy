import java.awt.Color;
import java.awt.Graphics;

public class Shell extends GameObject{
	double degree;
	
	
	public Shell() {
		x=10;
		y=10;
		width=10;
		height=5;
		degree=Math.random()*Math.PI;
		speed=5;
	}
	public void draw(Graphics g) {
		Color c=g.getColor();
		g.setColor(Color.YELLOW);
		g.fillOval((int)x,(int)y,width,height);
		x+=speed*Math.cos(degree);
		y+=speed*Math.sin(degree);
		
	}

}
