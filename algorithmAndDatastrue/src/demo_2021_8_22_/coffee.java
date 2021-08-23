package demo_2021_8_22_;

import java.util.Comparator;
import java.util.PriorityQueue;

public class coffee {
	public static void main(String[] args) {
		int[]arr= {2,3,7};
		System.out.println(minTimes(arr, 5, 5, 15));
	}
	
	public static class CoffeeNode{
		public int start;
		public int cost;
		
		public CoffeeNode(int start, int cost) {
			this.start = start;
			this.cost = cost;
		}
		
	}
	//n-> people size
	public static int minTimes(int[]arr,int n,int a,int b) {
		PriorityQueue<CoffeeNode>heap=new PriorityQueue<CoffeeNode>(new Comparator<>() {
			public int compare(CoffeeNode a,CoffeeNode b) {
				return (a.cost+a.start)-(b.cost+b.start);
			}
		});
		for(int i=0;i<arr.length;i++) {
			heap.add(new CoffeeNode(0,arr[i]));
		}
		int[]drinks=new int[n];
		for(int i=0;i<n;i++) {
			CoffeeNode cur=heap.poll();
			cur.start+=cur.cost;
			drinks[i]=cur.start;
			heap.add(cur);
		}
		return process(drinks, a, b, 0, 0);
	}

	public static int process(int[] drinks, int a, int b, int index, int washLine) {
		if (index == drinks.length - 1) {
			return Math.min(Math.max(washLine, drinks[index]) + a, drinks[index] + b);
		}
		// washLine是当前还要排多久队才能去洗，
		int wash = Math.max(washLine, drinks[index]) + a;
		//当前杯子决定去洗
		int next1 = process(drinks, a, b, index + 1, wash);
		int p1 = Math.max(wash, next1);
		// 决定当前杯子挥发
		int dry = drinks[index] + b;
		int next2 = process(drinks, a, b, index + 1, washLine);
		int p2 = Math.max(dry, next2);
		return Math.min(p1, p2);
	}

}
