package demo01;

import java.util.LinkedList;
import java.util.Queue;

public class DogsAndCatsQueue {
	
	public static void main(String[] args) {
		DogsAndCatsQueue dacq=new DogsAndCatsQueue();
	}
	private Queue<PetEnterQueue> dogQ;
	private Queue<PetEnterQueue> catQ;
	private long count;

	public DogsAndCatsQueue() {
		dogQ = new LinkedList<>();
		catQ = new LinkedList<PetEnterQueue>();
		count = 0;
	}

	public void add(pets pet) {
		if (pet.getType().equals("dog")) {
			dogQ.add(new PetEnterQueue(pet,count++));
		} else if (pet.getType().equals("cat")) {
			catQ.add(new PetEnterQueue(pet, count++));
		} else {
			throw new RuntimeException("not cat nor dog!!!");
		}
	}

	public pets pollAll() {
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
			throw new RuntimeException("queue is empty!!");
		}
	}
	
	public Dog pollDog() {
		if(dogQ.isEmpty()) {
			throw new RuntimeException("dogQ is empty");
		}
		return (Dog) dogQ.poll().getPet();
	}
	
	public Cat pollCat() {
		if(catQ.isEmpty()) {
			throw new RuntimeException("catQ is empty");
		}
		return (Cat) catQ.poll().getPet();
	}
	
	public boolean isEmpty() {
		return dogQ.isEmpty()&&catQ.isEmpty();
	}
	
	public boolean isDogQueueEmpty() {
		return dogQ.isEmpty();
	}
	
	public boolean isCatQueueEmpty() {
		return catQ.isEmpty();
	}

}

class PetEnterQueue {
	private pets pet;
	private long count;

	public PetEnterQueue(pets pet, long count) {
		super();
		this.pet = pet;
		this.count = count;
	}

	public pets getPet() {
		return pet;
	}

	public long getCount() {
		return count;
	}
}

class pets {
	String type;

	public pets(String type) {
		super();
		this.type = type;
	}

	public String getType() {
		return type;
	}
}

class Dog extends pets {

	public Dog() {
		super("dog");
	}
}

class Cat extends pets {
	public Cat() {
		super("cat");
	}
}
