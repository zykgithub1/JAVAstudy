package com.sxt.loc;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
//模拟网络爬虫
public class SpiderTest01 {
	public static void main(String[] args) throws Exception {
		//获取URL
		URL url=new URL("http://www.jd.com");
		//下载资源
		InputStream is=url.openStream();
		BufferedReader br=new BufferedReader(new InputStreamReader(is,"UTF-8"));
		String msg=null;
		while((msg=br.readLine())!=null) {
			System.out.println(msg);
		}
		br.close();
		//分析
		//处理
		
		
	}

}
