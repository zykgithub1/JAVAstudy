package cn.sxt.oo2;

public class TestOverriide {
	public static void main(String[]a) {
		Horse h=new Horse();
		h.run();
	}

}
class Vehicle{
	public void run() {
		System.out.println("runnrunnrunn");
	}
	public void stop() {
		System.out.println("STOPSTOP");
	}
}
class Horse extends Vehicle{
	public void run() {
		System.out.println("²ßÂí±¼ÌÚ");
	}
	
}