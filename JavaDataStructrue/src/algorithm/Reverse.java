package algorithm;

import java.util.Iterator;
import java.util.Stack;

public class Reverse {
	public static void main(String[] args) {
		int m=12345678;
		System.out.println(revers(m));
	}
	
	public static int revers(int m) {
		if(m>0) {
			int i=0;int count=0;int result=0;
			while(m>0) {
				int tmp=m%10;
				result=result*10+tmp;
				m/=10;
			}
			return result;
		}
		else {
			m=m*-1;
			int i=0;int count=0;int result=0;
			while(m>0) {
				int tmp=m%10;
				result=result*10+tmp;
				m/=10;
			}
			return result*-1;
		}
	}

}
