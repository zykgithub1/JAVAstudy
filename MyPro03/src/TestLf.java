
public class TestLf {
	public static void main(String[]args) {
		double a=Math.random();//����[0��1�������֣�������1��
		//System.out.println(a);
		//System.out.println((int)(6*Math.random()));
		int i=(int)(6*Math.random()+1);
		System.out.println(i);
		if(i<=3) {
			System.out.println("С");
		}
		else {
			System.out.println("��");
			
		}
		System.out.println("---------------------------------------------");
		//int m=(int)(6*Math.random()+1);
		int n=(int)(6*Math.random()+1);
		int h=(int)(6*Math.random()+1);
		int count=i+n+h;
		System.out.println(count);
		if(count>=15) {
			System.out.println("ţ��");
		}
		if(count>=10&&count<15) {
			System.out.println("����");
		}
		if(count<10) {
			System.out.println("ϴϴ˯��");
		}
	}

}
