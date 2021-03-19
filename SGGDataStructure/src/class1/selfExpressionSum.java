package class1;

public class selfExpressionSum {
	public static void main(String[] args) {
		ArrayStack2 numStack=new ArrayStack2(10);
		ArrayStack2 operStack=new ArrayStack2(11);
		String expression="7-6-1-8";
		String keepNums="";
		int num1=0,index=0,num2=0,res=0,oper;char ch=' ';
		char[] ex=expression.toCharArray();
		while(true) {
			ch=ex[index];
			//判断是不是操作符 
			if(numStack.isOper(ch)) {
				if(operStack.isEmpty()) {
					operStack.push(ch);
				}else {
					if(operStack.priority(ch)<=operStack.priority(operStack.peek())) {
						num1=numStack.pop();
						num2=numStack.pop();
						oper=operStack.pop();
						res=numStack.cal(num1, num2,(char) oper);
						numStack.push(res);
						operStack.push(ch);
					}else {
						operStack.push(ch);
					}
				}
			}else {
				keepNums+=ch;
				if(index==ex.length-1) {
					numStack.push(ch-48);
				}else {
					if(numStack.isOper(ex[index+1])) {
						numStack.push(Integer.valueOf(keepNums));
						keepNums="";
					}
				}
			}
			index++;
			if(index==ex.length) {
				break;
			}
		}
		while(!operStack.isEmpty()) {
			num1=numStack.pop();
			num2=numStack.pop();
			oper=operStack.pop();
			res=numStack.cal(num1, num2,(char)oper);
			numStack.push(res);
		}
		System.out.printf("表达式%s=%d",expression,numStack.pop());
	}
}
