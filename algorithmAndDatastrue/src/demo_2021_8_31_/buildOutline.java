package demo_2021_8_31_;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class buildOutline {
	public static void main(String[] args) {
		int[][]arr= {{2,9,10},{3,7,15},{5,12,12},{15,20,10},{19,24,8}};
		List<List<Integer>> buildingOutline = buildingOutline(arr);
//		System.out.println(buildingOutline);
	}
	public static class Node {
		public int x;
		public boolean isAdd;
		public int h;

		public Node(int x, boolean isAdd, int h) {
			this.x = x;
			this.isAdd = isAdd;
			this.h = h;
		}

	}

	public static List<List<Integer>> buildingOutline(int[][] matrix) {
		Node[] nodes = new Node[matrix.length * 2];
		for (int i = 0; i < matrix.length; i++) {
			nodes[i * 2] = new Node(matrix[i][0], true, matrix[i][2]);
			nodes[i * 2 + 1] = new Node(matrix[i][1], false, matrix[i][2]);
		}
		Arrays.sort(nodes, new Comparator<Node>() {
			public int compare(Node o1, Node o2) {
				if (o1.x != o2.x) {
					return o1.x - o2.x;
				}
				if (o1.isAdd != o2.isAdd) {
					return o1.isAdd ? -1 : 1;
				}
				return 0;
			}
		});
		TreeMap<Integer, Integer> mapHeightTimes = new TreeMap<>();
		TreeMap<Integer, Integer> maxHeight = new TreeMap<>();
		for (int i = 0; i < nodes.length; i++) {
			if (nodes[i].isAdd) {
				if (!mapHeightTimes.containsKey(nodes[i].h)) {
					mapHeightTimes.put(nodes[i].h, 1);
				} else {
					mapHeightTimes.put(nodes[i].h, mapHeightTimes.get(nodes[i].h) + 1);
				}
			} else {
				if (mapHeightTimes.get(nodes[i].h) == 1) {
					mapHeightTimes.remove(nodes[i].h);
				} else {
					mapHeightTimes.put(nodes[i].h, mapHeightTimes.get(nodes[i].h) - 1);
				}
			}
			if(mapHeightTimes.isEmpty()) {
				maxHeight.put(nodes[i].x, 0);
			}else {
				maxHeight.put(nodes[i].x,mapHeightTimes.lastKey());
			}
		}
		List<List<Integer>>res=new ArrayList();
		int start=0;
		int preHeight=0;
		for(Map.Entry<Integer, Integer> entry:maxHeight.entrySet()) {
			int curX=entry.getKey();
			int curMaxHeight=entry.getValue();
			System.out.println(curX+" "+curMaxHeight);
			if(preHeight!=curMaxHeight) {
				if(preHeight!=0) {
					res.add(new ArrayList<>(Arrays.asList(start,curX,preHeight)));
				}
				start=curX;
				preHeight=curMaxHeight;
			}
		}
		
		return res;
	}

}
