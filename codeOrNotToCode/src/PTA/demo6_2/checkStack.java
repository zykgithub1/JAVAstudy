package PTA.demo6_2;

import java.util.Scanner;

public class checkStack {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		int size=sc.nextInt();
		for(int i=0;i<N;i++) {
			String s=sc.next();
			cheak(s, size);
		}
		
	}
	
	public static void cheak(String str,int size) {
		int count=0;
		for(int i=0;i<str.length();i++) {
			if(str.charAt(i)=='S') {
				count++;
			}else {
				count--;
			}
			if(count<0) {
				System.out.println("NO");
				return;
			}
			if(count>size) {
				System.out.println("NO");
				return;
			}
		}
		if(count==0) {
			System.out.println("YES");
		}else {
			System.out.println("NO");
		}
	}

}
