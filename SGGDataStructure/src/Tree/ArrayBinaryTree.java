package Tree;

public class ArrayBinaryTree {
	public static void main(String[] args) {
		int arr[]= {1,2,3,4,5,6,7};
		ArrayBTree B=new ArrayBTree(arr);
		B.preOder();
	}

}
class ArrayBTree{
	private int[] arr;
	public ArrayBTree(int[] arr) {
		super();
		this.arr = arr;
	}
	
	public void preOder() {
		this.preOrder(0);
	}
	
	public void preOrder(int index) {
		if(arr==null||arr.length==0||index>arr.length) {
			System.out.println("Êı¾İÓĞÎó");
			return;
		}
		System.out.println(arr[index]);
		if((index*2+1)<arr.length) {
			preOrder(index*2+1);
		}
		if((index*2)+2<arr.length) {
			preOrder(index*2+2);
		}
	}
	
	
}
