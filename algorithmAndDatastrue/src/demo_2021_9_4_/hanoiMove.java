package demo_2021_9_4_;

public class hanoiMove {
	public static void main(String[] args) {
		int[]arr= {3,2,1};
		System.out.println(step1(arr));
	}
	public static int step1(int[]arr) {
		if(arr==null||arr.length==0) {
			return -1;
		}
		return process(arr,arr.length-1,1,2,3);
		
	}
	/*
	 * Ŀ���ǰ�0-i��Բ�̣���fromȫ��Ų��to��
	 * ���أ�arr�е�״̬arr[0-i],�������Ž�ĵڼ���
	 */
	private static int process(int[] arr, int i, int from, int other, int to) {
		if(i==-1) {
			return 0;
		}
		if(arr[i]!=from&&arr[i]!=to) {
			return -1;
		}
		if(arr[i]==from) {
			return process(arr, i-1, from, to, other);
		}else {
			int rest=process(arr, i-1, other, from, to);
			if(rest==-1) {
				return -1;
			}
			return (1<<i)+rest;
		}
	}

}
