package IOexperiments;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

public class Test2 {
	public static void main(String[] args) throws Exception
	{
		URL url=new URL("http://www.cqust.edu.cn/index.htm");
		BufferedReader br=new BufferedReader(new InputStreamReader(url.openStream(),"UTF-8"));
		String line=null;
		int cnt=0;
		while((line=br.readLine())!=null)
		{
			for(int i=0;i<line.length();i++)
			{
				if(line.charAt(i)=='重')
				{
					if(line.indexOf("重庆科技学院",i)==i)
					{
						cnt++;
					}
				}
			}
		}
		System.out.println("网页文件包含\"重庆科技学院\"的个数为"+cnt);
	}

}


