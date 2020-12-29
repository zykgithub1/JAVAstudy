package com.sxt.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CDownloader implements Callable<Boolean>{
	private String name;
	private String url;
	public CDownloader(String url, String name) {
		super();
		this.name = name;
		this.url = url;
	}
	public Boolean call() throws Exception{
		WebDownLoader wd=new WebDownLoader();
		wd.download(url, name);
		System.out.println(name);
		return true;
	}
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		CDownloader cd1 =new CDownloader("https://www.baidu.com/img/PCtm_d9c8750bed0b3c7d089fa7d55720d6cf.png","qq1.png");
		CDownloader cd2 =new CDownloader("https://www.baidu.com/img/PCtm_d9c8750bed0b3c7d089fa7d55720d6cf.png","qq2.png");
		CDownloader cd3 =new CDownloader("https://www.baidu.com/img/PCtm_d9c8750bed0b3c7d089fa7d55720d6cf.png","qq3.png");
		
		//创建执行服务：
		ExecutorService ser=Executors.newFixedThreadPool(3);
		//提交执行：
		Future<Boolean> result1=ser.submit(cd1);
		Future<Boolean> result2=ser.submit(cd2);
		Future<Boolean> result3=ser.submit(cd3);
		//获取结果：
		boolean r1=result1.get();
		boolean r2=result1.get();
		boolean r3=result1.get();
		ser.shutdown();
	}

}
