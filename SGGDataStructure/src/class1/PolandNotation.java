package class1;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PolandNotation {
	public static void main(String[] args) {
		//数字和符号用空格隔开：
		/*
		 * 将String放入ArrayList中
		 * 而后将list传入一个方法结合栈进行运算
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
	/*逆波兰运算：
	 * 1，从左至右扫描，将3，4入栈
	 * 2，遇到运算符将3，4弹出进行运算，得到结果压回栈
	 * 3，将5入栈
	 * 4，计算5*7.。。。。。。
	 */
	public static int calulate(List<String> ls) {
		Stack<String> stack=new Stack<>();
		for(String item:ls) {
			if(item.matches("\\d+")) {//正则表达式匹配
				stack.push(item);
			}else {
				//pop两个数运算后再入栈  后弹出来的数是被减数和被除数
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
					throw new RuntimeException("运算符有误");
				}
				stack.push(String.valueOf(res));//将int转化为字符串：（res+""）也行
			}
		}
		return Integer.valueOf(stack.pop());
	}
}
