package com.sxt.thread;

public class IDownloader implements Runnable{
	private String name;
	private String url;
	public IDownloader(String name, String url) {
		super();
		this.name = name;
		this.url = url;
	}
	public void run() {
		WebDownLoader wd=new WebDownLoader();
		wd.download(url, name);
	}
	public static void main(String[] args) {
		IDownloader td1 =new IDownloader("https://www.baidu.com/img/PCtm_d9c8750bed0b3c7d089fa7d55720d6cf.png","qq1.png");
		IDownloader td2 =new IDownloader("https://www.baidu.com/img/PCtm_d9c8750bed0b3c7d089fa7d55720d6cf.png","qq2.png");
		IDownloader td3 =new IDownloader("https://www.baidu.com/img/PCtm_d9c8750bed0b3c7d089fa7d55720d6cf.png","qq3.png");
		new Thread(td1).start();
		new Thread(td2).start();
		new Thread(td3).start();
		
	}

}
