package demo_2021_8_17_dp;

public class horseJump {
	public static void main(String[] args) {
		System.out.println(brute(7, 7, 10));
		System.out.println(dpWays(7, 7, 10));
		
	}
	//从0，0出发
	//要去往x,y位置 ，must jump step
	public static int brute(int a,int b,int step) {
		if(a<0||a>8||b<0||b>9) {
			return 0;
		}
		if(step==0) {
			return (a==0&&b==0)?1:0;
		}
		return brute(a+1, b+2, step-1)+
				brute(a+2, b+1, step-1)+
				brute(a+2, b-1, step-1)+
				brute(a+1, b-2, step-1)+
				brute(a-1, b-2, step-1)+
				brute(a-2, b-1, step-1)+
				brute(a-2, b+1, step-1)+
				brute(a-1, b+2, step-1);
	}
	
	public static int dpWays(int x,int y,int step) {
		if(x<0||x>8||y<0||y>9||step<0) {
			return 0;
		}
		int[][][]dp=new int[9][10][step+1];
		dp[0][0][0]=1;
		for(int h=1;h<=step;h++) {
			for(int r=0;r<9;r++) {
				for(int c=0;c<10;c++) {
					dp[r][c][h]+=getValue(dp,r-1,c+2,h-1);
					dp[r][c][h]+=getValue(dp,r+1,c+2,h-1);
					dp[r][c][h]+=getValue(dp,r+2,c+1,h-1);
					dp[r][c][h]+=getValue(dp,r+2,c-1,h-1);
					dp[r][c][h]+=getValue(dp,r+1,c-2,h-1);
					dp[r][c][h]+=getValue(dp,r-1,c-2,h-1);
					dp[r][c][h]+=getValue(dp,r-2,c-1,h-1);
					dp[r][c][h]+=getValue(dp,r-2,c+1,h-1);
				}
			}
		}
		return dp[x][y][step];
	}
	private static int getValue(int[][][] dp, int i, int j, int k) {
		if(i<0||i>8||j<0||j>9) {
			return 0;
		}
		return dp[i][j][k];
	}

}
