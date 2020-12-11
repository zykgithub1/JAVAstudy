import java.math.*;
class Point{
	double x,y;
	public Point(double x,double y) {
		this.x=x;
		this.y=y;
	}
	
	public double getDistance(Point p) {
		return Math.sqrt((x-p.x)*(x-p.x)+(y-p.y)*(y-p.y));
	}	
}
public class TestConstructor {
	public static void main(String[]a) {
		Point p=new Point(4.0,5.0);
		Point origin=new Point(7.0,9.0);
		System.out.println(p.getDistance(origin));
	}

}
