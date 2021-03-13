package demo01;

import java.util.LinkedList;
import java.util.Queue;

public class DogCatQueue {
	private Queue<enterQueue> dogQ;
	private Queue<enterQueue> catQ;
	int count;
	public DogCatQueue() {
		dogQ=new LinkedList<>();
		catQ=new LinkedList<>();
		count=0;
	}
	
	public void add(pets1 pet) {
		if(pet.getType().equals("dog")) {
			dogQ.add(new enterQueue(pet, count++));
		}else if(pet.getType().equals("cat")) {
			catQ.add(new enterQueue(pet, count++));
		}
		else {
			throw new RuntimeException("no cat nor dog");
		}
	}
	
	public pets1 pollAll() {
		if(!dogQ.isEmpty()&&!catQ.isEmpty()) {
			if(dogQ.peek().getCount()>catQ.peek().getCount()) {
				return catQ.poll().getPet();
			}else {
				return dogQ.poll().getPet();
			}
		}else if(!dogQ.isEmpty()) {
			return dogQ.poll().getPet();
		}else if(!catQ.isEmpty()) {
			return catQ.poll().getPet();
		}else {
			throw new RuntimeException("boom");
		}
	}
	

}


class enterQueue{
	private pets1 pet;
	private int count;
	public enterQueue(pets1 pet, int count) {
		super();
		this.pet = pet;
		this.count = count;
	}
	public pets1 getPet() {
		return pet;
	}
	
	public int getCount() {
		return count;
	}
	
	
}

class pets1{
	String type;

	public pets1(String type) {
		super();
		this.type = type;
	}

	public String getType() {
		return type;
	}

}
class Cat1 extends pets1{

	public Cat1() {
		super("cat");
		// TODO Auto-generated constructor stub
	}
}

class Dog1 extends pets1{

	public Dog1() {
		super("dog");
	}
}