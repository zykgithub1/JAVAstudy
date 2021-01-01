package com.sxt.syn;

import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;//并发容器
import java.util.List;

//操作并发容器   线程安全
public class SynContainer {
	public static void main(String[] args) throws InterruptedException {
		CopyOnWriteArrayList<String> list=new CopyOnWriteArrayList<>();
		for(int i=0;i<10000;i++) {
			new Thread(()->{
					list.add(Thread.currentThread().getName());
				
			}).start();
		}
		Thread.sleep(1000);
		System.out.println(list.size());
	}

}
