package demo_2021_8_30_;

public class Joseph {
	/*
	 * һ��i���ڵ㣬����m��ɱ�ˣ����ջ������Ľڵ㣬����������i���ڵ�ʱ�ı�� ��
	 */
	public static int getAlive(int i, int m) {
		if (i == 1) {
			return 1;
		}
		return (getAlive(i - 1, m) + m - 1) % i + 1;
	}

	public static void main(String[] args) {
		System.out.println(getAlive(8781, 9));
	}
	/*
	 * 0-n-1����ΧһȦ������ѭ��ȡ��arr�е�����
	 * ɱn-1�֣�����������õ���
	 */
	public static int getJob(int n, int arr[]) {
		return no(n, arr, 0);
	}

	private static int no(int i, int[] arr, int index) {
		if (i == 1) {
			return 1;
		}
		// ��=����+m-1��%i+1
		return (no(i - 1, arr, nextIndex(arr.length, index)) + arr[index] - 1) % i + 1;
	}

	public static int nextIndex(int size, int index) {
		return index == size - 1 ? 0 : size + 1;
	}

}
