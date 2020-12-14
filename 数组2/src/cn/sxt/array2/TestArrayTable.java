package cn.sxt.array2;

import java.util.Arrays;

public class TestArrayTable {
	public static void main(String[]a) {
		Object[] a1= {1000,"增yuki啊",24,"学生","1996910101"};
		Object[] a2= {1000,"增yuki啊",24,"学生","1996910101"};
		Object[] a3= {1000,"增yuki啊",24,"学生","1996910101"};
		Object[][] table=new Object[3][];
		table[0]=a1;
		table[1]=a2;
		table[2]=a3;
		for(Object[] aa:table) {
			System.out.println(Arrays.toString(aa));
		}
		
	}

}
