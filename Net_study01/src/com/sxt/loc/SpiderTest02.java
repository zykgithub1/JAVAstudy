package com.sxt.loc;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
//ģ����������+ģ�������
public class SpiderTest02 {
	public static void main(String[] args) throws Exception {
		//��ȡURL
		URL url=new URL("http://www.dianping.com");
		//������Դ
		HttpURLConnection conn=(HttpURLConnection)url.openConnection();
		conn.setRequestMethod("");
		//BufferedReader br=new BufferedReader(new InputStreamReader(conn,"UTF-8"));
//		String msg=null;
//		while((msg=br.readLine())!=null) {
//			System.out.println(msg);
//		}
//		br.close();
		//����
		//����
		
		
	}

}
