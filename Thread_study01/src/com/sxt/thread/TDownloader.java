package com.sxt.thread;

public class TDownloader extends Thread{
	private String name;
	private String url;
	public TDownloader(String name, String url) {
		super();
		this.name = name;
		this.url = url;
	}
	public void run() {
		WebDownLoader wd=new WebDownLoader();
		wd.download(url, name);
	}
	public static void main(String[] args) {
		TDownloader td1 =new TDownloader("https://www.baidu.com/img/PCtm_d9c8750bed0b3c7d089fa7d55720d6cf.png","qq1.png");
		TDownloader td2 =new TDownloader("https://www.baidu.com/img/PCtm_d9c8750bed0b3c7d089fa7d55720d6cf.png","qq2.png");
		TDownloader td3 =new TDownloader("https://www.baidu.com/img/PCtm_d9c8750bed0b3c7d089fa7d55720d6cf.png","qq3.png");
		td1.start();
		td2.start();
		td3.start();
		
	}

}
