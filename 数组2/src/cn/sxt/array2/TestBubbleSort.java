package cn.sxt.array2;

import java.util.Arrays;

public class TestBubbleSort {
	public static void main(String[]arhs) {
		int[] valus= {4,3,6,4,2,1,6,7,8,4,3,9,};
		int m=0;
		for(int j=0;j<valus.length-1;j++) {
			boolean flag=true;
			for(int n=0;n<valus.length-1-j;n++) {
				if(valus[n]>valus[n+1]) {
					m=valus[n];
					valus[n]=valus[n+1];
					valus[n+1]=m;
					flag=false;
				}
				System.out.println(Arrays.toString(valus));
			}
			if(flag==true) {
				System.out.print("½áÊø");
				break;
			}
			System.out.println("==================================================");
		}
	}
	

}
