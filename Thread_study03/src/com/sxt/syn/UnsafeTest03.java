package com.sxt.syn;

import java.util.ArrayList;
import java.util.List;

//操作容器   线程不安全
public class UnsafeTest03 {
	public static void main(String[] args) {
		List<String> list=new ArrayList<>();
		for(int i=0;i<10000;i++) {
			new Thread(()->{
				list.add(Thread.currentThread().getName());
			}).start();
		}
		System.out.println(list.size());
	}

}
