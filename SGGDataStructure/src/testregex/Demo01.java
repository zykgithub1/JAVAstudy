package testregex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
/*
 * ������ʽ�е�   \   ��java�б�    \\ 
 */
public class Demo01 {
	public static void main(String[] args) {
		//1��ƥ��һ���ַ���:asfdasjd233323:   regex:/w+    
		//(1),����pattern ����
		Pattern p=Pattern.compile("\\d+");
		//��2������Matcher ����
		Matcher m=p.matcher("-23&&33&2\\3");
		
	//	boolean yesOrNo=m.matches();
		//boolean yesorno2=m.find();//�÷���ɨ����������У��������ģʽƥ�����һ��������
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
