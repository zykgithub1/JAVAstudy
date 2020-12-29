package com.sxt.thread;
//加入返回值：

public class LambdaTest03 {

	public static void main(String[] args) {
		lInterst interst=(int a,int c)-> {
			System.out.println("i like lambda++++++++>"+(a+c));
			return a+c;
		};
		interst.lambda(100, 200);
		
		
		
		
		
	}
	

}
interface lInterst{
	int lambda(int a,int b);
}
class Interest implements lInterst{

	@Override
	public int lambda(int a,int c) {
		System.out.println("i like lambda++++++++>"+(a+c));
		return a+c;
	}
	
}