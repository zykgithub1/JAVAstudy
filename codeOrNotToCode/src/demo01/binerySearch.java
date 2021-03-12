package demo01;

import java.util.Scanner;

public class binerySearch {
	public static void main(String[] args) {
		int[] arr= {1,2,5,6,7,12,15,67,88,99,100,200};
		Scanner scanner=new Scanner(System.in);
		int pur=scanner.nextInt();
		int low=0;
		int high=arr.length-1;
		int mid=(high+low)/2;
		int count=0;
		while(low<=high) {
			count++;
			mid=(high+low)/2;
			if(arr[mid]>pur) {
				high=mid-1;
			}else if(arr[mid]<pur){
				low=mid+1;
			}else if(arr[mid]==pur){
				System.out.println("found!"+" "+mid+" "+count);
				break;
			}
		}
		if(arr[mid]!=pur) {
			System.out.println("not found!");
		}
	}
}
