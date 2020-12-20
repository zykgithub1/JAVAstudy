package cn.sxt.collection;

import java.util.Map;
import java.util.TreeMap;

public class TestTreeMap {
	public static void main(String[] args) {
		Map<Integer,String> treemap1=new TreeMap<>();
		treemap1.put(20, "aa");
		treemap1.put(3, "bb");
		treemap1.put(6, "cc");
		for(Integer key:treemap1.keySet()) {
			System.out.println(key+"------------"+treemap1.get(key));
		}
		
		Map<Emp,String> treemap2=new TreeMap<>();
		
		
		
	}

}
class Emp implements Comparable<Emp>{
	int id;
	String name;
	double salary;
	public Emp(int id, String name, double salary) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
	}
	
	public String toString() {
		return "id: "+id+"name: "+name+"salary: "+salary;
	}
	
	
	@Override
	public int compareTo(Emp o) {
		if(this.salary>o.salary) {
			return 1;
		}else if(this.salary<o.salary) {
			return -1;
		}else {
			if(this.id>o.id) {
				return 1;
			}else if(this.id<o.id) {
				return -1;
			}else {
				return 0;
			}
		}
	}
	
}
