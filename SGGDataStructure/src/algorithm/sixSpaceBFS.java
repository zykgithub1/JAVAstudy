package algorithm;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class sixSpaceBFS {
	public static int[][] matrix;
	static int vexNum;
	static int edgeNum;
	static boolean[] visited;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		vexNum = sc.nextInt();
		edgeNum = sc.nextInt();
		visited = new boolean[vexNum + 1];
		matrix = new int[vexNum + 1][vexNum + 1];
		for (int i = 0; i < edgeNum; i++) {
			int v1 = sc.nextInt();
			int v2 = sc.nextInt();
			matrix[v1][v2] = 1;
			matrix[v2][v1]=1;
		}
//		for (int[] link : matrix) {
//			for (int i : link) {
//				System.out.print(i + " ");
//			}
//			System.out.println();
//		}
//		System.out.println(vexNum+" "+edgeNum);
		for(int i=1;i<=vexNum;i++) {
			double ans=dfs(i)*1.0/vexNum*100;
			System.out.print(i+": ");
			System.out.printf("%.2f",ans);
			System.out.println("%");
			
		}
	}

	public static int dfs(int index) {
		visited = new boolean[vexNum + 1];
		int tail = 0;
		int level = 0;
		int last=index;
		int count=1;
		Deque<Integer> que = new LinkedList<>();
		que.add(index);
		visited[index] = true;
		while(!que.isEmpty()) {
			int now=que.poll();
			for(int i=1;i<=vexNum;i++) {
				if(matrix[now][i]==1&&visited[i]==false) {
					visited[i]=true;
					que.addLast(i);
					tail=i;
					count++;
				}
			}
			if(now==last) {
				level++;
				last=tail;
			}
			if(level==6) {
				break;
			}
		}
		return count;
	}

}
