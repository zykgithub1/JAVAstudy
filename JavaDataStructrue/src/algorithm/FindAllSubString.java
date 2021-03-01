package algorithm;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
//�ҵ��ַ������������С� 
//�Ӵ���һ���ַ������ִ�����������abcd�������У�bd���Ӵ���bcd,bc�������б��ִ����ɣ��м���Լ��
public class FindAllSubString {
	public static void main(String[] args) {
		String str="abcd";
		List<String> list=subs(str);
		Iterator<String> it=list.iterator();
		System.out.println(list.size());
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	}
	public static List<String> subs(String s){
		char[] str=s.toCharArray();
		String path="";
		List<String> ans=new ArrayList();
		process1(str,1,ans,path);
		return ans;
		
	}
	private static void process1(char[] str, int index, List<String> ans, String path) {
		if(index==str.length) {
			ans.add(path);
			return;
		}
		String no=path;
		process1(str, index+1, ans, no);
		String yes=path+String.valueOf(str[index]);
		process1(str, index+1, ans, yes);
	}

}
