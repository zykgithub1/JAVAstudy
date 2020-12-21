package cn.sxt.collection;

//import java.util.ArrayList;
import java.util.*;

public class TestStoreDate2 {
	public static void main(String[] args) {
		User user1=new User(1001,"张三",20000,"2018.5.5");
		User user2=new User(1002,"李四",33000,"2018.3.5");
		User user3=new User(1003,"王五",5000,"2018.4.5");
		List<User> list=new ArrayList<>();
		list.add(user1);
		list.add(user2);
		list.add(user3);
		for(User u:list) {
			System.out.println(u);
		}
		System.out.println("----------------------------");
		Map<Integer,User> map=new HashMap<>();
		map.put(1, user1);
		map.put(2, user2);
		map.put(3, user3);
 		Set<Integer> keyset=map.keySet();
		for(Integer key:keyset) {
			System.out.println(key+"========="+map.get(key));
		}
	}
	

}
class User{
	private int id;
	private String name;
	private double salary;
	private String hiredate;
	
	
	
	
	public User() {
		super();
	}
	public User(int id, String name, double salary, String hiredate) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.hiredate = hiredate;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public String getHiredate() {
		return hiredate;
	}
	public void setHiredate(String hiredate) {
		this.hiredate = hiredate;
	}
	public String toString() {
		return "id: "+id+"\t"+"name: "+name+"\t"+"salary: "+salary;
	}
	
	
}