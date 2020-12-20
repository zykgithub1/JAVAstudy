package cn.sxt.collection;

import java.util.HashMap;
import java.util.Map;

public class TestMap2 {
	
	public static void main(String[] args) {
		Employee e1=new Employee(1001,"赠一开",50000.0);
		Employee e2=new Employee(1002,"赠二开",5000.0);
		Employee e3=new Employee(1003,"赠三开",500.0);
		Employee e4=new Employee(1001,"赠四开",5100.0);
		Map<Integer,Employee> map=new HashMap<>();
		map.put(1, e1);
		map.put(2, e2);
		map.put(3, e3);
		map.put(4, e4);
		System.out.println(e1.hashCode());
		System.out.println(e2.hashCode());
		System.out.println(map.hashCode());
	    Employee emp=map.get(1001);
	    System.out.println(map);
	}
	

}
class Employee{
	private int id;
	private String name;
	private double salary;
	public Employee(int id, String name, double salary) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
	}
	public String toString(){
		return "id"+id+"name"+name+"salary"+salary;
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
	
}
