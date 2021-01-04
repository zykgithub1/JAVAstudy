package com.sxt.loc;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
//模拟网络爬虫+模拟浏览器
public class SpiderTest02 {
	public static void main(String[] args) throws Exception {
		//获取URL
		URL url=new URL("http://www.dianping.com");
		//下载资源
		HttpURLConnection conn=(HttpURLConnection)url.openConnection();
		conn.setRequestMethod("");
		//BufferedReader br=new BufferedReader(new InputStreamReader(conn,"UTF-8"));
//		String msg=null;
//		while((msg=br.readLine())!=null) {
//			System.out.println(msg);
//		}
//		br.close();
		//分析
		//处理
		
		
	}

}
