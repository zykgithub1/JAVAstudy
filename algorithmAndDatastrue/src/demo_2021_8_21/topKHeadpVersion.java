package demo_2021_8_21;

import java.util.HashMap;

public class topKHeadpVersion {
	public static void main(String[] args) {
		TopKRecord tp = new TopKRecord(3);
		tp.add("abc");
		tp.add("abc");
		tp.add("bcd");
		tp.add("bcd");
		tp.add("efg");
		tp.add("efg");
		tp.add("efg");
		tp.add("efg");
		tp.add("aaa");
		tp.add("aaa");
		tp.add("aaa");
		tp.add("aaa");
		tp.printTopK();
	}

	public static class Node {
		public String str;
		public int times;

		public Node(String str, int times) {
			this.str = str;
			this.times = times;
		}
	}

	public static class TopKRecord {
		public Node[] heap;
		public int heapSize;
		private HashMap<String, Node> strNodeMap;
		public HashMap<Node, Integer> nodeIndexMap;

		public TopKRecord(int size) {
			heap = new Node[size];
			heapSize = 0;
			strNodeMap = new HashMap();
			nodeIndexMap = new HashMap();
		}

		public void add(String str) {
			Node curNode = null;
			int preIndex = -1;
			if (!strNodeMap.containsKey(str)) {
				curNode = new Node(str, 1);
				strNodeMap.put(str, curNode);
				nodeIndexMap.put(curNode, -1);
			} else {
				curNode = strNodeMap.get(str);
				curNode.times++;
				preIndex = nodeIndexMap.get(curNode);
			}
			if (preIndex == -1) {
				if (heapSize == heap.length) {
					if (heap[0].times < curNode.times) {
						nodeIndexMap.put(heap[0], -1);
						nodeIndexMap.put(curNode, 0); // 新Node 替换原始的堆顶
						heap[0] = curNode;
						heapify(0, heapSize);
					}
				} else {
					nodeIndexMap.put(curNode, heapSize);
					heap[heapSize] = curNode;
					heapInsert(heapSize++);
				}
			} else {
				heapify(preIndex, heapSize);
			}
		}

		private void heapInsert(int cur) {
			while (heap[cur].times < heap[(cur - 1) / 2].times) {
				swap(cur, (cur - 1) / 2);
				cur = (cur - 1) / 2;
			}
		}

		private void heapify(int start, int size) {
			int left = 2 * start + 1;
			while (left < size) {
				int large = left + 1 < size && heap[left + 1].times < heap[left].times ? left + 1 : left;
				large = heap[large].times < heap[start].times ? large : start;
				if (large == start) {
					break;
				}
				swap(start, large);
				start = large;
				left = 2 * start + 1;
			}

		}

		private void swap(int i, int j) {
			// !!!!!!!!!!! 下标表也要交换
			nodeIndexMap.put(heap[i], j);
			nodeIndexMap.put(heap[j], i);
			Node cur = heap[i];
			heap[i] = heap[j];
			heap[j] = cur;
		}

		public void printTopK() {
			System.out.println("TOP:");
			for (int i = heap.length - 1; i >= 0; i--) {
				System.out.println("Str: " + heap[i].str);
				System.out.println("Times: ->" + heap[i].times);
			}
		}
	}

}
