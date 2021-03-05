package algorithm;
//��ֽ��ӡ���ϵ����ۺ��ǰ�����͹
public class PaperFolding {
	public static void main(String[] args) {
		int N=4;
		printAllFolds(N);
	}

	private static void printAllFolds(int N) {
		printProcess(1,N,true);
	}

	private static void printProcess(int i, int n, boolean down) {
		if(i>n) {
			return;
		}
		printProcess(i+1, n,true);
		System.out.println(down?"��":"͹");
		printProcess(i+1, n, false);
		
	}

}
