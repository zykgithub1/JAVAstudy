package com.sxt.cooperation;

import java.lang.reflect.Constructor;

//生产者消费者模型，实现方式1：管程法
//借助容器
public class CoTest01 {
	public static void main(String[] args) {
		SynContainer1 container=new SynContainer1();
		new Productor1(container).start();
		new Consumer1(container).start();
	}

}
//生产者
class Productor1 extends Thread{
	SynContainer1 container;	
	public Productor1(SynContainer1 container) {
		this.container = container;
	}

	@Override//开始生产
	public void run() {
		for(int i=0;i<100;i++) {
			System.out.println("生产第----》"+i+"个馒头");
			container.push(new Steamedbun1(i));
		}
		
		
	}
}
//消费者
class Consumer1 extends Thread{
	SynContainer1 container;	
	public Consumer1(SynContainer1 container) {
		this.container = container;
	}
	@Override//开始消费
	public void run() {
		for(int i=0;i<100;i++) {
			System.out.println("消费第---》"+container.pop().id+"个馒头");
		}
		
	}
}
//缓冲区
class SynContainer1{
	Steamedbun1[] buns=new Steamedbun1[10];
	int count=0;
	//存储生产
	public synchronized void push(Steamedbun1 bun) {
		//何时可以生产  容器存在空间时：
		
		//不能生产
		if(count==buns.length) {
			try {
				this.wait();//线程阻塞，消费者通知生产  而后解除
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		//存在空间可以生产：
		buns[count]=bun;
		count++;
	}
	//获取 消费
	public synchronized Steamedbun1 pop(){
		//何时能消费：容器中是否存在数据
		//没有数据只有等待
		if(count==0) {
			try {
				this.wait();//此时线程阻塞，等待生产者通知可以消费
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
		}else {
			//存在数据可以消费
		count--;
		this.notifyAll();//存在空间了可以唤醒对方生产了

		}
		Steamedbun1 bun=buns[count];
		return bun;
		
		
	}
	
	
	
}
//数据（馒头）
class Steamedbun1{
	int id;

	public Steamedbun1(int id) {
		this.id = id;
	}
	
}