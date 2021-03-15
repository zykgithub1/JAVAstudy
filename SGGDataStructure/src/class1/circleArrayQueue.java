package class1;

import java.util.Scanner;
//环形队列  front指向第一个元素   rear指向最后一个元素的后一位，末尾不用
//判断是否为空 rear==front  
//是否为满：(rear+1)%maxSize==front


public class circleArrayQueue {
	public static void main(String[] args) {
		CircleArrayQueue1 aq = new CircleArrayQueue1(4);
		char key = ' ';
		boolean loop = true;
		Scanner sc = new Scanner(System.in);
		while (loop) {
			System.out.println("s(show):显示队列");
			System.out.println("e(exit):退出程序");
			System.out.println("a(add):添加数据");
			System.out.println("g(get):从队列取出元素");
			System.out.println("h(head):查看队头元素");
			key = sc.next().charAt(0);
			switch (key) {
			case 's':
				aq.showQueue();
				break;
			case 'e':
				sc.close();
				loop = false;
				break;
			case 'a':
				System.out.println("输入一个数字");
				int value = sc.nextInt();
				aq.addQueue(value);
				break;
			case 'g':
				try {
					int res = aq.getQueue();
					System.out.printf("取出的数据是%d\n", res);

				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;
			case 'h':
				try {
					int res = aq.getHead();
					System.out.printf("队头数据为:%d", res);
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}

			}

		}
		System.out.println("程序退出");

	}
}

class CircleArrayQueue1 {
	private int maxSize;
	private int front;
	private int rear;
	private int[] arr;

	public CircleArrayQueue1(int arrMaxSize) {
		maxSize = arrMaxSize;
		arr = new int[maxSize];
		front = 0;
		rear = 0;
	}

	public int getHead() {
		if (isEmpty()) {
			throw new RuntimeException();
		}
		return arr[front];
	}

	public boolean isFull() {
		return (rear + 1) % maxSize == front;
	}

	public boolean isEmpty() {
		return rear == front;
	}

	public void addQueue(int n) {
		if (isFull()) {
			System.out.println("满");
			return;
		}
		arr[rear] = n;
		rear = (rear + 1) % maxSize;// 取模操作 因为是环
	}

	public int getQueue() {
		if (isEmpty()) {
			throw new RuntimeException("empty");
		}
		// front是指向队列的第一个元素
		// 1，先把front对应的值保存在变量中
		// 2，front++
		// 3.将临时保存的变量返回
		int value = arr[front];
		front = (front + 1) % maxSize;
		return value;
	}

	public void showQueue() {
		if (isEmpty()) {
			System.out.println("米有数据");
			return;
		}
		// 队列大小为(rear-front+maxSize)%maxSize
		for (int i = front; i < front + (rear - front + maxSize) % maxSize; i++) {
			System.out.printf("queue[%d]=%d\n", i % maxSize, arr[i % maxSize]);
		}
	}

	public int sizeOfQueue() {
		return (rear - front + maxSize) % maxSize;
	}

}
