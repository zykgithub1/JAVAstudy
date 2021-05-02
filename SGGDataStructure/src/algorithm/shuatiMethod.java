package algorithm;

import java.util.Scanner;

public class shuatiMethod {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int questionNum = sc.nextInt();
		int goal = sc.nextInt();
		codeNode[] arr = new codeNode[questionNum];
		for (int i = 0; i < questionNum; i++) {
			arr[i] = new codeNode(0, 0, 0);
			arr[i].intellegence = sc.nextInt();
			arr[i].codeNum = sc.nextInt();
			arr[i].boringNum = sc.nextInt();
			arr[i].weight = arr[i].intellegence * 1.0 / arr[i].codeNum / arr[i].boringNum;
		}
		heapSort(arr);
		for(int i=0;i<arr.length;i++) {
			System.out.println(arr[i].weight+" "+arr[i].intellegence+" "+arr[i].codeNum+" "+arr[i].boringNum);
		}
		int ans=count(arr,goal);
		System.out.println(ans);
		

	}
	
	



	private static int count(codeNode[] arr, int goal) {
		int sum=0;
		int countBor=0;
		int countCodeNum=0;
		for(int i=0;i<arr.length;i++) {
			sum+=arr[i].intellegence;
			countBor+=arr[i].boringNum;
			countCodeNum+=arr[i].codeNum;
			if(sum>=goal) {
				break;
			}
		}
		System.out.println(countBor+" "+countCodeNum);
		return countBor*countCodeNum;
	}





	public static void heapSort(codeNode[] arr) {
		for (int k = arr.length / 2-1; k >= 0; k--) {
			shift(arr, k, arr.length);
		}
		for(int i=arr.length-1;i>0;i--) {
			codeNode tmp=arr[i];
			arr[i]=arr[0];
			arr[0]=tmp;
			shift(arr, 0, i);
		}
	}

	public static void shift(codeNode[] arr, int start, int end) {
		int i = start, j = 2 * i + 1;
		while (j < end) {
			if (j + 1 < end && arr[j].weight > arr[j + 1].weight) {
				j++;
			}
			if (arr[j].weight < arr[i].weight) {
				codeNode tmp = arr[j];
				arr[j] = arr[i];
				arr[i] = tmp;
			}
			i = j;
			j = 2 * j + 1;
		}
	}

}

class codeNode {
	int intellegence;
	int codeNum;
	int boringNum;
	double weight;

	public codeNode(int intellegence, int cokeNum, int boringNum) {
		this.intellegence = intellegence;
		this.codeNum = cokeNum;
		this.boringNum = boringNum;
	}
}
