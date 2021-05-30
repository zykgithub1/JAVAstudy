package PTA2021_5_30;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class sixDegressSpace {
	private static int verTex;
	private static int edgeNum;
	static int[][]matrix=new int[1002][1002];
	static Queue<Integer>que=new LinkedList();
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		verTex=sc.nextInt();
		edgeNum=sc.nextInt();
		for(int i=0;i<edgeNum;i++) {
			int v1=sc.nextInt();
			int v2=sc.nextInt();
			matrix[v1][v2]=1;
			matrix[v2][v1]=1;
		}
		
	}
	public static int dfs(int index) {
		boolean[] visited=new boolean[1002];
		visited[index]=true;
		que.add(index);
		int count=1;
		while(!que.isEmpty()) {
			for(int i=0;i<6;i++) {
				int size=que.size();
				for(int j=1;j<=size;j++) {
					int now=que.poll();
					for(int k=1;k<=verTex;k++) {
						if(!visited[k]&&matrix[now][k]==1) {
							visited[k]=true;
							count++;
						}
					}
				}
			}
		}
		return count;
		
		
	}

}
