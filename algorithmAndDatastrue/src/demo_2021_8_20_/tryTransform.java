package demo_2021_8_20_;

public class tryTransform {
	public static void main(String[] args) {
		
		System.out.println(bruteTempt(21221211)+"  "+dpway(21221211));
	}
	public static int bruteTempt(int num) {
		if (num < 1) {
			return 0;
		}
		return process(String.valueOf(num).toCharArray(), 0);
	}

	public static int process(char[] str, int index) {
		if (index == str.length) {
			return 1;
		}
		if (str[index] == '0') {
			return 0;
		}
		int res = process(str, index + 1);
		if (index + 1 < str.length && (10 * (str[index] - '0') + str[index + 1] - '0') <= 26) {
			res += process(str, index + 2);
		}
		return res;
	}
	
	public static int dpway(int num) {
		if (num < 1) {
			return 0;
		}
		char[]chs=String.valueOf(num).toCharArray();
		int n=chs.length;
		int[]dp=new int[n+1];
		dp[n]=1;
		dp[n-1]=dp[n-1]=='0'?0:1;
		for(int i=n-2;i>=0;i--) {
			if(chs[i]=='0') {
				dp[i]=0;
			}else {
				dp[i]+=dp[i+1]+((10*(chs[i]-'0')+chs[i+1]-'0')<=26?dp[i+2]:0);
			}
		}
		return dp[0];
	}

}
