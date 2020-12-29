package com.sxt.thread;

//简化线程（用一次）的使用
import java.io.StreamTokenizer;

//创建线程方式二：
//创建Runnable 重写run
//启动：创建实现类对象+Thread对象start
//
public class LambdaThread{
	//静态内部类
	static class Test implements Runnable{
		public void run() {
		for(int i=0;i<20;i++) {
			System.out.println("一边ggg");
		}
	}
	}
	
	public static void main(String[] args) {
		new Thread(new Test()).start();
		//局部内部类
		class Test2 implements Runnable{
			public void run() {
			for(int i=0;i<20;i++) {
				System.out.println("一边cccc");
			    }
		    }
	    }
		new Thread(new Test2()).start();
		//匿名内部类：必须借助父类或者接口实现
		new Thread(new Runnable() {
			public void run() {
				for(int i=0;i<20;i++) {
					System.out.println("一边ddd");
				    }
			    }
		}).start();
		//jdk8 简化 lambda
		new Thread(()-> {
				for(int i=0;i<20;i++) {
					System.out.println("一边cg");
				    }
			    }
		).start();
		
	}

}
