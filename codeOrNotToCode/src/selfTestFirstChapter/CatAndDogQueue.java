package selfTestFirstChapter;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class CatAndDogQueue {

}

class pet{
	String type;

	public pet(String t) {
		type=t;
	}

	public String getType() {
		return type;
	}
	
}

class Dog extends pet{

	public Dog() {
		super("Dog");
	}
}
class Cat extends pet{

	public Cat() {
		super("Cat");
	}
}

class enterQueue{
	private pet pet;
	private int count;
	public enterQueue(selfTestFirstChapter.pet pet, int count) {
		super();
		this.pet = pet;
		this.count = count;
	}
	public pet getPet() {
		return pet;
	}
	public int getCount() {
		return count;
	}
}
class DogAndCatQueue{
	Queue<enterQueue> dogQ;
	Queue<enterQueue> catQ;
	int count;
	public DogAndCatQueue() {
		dogQ=new LinkedList<enterQueue>();
		catQ=new LinkedList<enterQueue>();
		count=0;
	}
	
	public void add(pet pe) {
		if(pe.getType().equals("Dog")) {
			dogQ.add(new enterQueue(pe, count++));
		}else if(pe.getType().equals("Cat")) {
			catQ.add(new enterQueue(pe, count++));
		}else {
			throw new RuntimeException();
		}
	}
	public pet pollAll() {
		if(!dogQ.isEmpty()&&!catQ.isEmpty()) {
			if(dogQ.peek().getCount()>catQ.peek().getCount()) {
				return catQ.poll().getPet();
			}else {
				return dogQ.poll().getPet();
			}
		}else if(dogQ.isEmpty()) {
			return catQ.poll().getPet();
		}else if(catQ.isEmpty()) {
			return dogQ.poll().getPet();
		}else {
			return null;
		}
	}
	
}

