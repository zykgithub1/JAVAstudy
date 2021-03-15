package class1;

import java.util.Scanner;

public class ArrayQueueDemo {
	public static void main(String[] args) {
		ArrayQueue aq=new ArrayQueue(3);
		char key=' ';
		boolean loop=true;
		Scanner sc=new Scanner(System.in);
		while(loop) {
			System.out.println("s(show):显示队列");
			System.out.println("e(exit):退出程序");
			System.out.println("a(add):添加数据");
			System.out.println("g(get):从队列取出元素");
			System.out.println("h(head):查看队头元素");
			key=sc.next().charAt(0);
			switch(key) {
			case 's':
				aq.showQueue();
				break;
			case 'e':
				sc.close();
				loop=false;
				break;
			case 'a':
				System.out.println("输入一个数字");
				int value=sc.nextInt();
				aq.addQueue(value);
				break;
			case 'g':
				try {
					int res=aq.getQueue();
					System.out.printf("取出的数据是%d\n",res);
					
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;
			case 'h':
				try {
					int res=aq.getHead();
					System.out.printf("队头数据为:%d",res);
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			
			}
				
		}
		System.out.println("程序退出");
		

	}
}
class ArrayQueue {
	private int maxSize;
	private int front;
	private int rear;
	private int[] arr;

	public ArrayQueue(int arrMaxSize) {
		maxSize = arrMaxSize;
		arr = new int[maxSize];
		front = -1;// 队头元素的前一个位置！
		rear = -1;
	}

	public int getHead() {
		if(isEmpty()) {
			throw new RuntimeException();
		}
		return arr[front+1];
		
	}

	public boolean isFull() {
		if (rear == maxSize - 1) {
			return true;
		}
		return false;
	}

	public boolean isEmpty() {
		return rear == front;
	}

	public void addQueue(int n) {
		if (isFull()) {
			System.out.println("满");
			return;
		}
		arr[++rear] = n;
	}
	
	public int getQueue() {
		if(isEmpty()) {
			throw new RuntimeException("empty");
		}
		
		return arr[++front];
	}
	
	public void showQueue() {
		if(isEmpty()) {
			System.out.println("米有数据");
			return;
		}
		for(int i=0;i<arr.length;i++) {
			System.out.printf("arr[%d]=%d ",i,arr[i]);
		}
	}

}
