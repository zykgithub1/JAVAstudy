

public  class Sort {
	public static void main(String[] args) {
		//int arr[]= {10,9,8,7,6,5,4,3,2,1};
		//int arr[]= {5,3,6,8,1,7,9,4,2,10,-1};
		//selectSort(arr);
		//DataCheak dc = new DataCheak();
		//int arr[]=dc.getRandomArr();
		//disPlay(arr);
		//dc.check();
		//selectSortDouble(arr);
		//disPlay(arr);
	
	}
	public static void selectSort(int arr[]) {
		int minPos;
		for(int i=0;i<arr.length;i++) {
			minPos=i;
			for(int j=i+1;j<arr.length;j++) {
				if(arr[j]<arr[minPos]) {
					minPos=j;
				}
			}
			change(arr,i,minPos);
		}
	}
	public static void change(int arr[],int i,int j) {
		int tmp=arr[i];
		arr[i]=arr[j];
		arr[j]=tmp;
	}
	
	public static void disPlay(int arr[]) {
		int i;
		for(i=0;i<arr.length;i++) {
			System.out.print(arr[i]+"  ");
		}
		System.out.println();
	}
	public static void selectSortDouble(int arr[]) {
		int start=0,end=arr.length-1;
		while(start<end) {
			int min=start;int max=end;
			for(int i=start;i<=end;i++) {
				if(arr[i]<arr[min]) {
					min=i;
				}
				if(arr[i]>arr[max]) {
					max=i;
				}
			}
			change(arr,min,start);
			if(max==start) {
				max=min;
			}
			change(arr,max,end);
			start++;
			end--;
		}
	}
	
}



