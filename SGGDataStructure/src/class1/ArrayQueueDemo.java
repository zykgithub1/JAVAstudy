package class1;

import java.util.Scanner;

public class ArrayQueueDemo {
	public static void main(String[] args) {
		ArrayQueue aq=new ArrayQueue(3);
		char key=' ';
		boolean loop=true;
		Scanner sc=new Scanner(System.in);
		while(loop) {
			System.out.println("s(show):��ʾ����");
			System.out.println("e(exit):�˳�����");
			System.out.println("a(add):�������");
			System.out.println("g(get):�Ӷ���ȡ��Ԫ��");
			System.out.println("h(head):�鿴��ͷԪ��");
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
				System.out.println("����һ������");
				int value=sc.nextInt();
				aq.addQueue(value);
				break;
			case 'g':
				try {
					int res=aq.getQueue();
					System.out.printf("ȡ����������%d\n",res);
					
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;
			case 'h':
				try {
					int res=aq.getHead();
					System.out.printf("��ͷ����Ϊ:%d",res);
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			
			}
				
		}
		System.out.println("�����˳�");
		

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
		front = -1;// ��ͷԪ�ص�ǰһ��λ�ã�
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
			System.out.println("��");
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
			System.out.println("��������");
			return;
		}
		for(int i=0;i<arr.length;i++) {
			System.out.printf("arr[%d]=%d ",i,arr[i]);
		}
	}

}
