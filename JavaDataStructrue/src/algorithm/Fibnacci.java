package algorithm;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Stack;
import java.util.Vector;

public class Fibnacci {
	public static void main(String[] args) {
//		Scanner scanner=new Scanner(System.in);
//		System.out.println(" ‰»ÎN÷µ");
//		int n=scanner.nextInt();
//		long m=fib1(n);
//		//int h=fib2(n);
//		System.out.println(m);
		Stack<Integer> stack=new Stack();
		for(int i=0;i<10;i++) {
			stack.push(i);
		}
//		stack.pop();stack.pop();stack.pop();stack.pop();stack.add(9);
//		Iterator it=stack.iterator();
//		while(it.hasNext()) {
//			System.out.print(it.next()+" ");
//		}
		Vector<Integer>vc=new Vector<>();
		System.out.println(vc.capacity()+"  "+vc.size());
		for(int i=0;i<100;i++) {
			vc.add(i, i);
			//System.out.println(vc.capacity()+"  "+vc.size()+"  "+vc.indexOf(i));
		}
		Enumeration e= vc.elements();
//		vc(100,0);
//		for(int i=0;i<vc.size();i++) {
//			int h=vc.get(i);
//			System.out.println(h);
//		}
		
	}
	
	public static long fib1(int n) {
		int arr[]=new int[100000];
		arr[1]=arr[2]=1;
		for(int i=3;i<=n;i++) {
			arr[i]=arr[i-1]+arr[i-2];
		}
		return arr[n];
		
		//1 1 2 3 5 8
	}

}
