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
				if(line.charAt(i)=='��')
				{
					if(line.indexOf("����Ƽ�ѧԺ",i)==i)
					{
						cnt++;
					}
				}
			}
		}
		System.out.println("��ҳ�ļ�����\"����Ƽ�ѧԺ\"�ĸ���Ϊ"+cnt);
	}

}


