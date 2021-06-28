package Astart;

import Astart.AstartNode;
import sun.security.util.Debug;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

public class AstartMgr {
//	private static AstartMgr instance=new AstartMgr();
//	private AstartMgr() {
//		
//	}
//	public static AstartMgr getInstance() {
//		return instance;
//	}
	public int mapWidth;
	public int mapHeight;

	private static AstartMgr instance;

	public static AstartMgr getInstance() {
		if (instance == null) {
			instance = new AstartMgr();
		}
		return instance;
	}

	private AstartNode[][] nodes;
	private List<AstartNode> openList;
	private List<AstartNode> closeList;

	public void InitMapInfo(int width, int height) {
		this.mapHeight = height;
		this.mapWidth = width;
		nodes = new AstartNode[width][height];
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; ++j) {
				AstartNode node = new AstartNode(i, j, getRandomBarrier());
				nodes[i][j] = node;
			}
		}
	}

	public E_node getRandomBarrier() {
		return 100 * Math.random() < 20 ? E_node.Wlak : E_node.Stop;
	}

	public List<AstartNode> FindPath(Point startPos, Point endPos) {
		// 1判断两点是否合法
		// (1)是否在范围内
		// (2)是否为阻挡 if 不合法直接return null
		if (startPos.x > this.mapWidth || startPos.y > this.mapHeight || endPos.x > this.mapWidth
				|| endPos.y > mapHeight || startPos.x < 0 || endPos.x < 0 || startPos.y < 0 || endPos.y < 0) {
			System.out.println("坐标error");
			return null;
		}
		AstartNode start = nodes[(int) startPos.x][(int) startPos.y];
		AstartNode end = nodes[(int) endPos.x][(int) endPos.y];
		if (start.type == E_node.Stop || end.type == E_node.Stop) {
			System.out.println("坐标error");
			return null;
		}
		// 因为会多次寻路 所以要把这个清了
		this.closeList.clear();
		this.openList.clear();

		// 应该得到起点和终点 对应的格子
		List<AstartNode> ans = new ArrayList();
		start.father = null;
		start.clearSelf();
		closeList.add(start);

		getSuroundPoint(start);

		// 从起点开始 找周围的点， 并放入开启列表
		/*
		 * 左上 上 右上 左 右 左下 下 右下 判断这些点是否为阻挡和边界 是否在开启和关闭列表中 如果不是则放入开启列表
		 * 
		 */

		// 选出开启列表中 寻路消耗最小的点
		// 放入关闭列表中

		// 如果是终点，等到最终节点 返回

		// 不是终点继续寻路

		return null;
	}

	private void getSuroundPoint(AstartNode start, float g, AstartNode end) {
//		AstartNode leftTop=nodes[(int)start.x-1][(int)start.y-1];
//		AstartNode top=nodes[(int)start.x][(int)start.y-1];
//		AstartNode rightTop=nodes[(int)start.x+1][(int)start.y-1];
//		AstartNode left=nodes[(int)start.x-1][(int)start.y];
//		AstartNode right=nodes[(int)start.x+1][(int)start.y];
//		AstartNode rightDown=nodes[(int)start.x+1][(int)start.y+1];
//		AstartNode leftDown=nodes[(int)start.x-1][(int)start.y+1];
//		AstartNode Down=nodes[(int)start.x][(int)start.y+1];
		AstartNode cur = null;
		for (int x = start.x - 1; x <= start.x + 1; x++) {
			for (int y = start.y - 1; y <= start.y + 1; y++) {
				if (x < 0 || x > this.mapWidth || y < 0 || y > this.mapHeight) {
					continue;
				}
				cur = nodes[x][y];
				if (cur == null || cur.type == E_node.Stop || openList.contains(cur) || closeList.contains(cur)) {
					continue;
				}
				cur.father = start;
				cur.g = start.g + g;
				openList.add(cur);
			}
		}
	}
}
