package algorithm;

public class olaSendMessages {
	public static void main(String[] args) {
		int result=func(4);
		System.out.println(result);
	}
	public static int func(int m) {
		if(m==1)
			return 0;
		else if(m==2) {
			return 1;
		}
		else if(m==3) {
			return 2;
		}
		else {
			return (m-1)*(func(m-1)+func(m-2));
		}
		
	}
	

}
