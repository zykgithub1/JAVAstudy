package testregex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WebSpiderTest {
	public static String getURLContent(String urlStr) {
		StringBuilder sb=new StringBuilder();
		
		try {
			URL url=new URL(urlStr);
			BufferedReader reader=new BufferedReader(new InputStreamReader(url.openStream()));
			String tmp="";
			while((tmp=reader.readLine())!=null) {
				sb.append(tmp+"\n");
			}
			
			
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return sb.toString();
		
	}
	/*
	 * destStr 是根据url得到的整个网页源码
	 */
	public static List<String> getMatcherStrs(String destStr,String regexStr){
		//String res=getURLContent(destUrl);
		//System.out.println(res);
		//此正则是超链接的整个内容
		//Pattern p=Pattern.compile("<a[\\s\\S]+?</a>");
		Pattern p=Pattern.compile(regexStr);
		//Pattern p2=Pattern.compile("href=\"(.+?)\"");
		Matcher m=p.matcher(destStr);
		List<String>result=new ArrayList<String>();
		while(m.find()) {
			result.add(m.group(1));
		}
		return result;
	}
	
	
	public static void main(String[] args) {
		String res=getURLContent("https://www.163.com/");
		//System.out.println(res);
		//此正则是超链接的整个内容
		//Pattern p=Pattern.compile("<a[\\s\\S]+?</a>");
//		Pattern p=Pattern.compile("href=\".+?\"");
//		Pattern p2=Pattern.compile("href=\"(.+?)\"");
//		Matcher m=p2.matcher(res);
//		while(m.find()) {
//			//System.out.println(m.group());
//			System.out.println(m.group(1));
//		}
		List<String>list=getMatcherStrs(res, "href=\"([\\w\\s./:]+?)\"");
		for(String tmp:list) {
			System.out.println(tmp);
		}
		
	}

}
