package demo_2021_8_19_intermediateClass__________;

public class eatGrass {
	public static void main(String[] args) {
		for(int i=0;i<=50;i++) {
			System.out.println(i+"  "+winner1(i)+"    "+winner2(i));
		}
	}

	public static String winner1(int n) {
		if (n < 5) {
			return (n == 0 || n == 2) ? "����" : "����";
		}
		int base = 1;
		while (base <= n) {
			if (winner1(n - base).equals("����")) {
				return "����";
			}
			if (base > n / 4) {
				break;
			}
			base *= 4;
		}
		return "����";
	}
	
	public static String winner2(int n) {
		if(n%5==2||n%5==0) {
			return "����";
		}else {
			return "����";
		}
	}

}
