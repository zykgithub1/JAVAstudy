package algorithm;

public class hanoi {
	static int count=0;
	public static void main(String[] args) {
		hanoi('x', 'y', 'z', 9);
		System.out.println(count);
		
		
	}
	
	public static void hanoi(char x,char y,char z,int n) {
		count++;
		if(n==1) {
			move(x,z);
		}else {
			hanoi(x,z,y,n-1);
			move(x,z);
			hanoi(y,x,z,n-1);
		}
		
	}

	private static void move(char c, char d) {
		System.out.println(c+"->"+d);
		
	}

}
