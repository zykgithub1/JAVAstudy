
public class TestLf {
	public static void main(String[]args) {
		double a=Math.random();//返回[0，1）的数字，不包括1；
		//System.out.println(a);
		//System.out.println((int)(6*Math.random()));
		int i=(int)(6*Math.random()+1);
		System.out.println(i);
		if(i<=3) {
			System.out.println("小");
		}
		else {
			System.out.println("大");
			
		}
		System.out.println("---------------------------------------------");
		//int m=(int)(6*Math.random()+1);
		int n=(int)(6*Math.random()+1);
		int h=(int)(6*Math.random()+1);
		int count=i+n+h;
		System.out.println(count);
		if(count>=15) {
			System.out.println("牛逼");
		}
		if(count>=10&&count<15) {
			System.out.println("还行");
		}
		if(count<10) {
			System.out.println("洗洗睡吧");
		}
	}

}
