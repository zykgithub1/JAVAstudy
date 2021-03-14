package demo01;

import java.util.Stack;
//汉诺塔问题左-》中-》右版本和用栈实现：
public class hanoiProblem {
	public static void main(String[] args) {
		int N=hanoi(5, 'x', 'y', 'z');
		System.out.println(N);
		int h=hanoiProblem2(5, 'x', 'y', 'z');
		if(N==h) {
			System.out.println("yes");
		}
	}
	
	public enum Action{
		No,LToM,MToL,MToR,RToM;
	}
	
	public static int hanoiProblem2(int num,char x,char y,char z) {
		Stack<Integer> lS=new Stack<>();
		Stack<Integer> mS=new Stack<>();
		Stack<Integer> rS=new Stack<>();
		lS.add(Integer.MAX_VALUE);
		mS.add(Integer.MAX_VALUE);
		rS.add(Integer.MAX_VALUE);
		for(int i=num;i>0;i--) {
			lS.add(i);
		}
		int step=0;
		Action[] record= {Action.No};
		while(rS.size()!=num+1) {
			step+=fstackToStack(record,Action.LToM,Action.MToL,mS,lS,y,x);
			step+=fstackToStack(record,Action.MToL,Action.LToM,lS,mS,x,y);
			step+=fstackToStack(record,Action.RToM,Action.MToR,mS,rS,y,z);
			step+=fstackToStack(record,Action.MToR,Action.RToM,rS,mS,z,y);
		}
		return step;
	}
	
	
	private static int fstackToStack(Action[] record,
			Action preAct, Action nowAcT, 
			Stack<Integer> f, Stack<Integer> t,
			char from, char to) {
		if(record[0]!=preAct&&f.peek()<t.peek()) {
			t.add(f.pop());
			System.out.println("move "+from+"to "+to);
			record[0]=nowAcT;
			return 1;
		}
		return 0;
		
	}


	public static int hanoi(int num,char x,char y,char z) {
		if(num<1) {
			return 0;
		}
		return process(num,x,y,z,x,z);
	}

	private static int process(int num, char x, char y, char z, char from, char to) {
		if(num==1) {
			if(from==y||to==y) {
				System.out.println("move 1 from "+from+"to "+to);
				return 1;
			}else {
				System.out.println("move 1 from "+from+"to "+y);
				System.out.println("move 1 form "+y+"to "+to);
				return 2;
			}
		}
		if(from==y||to==y) {
			char another=(from==x||to==x)?z:x;
			int part1=process(num-1, x, y, z, from, another);
			int part2=1;
			System.out.println("move "+num+"from "+from+"to "+to);
			int part3=process(num-1, x, y, z, another, to);
			return part1+part2+part3;
		}else {
			int part1=process(num-1, x, y, z, from, to);
			int part2=1;
			System.out.println("move "+num+"from "+from+"to "+y);
			int part3=process(num-1, x, y, z, to,from );
			int part4=1;
			System.out.println("move "+num+"from "+y+"to "+to);
			int part5=process(num-1, x, y, z, from, to);
			return part1+part2+part3+part4+part5;
		}
	}

}
