package PTA.demo6_2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class pointDistance {
	public static void main(String[] args) {
		node[]nodes;
		
		Scanner sc=new Scanner(System.in);
		double N=sc.nextInt();
		nodes=new node[(int)N];
		double a,b;
		for(int i=0;i<nodes.length;i++) {
			a=sc.nextDouble();
			b=sc.nextDouble();
			nodes[i]=new node(a, b);
		}
		double ans[]=creat(nodes);
		Arrays.sort(ans);
		System.out.println((int)ans[ans.length-2]);
		
		
	}
	
	private static double[] creat(node[] nodes) {
		int n=nodes.length;
		int size=(n*n-n)/2;
		double ans[]=new double[size];
		int h=0;
		for(int i=0;i<n;i++) {
			for(int j=i+1;j<n;j++) {
				ans[h++]=getMax(nodes[i], nodes[j]);
			}
		}
		return ans;
	}

	public static double getMax(node a,node b) {
		return Math.max(Math.abs(a.x-b.x), Math.abs(a.y-b.y));
	}

}
class node {
	double x;
	double y;
	public node(double x, double y) {
		super();
		this.x = x;
		this.y = y;
	}
}
