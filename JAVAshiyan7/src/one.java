class Thread_one1 extends Thread{
	private String who;
	public Thread_one1(String str) {
		who=str;
	}
	public void run() {
		for(int i=1;i<20;i=i+2) {
			try {
				sleep(500);
			}catch(InterruptedException e) {}
			System.out.print(i);
		}
	}
}
class Thread_two2 extends Thread{
	private String who;
	public Thread_two2(String str) {
		who=str;
	}
	public void run() {
		for(int i=2;i<=20;i=i+2) {
			try {
				sleep(300);
			}catch(InterruptedException e) {}
			System.out.print(i);
		}
	}
}
public class one {

	public static void main(String[] args) {
		Thread_one1 one=new Thread_one1("Thread_one");
		Thread_two2 two=new Thread_two2("Thread_two");
		one.setDaemon(true);
		one.start();
		two.start();
		System.out.println("主方法main()结束运行");
	}
}