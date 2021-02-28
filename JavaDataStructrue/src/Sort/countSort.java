package Sort;

public class countSort {
	public static void main(String[] args) {
		int arr[]= {6,4,2,7,9,1,0,4,6,3,2};
		Sort.disPlay(arr);
		Sort.disPlay(countSort(arr));
		
	}
	//���ȶ��汾��
//	public static int[] countSort(int arr[]) {
//		int count[]=new int[3];
//		int result[]=new int[arr.length];
//		for(int i=0;i<arr.length;i++) {
//			count[arr[i]]++;
//		}
//		Sort.disPlay(count);
//		for(int i=0,j=0;i<count.length;i++) {
//			while(count[i]-->0) {
//				result[j++]=i;
//			}
//		}
//		return result;
//	}�ȶ��ģ�
	public static int[] countSort(int arr[]) {
		int count[]=new int[10];
		int result[]=new int[arr.length];
		for(int i=0;i<arr.length;i++) {
			count[arr[i]]++;
		}
		Sort.disPlay(count);
		for(int i=1;i<count.length;i++) {
			count[i]=count[i]+count[i-1];
		}

		for(int i=arr.length-1;i>=0;i--) {
			result[--count[arr[i]]]=arr[i];
		}
		return result;
	}
}
