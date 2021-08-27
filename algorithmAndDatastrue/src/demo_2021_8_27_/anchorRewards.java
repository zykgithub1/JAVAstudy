package demo_2021_8_27_;

public class anchorRewards {
	static int cunt=0;
	public static void main(String[] args) {
		int minCost = processSelf(2, 20, 2, 3, 1);
		int ans=coins(2,32, 2, 3, 1);
		System.out.println(minCost+"  "+ans);
		System.out.println(cunt);
		System.out.println(Math.pow(10, 100));
	}

	public static int processSelf(int start, int end, int add, int times, int del) {
		if (end == start) {
			return 0;
		}
		if (2 * end < start) {
			return Integer.MAX_VALUE;
		}
		int pAdd = processSelf(start, end - 2, add, times, del);
		if (pAdd != Integer.MAX_VALUE) {
			pAdd += add;
		}
		int pTimes = processSelf(start, end / 2, add, times, del);
		if (pTimes != Integer.MAX_VALUE) {
			pTimes += times;
		}
		int pDel = processSelf(start + 2, end, pAdd, pTimes, del);
		if (pDel != Integer.MAX_VALUE) {
			pDel += del;
		}
		return Math.min(pAdd, Math.min(pTimes, pDel));
	}
	public static int coins(int start, int end, int add, int times, int del) {
		return limitTry(0, start, end, add, times, del, ((end-start)/2)*add, 2*end);
	}

	public static int limitTry(int preSum,
			int cur,int end,int add,int times,int del,int limitCur,int limitCoins) {
		cunt++;
		if(preSum>limitCur) {
			return Integer.MAX_VALUE;
		}
		if(cur<0) {
			return Integer.MAX_VALUE;
		}
		if(cur>limitCoins) {
			return Integer.MAX_VALUE;
		}
		if(cur==end) {
			return preSum;
		}
		int min=Integer.MAX_VALUE;
		int p1=limitTry(preSum+add, cur+2, end, add, times, del, limitCur, limitCoins);
		if(p1!=Integer.MAX_VALUE) {
			min=p1;
		}
		int p2=limitTry(preSum+times, cur*2, end, add, times, del, limitCur, limitCoins);
		if(p2!=Integer.MAX_VALUE) {
			min=Math.min(min, p2);
		}
		int p3=limitTry(preSum+del, cur-2, end, add, times, del, limitCur, limitCoins);
		if(p3!=Integer.MAX_VALUE) {
			min=Math.min(min, p3);
		}
		return min;
	}

}
