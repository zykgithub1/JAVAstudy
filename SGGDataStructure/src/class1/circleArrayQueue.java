package class1;

import java.util.Scanner;
//���ζ���  frontָ���һ��Ԫ��   rearָ�����һ��Ԫ�صĺ�һλ��ĩβ����
//�ж��Ƿ�Ϊ�� rear==front  
//�Ƿ�Ϊ����(rear+1)%maxSize==front


public class circleArrayQueue {
	public static void main(String[] args) {
		CircleArrayQueue1 aq = new CircleArrayQueue1(4);
		char key = ' ';
		boolean loop = true;
		Scanner sc = new Scanner(System.in);
		while (loop) {
			System.out.println("s(show):��ʾ����");
			System.out.println("e(exit):�˳�����");
			System.out.println("a(add):�������");
			System.out.println("g(get):�Ӷ���ȡ��Ԫ��");
			System.out.println("h(head):�鿴��ͷԪ��");
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
				System.out.println("����һ������");
				int value = sc.nextInt();
				aq.addQueue(value);
				break;
			case 'g':
				try {
					int res = aq.getQueue();
					System.out.printf("ȡ����������%d\n", res);

				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;
			case 'h':
				try {
					int res = aq.getHead();
					System.out.printf("��ͷ����Ϊ:%d", res);
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}

			}

		}
		System.out.println("�����˳�");

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
			System.out.println("��");
			return;
		}
		arr[rear] = n;
		rear = (rear + 1) % maxSize;// ȡģ���� ��Ϊ�ǻ�
	}

	public int getQueue() {
		if (isEmpty()) {
			throw new RuntimeException("empty");
		}
		// front��ָ����еĵ�һ��Ԫ��
		// 1���Ȱ�front��Ӧ��ֵ�����ڱ�����
		// 2��front++
		// 3.����ʱ����ı�������
		int value = arr[front];
		front = (front + 1) % maxSize;
		return value;
	}

	public void showQueue() {
		if (isEmpty()) {
			System.out.println("��������");
			return;
		}
		// ���д�СΪ(rear-front+maxSize)%maxSize
		for (int i = front; i < front + (rear - front + maxSize) % maxSize; i++) {
			System.out.printf("queue[%d]=%d\n", i % maxSize, arr[i % maxSize]);
		}
	}

	public int sizeOfQueue() {
		return (rear - front + maxSize) % maxSize;
	}

}
