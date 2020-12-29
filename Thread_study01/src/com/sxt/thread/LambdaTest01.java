package com.sxt.thread;

public class LambdaTest01 {
	//静态内部类
	static class Like2 implements lLike{

		public void lambda() {
			System.out.println("i like 2222222lambda");
		}
	}
	public static void main(String[] args) {
		lLike like=new Like();
		like=new Like2();
		like.lambda();
		class Like3 implements lLike{

			public void lambda() {
				System.out.println("i like 5555lambda");
			}
		}
		like=new Like3();
		like.lambda();
		//匿名内部类
		like=new lLike() {
			public void lambda() {
				System.out.println("i like 333333333lambda");
			}	
		};
		like.lambda();
		like=()->{
			System.out.println("i like 444lambda");
		};
		like.lambda();
		
		
		
	}
	

}
interface lLike{
	void lambda();
}
class Like implements lLike{

	@Override
	public void lambda() {
		System.out.println("i like 111lambda");
		
	}
	
}