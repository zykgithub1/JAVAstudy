package demo_2021_8_26_;

public class modifyArr {
	public static void main(String[] args) {
		int[]arr= {6,5,8,3,6,1,4,4,9,5,3};
		System.out.println(findAndModifyLostValue(arr));
	}
	public static int findAndModifyLostValue(int[]arr) {
		for(int ar:arr)
			modify(arr,ar);
		for(int i=0;i<arr.length;i++) {
			if(arr[i]!=i+1) {
				return i+1;
			}
		}
		return -1;
	}

	private static void modify(int[] arr, int ar) {
		while(arr[ar-1]!=ar) {
			int temp=arr[ar-1];
			arr[ar-1]=ar;
			ar=temp;
		}
		
	}

}
