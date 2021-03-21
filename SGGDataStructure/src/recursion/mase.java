package recursion;

public class mase {

	public static void main(String[] args) {
		// ��ά���鴴���Թ���
		int[][] map = new int[8][7];
		// 1��ʾǽ
		for (int i = 0; i < 7; i++) {
			map[0][i] = 1;
			map[7][i] = 1;
		}
		for (int i = 0; i < 8; i++) {
			map[i][0] = 1;
			map[i][6] = 1;
		}
		map[3][1] = 1;
		map[3][2] = 1;
		map[2][3] = 1;
		map[1][3]=1;
		show(map);
		System.out.println(setWay2(map, 1, 1));
		show(map);
	}

	public static void show(int[][] map) {
		for (int[] row : map) {
			for (int i : row) {
				System.out.print(i + " ");
			}
			System.out.println();
		}
	}

	// ʹ�õݹ���ݸ�С����·����
	// Լ��0��ʾû�߹���2��ʾ�����ߣ�3��ʾ���߹��������߲�ͨ
	// �ӣ�1��1������6��5��
	// ���ԣ�������-����-����-���ߣ�����õ��߲�ͨ�ٻ���
	/**
	 * @param map��ʾ��ͼ
	 * @param i��ʾ���
	 * @param j
	 * @return
	 */
	static boolean setWay(int[][] map, int i, int j) {
		if (map[6][5] == 2) {
			return true;
		} else {// ��ǰ0���ʾ��û�߹���
			if (map[i][j] == 0) {
				map[i][j] = 2;// �ٶ��õ������ͨ set 2
				if (setWay(map, i + 1, j)) {
					return true;
				} else if (setWay(map, i, j + 1)) {
					return true;
				} else if (setWay(map, i - 1, j)) {
					return true;
				} else if (setWay(map, i, j - 1)) {
					return true;
				} else {
					map[i][j] = 3;
					return false;
				}
			} else {// ���map[i][j]!=0 ������1��2��3
				return false;
			}
		}
	}

	public static boolean setWay2(int[][] map, int i, int j) {
		if (map[6][5] == 2) {
			return true;
		}else {
			if(map[i][j]==0) {
				map[i][j]=2;
				if(setWay2(map, i+1, j)) {
					return true;
				}else if(setWay2(map, i, j+1)) {
					return true;
				}else if(setWay2(map, i-1, j)) {
					return true;
				}else if(setWay2(map, i, j-1)) {
					return true;
				}else {
					map[i][j]=3;
					return false;
				}
			}else {
				return false;
			}
		}
	}
}
