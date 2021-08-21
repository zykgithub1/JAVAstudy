package demo_2021_8_21;

import java.util.HashMap;

public class topKHeapSelf {
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
		private int heapSize;
		private Node[]heap;
		private HashMap<String,Node> strNodeMap;
		private HashMap<Node,Integer> nodeIndexMap;
		public TopKRecord(int K) {
			heap=new Node[K];
			strNodeMap=new HashMap();
			nodeIndexMap=new HashMap();
			heapSize=0;
		}
		
		public void printTopK() {
			System.out.println("TOP-> K");
			for(int i=heapSize-1;i>=0;i--) {
				System.out.println("str -> "+heap[i].str);
				System.out.println("times -> "+heap[i].times);
			}
			
		}

		public void add(String str) {
			Node curNode=null;
			int preIndex=-1;
			if(!strNodeMap.containsKey(str)) {
				curNode=new Node(str,1);
				strNodeMap.put(str, curNode);
				nodeIndexMap.put(curNode, -1);
			}else {
				curNode=strNodeMap.get(str);
				curNode.times++;
				preIndex=nodeIndexMap.get(curNode);
			}
			if(preIndex==-1) {
				if(heapSize==heap.length) {
					if(heap[0].times<curNode.times) {
						nodeIndexMap.put(curNode, 0);
						nodeIndexMap.put(heap[0], -1);
						heap[0]=curNode;
						heapify(0,heapSize);
					}
				}else {
					nodeIndexMap.put(curNode, heapSize);
					heap[heapSize]=curNode;
					heapInsert(heapSize++);
				}
			} else {
				heapify(preIndex, heapSize);
			}
		}

		private void heapInsert(int i) {
			while(heap[i].times<heap[(i-1)/2].times) {
				swap(i,(i-1)/2);
				i=(i-1)/2;
			}
		}

		private void swap(int i, int j) {
			nodeIndexMap.put(heap[i], j);
			nodeIndexMap.put(heap[j], i);
			Node temp=heap[i];
			heap[i]=heap[j];
			heap[j]=temp;
		}

		private void heapify(int i, int size) {
			int left=2*i+1;
			while(left<size) {
				int right=left+1<heapSize&&heap[left+1].times<heap[left].times?left+1:left;
				int small=heap[right].times<heap[i].times?right:i;
				if(small==i) {
					break;
				}
				swap(i, small);
				i=small;
				left=2*i+1;
			}
		}
	}

}
