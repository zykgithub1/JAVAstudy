package testregex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
/*
 * 正则表达式中的   \   在java中变    \\ 
 */
public class Demo01 {
	public static void main(String[] args) {
		//1，匹配一个字符串:asfdasjd233323:   regex:/w+    
		//(1),创建pattern 对象
		Pattern p=Pattern.compile("\\d+");
		//（2）创建Matcher 对象
		Matcher m=p.matcher("-23&&33&2\\3");
		
	//	boolean yesOrNo=m.matches();
		//boolean yesorno2=m.find();//该方法扫描输入的序列，查找与该模式匹配的下一个子序列
		/*
	     * true
                 23
                 true
                 33
                 true
                 2
		 */
//		System.out.println(m.find());
//		System.out.println(m.find());
//		System.out.println(m.find());
//		System.out.println(m.find());
//		System.out.println(m.group());
//		System.out.println(m.find());
//		System.out.println(m.group());
//		System.out.println(m.find());
//		System.out.println(m.group());
	}

}
