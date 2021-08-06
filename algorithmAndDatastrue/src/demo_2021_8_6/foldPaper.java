package demo_2021_8_6;

public class foldPaper {
	public static void fold(int n) {
		printProcess(1,n,true);
	}

	private static void printProcess(int i, int n, boolean down) {
		if(i>n) {
			return;
		}
		printProcess(i+1, n, true);
		System.out.println(down?"°¼":"Í¹");
		printProcess(i+1, n, false);
	}

}
