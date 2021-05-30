package PTA2021_5_30;

import java.util.Scanner;

public class amazyFruit {
	static int []dp;
	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		while(n!=0) {
			int k=sc.nextInt();
			if(k==1||k==2||k==3) {
				System.out.println(-1);
				continue;
			}
			System.out.println(k/2);
		}
	}
}
