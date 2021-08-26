package demo_2021_8_26_;

public class rewardOfAnchor {
	public static void main(String[] args) {
		int minCost=minCost1(2,10,1,10,50);
		System.out.println(minCost);
		for(int i=0;i<dp.length;i++) {
			for(int j=0;j<dp[0].length;j++) {
				System.out.printf(dp[i][j]+" ");;
			}
			System.out.println();
		}
	}
	static int[][]dp;
	private static int minCost1(int add, int times, int del, int start, int aim) {
		dp=new int[(aim-start)/2*add+1][2*aim+1];
		for(int i=0;i<dp.length;i++) {
			for(int j=0;j<dp[0].length;j++) {
				dp[i][j]=Integer.MAX_VALUE;
			}
		}
		return limitTry(0,aim,add,times,del,start,2*aim,((aim-start)/2)*add);
	}

	private static int limitTry(int preMoney, int aim, int add, 
			int times, int del, int cur, int limitAim, int limitMoney) {
		
		if(preMoney>limitMoney) {
			return Integer.MAX_VALUE;
		}
		if(cur>limitAim) {
			return Integer.MAX_VALUE;
		}
		if(cur<0) {
			return Integer.MAX_VALUE;
		}
		if(dp[preMoney][cur]!=Integer.MAX_VALUE) {
			return dp[preMoney][cur];
		}
		if(cur==aim) {
			dp[preMoney][cur]=preMoney;
			return preMoney;
		}
		int p1=limitTry(preMoney+add, aim, add, times, del, cur+2, limitAim, limitMoney);
		int min=Integer.MAX_VALUE;
		if(p1!=Integer.MAX_VALUE) {
			min=p1;
		}
		int p2=limitTry(preMoney+times, aim, add, times, del, cur*2, limitAim, limitMoney);
		if(p2!=Integer.MAX_VALUE) {
			min=Math.min(min, p2);
		}
		int p3=limitTry(preMoney+del, aim, add, times, del, cur-2, limitAim, limitMoney);
		if(p3!=Integer.MAX_VALUE) {
			min=Math.min(min, p3);
		}
		dp[preMoney][cur]=min;
		return min;
	}

}
