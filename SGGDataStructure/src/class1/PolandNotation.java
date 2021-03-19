package class1;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PolandNotation {
	public static void main(String[] args) {
		//���ֺͷ����ÿո������
		/*
		 * ��String����ArrayList��
		 * ����list����һ���������ջ��������
		 * 
		 * */
		String suffixExpreesion="30 4 + 5 * 6 -";
		List<String> rpnList=getListString(suffixExpreesion);
		System.out.println(rpnList);
		int res=calulate(rpnList);
		System.out.println(res);
	}
	
	public static List<String> getListString(String suffixExpreesion){
		String[]split=suffixExpreesion.split(" ");
		List<String>list=new ArrayList();
		for(String ele:split) {
			list.add(ele);
		}
		return list;
	}
	/*�沨�����㣺
	 * 1����������ɨ�裬��3��4��ջ
	 * 2�������������3��4�����������㣬�õ����ѹ��ջ
	 * 3����5��ջ
	 * 4������5*7.������������
	 */
	public static int calulate(List<String> ls) {
		Stack<String> stack=new Stack<>();
		for(String item:ls) {
			if(item.matches("\\d+")) {//������ʽƥ��
				stack.push(item);
			}else {
				//pop���������������ջ  �󵯳��������Ǳ������ͱ�����
				int num2=Integer.valueOf(stack.pop());
				int num1=Integer.parseInt(stack.pop());
				int res=0;
				if(item.equals("+")) {
					res=num1+num2;
				}else if(item.equals("-")) {
					res=num1-num2;
				}else if(item.equals("*")) {
					res=num1*num2;
				}else if(item.equals("/")) {
					res=num1/num2;
				}else {
					throw new RuntimeException("���������");
				}
				stack.push(String.valueOf(res));//��intת��Ϊ�ַ�������res+""��Ҳ��
			}
		}
		return Integer.valueOf(stack.pop());
	}
}
