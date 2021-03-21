package recursion;

public class mase {

	public static void main(String[] args) {
		// 二维数组创建迷宫：
		int[][] map = new int[8][7];
		// 1表示墙
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

	// 使用递归回溯给小球找路径：
	// 约定0表示没走过，2表示可以走，3表示已走过，但是走不通
	// 从（1，1）到（6，5）
	// 策略：优先下-》右-》上-》走，如果该点走不通再回溯
	/**
	 * @param map表示地图
	 * @param i表示起点
	 * @param j
	 * @return
	 */
	static boolean setWay(int[][] map, int i, int j) {
		if (map[6][5] == 2) {
			return true;
		} else {// 当前0点表示还没走过：
			if (map[i][j] == 0) {
				map[i][j] = 2;// 假定该点可以走通 set 2
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
			} else {// 如果map[i][j]!=0 可能是1，2，3
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
