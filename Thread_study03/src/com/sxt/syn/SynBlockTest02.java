package com.sxt.syn;

import java.util.ArrayList;
import java.util.List;

//操作容器   线程不安全
public class SynBlockTest02 {
	public static void main(String[] args) throws InterruptedException {
		List<String> list=new ArrayList<>();
		for(int i=0;i<10000;i++) {
			new Thread(()->{
				//同步块
				synchronized (list) {
					list.add(Thread.currentThread().getName());
				}
			}).start();
		}
		Thread.sleep(1000);
		System.out.println(list.size());
	}

}
