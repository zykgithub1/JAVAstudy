package JAVAFX;

public class Test01 {
	public static void main(String[] args) {
		Thread_one one=new Thread_one();
		Thread_two two=new Thread_two();
		one.start();
		two.start();
		
		
	}

}
class Thread_one extends Thread{
	public void run() {
		for(int i=1;i<=19;i++) {
			if((i%2)!=0) {
				System.out.print(i+"\t");
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
class Thread_two extends Thread{
	public void run() {
		for(int i=2;i<=20;i++) {
			if((i%2)==0) {
				System.out.print(i+"\t");
				try {
					Thread.sleep(300);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}