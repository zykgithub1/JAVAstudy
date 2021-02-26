package algorithm;

import java.util.Scanner;

public class Fib {
	public static void main(String[] args) {
		while(true) {
			Scanner scanner=new Scanner(System.in);
			int n=scanner.nextInt();
			System.out.println(fib(n));
		}
	}
	public static int fib(int n) {
		int arr[]=new int[10000];
		if(n==1||n==2)
			return 1;
		return helep(arr,n);
	}
	private static int helep(int arr[],int n) {
		if(n==1||n==2)
			return 1;
		if(arr[n]!=0)
			return arr[n];
		arr[n]=helep(arr,n-1)+helep(arr,n-2);
		return arr[n];
		
	}

}
