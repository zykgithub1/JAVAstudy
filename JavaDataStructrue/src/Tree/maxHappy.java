package Tree;

import java.util.ArrayList;
import java.util.List;

public class maxHappy {
	public static void main(String[] args) {
		Employee a=new Employee(17);
		Employee b=new Employee(5);
		Employee c=new Employee(3);
		Employee d=new Employee(500);
		a.nexts.add(b);
		a.nexts.add(c);
		c.nexts.add(d);
		System.out.println(process(a).yes+"  "+process(a).no);
	}
	public static class Employee{
		private int happy;
		private List<Employee> nexts;
		public Employee(int h) {
			happy=h;
			nexts=new ArrayList<maxHappy.Employee>();
		}
	}
	public static class Info{
		private int yes;
		private int no;
		public Info(int y,int n) {
			yes=y;no=n;
		}
	}
	
	public static Info process(Employee x) {
		if(x.nexts.isEmpty()) {
			return new Info(x.happy,0);
		}
		int yes=x.happy;
		int no=0;
		for(Employee e:x.nexts) {
			Info nextInfo=process(e);
			yes+=nextInfo.no;
			no+=Math.max(nextInfo.yes, nextInfo.no);
		}
		return new Info(yes,no);
	}
}
