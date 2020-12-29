package com.sxt.thread;
//加入参数：

public class LambdaTest02 {

	public static void main(String[] args) {
		lLove love=(int a)-> {
			System.out.println("i like lambda++++++++>"+a);
		};
		love.lambda(100);
		love=(a)-> {
			System.out.println("i like lambda++++++++>"+a);
		};
		love.lambda(50);
	}
	

}
interface lLove{
	void lambda(int a);
}
class Love implements lLove{

	@Override
	public void lambda(int a) {
		System.out.println("i like lambda++++++++>"+a);
		
	}
	
}